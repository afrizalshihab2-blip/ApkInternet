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
public class LaporanPendapatan1 extends javax.swing.JPanel {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;

    public LaporanPendapatan1() {
        initComponents(); 
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cbbulan.setSelectedIndex(cal.get(java.util.Calendar.MONTH) + 1);
        loadDashboard();
        datatable();
    }
    
   
    private void loadDashboard() {
        int bulan = cbbulan.getSelectedIndex();
        if (bulan == 0) return;
        try {

            PreparedStatement ps1 = conn.prepareStatement("SELECT COALESCE(SUM(harga),0) "
                                    + "total FROM transaksi WHERE status='Lunas' AND MONTH(tgl_bayar)=?"
            );
            ps1.setInt(1, bulan);
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next())
                lblPendapatan.setText("Rp " + String.format("%,d", rs1.getLong("total")).replace(",","."));
            PreparedStatement ps2 = conn.prepareStatement("SELECT COUNT(*) total FROM transaksi "
                                     + "WHERE MONTH(tgl_bayar)=?"
            );
                    
            ps2.setInt(1, bulan);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next())
                lblTransaksi.setText(String.valueOf(rs2.getInt("total")));
            PreparedStatement ps3 = conn.prepareStatement( "SELECT COUNT(*) total FROM transaksi "
                                    + "WHERE status='Lunas' AND MONTH(tgl_bayar)=?"
            );
            
            ps3.setInt(1, bulan);
            ResultSet rs3 = ps3.executeQuery();
            if(rs3.next())
                lblLunas.setText(String.valueOf(rs3.getInt("total")));
            PreparedStatement ps4 = conn.prepareStatement("SELECT COUNT(*) total FROM "
                                    + "transaksi WHERE status<>'Lunas' AND MONTH(tgl_bayar)=?"
            );
                
            ps4.setInt(1, bulan);
            ResultSet rs4 = ps4.executeQuery();
            if(rs4.next())
                lblBelumBayar.setText(String.valueOf(rs4.getInt("total")));

        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Dashboard error: " + e.getMessage());
        }
    }
    
    protected void datatable(){
        Object[] Baris ={"Tgl Bayar","Id Transaksi","Pelanggan","Paket","Metode","Status"};
          tabmode = new DefaultTableModel(null, Baris);
         
        try{
         int bulan = cbbulan.getSelectedIndex();
         if (bulan == 0) return; 

            String sql ="SELECT * FROM transaksi WHERE MONTH(tgl_bayar)=? ORDER BY tgl_bayar DESC";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, bulan);

            ResultSet hasil = pst.executeQuery();

                while (hasil.next()){
                    tabmode.addRow(new Object[]{
                    hasil.getDate("tgl_bayar"),
                    hasil.getString("id_transaksi"),
                    hasil.getString("nama_pel"),
                    hasil.getString("paket"),
                    hasil.getString("metode"),
                    hasil.getString("status")

                    });
                   }
                   tbltransaksi.setModel(tabmode);
            }catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"data gagal dianggil"+e);
            }
    }
    
    public void cetak() {
    try {
        int bulan = cbbulan.getSelectedIndex();
        if (bulan == 0) {
            JOptionPane.showMessageDialog(null, "Pilih bulan dulu!");
            return;
        }
            String[] namaBulan = {"","Januari","Februari","Maret","April","Mei","Juni",
                                  "Juli","Agustus","September","Oktober","November","Desember"};
            String path = "./src/Laporan/laporanpendapatann.jasper";
            HashMap parameter = new HashMap();
            parameter.put("P_BULAN", bulan);
            parameter.put("P_NAMA_BULAN", namaBulan[bulan]);
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
            
            String jasperPath = "./src/Laporan/LaporanPendapatan1.jasper";
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
        lblPendapatan = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblTransaksi = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblLunas = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblBelumBayar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbltransaksi = new javax.swing.JTable();
        cbbulan = new javax.swing.JComboBox<>();
        bCetak = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(11, 20, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 204));
        jLabel1.setText("Laporan Pendapatan");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 6, -1, 57));

        jPanel2.setBackground(new java.awt.Color(11, 26, 51));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 51), new java.awt.Color(0, 255, 204), null));
        jPanel2.setPreferredSize(new java.awt.Dimension(255, 149));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total Pendapatan");

        lblPendapatan.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblPendapatan.setForeground(new java.awt.Color(255, 255, 255));
        lblPendapatan.setText("6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblPendapatan))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPendapatan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 93, -1, -1));

        jPanel3.setBackground(new java.awt.Color(11, 26, 51));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 51), new java.awt.Color(0, 255, 204), null));
        jPanel3.setPreferredSize(new java.awt.Dimension(255, 149));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Transaksi");

        lblTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        lblTransaksi.setText("6");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblTransaksi))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTransaksi)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 93, -1, -1));

        jPanel4.setBackground(new java.awt.Color(11, 26, 51));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 51), new java.awt.Color(0, 255, 204), null));
        jPanel4.setPreferredSize(new java.awt.Dimension(255, 149));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tagihan Lunas");

        lblLunas.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblLunas.setForeground(new java.awt.Color(255, 255, 255));
        lblLunas.setText("6");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblLunas))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLunas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 93, -1, -1));

        jPanel5.setBackground(new java.awt.Color(11, 26, 51));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 51), new java.awt.Color(0, 255, 204), null));
        jPanel5.setPreferredSize(new java.awt.Dimension(255, 149));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Belum Bayar");

        lblBelumBayar.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblBelumBayar.setForeground(new java.awt.Color(255, 255, 255));
        lblBelumBayar.setText("6");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(lblBelumBayar))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBelumBayar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(816, 93, -1, -1));

        tbltransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbltransaksi);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 305, 1044, 371));

        cbbulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Bulan", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember", " " }));
        cbbulan.addActionListener(this::cbbulanActionPerformed);
        jPanel1.add(cbbulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 270, 401, -1));

        bCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Print_1.png"))); // NOI18N
        bCetak.setText("Cetak");
        bCetak.addActionListener(this::bCetakActionPerformed);
        jPanel1.add(bCetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        bSimpan.setText("Simpan");
        bSimpan.addActionListener(this::bSimpanActionPerformed);
        jPanel1.add(bSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 270, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbbulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbulanActionPerformed
    loadDashboard();
    datatable();
    }//GEN-LAST:event_cbbulanActionPerformed

    private void bCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetakActionPerformed
    cetak();
    }//GEN-LAST:event_bCetakActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        exportPDF();
    }//GEN-LAST:event_bSimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCetak;
    private javax.swing.JButton bSimpan;
    private javax.swing.JComboBox<String> cbbulan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBelumBayar;
    private javax.swing.JLabel lblLunas;
    private javax.swing.JLabel lblPendapatan;
    private javax.swing.JLabel lblTransaksi;
    private javax.swing.JTable tbltransaksi;
    // End of variables declaration//GEN-END:variables
}
