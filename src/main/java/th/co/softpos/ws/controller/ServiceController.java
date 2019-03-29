package th.co.softpos.ws.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import th.co.softpos.db.model.ServiceDocs;
import th.co.softpos.db.model.ServiceReq;
import th.co.softpos.db.model.ServiceRes;
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
import th.co.softpos.ws.model.req.Payment;
import th.co.softpos.ws.util.SPUtil;
import th.co.softpos.ws.util.ThaiUtil;

public class ServiceController {

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
        } catch (ClassNotFoundException | SQLException e) {
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
        } catch (ClassNotFoundException | SQLException e) {
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
        } catch (ClassNotFoundException | SQLException e) {
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

            sql = "select * from service_req where req_id is null limit 0,1 ";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    try {
                        reqBean = mappingReq(rs);
                    } catch (Exception e) {
                    }

                }
            }
        } catch (ClassNotFoundException | SQLException e) {
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

    public void processGetPrivilegeTrueYouCard(String apiUri, ServiceReq req) throws Exception {
        updateServiceRequest(req.getUid(), WSConstants.WAIT);

        apiUri = SPUtil.parseUriFormat(apiUri, new String[]{
            req.getParamTerminalId(),
            req.getBrandId(), req.getBranchId(), req.getAccountType(), req.getAccountValue(), req.getExternal()
        });

        String data = TaskPost.sendGet(apiUri);
        // logic
        Gson gson = new GsonBuilder().create();
        TrueYouCardDTO bean = gson.fromJson(data, TrueYouCardDTO.class);
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH);
            insertServiceResponse(bean, data, req.getUid(), WSConstants.FINISH);
        }
        System.out.println("Method: GET, \nUri: " + apiUri + ", \nReturn Msg: " + data);
    }

    public void processGetCampaign(String apiUri, ServiceReq req) throws Exception {
        updateServiceRequest(req.getUid(), WSConstants.WAIT);

        apiUri = SPUtil.parseUriFormat(apiUri, new String[]{
            req.getParamTerminalId(),
            req.getBrandId(), req.getBranchId(), req.getRedeemType(), req.getAccountValue(), req.getExternal()
        });
        String data = TaskPost.sendGet(apiUri);
        // logic
        Gson gson = new GsonBuilder().create();
        CampaignDTO bean = gson.fromJson(data, CampaignDTO.class);
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH);
            insertServiceResponse(bean, data, req.getUid(), WSConstants.FINISH);
        }

        System.out.println("Method: GET, \nUri: " + apiUri + ", \nReturn Msg: " + data);
    }

    public void processGetServiceHealth(String apiUri, ServiceReq req) throws Exception {
        updateServiceRequest(req.getUid(), WSConstants.WAIT);
        String data = TaskPost.sendGet(apiUri);
        if ("Service is available".equals(data)) {
            updateServiceRequest(req.getUid(), WSConstants.FINISH);
        }
        System.out.println("Method: GET, \nUri: " + apiUri + ", \nReturn Msg: " + data);
    }

    public void processPostActivate(String apiUri, ServiceReq req, Gson gson) throws Exception {
        updateServiceRequest(req.getUid(), WSConstants.WAIT);

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
        ActivateDTO bean = gson.fromJson(data, ActivateDTO.class);
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH);
            insertServiceResponse(bean, data, req.getUid(), WSConstants.FINISH);
        }
    }

    public void processPostCreateRedeemCampaign(String apiUri, ServiceReq req, Gson gson) throws Exception {
        updateServiceRequest(req.getUid(), WSConstants.WAIT);

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
        RedeemCampaignDTO bean = gson.fromJson(data, RedeemCampaignDTO.class);
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH);
//            insertServiceResponse(bean, data, req.getUid(), WSConstants.FINISH);
        }
    }

    public void processPostCreateRedeemCode(String apiUri, ServiceReq req, Gson gson) throws Exception {
        updateServiceRequest(req.getUid(), WSConstants.WAIT);

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
        RedeemCodeDTO bean = gson.fromJson(data, RedeemCodeDTO.class);
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH);
//            insertServiceResponse(bean, data, req.getUid(), WSConstants.FINISH);
        }
    }

    public void processPostCreateEarnPoint(String apiUri, ServiceReq req, Gson gson) throws Exception {
        updateServiceRequest(req.getUid(), WSConstants.WAIT);

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
        EarnPointDTO bean = gson.fromJson(data, EarnPointDTO.class);
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH);
//            insertServiceResponse(bean, data, req.getUid(), WSConstants.FINISH);
        }
    }

    public void processPostVoidEarnPoint(String apiUri, ServiceReq req, Gson gson) throws Exception {
        updateServiceRequest(req.getUid(), WSConstants.WAIT);

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
        VoidEarnPointDTO bean = gson.fromJson(data, VoidEarnPointDTO.class);
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH);
//            insertServiceResponse(bean, data, req.getUid(), WSConstants.FINISH);
        }
    }

    public void processPostVoidBurnPoint(String apiUri, ServiceReq req, Gson gson) throws Exception {
        updateServiceRequest(req.getUid(), WSConstants.WAIT);

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
        VoidBurnPointDTO bean = gson.fromJson(data, VoidBurnPointDTO.class);
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH);
//            insertServiceResponse(bean, data, req.getUid(), WSConstants.FINISH);
        }
    }

    public void processPostCreatePayment(String apiUri, ServiceReq req, Gson gson) throws Exception {
        updateServiceRequest(req.getUid(), WSConstants.WAIT);

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
        PaymentDTO bean = gson.fromJson(data, PaymentDTO.class);
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH);
//            insertServiceResponse(bean, data, req.getUid(), WSConstants.FINISH);
        }
    }

    public void processPostVoidPayment(String apiUri, ServiceReq req, Gson gson) throws Exception {
        updateServiceRequest(req.getUid(), WSConstants.WAIT);

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
        VoidPaymentDTO bean = gson.fromJson(data, VoidPaymentDTO.class);
        if (bean == null) {
            ErrorArrayDTO errors = getErrorFromData(data, gson);
            if (errors != null) {
                updateServiceRequest(req.getUid(), WSConstants.ERROR);
            } else {
                updateServiceRequest(req.getUid(), WSConstants.NOT_FOUND);
            }
        } else {
            updateServiceRequest(req.getUid(), WSConstants.FINISH);
//            insertServiceResponse(bean, data, req.getUid(), WSConstants.FINISH);
        }
    }

    private void updateServiceRequest(String uid, String status) throws Exception {
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String reqId = getUUID();
            sql = "update service_req "
                    + "set req_id='" + reqId + "', req_datetime=curdate(), req_status='" + status + "' "
                    + "where uid='" + uid + "'";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
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
            }
        }
    }

    private void insertServiceResponse(TrueYouCardDTO bean, String json, String reqId, String status) throws Exception {
        String sql;
        Connection myConn = null;
        Statement stmt = null;

        try {
            Class.forName(DBConstant.CLASS_NAME);
            myConn = DriverManager.getConnection(DBConstant.DRIVER, DBConstant.USERNAME, DBConstant.PASSWORD);
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //create new response
            String resId = getUUID();
            sql = "insert into service_res"
                    + "(uid, req_id, res_data,res_status, res_datetime,"
                    + "true_card_no, card_holder_name, true_card_type, true_card_status, true_card_expired, "
                    + "point_balance, point_pack_desc, point_pack_balance, point_pack_expired, "
                    + "sliptype_id, sliptype_desc) "
                    + "values("
                    + "'" + resId + "', '" + reqId + "', '" + json + "', '" + status + "', curdate(),"
                    + "'" + bean.getFalses() + "', '" + bean.getName() + "', '" + bean.getType() + "', '" + bean.getStatus() + "', '" + bean.getExpired() + "',"
                    + "'" + bean.getPoint().getBalance() + "', '" + bean.getPoint().getPockets().get(0) + "', '" + bean.getPoint().getPockets().get(1) + "', '" + bean.getPoint().getPockets().get(2) + "',"
                    + "'" + bean.getSlipType().getId() + "', '" + bean.getSlipType().getDescription() + "'"
                    + ")";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
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
            stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //create new response
            String resId = getUUID();
            sql = "insert into service_res"
                    + "(uid, req_id, res_data,res_status, res_datetime,"
                    + "brand_id, branch_id, terminal_id, "
                    + "cont_camp_code, "
                    + "cont_camp_name, "
                    + "cont_camp_img_url, "
                    + "cont_camp_start, "
                    + "cont_camp_end, "
                    + "cont_camp_last_modified, "
                    + "cont_camp_status) "
                    + "values("
                    + "'" + resId + "', '" + reqId + "', '" + json + "', '" + status + "', curdate(),"
                    + "'" + bean.getContent().get(0).getBrandId() + "', '" + bean.getContent().get(0).getBranchId() + "', '" + bean.getContent().get(0).getTerminalId() + "',"
                    + "'" + bean.getContent().get(0).getCampaign().getCode() + "', "
                    + "'" + bean.getContent().get(0).getCampaign().getName() + "', "
                    + "'" + bean.getContent().get(0).getCampaign().getImageUrl() + "', "
                    + "'" + bean.getContent().get(0).getCampaign().getStart() + "', "
                    + "'" + bean.getContent().get(0).getCampaign().getEnd() + "', "
                    + "'" + bean.getContent().get(0).getCampaign().getLastModifiedDate() + "', "
                    + "'" + bean.getContent().get(0).getCampaign().getStatus() + "'"
                    + ")";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: \n" + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
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
            }
        }
    }

    private void insertServiceResponse(ActivateDTO bean, String json, String reqId, String status) {

    }

}