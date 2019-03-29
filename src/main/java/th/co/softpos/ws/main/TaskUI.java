package th.co.softpos.ws.main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import th.co.softpos.db.model.ServiceDocs;
import th.co.softpos.db.model.ServiceReq;
import th.co.softpos.db.model.ServiceRes;
import th.co.softpos.ws.controller.ServiceController;

public class TaskUI extends javax.swing.JDialog {

    private DefaultTableModel serviceDocsModel = null;
    private DefaultTableModel serviceReqModel = null;
    private DefaultTableModel serviceResModel = null;

    private final ServiceController serviceController = new ServiceController();

    public TaskUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        initWindow();

        serviceDocsModel = (DefaultTableModel) tbServiceDocs.getModel();
        serviceReqModel = (DefaultTableModel) tbServiceRequest.getModel();
        serviceResModel = (DefaultTableModel) tbServiceResponse.getModel();
        initTable(tbServiceDocs);
        initTable(tbServiceRequest);
        initTable(tbServiceResponse);

        loadServiceLogs();
        refresh();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbServiceRequest = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbServiceResponse = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbServiceDocs = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Task Transaction Table");

        tbServiceRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "uid", "api_name", "req_id", "req_datetime", "req_status", "act_code", "imei", "latitude", "longitude", "passwd", "ext", "brand_id", "branch_id", "camp_code", "acc_type", "acc_value", "rew_code", "earn_point_amt", "pay_amt", "pay_curr", "pay_code", "pay_method", "pay_desc"
            }
        ));
        tbServiceRequest.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tbServiceRequest);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Service Request", jPanel1);

        tbServiceResponse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "uid", "req_id", "brand_id", "branch_id", "terminal_id", "serial_no", "act_code", "true_you_id", "tran_trac_id", "tran_bat_id", "tran_ref_id", "tran_date", "tran_point", "tran_amt", "cust_ref_id", "cust_point_used", "cust_point_balance", "rew_code", "acc_type", "acc_value", "true_card_no", "card_holder_name", "true_card_type", "true_card_status", "true_card_expired", "point_balance", "point_pack_desc", "point_pack_balance", "point_pack_expired", "sliptype_id", "sliptype_desc", "tran_type", "pay_trac_id", "pay_bat_id", "pay_tran_ref_id", "pay_tran_date", "pay_amt", "pay_curr", "pay_code", "pay_method", "camp_name", "cont_camp_code", "cont_camp_name", "cont_camp_img_url", "cont_camp_start", "cont_camp_end", "cont_camp_last_modified", "cont_camp_status", "point_str", "res_data", "res_status", "req_datetime", "req_time_diff"
            }
        ));
        tbServiceResponse.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tbServiceResponse);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Service Response", jPanel2);

        tbServiceDocs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "api_id", "api_name", "api_uri", "api_desc", "api_method"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbServiceDocs);
        if (tbServiceDocs.getColumnModel().getColumnCount() > 0) {
            tbServiceDocs.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbServiceDocs.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbServiceDocs.getColumnModel().getColumn(2).setPreferredWidth(350);
            tbServiceDocs.getColumnModel().getColumn(3).setPreferredWidth(400);
            tbServiceDocs.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Service Document", jPanel3);

        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRefresh.setText("Refresh Data");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbServiceDocs;
    private javax.swing.JTable tbServiceRequest;
    private javax.swing.JTable tbServiceResponse;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        clearModel(serviceReqModel);
        List<ServiceReq> listReqBean = serviceController.findServiceRequestAll();
        for (ServiceReq bean : listReqBean) {
            serviceReqModel.addRow(new Object[]{
                bean.getUid(),
                bean.getApiName(),
                bean.getReqId(),
                bean.getReqDatetime(),
                bean.getReqStatus(),
                bean.getActivationCode(),
                bean.getImei(),
                bean.getLatitude(),
                bean.getLongitude(),
                bean.getPassword(),
                bean.getExternal(),
                bean.getBrandId(),
                bean.getBranchId(),
                bean.getCampaignCode(),
                bean.getAccountType(),
                bean.getAccountValue(),
                bean.getRewardCode(),
                bean.getEarnPointAmount(),
                bean.getPaymentAmount(),
                bean.getPaymentCurrency(),
                bean.getPaymentCode(),
                bean.getPaymentMethod(),
                bean.getPaymentDescription()
            });
        }

        clearModel(serviceResModel);
        List<ServiceRes> listResBean = serviceController.findServiceResponseAll();
        for (ServiceRes bean : listResBean) {
            serviceResModel.addRow(new Object[]{
                bean.getUid(),
                bean.getReqId(),
                bean.getBrandId(),
                bean.getBranchId(),
                bean.getTerminalId(),
                bean.getSerialNo(),
                bean.getActCode(),
                bean.getTrueYouId(),
                bean.getTranTracId(),
                bean.getTranBatId(),
                bean.getTranRefId(),
                bean.getTranDate(),
                bean.getTranPoint(),
                bean.getTranAmt(),
                bean.getCustRefId(),
                bean.getCustPointUsed(),
                bean.getCustPointBalance(),
                bean.getRewCode(),
                bean.getAccType(),
                bean.getAccValue(),
                bean.getTrueCardNo(),
                bean.getCardHolderName(),
                bean.getTrueCardType(),
                bean.getTrueCardStatus(),
                bean.getTrueCardExpired(),
                bean.getPointBalance(),
                bean.getPointPackDesc(),
                bean.getPointPackBalance(),
                bean.getPointPackExpired(),
                bean.getSliptypeId(),
                bean.getSliptypeDesc(),
                bean.getTranType(),
                bean.getPayTracId(),
                bean.getPayBatId(),
                bean.getPayTranRefId(),
                bean.getPayTranDate(),
                bean.getPayAmt(),
                bean.getPayCurr(),
                bean.getPayCode(),
                bean.getPayMethod(),
                bean.getCampName(),
                bean.getContCampCode(),
                bean.getContCampName(),
                bean.getContCampImgUrl(),
                bean.getContCampStart(),
                bean.getContCampEnd(),
                bean.getContCampLastModified(),
                bean.getContCampStatus(),
                bean.getPointStr(),
                bean.getResData(),
                bean.getResStatus(),
                bean.getResDatetime()
            });
        }
    }

    private void loadServiceLogs() {
        clearModel(serviceDocsModel);
        List<ServiceDocs> listBean = serviceController.findServiceDocsAll();
        for (ServiceDocs bean : listBean) {
            serviceDocsModel.addRow(new Object[]{
                bean.getApiId(),
                bean.getApiName(),
                bean.getApiUri(),
                bean.getApiDesc(),
                bean.getApiMethod()
            });
        }
    }

    private void clearModel(DefaultTableModel model) {
        int size = model.getRowCount();
        for (int i = 0; i < size; i++) {
            model.removeRow(0);
        }
    }

    private void initTable(JTable tb) {
        tb.setFont(new Font("Tahoma", Font.PLAIN, 12));
        tb.setRowHeight(25);
        JTableHeader tHead = tb.getTableHeader();
        tHead.setFont(new Font("Tahoma", Font.BOLD, 12));
    }

    private void initWindow() {
        try {
            File file = new File("app/services_tray.png");
            Image image = ImageIO.read(file);
            this.setIconImage(image);
        } catch (IOException e) {
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(0, 0);
        setSize(screenSize);
    }
}
