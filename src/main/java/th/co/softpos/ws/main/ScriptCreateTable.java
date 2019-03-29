package th.co.softpos.ws.main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScriptCreateTable extends javax.swing.JDialog {

    public ScriptCreateTable(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        loadSql();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCreateServiceDocs = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCreateServiceReq = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCreateServiceRes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generate Table Creatation");

        txtCreateServiceDocs.setColumns(20);
        txtCreateServiceDocs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCreateServiceDocs.setLineWrap(true);
        txtCreateServiceDocs.setRows(5);
        jScrollPane1.setViewportView(txtCreateServiceDocs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Service Docs", jPanel1);

        txtCreateServiceReq.setColumns(20);
        txtCreateServiceReq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCreateServiceReq.setLineWrap(true);
        txtCreateServiceReq.setRows(5);
        jScrollPane2.setViewportView(txtCreateServiceReq);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Service Request", jPanel2);

        txtCreateServiceRes.setColumns(20);
        txtCreateServiceRes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCreateServiceRes.setLineWrap(true);
        txtCreateServiceRes.setRows(5);
        jScrollPane3.setViewportView(txtCreateServiceRes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Service Response", jPanel3);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea txtCreateServiceDocs;
    private javax.swing.JTextArea txtCreateServiceReq;
    private javax.swing.JTextArea txtCreateServiceRes;
    // End of variables declaration//GEN-END:variables

    private void loadSql() {
        loadDocs();
        loadReq();
        loadRes();
    }

    private void loadDocs() {
        File file = new File("app/db/service_docs.sql");
        StringBuilder result = new StringBuilder("");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
        }
        txtCreateServiceDocs.setText(result.toString());
    }

    private void loadReq() {
        File file = new File("app/db/service_req.sql");
        StringBuilder result = new StringBuilder("");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
        }
        txtCreateServiceReq.setText(result.toString());
    }

    private void loadRes() {
        File file = new File("app/db/service_res.sql");
        StringBuilder result = new StringBuilder("");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
        }
        txtCreateServiceRes.setText(result.toString());
    }
}
