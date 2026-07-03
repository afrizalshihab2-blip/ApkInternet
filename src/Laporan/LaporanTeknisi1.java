/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Laporan;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperExportManager;



public class LaporanTeknisi1 extends javax.swing.JPanel {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;

    public LaporanTeknisi1() {
        initComponents(); 
        loadDashboard();
        datatable();
    }
    

    private void loadDashboard() {
        try {
         
        PreparedStatement ps1 = conn.prepareStatement("SELECT COUNT(*) total FROM teknisi");
        ResultSet rs1 = ps1.executeQuery();
        if (rs1.next()) lbltotal.setText(String.valueOf(rs1.getInt("total")));

        PreparedStatement ps2 = conn.prepareStatement("SELECT COUNT(*) total FROM teknisi WHERE status='Aktif'");
        ResultSet rs2 = ps2.executeQuery();
        if (rs2.next()) lblaktif.setText(String.valueOf(rs2.getInt("total")));

        PreparedStatement ps3 = conn.prepareStatement("SELECT COUNT(*) total FROM teknisi WHERE status='Cuti'");
        ResultSet rs3 = ps3.executeQuery();
        if (rs3.next()) lblcuti.setText(String.valueOf(rs3.getInt("total")));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dashboard error: " + e.getMessage());
        }
    }

 
    
    protected void datatable(){
        Object[] Baris ={"No", "Nama Teknisi", "Spesialis", "Tiket Ditangani", "Tiket Selesai", "Status"};
          tabmode = new DefaultTableModel(null, Baris);
         
        try{
            String filterStatus = cbstatus.getSelectedItem().toString();

        String sql;
        PreparedStatement pst;

        if (filterStatus.equals("Semua")) {
            sql = "SELECT t.nama, t.spesialis, " +
                  "COUNT(tk.no_tiket) AS tiket_ditangani, " +
                  "SUM(CASE WHEN tk.status='Selesai' THEN 1 ELSE 0 END) AS tiket_selesai, " +
                  "t.status " +
                  "FROM teknisi t " +
                  "LEFT JOIN tiket tk ON t.id_teknisi = tk.id_teknisi " +
                  "GROUP BY t.id_teknisi, t.nama, t.spesialis, t.status " +
                  "ORDER BY t.nama ASC";
            pst = conn.prepareStatement(sql);
        } else {
            sql = "SELECT t.nama, t.spesialis, " +
                  "COUNT(tk.no_tiket) AS tiket_ditangani, " +
                  "SUM(CASE WHEN tk.status='Selesai' THEN 1 ELSE 0 END) AS tiket_selesai, " +
                  "t.status " +
                  "FROM teknisi t " +
                  "LEFT JOIN tiket tk ON t.id_teknisi = tk.id_teknisi " +
                  "WHERE t.status=? " +
                  "GROUP BY t.id_teknisi, t.nama, t.spesialis, t.status " +
                  "ORDER BY t.nama ASC";
            pst = conn.prepareStatement(sql);
            pst.setString(1, filterStatus);
        }

        ResultSet hasil = pst.executeQuery();
        int no = 1;
        while (hasil.next()) {
            tabmode.addRow(new Object[]{
                no++,
                hasil.getString("nama"),
                hasil.getString("spesialis"),
                hasil.getInt("tiket_ditangani"),
                hasil.getInt("tiket_selesai"),
                hasil.getString("status")
            });
        }
                tblteknisi.setModel(tabmode);
                
            }catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"data gagal dianggil"+e);
            }
    }
    
   public void cetak() {
    try {
        String filterStatus = cbstatus.getSelectedItem().toString();
        
        String path = "./src/Laporan/LaporanTeknisi.jasper"; 
        HashMap parameter = new HashMap();
        parameter.put("P_STATUS", filterStatus);
        
        JasperPrint print = JasperFillManager.fillReport(path, parameter, conn);
        JasperViewer.viewReport(print, false);
        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Gagal cetak: " + ex);
    }
    }
      public void exportPDF() {
    try {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Simpan PDF");
        fc.setSelectedFile(new java.io.File("LaporanPaket.pdf"));
        int result = fc.showSaveDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getAbsolutePath();
            if (!path.endsWith(".pdf")) path += ".pdf";
            
            String jasperPath = "./src/Laporan/LaporanTeknisi1.jasper";
            HashMap parameter = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(jasperPath, parameter, conn);
            JasperExportManager.exportReportToPdfFile(print, path);
            JOptionPane.showMessageDialog(null, "PDF berhasil disimpan!");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Gagal export PDF: " + ex);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblaktif = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblcuti = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblteknisi = new javax.swing.JTable();
        cbstatus = new javax.swing.JComboBox<>();
        bCetak = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(11, 20, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 204));
        jLabel1.setText("Laporan Teknisi");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 35, -1, 57));

        jPanel2.setBackground(new java.awt.Color(11, 26, 51));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 51), new java.awt.Color(0, 255, 204), null));
        jPanel2.setPreferredSize(new java.awt.Dimension(255, 149));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total Teknisi");

        lbltotal.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lbltotal.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal.setText("6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lbltotal))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 122, 309, -1));

        jPanel3.setBackground(new java.awt.Color(11, 26, 51));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 51), new java.awt.Color(0, 255, 204), null));
        jPanel3.setPreferredSize(new java.awt.Dimension(255, 149));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Teknisi Aktif");

        lblaktif.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblaktif.setForeground(new java.awt.Color(255, 255, 255));
        lblaktif.setText("6");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblaktif))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblaktif, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 122, 309, -1));

        jPanel4.setBackground(new java.awt.Color(11, 26, 51));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 51), new java.awt.Color(0, 255, 204), null));
        jPanel4.setPreferredSize(new java.awt.Dimension(255, 149));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Teknisi Cuti");

        lblcuti.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblcuti.setForeground(new java.awt.Color(255, 255, 255));
        lblcuti.setText("6");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblcuti))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblcuti)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 122, 270, -1));

        tblteknisi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama Teknisi", "Spesialis", "Tiket Ditangani", "Tiket Selesai", "Status"
            }
        ));
        jScrollPane2.setViewportView(tblteknisi);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 334, 975, 371));

        cbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Aktif", "Cuti" }));
        cbstatus.addActionListener(this::cbstatusActionPerformed);
        jPanel1.add(cbstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 299, 401, -1));

        bCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Print_1.png"))); // NOI18N
        bCetak.setText("Cetak");
        bCetak.addActionListener(this::bCetakActionPerformed);
        jPanel1.add(bCetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 299, -1, -1));

        bSimpan.setText("Simpan");
        bSimpan.addActionListener(this::bSimpanActionPerformed);
        jPanel1.add(bSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 299, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstatusActionPerformed
    loadDashboard();
    datatable();
    }//GEN-LAST:event_cbstatusActionPerformed

    private void bCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetakActionPerformed
    cetak();
    }//GEN-LAST:event_bCetakActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        exportPDF();
    }//GEN-LAST:event_bSimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCetak;
    private javax.swing.JButton bSimpan;
    private javax.swing.JComboBox<String> cbstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblaktif;
    private javax.swing.JLabel lblcuti;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JTable tblteknisi;
    // End of variables declaration//GEN-END:variables
}
