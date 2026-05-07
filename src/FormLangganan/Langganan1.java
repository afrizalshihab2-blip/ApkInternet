/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormLangganan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import koneksi.koneksi;
public class Langganan1 extends javax.swing.JPanel {
private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    public Langganan1() {
        initComponents();
        loadPaket();    
        loadRouter();
        datatable();
        
           btnID.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        setPelanggan();
                }
            });
    }
    
    protected void kosong(){
        txtid.setText("");
        txtNama.setText("");
        txtPaket.setText("");
        cbRouter.setSelectedIndex(0);
        txtTeknisi.setText("");
        cbPaket.setSelectedIndex(0);
    }
    protected void datatable(){
    Object[] Baris ={"ID Pelanggan","Nama Pelanggan","Paket","Teknisi","Router"};
    tabmode = new DefaultTableModel(null, Baris);

    String cariitem = txtCari.getText();

    try {
        String sql = "SELECT p.id_langganan, p.pelanggan, p.teknisi, " +
                     "pk.nama_paket, r.nama AS nama_router " +
                     "FROM langganan p " +
                     "LEFT JOIN paket pk ON p.id_paket = pk.id_paket " +
                     "LEFT JOIN router r ON p.id_router = r.id_router " +
                     "WHERE p.id_langganan LIKE '%"+cariitem+"%' " +
                     "OR p.pelanggan LIKE '%"+cariitem+"%' " +
                     "OR pk.nama_paket LIKE '%"+cariitem+"%' " +
                     "OR p.teknisi LIKE '%"+cariitem+"%' " +
                     "OR r.nama LIKE '%"+cariitem+"%'";

        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()){
            tabmode.addRow(new Object[]{
                hasil.getString("id_langganan"),
                hasil.getString("pelanggan"),
                hasil.getString("nama_paket"),
                hasil.getString("teknisi"),
                hasil.getString("nama_router")
            });
        }

        tblLangganan.setModel(tabmode);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil "+e);
        }
    }
            private void loadPaket(){
            try {
                String sql = "SELECT * FROM paket";
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery(sql);

                cbPaket.removeAllItems();
                cbPaket.addItem("-- pilih paket --");

                while(rs.next()){
                    cbPaket.addItem(rs.getString("nama_paket"));
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Gagal load paket: "+e);
            }
        }

        private void loadRouter(){
            try {
                String sql = "SELECT * FROM router";
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery(sql);

                cbRouter.removeAllItems();
                cbRouter.addItem("-- pilih Router --");

                while(rs.next()){
                    cbRouter.addItem(rs.getString("nama"));
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Gagal load teknisi: "+e);
            }
        }
     
        private void setPelanggan(){
            boolean closable =true;
            DataPelanggan1 pelanggan = new DataPelanggan1(null, closable);
            pelanggan.setVisible(true);

            txtid.setText(pelanggan.getId_pelanggan());
            txtNama.setText(pelanggan.getNama());
            txtTeknisi.setText(pelanggan.getId_teknisi());
            txtPaket.setText(pelanggan.getId_paket());

            txtid.setEditable(false);
            txtNama.setEditable(false);
            txtTeknisi.setEditable(false);
            txtPaket.setEditable(false);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLangganan = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbRouter = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbPaket = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtPaket = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        txtTeknisi = new javax.swing.JTextField();
        btnID = new javax.swing.JButton();
        btnUbah1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1556, 872));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setText("Daftar Langganan");

        tblLangganan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblLangganan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Langganan", "Nama Pelanggan", "Paket", "Teknisi", "Router"
            }
        ));
        tblLangganan.setPreferredSize(new java.awt.Dimension(250, 140));
        tblLangganan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLanggananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLangganan);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("ID Langganan");

        txtid.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Nama Pelanggan");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Paket Lama");

        cbRouter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Router--" }));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Teknisi");

        cbPaket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Paket --", " " }));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Router");

        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(51, 51, 51));
        btnBatal.setText("Batal");
        btnBatal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(51, 51, 51));
        btnHapus.setText("Hapus");
        btnHapus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        txtPaket.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Paket Baru");

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        btnCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        txtTeknisi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnID.setText(".........");

        btnUbah1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUbah1.setText("Ubah");
        btnUbah1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        btnUbah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbah1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtTeknisi, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCari)))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(cbPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnUbah1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(583, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTeknisi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnUbah1)
                            .addComponent(btnHapus)
                            .addComponent(btnBatal))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCari))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        datatable();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
    try {
      
            String sql = "INSERT INTO langganan (id_langganan, pelanggan, teknisi, id_paket, id_router) VALUES (?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtid.getText());
            stat.setString(2, txtNama.getText());
            stat.setString(3, txtTeknisi.getText());
            
            
                String idPaket = "";
                String sqlPaket = "SELECT id_paket FROM paket WHERE nama_paket=?";
                PreparedStatement ps1 = conn.prepareStatement(sqlPaket);
                ps1.setString(1, txtPaket.getText()); 
                ResultSet rs1 = ps1.executeQuery();

                if(rs1.next()){
                    idPaket = rs1.getString("id_paket");
                } else {
                    JOptionPane.showMessageDialog(null,"Paket lama tidak ditemukan");
                    return;
                }

            String idRouter = "";
        String sqlRouter = "SELECT id_router FROM router WHERE nama=?";
        PreparedStatement ps2 = conn.prepareStatement(sqlRouter);
        ps2.setString(1, cbRouter.getSelectedItem().toString());
        ResultSet rs2 = ps2.executeQuery();
        if(rs2.next()){
            idRouter = rs2.getString("id_router");
        } else {
        JOptionPane.showMessageDialog(null,"Router tidak ditemukan");
        return;
    }
            stat.setString(4, idPaket);  
            stat.setString(5, idRouter);
            
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosong();
            txtid.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan" + e);
        }
        datatable();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int row = tblLangganan.getSelectedRow();

        if(row == -1){
            JOptionPane.showMessageDialog(null,"Pilih data di tabel dulu!");
            return;
        }

        String id = tblLangganan.getValueAt(row, 0).toString();

        int ok = JOptionPane.showConfirmDialog(null,"Hapus data?","Konfirmasi",JOptionPane.YES_NO_OPTION);

        if(ok==0){
            try{
                String sql = "DELETE FROM langganan WHERE id_langganan=?";
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
    
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblLanggananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLanggananMouseClicked
           int bar = tblLangganan.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
     
        

        txtid.setText(a);
        txtNama.setText(b);
        txtPaket.setText(c);
         txtTeknisi.setText(d);
        cbRouter.setSelectedItem(e);

 
    }//GEN-LAST:event_tblLanggananMouseClicked

    private void btnUbah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbah1ActionPerformed

            try {
        String sql = "UPDATE langganan SET id_paket=?, id_router=? WHERE id_langganan=?";
        PreparedStatement stat = conn.prepareStatement(sql);


        String idPaket = "";
        String sqlPaket = "SELECT id_paket FROM paket WHERE nama_paket=?";
        PreparedStatement ps1 = conn.prepareStatement(sqlPaket);
        ps1.setString(1, cbPaket.getSelectedItem().toString());
        ResultSet rs1 = ps1.executeQuery();

        if(rs1.next()){
            idPaket = rs1.getString("id_paket");
        } else {
            JOptionPane.showMessageDialog(null,"Paket tidak ditemukan");
            return;
        }


        String idRouter = "";
        String sqlRouter = "SELECT id_router FROM router WHERE nama=?";
        PreparedStatement ps2 = conn.prepareStatement(sqlRouter);
        ps2.setString(1, cbRouter.getSelectedItem().toString());
        ResultSet rs2 = ps2.executeQuery();

        if(rs2.next()){
            idRouter = rs2.getString("id_router");
        } else {
            JOptionPane.showMessageDialog(null,"Router tidak ditemukan");
            return;
        }


        stat.setString(1, idPaket);                
        stat.setString(2, idRouter);               
        stat.setString(3, txtid.getText());       

        stat.executeUpdate();

        JOptionPane.showMessageDialog(null, "Data berhasil diubah");

        kosong();
        datatable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
       }

    }//GEN-LAST:event_btnUbah1ActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
      }
    }//GEN-LAST:event_txtCariKeyPressed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
     kosong();
     datatable();
    }//GEN-LAST:event_btnBatalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnID;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah1;
    private javax.swing.JComboBox<String> cbPaket;
    private javax.swing.JComboBox<String> cbRouter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLangganan;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPaket;
    private javax.swing.JTextField txtTeknisi;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
