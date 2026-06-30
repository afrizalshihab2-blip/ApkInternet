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
import net.sf.jasperreports.engine.JasperExportManager;
import javax.swing.JFileChooser;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
public class LaporanPelanggan1 extends javax.swing.JPanel {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;

    public LaporanPelanggan1() {
        initComponents(); 
        datatable();
    }
    

   
 
  protected void datatable() {
    Object[] Baris = {"No", "ID Pelanggan", "Nama Pelanggan", "NO. HP", "Alamat"};
    tabmode = new DefaultTableModel(null, Baris);

    try {
        String sql = "SELECT id_pelanggan, nama_pel, no_hp, alamat FROM pelanggan";
        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        int no = 1;
        while (hasil.next()) {
            tabmode.addRow(new Object[]{
                no++,
                hasil.getString("id_pelanggan"),
                hasil.getString("nama_pel"),
                hasil.getString("no_hp"),
                hasil.getString("alamat")
            });
        }
        tblpelanggan.setModel(tabmode);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data gagal dipanggil: " + e);
    }
}
    
   public void cetak() {
    try {
        
        
        String path = "./src/Laporan/LaporanPelanggan.jasper"; 
        HashMap parameter = new HashMap();
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
            
            String jasperPath = "./src/Laporan/LaporanPelanggan1.jasper";
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblpelanggan = new javax.swing.JTable();
        bcetak = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setText("Laporan Pelanggan");

        tblpelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "ID Pelanggan", "Nama Pelanggan", "No.HP", "Alamat"
            }
        ));
        jScrollPane2.setViewportView(tblpelanggan);

        bcetak.setText("Cetak");
        bcetak.addActionListener(this::bcetakActionPerformed);

        bSimpan.setText("Simpan");
        bSimpan.addActionListener(this::bSimpanActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bcetak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bSimpan))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bcetak)
                    .addComponent(bSimpan))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(486, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void bcetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetakActionPerformed
    cetak();
    }//GEN-LAST:event_bcetakActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
      exportPDF();
    }//GEN-LAST:event_bSimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton bcetak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblpelanggan;
    // End of variables declaration//GEN-END:variables
}
