/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FormLangganan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import koneksi.koneksi;
public class Langganan extends javax.swing.JPanel {
private Connection conn = new koneksi().connect();
public String id, nama, jenis, telp, almt;
private DefaultTableModel tabmode;
    public Langganan() {
        initComponents();
        loadPaket();    
        loadRouter();
        loadTeknisi();
        tampilHarga();
        kosong();
        datatable();
        autonumber();
    }

   protected void kosong(){
        txtidlangg.setText("");
         txtid.setText("");
        txtnama.setText("");
        txtalamat.setText("");
        jtgl.setDate(null);
        cbrouter.setSelectedIndex(0);
         cbteknisi.setSelectedIndex(0); 
         cbpaket.setSelectedIndex(0);
         txtharga.setText("");
       
    }
    protected void datatable(){
    Object[] Baris ={"ID Langganan","Nama Pelanggan","Tanggal","Paket","Harga","Teknisi","Router"};
    tabmode = new DefaultTableModel(null, Baris);

    String cariitem = txtcari.getText();

  try {
  String sql = "SELECT id_langganan, nama_pel, tanggal, nama_paket, harga, nama, tipe_router "
           + "FROM langganan "
           + "WHERE id_langganan LIKE '%" + cariitem + "%' "
           + "OR nama_pel LIKE '%" + cariitem + "%' "
           + "OR nama_paket LIKE '%" + cariitem + "%' "
           + "OR tipe_router LIKE '%" + cariitem + "%'";

        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

       while (hasil.next()){
         tabmode.addRow(new Object[]{
        hasil.getString("id_langganan"),
        hasil.getString("nama_pel"),      
        hasil.getString("tanggal"),
        hasil.getString("nama_paket"),
        hasil.getString("harga"),
        hasil.getString("nama"),      
        hasil.getString("tipe_router")
    });
}

        tblLangganan.setModel(tabmode);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil "+e);
        }
    }
    
    
     protected void autonumber() {
    try {
        String sql = "SELECT id_langganan FROM langganan order by id_langganan asc";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        txtidlangg.setText("IN0001");

        while (rs.next()) {
            String id_nota = rs.getString("id_langganan").substring(2);
            int AN = Integer.parseInt(id_nota) + 1;
            String Nol = "";

            if (AN < 10) {
                Nol = "000";
            } else if (AN < 100) {
                Nol = "00";
            } else if (AN < 1000) {
                Nol = "0";
            } else if (AN < 10000) {
                Nol = "";
            }

            txtidlangg.setText("IN" + Nol + AN);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Auto Number Gagal" + e);
    }
    }
     
      private void loadPaket(){
             cbpaket.removeAllItems();
            cbpaket.addItem("-- pilih paket --");

            try {
                String sql = "SELECT id_paket, nama_paket, harga FROM paket";
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery(sql);

                while(rs.next()){
                    cbpaket.addItem(rs.getString("nama_paket"));
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Gagal load paket: "+e);
            }
        }

        private void loadRouter(){
             cbrouter.removeAllItems();
                cbrouter.addItem("-- pilih Router --");
            try {
                String sql = "SELECT ip_address, tipe_router FROM router";
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery(sql);

               

                while(rs.next()){
                    cbrouter.addItem(rs.getString("tipe_router"));
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Gagal load teknisi: "+e);
            }
        }
        
        private void tampilHarga() {
    
        if (cbpaket.getSelectedItem() == null || 
            cbpaket.getSelectedItem().toString().startsWith("--")) {
            txtharga.setText("");
            return;
        }
        try {
            String sql = "SELECT harga FROM paket WHERE nama_paket = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cbpaket.getSelectedItem().toString());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                txtharga.setText(rs.getString("harga"));
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        }
     private void loadTeknisi(){
          cbteknisi.removeAllItems();
                cbteknisi.addItem("-- pilih Teknisi --");
            try {
                String sql = "SELECT * FROM teknisi";
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery(sql);

               

                while(rs.next()){
                    cbteknisi.addItem(rs.getString("nama"));
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Gagal load teknisi: "+e);
            }
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        bcarip = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbpaket = new javax.swing.JComboBox<>();
        cbrouter = new javax.swing.JComboBox<>();
        cbteknisi = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        btnUbah1 = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        bcari = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLangganan = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jtgl = new com.toedter.calendar.JDateChooser();
        txtidlangg = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane1.setViewportView(jPanel1);

        jPanel1.setBackground(new java.awt.Color(11, 20, 51));

        jPanel2.setBackground(new java.awt.Color(11, 20, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pelanggan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13), new java.awt.Color(51, 255, 204))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 204));
        jLabel6.setText("ID Pelanggan");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 204));
        jLabel7.setText("Nama");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 204));
        jLabel10.setText("Alamat");

        txtalamat.setColumns(20);
        txtalamat.setRows(5);
        jScrollPane2.setViewportView(txtalamat);

        bcarip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Search_3.png"))); // NOI18N
        bcarip.setText("Cari");
        bcarip.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bcarip.addActionListener(this::bcaripActionPerformed);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 255, 204));
        jLabel16.setText("Paket Internet");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 255, 204));
        jLabel17.setText("Router");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 255, 204));
        jLabel18.setText("Teknisi Pemasangan");

        cbpaket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Pilih Paket----" }));
        cbpaket.addActionListener(this::cbpaketActionPerformed);

        cbrouter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Pilih Router----", " " }));

        cbteknisi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Pilih Teknisi----", " " }));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 255, 204));
        jLabel20.setText("Harga");

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnUbah1.setText("Ubah");
        btnUbah1.addActionListener(this::btnUbah1ActionPerformed);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        bcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Search_3.png"))); // NOI18N
        bcari.setText("Cari");
        bcari.addActionListener(this::bcariActionPerformed);

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        tblLangganan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Langganan", "Nama Pelanggan", "Tanggal", "Paket", "Harga", "Teknisi", "Router"
            }
        ));
        tblLangganan.setPreferredSize(new java.awt.Dimension(250, 140));
        tblLangganan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLanggananMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblLangganan);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 204));
        jLabel9.setText("Tanggal Pemasangan");

        txtidlangg.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 204));
        jLabel8.setText("ID Langganan");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 204));
        jLabel1.setText("Daftar Langganan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel20))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUbah1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bcari))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtnama, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bcarip))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbpaket, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtharga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(77, 77, 77)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel17))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbrouter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbteknisi, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtgl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtidlangg, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidlangg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcarip)
                    .addComponent(jLabel6))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cbpaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbrouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(cbteknisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah1)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(620, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents
    public void itemTerpilih() {
    popuppelanggan Pp = new popuppelanggan();
    Pp.plgn = this;

    txtid.setText(id);
    txtnama.setText(nama);
    txtalamat.setText(almt);
    }
    private void bcaripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripActionPerformed
        popuppelanggan Pp = new popuppelanggan();
        Pp.plgn = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_bcaripActionPerformed

    private void cbpaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpaketActionPerformed
        Object selected = cbpaket.getSelectedItem();
        if (selected == null || selected.toString().startsWith("--")) {
            txtharga.setText("");
            return;
        }
        try {
            String sql = "SELECT harga FROM paket WHERE nama_paket=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, selected.toString());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                txtharga.setText(rs.getString("harga"));
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_cbpaketActionPerformed

    private void tblLanggananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLanggananMouseClicked
        int bar = tblLangganan.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();

        txtidlangg.setText(a);
        txtid.setText(b);
        try {
            java.util.Date date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(c);
            jtgl.setDate(date);
            cbpaket.setSelectedItem(d);
            txtharga.setText(e);
            cbteknisi.setSelectedItem(f);
            cbrouter.setSelectedItem(g);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_tblLanggananMouseClicked

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
        }
    }//GEN-LAST:event_txtcariKeyPressed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        datatable();
    }//GEN-LAST:event_bcariActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tgl = sdf.format(jtgl.getDate());

        String sql = "insert into langganan values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtidlangg.getText());
            stat.setString(2, txtnama.getText());
            stat.setString(3, tgl);
            stat.setString(4, cbpaket.getSelectedItem().toString());
            stat.setString(5, txtharga.getText());
            stat.setString(6, cbteknisi.getSelectedItem().toString());
            stat.setString(7, cbrouter.getSelectedItem().toString());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");

            kosong();
            autonumber();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan" + e);
        }
        datatable();

    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbah1ActionPerformed
         if (txtidlangg.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pilih data di tabel dulu!");
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tgl = sdf.format(jtgl.getDate());

            String sql = "UPDATE langganan SET tanggal=?, nama_paket=?, harga=?, nama=?, tipe_router=? WHERE id_langganan=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tgl);
            stat.setString(2, cbpaket.getSelectedItem().toString());
            stat.setString(3, txtharga.getText());
            stat.setString(4, cbteknisi.getSelectedItem().toString());
            stat.setString(5, cbrouter.getSelectedItem().toString());
            stat.setString(6, txtidlangg.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");

            kosong();
            autonumber();
            datatable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }//GEN-LAST:event_btnUbah1ActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "konfirmasi dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from langganan where id_langganan ='" + txtidlangg.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                autonumber();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus" + e);
            }
            datatable();
        }
    }//GEN-LAST:event_btnHapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari;
    private javax.swing.JButton bcarip;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah1;
    private javax.swing.JComboBox<String> cbpaket;
    private javax.swing.JComboBox<String> cbrouter;
    private javax.swing.JComboBox<String> cbteknisi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jtgl;
    private javax.swing.JTable tblLangganan;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidlangg;
    private javax.swing.JTextField txtnama;
    // End of variables declaration//GEN-END:variables
}
