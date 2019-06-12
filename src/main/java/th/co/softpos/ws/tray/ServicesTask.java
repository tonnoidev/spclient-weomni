package th.co.softpos.ws.tray;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import th.co.softpos.db.model.ServiceReq;
import th.co.softpos.ws.client.WSConstants;
import th.co.softpos.ws.controller.ServiceController;

public class ServicesTask extends TimerTask {

    private final String name;
    public final ServiceController service = new ServiceController();
    private final SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private final SimpleDateFormat simp2 = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);

    public ServicesTask(String n) {
        this.name = n;
    }

    @Override
    public void run() {
        if ("ServiceTask".equalsIgnoreCase(name)) {
            try {
                String timeCreate = simp.format(new Date()) + "T" + simp2.format(new Date()) + ".000Z";
                System.out.println("Logs: " + timeCreate);

                ServiceReq req = service.getNewReq();
                if (req == null) {
                    return;
                }

                // process service
                Gson gson = new GsonBuilder().create();
                String apiUri;
                for (int i = 0; i < 11; i++) {
                    if (WSConstants.API_NAMES[i].equals(req.getApiName())) {
                        apiUri = WSConstants.MAP_SERVICES.get(WSConstants.API_NAMES[i]).toString();
                        switch (i) {
                            case 0: {
                                try {
                                 service.processPostActivate(apiUri, req, gson);   
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "API Activate Error : "+e.getMessage());
                                }                                
                                break;
                            }
                            case 1: {
                                service.processPostCreateRedeemCampaign(apiUri, req, gson);
                                break;
                            }
                            case 2: {
                                service.processPostCreateRedeemCode(apiUri, req, gson);
                                break;
                            }
                            case 3: {
                                service.processPostCreateEarnPoint(apiUri, req, gson);
                                break;
                            }
                            case 4: {
                                service.processGetPrivilegeTrueYouCard(apiUri, req);
                                break;
                            }
                            case 5: {
                                service.processPostVoidEarnPoint(apiUri, req, gson);
                                break;
                            }
                            case 6: {
                                service.processPostVoidBurnPoint(apiUri, req, gson);
                                break;
                            }
                            case 7: {
                                service.processGetCampaign(apiUri, req);
                                break;
                            }
                            case 8: {
                                try {
                                    service.processPostCreatePayment(apiUri, req, gson);    
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "API Payment Error : "+e.getMessage());
                                }                                
                                break;
                            }
                            case 9: {
                                try {
                                 service.processPostVoidPayment(apiUri, req, gson);   
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "API Void Payment Error : "+e.getMessage());
                                }                                
                                break;
                            }
                            case 10: {
                                service.processGetServiceHealth(apiUri, req);
                                break;
                            }
                        }
                    }
                } // for loop
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "API Error", "API Error\n" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
