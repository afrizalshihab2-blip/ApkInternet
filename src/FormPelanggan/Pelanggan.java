/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FormPelanggan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import koneksi.koneksi;

public class Pelanggan extends javax.swing.JPanel {
private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    public Pelanggan() {
         initComponents();
        kosong();
        datatable();
    }

   protected void kosong(){
    txtid.setText("");
    txtnama.setText("");
    txtno.setText("");
    txtalamat.setText("");
}

protected void datatable(){

    Object[] Baris = {
        "ID Pelanggan",
        "Nama",
        "No Hp",
        "Alamat"
    };

    tabmode = new DefaultTableModel(null, Baris);
    tblplgn.setModel(tabmode);

    String cariitem = txtcari.getText();

    try {

        String sql =
        "SELECT * FROM pelanggan " +
        "WHERE id_pelanggan LIKE '%"+cariitem+"%' " +
        "OR nama_pel LIKE '%"+cariitem+"%' " +
        "ORDER BY id_pelanggan ASC";

        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        while(hasil.next()){

            tabmode.addRow(new Object[]{
                hasil.getString("id_pelanggan"),
                hasil.getString("nama_pel"),
                hasil.getString("no_hp"),
                hasil.getString("alamat")
            });

        }

    } catch(Exception e){
        JOptionPane.showMessageDialog(null,
        "Data gagal dipanggil : "+e);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btambah = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        bubah = new javax.swing.JButton();
        txtalamat = new javax.swing.JTextField();
        bbatal = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        bhapus = new javax.swing.JButton();
        txtno = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        txtnama = new javax.swing.JTextField();
        txtcari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblplgn = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(11, 20, 51));

        jPanel3.setBackground(new java.awt.Color(11, 20, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pelanggan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 255, 204))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 255, 204));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 204));
        jLabel12.setText("Alamat");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 204));
        jLabel10.setText("No. Hp");

        btambah.setText("Tambah");
        btambah.addActionListener(this::btambahActionPerformed);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 204));
        jLabel9.setText("Nama");

        bubah.setText("Ubah");
        bubah.addActionListener(this::bubahActionPerformed);

        txtalamat.addActionListener(this::txtalamatActionPerformed);

        bbatal.setText("Batal");
        bbatal.addActionListener(this::bbatalActionPerformed);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 204));
        jLabel8.setText("ID Pelanggan");

        bhapus.setText("Hapus");
        bhapus.addActionListener(this::bhapusActionPerformed);

        bcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Search_3.png"))); // NOI18N
        bcari.setText("Cari");
        bcari.addActionListener(this::bcariActionPerformed);

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        tblplgn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Pelanggan", "Nama", "No.Telepon", "Alamat"
            }
        ));
        tblplgn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblplgnMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblplgn);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 204));
        jLabel1.setText("Data Pelanggan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btambah)
                        .addGap(12, 12, 12)
                        .addComponent(bubah)
                        .addGap(12, 12, 12)
                        .addComponent(bhapus)
                        .addGap(12, 12, 12)
                        .addComponent(bbatal))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(bcari, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))))))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(0, 0, 0)
                        .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)
                        .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(6, 6, 6)
                        .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bcari))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btambah)
                    .addComponent(bubah)
                    .addComponent(bhapus)
                    .addComponent(bbatal))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents

    private void txtalamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalamatActionPerformed

    private void tblplgnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblplgnMouseClicked
        int bar = tblplgn.getSelectedRow();

        String a = tabmode.getValueAt(bar,0).toString();
        String b = tabmode.getValueAt(bar,1).toString();
        String c = tabmode.getValueAt(bar,2).toString();
        String d = tabmode.getValueAt(bar,3).toString();

        txtid.setText(a);
        txtnama.setText(b);
        txtno.setText(c);
        txtalamat.setText(d);
    }//GEN-LAST:event_tblplgnMouseClicked

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { datatable(); }
    }//GEN-LAST:event_txtcariKeyPressed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        datatable();
    }//GEN-LAST:event_bcariActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        try {

            String sql =
            "INSERT INTO pelanggan " +
            "(id_pelanggan,nama_pel,no_hp,alamat) " +
            "VALUES (?,?,?,?)";

            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, txtid.getText());
            stat.setString(2, txtnama.getText());
            stat.setString(3, txtno.getText());
            stat.setString(4, txtalamat.getText());

            stat.executeUpdate();

            JOptionPane.showMessageDialog(null,
                "Data berhasil disimpan");

            kosong();
            datatable();

        } catch(Exception e){
            JOptionPane.showMessageDialog(null,
                "Data gagal disimpan : "+e);
        }
    }//GEN-LAST:event_btambahActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        try {

        String sql = "UPDATE pelanggan SET "
                + "nama_pel=?, "
                + "no_hp=?, "
                + "alamat=? "
                + "WHERE id_pelanggan=?";

        PreparedStatement stat = conn.prepareStatement(sql);

        stat.setString(1, txtnama.getText());
        stat.setString(2, txtno.getText());
        stat.setString(3, txtalamat.getText());
        stat.setString(4, txtid.getText());

        stat.executeUpdate();

        JOptionPane.showMessageDialog(null,
                "Data berhasil diubah");

        kosong();
        datatable();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
                "Data gagal diubah : " + e);
    }
    }//GEN-LAST:event_bubahActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
         int row = tblplgn.getSelectedRow();

        if(row == -1){
            JOptionPane.showMessageDialog(null,"Pilih data di tabel dulu!");
            return;
        }

        String id = tblplgn.getValueAt(row, 0).toString();

        int ok = JOptionPane.showConfirmDialog(null,"Hapus data?","Konfirmasi",JOptionPane.YES_NO_OPTION);

        if(ok==0){
            try{
                String sql = "DELETE FROM pelanggan WHERE id_pelanggan=?";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, id);
                stat.executeUpdate();

                JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
                kosong();
                datatable();

            } catch(Exception e){
                JOptionPane.showMessageDialog(null,"Data gagal dihapus: "+e);
            }

        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        kosong();
        datatable();
    }//GEN-LAST:event_bbatalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton btambah;
    private javax.swing.JButton bubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblplgn;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtno;
    // End of variables declaration//GEN-END:variables
}
