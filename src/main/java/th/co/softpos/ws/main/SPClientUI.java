package th.co.softpos.ws.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import th.co.softpos.ws.client.POSConstant;
import th.co.softpos.ws.client.WSConstants;
import th.co.softpos.ws.model.AccessToken;

public class SPClientUI extends javax.swing.JDialog {

    private final Map map = new HashMap();
    private final String[] API = new String[]{
        "API_ACTIVATE",
        "API_PRIVILEGE_REDEEM_CAMPAIGN",
        "API_PRIVILEGE_REDEEM_CODE",
        "API_PRIVILEGE_EARN_POINT",
        "API_PRIVILEGE_TRUE_YOU_CARD",
        "API_PRIVILEGE_EARN_POINT_VOID",
        "API_PRIVILEGE_BURN_POINT_VOID",
        "API_CAMPAIGN",
        "API_PAYMENTS",
        "API_PAYMENTS_VOID",
        "API_POS_HEALTH"
    };

    public SPClientUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("services_tray.png").getFile());
            Image image = ImageIO.read(file);
            this.setIconImage(image);
        } catch (IOException e) {
        }

        initCombo();
        loadToken();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cbServiceType = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRequest = new javax.swing.JTextArea();
        btnRequest = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtResponse = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdGet = new javax.swing.JRadioButton();
        rdPost = new javax.swing.JRadioButton();
        btnGenerateToken = new javax.swing.JButton();
        txtToken = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtApiRequest = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Service Management");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Get Services");

        cbServiceType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbServiceType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbServiceTypeItemStateChanged(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtRequest.setColumns(20);
        txtRequest.setRows(5);
        jScrollPane2.setViewportView(txtRequest);

        btnRequest.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRequest.setText("Request Submit");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        txtResponse.setColumns(20);
        txtResponse.setRows(5);
        jScrollPane4.setViewportView(txtResponse);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Request JSON");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Response JSON");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRequest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)))
        );

        jTabbedPane1.addTab("Client Information", jPanel1);

        buttonGroup1.add(rdGet);
        rdGet.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdGet.setSelected(true);
        rdGet.setText("GET");

        buttonGroup1.add(rdPost);
        rdPost.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdPost.setText("POST");

        btnGenerateToken.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGenerateToken.setText("Generate Token");
        btnGenerateToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateTokenActionPerformed(evt);
            }
        });

        txtToken.setEditable(false);
        txtToken.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtApiRequest.setColumns(20);
        txtApiRequest.setLineWrap(true);
        txtApiRequest.setRows(5);
        jScrollPane1.setViewportView(txtApiRequest);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGenerateToken)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtToken))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdGet)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdPost)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerateToken, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtToken, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdGet)
                    .addComponent(rdPost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbServiceTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbServiceTypeItemStateChanged
        actionCombo();
    }//GEN-LAST:event_cbServiceTypeItemStateChanged

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        requestAction();
    }//GEN-LAST:event_btnRequestActionPerformed

    private void btnGenerateTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateTokenActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to generate new token again !");
        if (confirm == JOptionPane.YES_OPTION) {
            generateToken();
        }
    }//GEN-LAST:event_btnGenerateTokenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateToken;
    private javax.swing.JButton btnRequest;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbServiceType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdGet;
    private javax.swing.JRadioButton rdPost;
    private javax.swing.JTextArea txtApiRequest;
    private javax.swing.JTextArea txtRequest;
    private javax.swing.JTextArea txtResponse;
    private javax.swing.JTextField txtToken;
    // End of variables declaration//GEN-END:variables

    private void initCombo() {
        map.put(API[0], WSConstants.API_ACTIVATE);
        map.put(API[1], WSConstants.API_PRIVILEGE_REDEEM_CAMPAIGN);
        map.put(API[2], WSConstants.API_PRIVILEGE_REDEEM_CODE);
        map.put(API[3], WSConstants.API_PRIVILEGE_EARN_POINT);
        map.put(API[4], WSConstants.API_PRIVILEGE_TRUE_YOU_CARD);
        map.put(API[5], WSConstants.API_PRIVILEGE_EARN_POINT_VOID);
        map.put(API[6], WSConstants.API_PRIVILEGE_BURN_POINT_VOID);
        map.put(API[7], WSConstants.API_CAMPAIGN);
        map.put(API[8], WSConstants.API_PAYMENTS);
        map.put(API[9], WSConstants.API_PAYMENTS_VOID);
        map.put(API[10], WSConstants.API_POS_HEALTH);

        for (String apiUri : API) {
            cbServiceType.addItem(apiUri);
        }
    }

    private void actionCombo() {
        txtRequest.setText("");
        txtResponse.setText("");

        Object itemSel = map.get(cbServiceType.getSelectedItem());
        if (itemSel != null) {
            txtApiRequest.setText(itemSel.toString());
            String reqFile = loadJsonSampleFile(cbServiceType.getSelectedItem().toString());
            if ("".equals(reqFile)) {
                txtRequest.setText("");
                txtResponse.setText("");
                rdGet.setSelected(true);
            } else {
                txtRequest.setText(reqFile);
                txtResponse.setText("");
                rdPost.setSelected(true);
            }

        }
    }

    private void requestAction() {
        if (inValidRequest()) {
            JOptionPane.showMessageDialog(this, "กรุณาระบุข้อมูลใน { } ให้ครบถ้วน !");
            return;
        }
        String data;
        if (rdPost.isSelected()) {
            data = TaskPost.sendPost(txtRequest.getText(), txtApiRequest.getText());
            txtResponse.setText(formatJson(data));
        } else if (rdGet.isSelected()) {
            data = TaskPost.sendGet(txtApiRequest.getText());
            txtResponse.setText(formatJson(data));
        }
    }

    private static String formatJson(String data) {
        String temp = "";
        data = data.replace(",", ",\n    ");
        for (int i = 0; i < data.length(); i++) {
            String c = "" + data.charAt(i);
            if (c.contains("{")) {
                c = "\n" + c + "\n    ";
            } else if (c.contains("}")) {
                c = "\n" + c;
            }
            temp += c;
        }
        temp = temp.trim();
        return temp;
    }

    private String loadJsonSampleFile(String apiName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("json/" + apiName + "_req.json").getFile());

        StringBuilder result = new StringBuilder("");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
        }

        return result.toString();
    }

    private boolean inValidRequest() {
        return txtApiRequest.getText().contains("{");
    }

    private void generateToken() {
        String tokenResponse = TaskPost.getToken("", "");
        System.out.println(tokenResponse);

        Gson gson = new GsonBuilder().create();
        AccessToken tokenBean = gson.fromJson(tokenResponse, AccessToken.class);

        String token = tokenBean.getAccessToken();
        POSConstant.ACCESS_TOKEN = token;

        txtToken.setText(token);

        writeToken();
    }

    private void loadToken() {
        Properties prop = new Properties();
        InputStream input = null;
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            input = new FileInputStream(classLoader.getResource("config.properties").getFile());
            prop.load(input);

            POSConstant.CLIENT_ID = prop.getProperty("CLIENT_ID");
            POSConstant.CLIENT_SECRET = prop.getProperty("CLIENT_SECRET");
            POSConstant.ACCESS_TOKEN = prop.getProperty("ACCESS_TOKEN");

            txtToken.setText(POSConstant.ACCESS_TOKEN);
        } catch (IOException e) {
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        }

    }

    private void writeToken() {
        Properties prop = new Properties();
        OutputStream output = null;
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            output = new FileOutputStream(classLoader.getResource("config.properties").getFile());
            prop.setProperty("CLIENT_ID", POSConstant.CLIENT_ID);
            prop.setProperty("CLIENT_SECRET", POSConstant.CLIENT_SECRET);
            prop.setProperty("ACCESS_TOKEN", txtToken.getText());
            prop.store(output, null);
        } catch (IOException e) {
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                }
            }
        }
    }

}
