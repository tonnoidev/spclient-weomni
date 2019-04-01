package th.co.softpos.ws.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import th.co.softpos.db.model.ServiceDocs;
import th.co.softpos.db.model.ServiceReq;
import th.co.softpos.db.model.ServiceRes;
import th.co.softpos.ws.client.POSConstant;
import th.co.softpos.ws.client.TaskPost;
import th.co.softpos.ws.client.WSConstants;
import th.co.softpos.ws.dto.ActivateDTO;
import th.co.softpos.ws.dto.CampaignDTO;
import th.co.softpos.ws.dto.CreateActivateDTO;
import th.co.softpos.ws.dto.CreateEarnPointDTO;
import th.co.softpos.ws.dto.CreatePaymentDTO;
import th.co.softpos.ws.dto.CreateRedeemCampaignDTO;
import th.co.softpos.ws.dto.CreateRedeemCodeDTO;
import th.co.softpos.ws.dto.CreateVoidBurnPointDTO;
import th.co.softpos.ws.dto.CreateVoidEarnPointDTO;
import th.co.softpos.ws.dto.CreateVoidPaymentDTO;
import th.co.softpos.ws.dto.EarnPointDTO;
import th.co.softpos.ws.dto.ErrorArrayDTO;
import th.co.softpos.ws.dto.PaymentDTO;
import th.co.softpos.ws.dto.RedeemCampaignDTO;
import th.co.softpos.ws.dto.RedeemCodeDTO;
import th.co.softpos.ws.dto.TrueYouCardDTO;
import th.co.softpos.ws.dto.VoidBurnPointDTO;
import th.co.softpos.ws.dto.VoidEarnPointDTO;
import th.co.softpos.ws.dto.VoidPaymentDTO;
import th.co.softpos.ws.model.Account;
import th.co.softpos.ws.model.Campaign;
import th.co.softpos.ws.model.Content;
import th.co.softpos.ws.model.Customer;
import th.co.softpos.ws.model.Pockets;
import th.co.softpos.ws.model.Point;
import th.co.softpos.ws.model.SlipType;
import th.co.softpos.ws.model.Transaction;
import th.co.softpos.ws.model.req.Payment;
import th.co.softpos.ws.util.SPUtil;
import th.co.softpos.ws.util.ThaiUtil;

public class ServiceController {

    private static Logger logger = Logger.getLogger(ServiceController.class);

    static {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("app/config.properties");
            prop.load(input);

            POSConstant.CLIENT_ID = prop.getProperty("CLIENT_ID");
            POSConstant.CLIENT_SECRET = prop.getProperty("CLIENT_SECRET");
            POSConstant.ACCESS_TOKEN = prop.getProperty("ACCESS_TOKEN");
            POSConstant.APP_ID = prop.getProperty("APP_ID");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IO Error: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        }
    }

    String getUUID() {
        return UUID.randomUUID().toString();
    }

    private ErrorArrayDTO getErrorFromData(String data, Gson gson) {
        JsonArray errorArray = gson.fromJson(data, JsonArray.class);
        ErrorArrayDTO errors = null;
        for (int i = 0; i < errorArray.size(); i++) {
            errors = gson.fromJson(errorArray.get(i), ErrorArrayDTO.class);
        }

        return errors;
    }

    public List<ServiceDocs> findServiceDocsAll() {
        List<ServiceDocs> listBean = new ArrayList<>();
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            sql = "select * from service_docs where 1=1 ";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    ServiceDocs bean = new ServiceDocs();
                    bean.setApiId(rs.getString("api_id"));
                    bean.setApiName(rs.getString("api_name"));
                    bean.setApiUri(rs.getString("api_uri"));
                    bean.setApiDesc(ThaiUtil.readThai(rs.getString("api_desc")));
                    bean.setApiMethod(rs.getString("api_method"));

                    listBean.add(bean);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            return listBean;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
            }
        }

        return listBean;
    }

    public List<ServiceReq> findServiceRequestAll() {
        List<ServiceReq> listBean = new ArrayList<>();
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            sql = "select * from service_req where 1=1 ";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    try {
                        ServiceReq bean = mappingReq(rs);
                        listBean.add(bean);
                    } catch (Exception e) {
                    }

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            return listBean;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
            }
        }

        return listBean;
    }

    public List<ServiceRes> findServiceResponseAll() {
        List<ServiceRes> listBean = new ArrayList<>();
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            sql = "select * from service_res where 1=1 ";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    try {
                        ServiceRes bean = mappingRes(rs);
                        listBean.add(bean);
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            return listBean;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
            }
        }

        return listBean;
    }

    public ServiceReq getNewReq() {
        ServiceReq reqBean = null;
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            sql = "select * from service_req where req_id is null or req_id='' limit 0,1 ";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    try {
                        reqBean = mappingReq(rs);
                    } catch (Exception e) {
                    }

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
            }
        }

        return reqBean;
    }

    private ServiceReq mappingReq(ResultSet rs) throws Exception {
        ServiceReq bean = new ServiceReq();
        bean.setUid(rs.getString("uid"));
        bean.setActivationCode(rs.getString("act_code"));
        bean.setImei(rs.getString("imei"));
        bean.setLatitude(rs.getString("latitude"));
        bean.setLongitude(rs.getString("longitude"));
        bean.setPassword(rs.getString("passwd"));
        bean.setExternal(rs.getString("ext"));
        bean.setBrandId(rs.getString("brand_id"));
        bean.setBranchId(rs.getString("branch_id"));
        bean.setCampaignCode(rs.getString("camp_code"));
        bean.setAccountType(rs.getString("acc_type"));
        bean.setAccountValue(rs.getString("acc_value"));
        bean.setRewardCode(rs.getString("rew_code"));
        bean.setEarnPointAmount(rs.getString("earn_point_amt"));
        bean.setPaymentAmount(rs.getBigDecimal("pay_amt"));
        bean.setPaymentCurrency(rs.getString("pay_curr"));
        bean.setPaymentCode(rs.getString("pay_code"));
        bean.setPaymentMethod(rs.getString("pay_method"));
        bean.setPaymentDescription(rs.getString("pay_desc"));
        bean.setReqId(rs.getString("req_id"));
        bean.setReqStatus(rs.getString("req_status"));
        bean.setReqDatetime(rs.getDate("req_datetime"));
        bean.setApiName(rs.getString("api_name"));
        bean.setParamTerminalId(rs.getString("param_terminal_id"));
        bean.setParamTraceId(rs.getString("param_trace_id"));
        bean.setRedeemType(rs.getString("redeem_type"));

        return bean;
    }

    private ServiceRes mappingRes(ResultSet rs) throws Exception {
        ServiceRes bean = new ServiceRes();
        bean.setUid(rs.getString("uid"));
        bean.setReqId(rs.getString("req_id"));
        bean.setBrandId(rs.getString("brand_id"));
        bean.setBranchId(rs.getString("branch_id"));
        bean.setTerminalId(rs.getString("terminal_id"));
        bean.setSerialNo(rs.getString("serial_no"));
        bean.setActCode(rs.getString("act_code"));
        bean.setTrueYouId(rs.getString("true_you_id"));
        bean.setTranTracId(rs.getString("tran_trac_id"));
        bean.setTranBatId(rs.getString("tran_bat_id"));
        bean.setTranRefId(rs.getString("tran_ref_id"));
        bean.setTranDate(rs.getDate("tran_date"));
        bean.setTranPoint(rs.getString("tran_point"));
        bean.setTranAmt(rs.getBigDecimal("tran_amt"));
        bean.setCustRefId(rs.getString("cust_ref_id"));
        bean.setCustPointUsed(rs.getString("cust_point_used"));
        bean.setCustPointBalance(rs.getString("cust_point_balance"));
        bean.setRewCode(rs.getString("rew_code"));
        bean.setAccType(rs.getString("acc_type"));
        bean.setAccValue(rs.getString("acc_value"));
        bean.setTrueCardNo(rs.getString("true_card_no"));
        bean.setCardHolderName(rs.getString("card_holder_name"));
        bean.setTrueCardType(rs.getString("true_card_type"));
        bean.setTrueCardStatus(rs.getString("true_card_status"));
        bean.setTrueCardExpired(rs.getString("true_card_expired"));
        bean.setPointBalance(rs.getString("point_balance"));
        bean.setPointPackDesc(rs.getString("point_pack_desc"));
        bean.setPointPackBalance(rs.getBigDecimal("point_pack_balance"));
        bean.setPointPackExpired(rs.getString("point_pack_expired"));
        bean.setSliptypeId(rs.getString("sliptype_id"));
        bean.setSliptypeDesc(rs.getString("sliptype_desc"));
        bean.setTranType(rs.getString("tran_type"));
        bean.setPayTracId(rs.getString("pay_trac_id"));
        bean.setPayBatId(rs.getString("pay_bat_id"));
        bean.setPayTranRefId(rs.getString("pay_tran_ref_id"));
        bean.setPayTranDate(rs.getDate("pay_tran_date"));
        bean.setPayAmt(rs.getBigDecimal("pay_amt"));
        bean.setPayCurr(rs.getString("pay_curr"));
        bean.setPayCode(rs.getString("pay_code"));
        bean.setPayMethod(rs.getString("pay_method"));
        bean.setCampName(rs.getString("camp_name"));
        bean.setContCampCode(rs.getString("cont_camp_code"));
        bean.setContCampName(rs.getString("cont_camp_name"));
        bean.setContCampImgUrl(rs.getString("cont_camp_img_url"));
        bean.setContCampStart(rs.getString("cont_camp_start"));
        bean.setContCampEnd(rs.getString("cont_camp_end"));
        bean.setContCampLastModified(rs.getString("cont_camp_last_modified"));
        bean.setContCampStatus(rs.getString("cont_camp_status"));
        bean.setPointStr(rs.getString("point_str"));
        bean.setResData(rs.getString("res_data"));
        bean.setResStatus(rs.getString("res_status"));
        bean.setResDatetime(rs.getDate("res_datetime"));

        return bean;
    }

    public void processPostActivate(String apiUri, ServiceReq req, Gson gson) throws Exception {
        String reqId = updateServiceRequest(req.getUid(), WSConstants.WAIT, null);
        req.setReqId(reqId);

        CreateActivateDTO reqBean = new CreateActivateDTO();
        reqBean.setActivationCode(req.getActivationCode());
        reqBean.setImei(req.getImei());
        reqBean.setLatitude(new BigDecimal(req.getLatitude()));
        reqBean.setLongitude(new BigDecimal(req.getLongitude()));
        reqBean.setPassword(req.getPassword());
        reqBean.setExternal(req.getExternal().equalsIgnoreCase("true"));

        Type type = new TypeToken<CreateActivateDTO>() {
        }.getType();
        String json = gson.toJson(reqBean, type);

        String data = TaskPost.sendPost(json, apiUri);
        // logic
        ActivateDTO bean = null;
        try {
            bean = gson.fromJson(data, ActivateDTO.class);
        } catch (JsonSyntaxException e) {
        }

        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR, reqId);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND, reqId);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH, reqId);
            insertServiceResponse(bean, data, reqId, WSConstants.FINISH);
        }
    }

    public void processPostCreateRedeemCampaign(String apiUri, ServiceReq req, Gson gson) throws Exception {
        String reqId = updateServiceRequest(req.getUid(), WSConstants.WAIT, null);
        req.setReqId(reqId);

        CreateRedeemCampaignDTO reqBean = new CreateRedeemCampaignDTO();
        reqBean.setBrandId(req.getBrandId());
        reqBean.setBranchId(req.getBranchId());
        reqBean.setCampaignCode(req.getCampaignCode());
        reqBean.setAccount(new Account(req.getAccountType(), req.getAccountValue()));
        reqBean.setExternal(req.getExternal().equalsIgnoreCase("true"));

        Type type = new TypeToken<CreateRedeemCampaignDTO>() {
        }.getType();
        String json = gson.toJson(reqBean, type);

        apiUri = SPUtil.parseUriFormat(apiUri, new String[]{req.getParamTerminalId()});

        String data = TaskPost.sendPost(json, apiUri);
        // logic
        RedeemCampaignDTO bean = null;
        try {
            bean = gson.fromJson(data, RedeemCampaignDTO.class);
        } catch (JsonSyntaxException e) {
        }
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR, reqId);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND, reqId);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH, reqId);
            insertServiceResponse(bean, data, reqId, WSConstants.FINISH);
        }
    }

    public void processPostCreateRedeemCode(String apiUri, ServiceReq req, Gson gson) throws Exception {
        String reqId = updateServiceRequest(req.getUid(), WSConstants.WAIT, null);
        req.setReqId(reqId);

        CreateRedeemCodeDTO reqBean = new CreateRedeemCodeDTO();
        reqBean.setBrandId(req.getBrandId());
        reqBean.setBranchId(req.getBranchId());
        reqBean.setCampaignCode(req.getCampaignCode());
        reqBean.setRewardCode(req.getRewardCode());
        reqBean.setExternal(req.getExternal().equalsIgnoreCase("true"));

        Type type = new TypeToken<CreateRedeemCodeDTO>() {
        }.getType();
        String json = gson.toJson(reqBean, type);

        apiUri = SPUtil.parseUriFormat(apiUri, new String[]{req.getParamTerminalId()});

        String data = TaskPost.sendPost(json, apiUri);
        // logic
        RedeemCodeDTO bean = null;
        try {
            bean = gson.fromJson(data, RedeemCodeDTO.class);
        } catch (JsonSyntaxException e) {
        }

        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR, reqId);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND, reqId);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH, reqId);
            insertServiceResponse(bean, data, reqId, WSConstants.FINISH);
        }
    }

    public void processPostCreateEarnPoint(String apiUri, ServiceReq req, Gson gson) throws Exception {
        String reqId = updateServiceRequest(req.getUid(), WSConstants.WAIT, null);
        req.setReqId(reqId);

        CreateEarnPointDTO reqBean = new CreateEarnPointDTO();
        reqBean.setBrandId(req.getBrandId());
        reqBean.setBranchId(req.getBranchId());
        reqBean.setAccount(new Account(req.getAccountType(), req.getAccountValue()));
        reqBean.setAmount(SPUtil.parseAmout100(req.getEarnPointAmount()));
        reqBean.setExternal(req.getExternal().equalsIgnoreCase("true"));

        Type type = new TypeToken<CreateEarnPointDTO>() {
        }.getType();
        String json = gson.toJson(reqBean, type);

        apiUri = SPUtil.parseUriFormat(apiUri, new String[]{req.getParamTerminalId()});

        String data = TaskPost.sendPost(json, apiUri);
        // logic
        EarnPointDTO bean = null;
        try {
            bean = gson.fromJson(data, EarnPointDTO.class);
        } catch (JsonSyntaxException e) {
        }
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR, reqId);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND, reqId);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH, reqId);
            insertServiceResponse(bean, data, reqId, WSConstants.FINISH);
        }
    }

    public void processGetPrivilegeTrueYouCard(String apiUri, ServiceReq req) throws Exception {
        String reqId = updateServiceRequest(req.getUid(), WSConstants.WAIT, null);
        req.setReqId(reqId);

        apiUri = SPUtil.parseUriFormat(apiUri, new String[]{
            req.getParamTerminalId(),
            req.getBrandId(), req.getBranchId(), req.getAccountType(), req.getAccountValue(), req.getExternal()
        });

        String data = TaskPost.sendGet(apiUri);
        // logic
        Gson gson = new GsonBuilder().create();
        TrueYouCardDTO bean = null;
        try {
            bean = gson.fromJson(data, TrueYouCardDTO.class);
        } catch (JsonSyntaxException e) {
        }
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR, reqId);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND, reqId);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH, reqId);
            insertServiceResponse(bean, data, reqId, WSConstants.FINISH);
        }
        System.out.println("Method: GET, \nUri: " + apiUri + ", \nReturn Msg: " + data);
    }

    public void processPostVoidEarnPoint(String apiUri, ServiceReq req, Gson gson) throws Exception {
        String reqId = updateServiceRequest(req.getUid(), WSConstants.WAIT, null);
        req.setReqId(reqId);

        CreateVoidEarnPointDTO reqBean = new CreateVoidEarnPointDTO();
        reqBean.setBrandId(req.getBrandId());
        reqBean.setBranchId(req.getBranchId());
        reqBean.setExternal(req.getExternal().equalsIgnoreCase("true"));

        Type type = new TypeToken<CreateVoidEarnPointDTO>() {
        }.getType();
        String json = gson.toJson(reqBean, type);

        apiUri = SPUtil.parseUriFormat(apiUri, new String[]{
            req.getParamTerminalId(), req.getParamTraceId()
        });

        String data = TaskPost.sendPost(json, apiUri);
        // logic
        VoidEarnPointDTO bean = null;
        try {
            bean = gson.fromJson(data, VoidEarnPointDTO.class);
        } catch (JsonSyntaxException e) {
        }
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR, reqId);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND, reqId);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH, reqId);
            insertServiceResponse(bean, data, reqId, WSConstants.FINISH);
        }
    }

    public void processPostVoidBurnPoint(String apiUri, ServiceReq req, Gson gson) throws Exception {
        String reqId = updateServiceRequest(req.getUid(), WSConstants.WAIT, null);
        req.setReqId(reqId);

        CreateVoidBurnPointDTO reqBean = new CreateVoidBurnPointDTO();
        reqBean.setBrandId(req.getBrandId());
        reqBean.setBranchId(req.getBranchId());
        reqBean.setExternal(req.getExternal().equalsIgnoreCase("true"));

        Type type = new TypeToken<CreateVoidBurnPointDTO>() {
        }.getType();
        String json = gson.toJson(reqBean, type);

        apiUri = SPUtil.parseUriFormat(apiUri, new String[]{
            req.getParamTerminalId(), req.getParamTraceId()
        });

        String data = TaskPost.sendPost(json, apiUri);
        // logic
        VoidBurnPointDTO bean = null;
        try {
            bean = gson.fromJson(data, VoidBurnPointDTO.class);
        } catch (JsonSyntaxException e) {
        }
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR, reqId);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND, reqId);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH, reqId);
            insertServiceResponse(bean, data, reqId, WSConstants.FINISH);
        }
    }

    public void processGetCampaign(String apiUri, ServiceReq req) throws Exception {
        String reqId = updateServiceRequest(req.getUid(), WSConstants.WAIT, null);
        req.setReqId(reqId);

        apiUri = SPUtil.parseUriFormat(apiUri, new String[]{
            req.getParamTerminalId(),
            req.getBrandId(), req.getBranchId(), req.getRedeemType(), req.getAccountValue(), req.getExternal()
        });
        String data = TaskPost.sendGet(apiUri);
        // logic
        Gson gson = new GsonBuilder().create();
        CampaignDTO bean = null;
        try {
            bean = gson.fromJson(data, CampaignDTO.class);
        } catch (JsonSyntaxException e) {
        }
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR, reqId);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND, reqId);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH, reqId);
            insertServiceResponse(bean, data, reqId, WSConstants.FINISH);
        }

        System.out.println("Method: GET, \nUri: " + apiUri + ", \nReturn Msg: " + data);
    }

    public void processPostCreatePayment(String apiUri, ServiceReq req, Gson gson) throws Exception {
        String reqId = updateServiceRequest(req.getUid(), WSConstants.WAIT, null);
        req.setReqId(reqId);

        CreatePaymentDTO reqBean = new CreatePaymentDTO();
        reqBean.setBrandId(req.getBrandId());
        reqBean.setBranchId(req.getBranchId());
        reqBean.setPayment(new Payment(
                "" + SPUtil.parseAmout100(req.getPaymentAmount()),
                req.getPaymentCurrency(),
                req.getPaymentCode(),
                req.getPaymentMethod(),
                req.getPaymentDescription()
        ));
        reqBean.setExternal(req.getExternal().equalsIgnoreCase("true"));

        Type type = new TypeToken<CreatePaymentDTO>() {
        }.getType();
        String json = gson.toJson(reqBean, type);

        apiUri = SPUtil.parseUriFormat(apiUri, new String[]{
            req.getParamTerminalId()
        });

        String data = TaskPost.sendPost(json, apiUri);
        // logic
        PaymentDTO bean = null;
        try {
            bean = gson.fromJson(data, PaymentDTO.class);
        } catch (JsonSyntaxException e) {
        }
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR, reqId);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND, reqId);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH, reqId);
            insertServiceResponse(bean, data, reqId, WSConstants.FINISH);
        }
    }

    public void processPostVoidPayment(String apiUri, ServiceReq req, Gson gson) throws Exception {
        String reqId = updateServiceRequest(req.getUid(), WSConstants.WAIT, null);
        req.setReqId(reqId);

        CreateVoidPaymentDTO reqBean = new CreateVoidPaymentDTO();
        reqBean.setBrandId(req.getBrandId());
        reqBean.setBranchId(req.getBranchId());
        reqBean.setExternal(req.getExternal().equalsIgnoreCase("true"));

        Type type = new TypeToken<CreateVoidPaymentDTO>() {
        }.getType();
        String json = gson.toJson(reqBean, type);

        apiUri = SPUtil.parseUriFormat(apiUri, new String[]{
            req.getParamTerminalId(), req.getParamTraceId()
        });

        String data = TaskPost.sendPost(json, apiUri);
        // logic
        VoidPaymentDTO bean = null;
        try {
            bean = gson.fromJson(data, VoidPaymentDTO.class);
        } catch (JsonSyntaxException e) {
        }
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR, reqId);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND, reqId);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH, reqId);
            insertServiceResponse(bean, data, reqId, WSConstants.FINISH);
        }
    }

    public void processGetServiceHealth(String apiUri, ServiceReq req) throws Exception {
        String reqId = updateServiceRequest(req.getUid(), WSConstants.WAIT, null);
        req.setReqId(reqId);
        String data = TaskPost.sendGet(apiUri);
        if ("Service is available".equals(data)) {
            updateServiceRequest(req.getUid(), WSConstants.FINISH, reqId);
        }
        System.out.println("Method: GET, \nUri: " + apiUri + ", \nReturn Msg: " + data);
    }

    private String updateServiceRequest(String uid, String status, String oldReqId) throws Exception {
        String sql;
        Connection myConn = null;
        Statement stmt = null;
        String reqId = null;
        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            myConn.setAutoCommit(false);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            if (oldReqId == null) {
                reqId = getUUID();
            }else{
                reqId = oldReqId;
            }
            sql = "update service_req "
                    + "set req_id='" + reqId + "', req_datetime=now(), req_status='" + status + "' "
                    + "where uid='" + uid + "'";
            stmt.executeUpdate(sql);
            myConn.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
            throw e;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }

        return reqId;
    }

    private void insertServiceResponse(TrueYouCardDTO bean, String json, String reqId, String status) throws Exception {
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            myConn.setAutoCommit(false);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //create new response            
            Point point = bean.getPoint();
            List<Pockets> pockets = point.getPockets();
            for (Pockets pocket : pockets) {
                String resId = getUUID();
                SlipType slipType = bean.getSlipType();
                sql = "insert into service_res"
                        + "(uid, req_id, res_data, res_status, res_datetime, "
                        + "true_card_no, card_holder_name, true_card_type, "
                        + "true_card_status, true_card_expired, point_balance, "
                        + "point_pack_desc, point_pack_balance, point_pack_expired, "
                        + "sliptype_id, sliptype_desc) "
                        + "values('" + resId + "', '" + reqId + "', '" + json + "', '" + status + "', now(),"
                        + "'" + bean.getNo() + "', '" + bean.getName() + "', '" + bean.getType() + "', "
                        + "'" + bean.getStatus() + "', '" + bean.getExpired() + "','" + point.getBalance() + "', "
                        + "'" + pocket.getDescription() + "', '" + pocket.getBalance() + "', '" + pocket.getExpired() + "',"
                        + "'" + slipType.getId() + "', '" + slipType.getDescription() + "')";
                stmt.executeUpdate(sql);
            }
            myConn.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
            throw e;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    private void insertServiceResponse(CampaignDTO bean, String json, String reqId, String status) throws Exception {
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            myConn.setAutoCommit(false);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //create new response            
            for (Content content : bean.getContent()) {
                String resId = getUUID();
                if (content.getCampaign() == null) {
                    content.setCampaign(new Campaign());
                }
                sql = "insert into service_res"
                        + "(uid, req_id, res_data, res_status, res_datetime,"
                        + "brand_id, branch_id, terminal_id, "
                        + "cont_camp_code, cont_camp_name, cont_camp_img_url, "
                        + "cont_camp_start, cont_camp_end, cont_camp_last_modified, "
                        + "cont_camp_status) "
                        + "values('" + resId + "', '" + reqId + "', '" + json + "', '" + status + "', now(),"
                        + "'" + content.getBrandId() + "', '" + content.getBranchId() + "', '" + content.getTerminalId() + "',"
                        + "'" + content.getCampaign().getCode() + "', '" + content.getCampaign().getName() + "', '" + content.getCampaign().getImageUrl() + "', "
                        + "'" + content.getCampaign().getStart() + "', '" + content.getCampaign().getEnd() + "', '" + content.getCampaign().getLastModifiedDate() + "', "
                        + "'" + content.getCampaign().getStatus() + "')";
                stmt.executeUpdate(sql);
            }
            if (bean.getContent().isEmpty()) {
                String resId = getUUID();
                sql = "insert into service_res"
                        + "(uid, req_id, res_data, res_status, res_datetime) "
                        + "values('" + resId + "', '" + reqId + "', '" + json + "', '" + status + "', now())";
                stmt.executeUpdate(sql);
            }
            myConn.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
            throw e;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    private void insertServiceResponse(ActivateDTO bean, String json, String reqId, String status) throws Exception {
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            myConn.setAutoCommit(false);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //create new response
            String resId = getUUID();
            sql = "insert into service_res"
                    + "(uid, req_id, res_data,res_status, res_datetime,"
                    + "brand_id, branch_id, terminal_id, "
                    + "serial_no, act_code) "
                    + "values('" + resId + "', '" + reqId + "', '" + json + "', '" + status + "', now(),"
                    + "'" + bean.getBrandId() + "', '" + bean.getBranchId() + "', '" + bean.getTerminalId() + "', "
                    + "'" + bean.getSerialNumber() + "', '" + bean.getActivationCode() + "')";
            stmt.executeUpdate(sql);
            myConn.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
            throw e;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    private void insertServiceResponse(RedeemCampaignDTO bean, String json, String reqId, String status) throws Exception {
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            myConn.setAutoCommit(false);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //create new response
            String resId = getUUID();
            Transaction trans = bean.getTransaction();
            Customer cust = bean.getCustomer();
            sql = "insert into service_res"
                    + "(uid, req_id, res_data,res_status, res_datetime,"
                    + "brand_id, branch_id, terminal_id, "
                    + "true_you_id, tran_trac_id, tran_bat_id, "
                    + "tran_ref_id, tran_date, cust_ref_id, "
                    + "cust_point_used, cust_point_balance) "
                    + "values('" + resId + "', '" + reqId + "', '" + json + "', '" + status + "', now(),"
                    + "'" + bean.getBrandId() + "', '" + bean.getBranchId() + "', '" + bean.getTerminalId() + "', "
                    + "'" + bean.getTrueYouId() + "', '" + trans.getTraceId() + "', '" + trans.getBatchId() + "',  "
                    + "'" + trans.getTransactionReferenceId() + "', '" + trans.getTransactionDate() + "', '" + cust.getCustomerReferenceId() + "', "
                    + "'" + cust.getPointUsed() + "', '" + cust.getPointBalance() + "')";
            stmt.executeUpdate(sql);
            myConn.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
            throw e;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    private void insertServiceResponse(RedeemCodeDTO bean, String json, String reqId, String status) throws Exception {
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            myConn.setAutoCommit(false);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //create new response
            String resId = getUUID();
            Transaction trans = bean.getTransaction();
            sql = "insert into service_res"
                    + "(uid, req_id, res_data,res_status, res_datetime,"
                    + "brand_id, branch_id, terminal_id, "
                    + "true_you_id, tran_trac_id, tran_bat_id, "
                    + "tran_ref_id, tran_date, rew_code) "
                    + "values('" + resId + "', '" + reqId + "', '" + json + "', '" + status + "', now(),"
                    + "'" + bean.getBrandId() + "', '" + bean.getBranchId() + "', '" + bean.getTerminalId() + "', "
                    + "'" + bean.getTrueYouId() + "', '" + trans.getTraceId() + "', '" + trans.getBatchId() + "',  "
                    + "'" + trans.getTransactionReferenceId() + "', '" + trans.getTransactionDate() + "', '" + bean.getRewardCode() + "')";
            stmt.executeUpdate(sql);
            myConn.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
            throw e;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    private void insertServiceResponse(EarnPointDTO bean, String json, String reqId, String status) throws Exception {
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            myConn.setAutoCommit(false);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //create new response
            String resId = getUUID();
            Transaction trans = bean.getTransaction();
            sql = "insert into service_res"
                    + "(uid, req_id, res_data,res_status, res_datetime,"
                    + "brand_id, branch_id, terminal_id, "
                    + "true_you_id, tran_trac_id, tran_bat_id, "
                    + "tran_ref_id, tran_date, "
                    + "acc_type, acc_value, "
                    + "tran_point, tran_amt) "
                    + "values('" + resId + "', '" + reqId + "', '" + json + "', '" + status + "', now(),"
                    + "'" + bean.getBrandId() + "', '" + bean.getBranchId() + "', '" + bean.getTerminalId() + "', "
                    + "'" + bean.getTrueYouId() + "', '" + trans.getTraceId() + "', '" + trans.getBatchId() + "',  "
                    + "'" + trans.getTransactionReferenceId() + "', '" + trans.getTransactionDate() + "', "
                    + "'" + bean.getAccount().getType() + "', '" + bean.getAccount().getValue() + "', "
                    + "'" + trans.getPoints() + "', '" + trans.getAmount() + "')";
            stmt.executeUpdate(sql);
            myConn.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
            throw e;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    private void insertServiceResponse(VoidBurnPointDTO bean, String json, String reqId, String status) throws Exception {
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            myConn.setAutoCommit(false);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //create new response
            String resId = getUUID();
            th.co.softpos.ws.model.Payment payment = bean.getPayment();
            sql = "insert into service_res"
                    + "(uid, req_id, res_data,res_status, res_datetime,"
                    + "brand_id, branch_id, terminal_id, "
                    + "true_you_id, acc_type, acc_value, "
                    + "tran_type, pay_trac_id, pay_bat_id, "
                    + "pay_tran_ref_id, pay_tran_date, pay_amt, "
                    + "pay_curr, pay_code, pay_method, "
                    + "camp_name, point_str) "
                    + "values("
                    + "'" + resId + "', '" + reqId + "', '" + json + "', '" + status + "', now(),"
                    + "'" + bean.getBrandId() + "', '" + bean.getBranchId() + "', '" + bean.getTerminalId() + "', "
                    + "'" + bean.getTrueYouId() + "', '" + bean.getAccount().getType() + "', '" + bean.getAccount().getValue() + "', "
                    + "'" + bean.getTransactionType() + "', '" + payment.getTraceId() + "', '" + payment.getBatchId() + "', "
                    + "'" + payment.getTransactionReferenceId() + "', '" + payment.getTransactionDate() + "', '" + payment.getAmount() + "', "
                    + "'" + payment.getCurrency() + "', '" + payment.getCode() + "', '" + payment.getMethod() + "', "
                    + "'" + bean.getCampaign().getName() + "', '" + bean.getPoint() + "')";
            stmt.executeUpdate(sql);
            myConn.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
            throw e;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    private void insertServiceResponse(PaymentDTO bean, String json, String reqId, String status) throws Exception {
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            myConn.setAutoCommit(false);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //create new response
            String resId = getUUID();
            th.co.softpos.ws.model.Payment payment = bean.getPayment();
            sql = "insert into service_res"
                    + "(uid, req_id, res_data,res_status, res_datetime,"
                    + "brand_id, branch_id, terminal_id, "
                    + "true_you_id, pay_trac_id, pay_bat_id, "
                    + "pay_tran_ref_id, pay_tran_date, pay_amt, "
                    + "pay_curr, pay_code, pay_method) "
                    + "values('" + resId + "', '" + reqId + "', '" + json + "', '" + status + "', now(),"
                    + "'" + bean.getBrandId() + "', '" + bean.getBranchId() + "', '" + bean.getTerminalId() + "', "
                    + "'" + bean.getTrueYouId() + "', '" + payment.getTraceId() + "', '" + payment.getBatchId() + "', "
                    + "'" + payment.getTransactionReferenceId() + "', '" + payment.getTransactionDate() + "', '" + payment.getAmount() + "', "
                    + "'" + payment.getCurrency() + "', '" + payment.getCode() + "', '" + payment.getMethod() + "')";
            stmt.executeUpdate(sql);
            myConn.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
            throw e;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    private void insertServiceResponse(VoidPaymentDTO bean, String json, String reqId, String status) throws Exception {
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            myConn.setAutoCommit(false);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //create new response
            String resId = getUUID();
            th.co.softpos.ws.model.Payment payment = bean.getPayment();
            sql = "insert into service_res"
                    + "(uid, req_id, res_data,res_status, res_datetime,"
                    + "brand_id, branch_id, terminal_id, "
                    + "true_you_id, pay_trac_id, pay_bat_id, "
                    + "pay_tran_ref_id, pay_tran_date, pay_amt, "
                    + "pay_curr, pay_code, pay_method, "
                    + "true_you_id, acc_type, acc_value, "
                    + "tran_type, camp_name, point_str) "
                    + "values("
                    + "'" + resId + "', '" + reqId + "', '" + json + "', '" + status + "', now(),"
                    + "'" + bean.getBrandId() + "', '" + bean.getBranchId() + "', '" + bean.getTerminalId() + "', "
                    + "'" + bean.getTrueYouId() + "', '" + payment.getTraceId() + "', '" + payment.getBatchId() + "', "
                    + "'" + payment.getTransactionReferenceId() + "', '" + payment.getTransactionDate() + "', '" + payment.getAmount() + "', "
                    + "'" + payment.getCurrency() + "', '" + payment.getCode() + "', '" + payment.getMethod() + "', "
                    + "'" + bean.getTrueYouId() + "', '" + bean.getAccount().getType() + "', '" + bean.getAccount().getValue() + "', "
                    + "'" + bean.getTransactionType() + "', '" + bean.getCampaign().getName() + "', '" + bean.getPoint() + "')";
            stmt.executeUpdate(sql);
            myConn.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
            throw e;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    private void insertServiceResponse(VoidEarnPointDTO bean, String json, String reqId, String status) throws Exception {
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            myConn.setAutoCommit(false);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //create new response
            String resId = getUUID();
            th.co.softpos.ws.model.Payment payment = bean.getPayment();
            sql = "insert into service_res"
                    + "(uid, req_id, res_data,res_status, res_datetime,"
                    + "brand_id, branch_id, terminal_id, "
                    + "true_you_id, pay_trac_id, pay_bat_id, "
                    + "pay_tran_ref_id, pay_tran_date, pay_amt, "
                    + "pay_curr, pay_code, pay_method, "
                    + "true_you_id, acc_type, acc_value, "
                    + "tran_type, camp_name, point_str) "
                    + "values("
                    + "'" + resId + "', '" + reqId + "', '" + json + "', '" + status + "', now(),"
                    + "'" + bean.getBrandId() + "', '" + bean.getBranchId() + "', '" + bean.getTerminalId() + "', "
                    + "'" + bean.getTrueYouId() + "', '" + payment.getTraceId() + "', '" + payment.getBatchId() + "', "
                    + "'" + payment.getTransactionReferenceId() + "', '" + payment.getTransactionDate() + "', '" + payment.getAmount() + "', "
                    + "'" + payment.getCurrency() + "', '" + payment.getCode() + "', '" + payment.getMethod() + "', "
                    + "'" + bean.getTrueYouId() + "', '" + bean.getAccount().getType() + "', '" + bean.getAccount().getValue() + "', "
                    + "'" + bean.getTransactionType() + "', '" + bean.getCampaign().getName() + "', '" + bean.getPoint() + "')";
            stmt.executeUpdate(sql);
            myConn.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
            throw e;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    public void truncate(String reqId) {
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            myConn.setAutoCommit(false);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            sql = "delete from service_req where req_id='" + reqId + "'";
            stmt.executeUpdate(sql);

            sql = "delete from service_res where req_id='" + reqId + "'";
            stmt.executeUpdate(sql);

            myConn.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
            logger.error(e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
