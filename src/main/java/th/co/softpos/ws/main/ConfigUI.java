package th.co.softpos.ws.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

public class ConfigUI extends javax.swing.JDialog {

    public ConfigUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        loadAllConfig();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbServer = new javax.swing.JLabel();
        txtServer = new javax.swing.JTextField();
        lbDb = new javax.swing.JLabel();
        txtDb = new javax.swing.JTextField();
        lbUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lbPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lbPort = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        lbCharset = new javax.swing.JLabel();
        txtCharset = new javax.swing.JTextField();
        btnSaveDatabaseConfig = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbClientId = new javax.swing.JLabel();
        txtClientId = new javax.swing.JTextField();
        lbClientSecret = new javax.swing.JLabel();
        txtClientSecret = new javax.swing.JTextField();
        lbAccessToken = new javax.swing.JLabel();
        txtAccessToken = new javax.swing.JTextField();
        lbAppId = new javax.swing.JLabel();
        txtAppId = new javax.swing.JTextField();
        btnSaveServiceConfig = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuration");

        lbServer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbServer.setText("MySQL Server");

        txtServer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbDb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDb.setText("Database");

        txtDb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbUsername.setText("Username");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbPassword.setText("Password");

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbPort.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbPort.setText("Port");

        txtPort.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbCharset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCharset.setText("Charset");

        txtCharset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnSaveDatabaseConfig.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSaveDatabaseConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        btnSaveDatabaseConfig.setText("SAVE");
        btnSaveDatabaseConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDatabaseConfigActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("* เมื่อทำการบันทึกข้อมูลใหม่ ให้ restart program อีกครั้ง");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbServer, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtServer))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbCharset, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCharset))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbDb, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDb))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsername))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbPort, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPort))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveDatabaseConfig)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbServer)
                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDb)
                    .addComponent(txtDb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPort)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCharset)
                    .addComponent(txtCharset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveDatabaseConfig)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Database Config", jPanel1);

        lbClientId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbClientId.setText("CLIENT_ID");

        txtClientId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbClientSecret.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbClientSecret.setText("CLIENT_SECRET");

        txtClientSecret.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbAccessToken.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbAccessToken.setText("ACCESS_TOKEN");

        txtAccessToken.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbAppId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbAppId.setText("APP_ID");

        txtAppId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnSaveServiceConfig.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSaveServiceConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        btnSaveServiceConfig.setText("SAVE");
        btnSaveServiceConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveServiceConfigActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("* เมื่อทำการบันทึกข้อมูลใหม่ ให้ restart program อีกครั้ง");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbClientId, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClientId, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbAppId, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAppId))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbClientSecret, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClientSecret))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbAccessToken, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAccessToken))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveServiceConfig)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbClientId)
                    .addComponent(txtClientId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbClientSecret)
                    .addComponent(txtClientSecret, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAccessToken)
                    .addComponent(txtAccessToken, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAppId)
                    .addComponent(txtAppId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveServiceConfig)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Service Config", jPanel2);

        jMenu1.setText("File");

        jMenuItem3.setText("Tables...");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("Close");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveDatabaseConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDatabaseConfigActionPerformed
        saveDbConf();
    }//GEN-LAST:event_btnSaveDatabaseConfigActionPerformed

    private void btnSaveServiceConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveServiceConfigActionPerformed
        saveServiceConf();
    }//GEN-LAST:event_btnSaveServiceConfigActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ScriptCreateTable script = new ScriptCreateTable(null, true);
        script.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveDatabaseConfig;
    private javax.swing.JButton btnSaveServiceConfig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbAccessToken;
    private javax.swing.JLabel lbAppId;
    private javax.swing.JLabel lbCharset;
    private javax.swing.JLabel lbClientId;
    private javax.swing.JLabel lbClientSecret;
    private javax.swing.JLabel lbDb;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbPort;
    private javax.swing.JLabel lbServer;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JTextField txtAccessToken;
    private javax.swing.JTextField txtAppId;
    private javax.swing.JTextField txtCharset;
    private javax.swing.JTextField txtClientId;
    private javax.swing.JTextField txtClientSecret;
    private javax.swing.JTextField txtDb;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtServer;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void saveDbConf() {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("app/db.properties");
            prop.setProperty("mysql.server", txtServer.getText());
            prop.setProperty("mysql.db", txtDb.getText());
            prop.setProperty("mysql.username", txtUsername.getText());
            prop.setProperty("mysql.password", txtPassword.getText());
            prop.setProperty("mysql.port", txtPort.getText());
            prop.setProperty("mysql.charset", txtCharset.getText());
            prop.store(output, null);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "IO Error: "+e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            return;
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                }
            }
        }
        
        JOptionPane.showMessageDialog(this, "Save Data Complete.");
    }

    private void saveServiceConf() {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("app/config.properties");
            prop.setProperty("CLIENT_ID", txtClientId.getText());
            prop.setProperty("CLIENT_SECRET", txtClientSecret.getText());
            prop.setProperty("ACCESS_TOKEN", txtAccessToken.getText());
            prop.setProperty("APP_ID", txtAppId.getText());
            prop.store(output, null);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "IO Error: "+e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            return;
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Save Data Complete.");
    }

    private void loadAllConfig() {
        // load db config
        loadDbConfig();
        // load service config
        loadServiceConfig();
    }

    private void loadDbConfig() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("app/db.properties");
            prop.load(input);

            txtServer.setText(prop.getProperty("mysql.server"));
            txtDb.setText(prop.getProperty("mysql.db"));
            txtUsername.setText(prop.getProperty("mysql.username"));
            txtPassword.setText(prop.getProperty("mysql.password"));
            txtPort.setText(prop.getProperty("mysql.port"));
            txtCharset.setText(prop.getProperty("mysql.charset"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "IO Error: "+e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private void loadServiceConfig() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("app/config.properties");
            prop.load(input);

            txtClientId.setText(prop.getProperty("CLIENT_ID"));
            txtClientSecret.setText(prop.getProperty("CLIENT_SECRET"));
            txtAccessToken.setText(prop.getProperty("ACCESS_TOKEN"));
            txtAppId.setText(prop.getProperty("APP_ID"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "IO Error: "+e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
