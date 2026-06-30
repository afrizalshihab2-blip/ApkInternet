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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setText("Laporan Teknisi");

        jPanel2.setBackground(new java.awt.Color(38, 50, 78));
        jPanel2.setPreferredSize(new java.awt.Dimension(255, 149));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total Teknisi");

        lbltotal.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lbltotal.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal.setText("6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lbltotal))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel2)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel3.setBackground(new java.awt.Color(38, 50, 78));
        jPanel3.setPreferredSize(new java.awt.Dimension(255, 149));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Teknisi Aktif");

        lblaktif.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblaktif.setForeground(new java.awt.Color(255, 255, 255));
        lblaktif.setText("6");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(lblaktif)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblaktif, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(38, 50, 78));
        jPanel4.setPreferredSize(new java.awt.Dimension(255, 149));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Teknisi Cuti");

        lblcuti.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblcuti.setForeground(new java.awt.Color(255, 255, 255));
        lblcuti.setText("6");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lblcuti)
                        .addGap(129, 129, 129))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblcuti, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        cbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Aktif", "Cuti" }));
        cbstatus.addActionListener(this::cbstatusActionPerformed);

        bCetak.setText("Cetak");
        bCetak.addActionListener(this::bCetakActionPerformed);

        bSimpan.setText("Simpan");
        bSimpan.addActionListener(this::bSimpanActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bCetak)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(bSimpan))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel1))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCetak)
                    .addComponent(bSimpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(315, Short.MAX_VALUE))
        );

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
