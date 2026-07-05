/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FormTiket;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import koneksi.koneksi;

public class tiket extends javax.swing.JPanel {
private Connection conn = new koneksi().connect();
public String id,nama_pel, alamat;
public String nama, spesialis,id_teknisi;
private DefaultTableModel tabmode;
    public tiket() {
        initComponents();
        kosong();
        datatable();
        autonumber();
    }

     protected void kosong(){
        txttiket.setText("");
        txtid.setText("");
        txtnama.setText("");
        txtlokasi.setText("");
        cbjenis.setSelectedIndex(0);
        cbprioritas.setSelectedIndex(0);
        txtdesk.setText("");
        txtteknisi.setText("");
        jtgl.setDate(null);
        cbstatus.setSelectedIndex(0); 
    }
     
    protected void datatable(){
    Object[] Baris ={"No Tiket","Nama Pelanggan","Alamat","Jenis","Prioritas","Teknisi","Tanggal","Status"};
    tabmode = new DefaultTableModel(null, Baris);
    String cariitem = txtcari.getText();

  try {
  String sql = "SELECT tk.no_tiket, tk.nama_pel, tk.alamat, tk.masalah, tk.prioritas, " +
             "t.nama AS nama_teknisi, tk.tgl_lapor, tk.status " +
             "FROM tiket tk " +
             "LEFT JOIN teknisi t ON tk.id_teknisi = t.id_teknisi " +
             "WHERE tk.no_tiket LIKE '%" + cariitem + "%' " +
             "OR tk.nama_pel LIKE '%" + cariitem + "%' " +
             "ORDER BY tk.no_tiket ASC";
        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

       while (hasil.next()){
         tabmode.addRow(new Object[]{
        hasil.getString("no_tiket"),
        hasil.getString("nama_pel"),      
        hasil.getString("alamat"),
        hasil.getString("masalah"),
        hasil.getString("prioritas"),
        hasil.getString("nama_teknisi"),      
        hasil.getString("tgl_lapor"),
        hasil.getString("status")
   });
}

        tbltiket.setModel(tabmode);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil "+e);
        }
    }
       
    protected void autonumber() {
    try {
        String sql = "SELECT no_tiket FROM tiket order by no_tiket asc";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        txttiket.setText("TX0001");

        while (rs.next()) {
            String no_tiket= rs.getString("no_tiket").substring(2);
            int AN = Integer.parseInt(no_tiket) + 1;
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

            txttiket.setText("TX" + Nol + AN);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Auto Number Gagal" + e);
    }
    }
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtlokasi = new javax.swing.JTextField();
        cbprioritas = new javax.swing.JComboBox<>();
        cbjenis = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdesk = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txttiket = new javax.swing.JTextField();
        bcarip = new javax.swing.JButton();
        bcarip1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbstatus = new javax.swing.JComboBox<>();
        bsimpan = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        txtteknisi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jtgl = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbltiket = new javax.swing.JTable();

        setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane1.setViewportView(jPanel1);

        jPanel1.setBackground(new java.awt.Color(11, 20, 51));

        jPanel2.setBackground(new java.awt.Color(11, 20, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MAINTENANCE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 255, 204))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(0, 255, 204));
        jLabel2.setText("No. Tiket");

        jLabel3.setForeground(new java.awt.Color(0, 255, 204));
        jLabel3.setText("Lokasi/Alamat");

        jLabel4.setForeground(new java.awt.Color(0, 255, 204));
        jLabel4.setText("Jenis Masalah");

        jLabel5.setForeground(new java.awt.Color(0, 255, 204));
        jLabel5.setText("Prioritas");

        jLabel6.setForeground(new java.awt.Color(0, 255, 204));
        jLabel6.setText("Deskripsi Masalah");

        jLabel7.setForeground(new java.awt.Color(0, 255, 204));
        jLabel7.setText("Tanggal Lapor");

        jLabel8.setForeground(new java.awt.Color(0, 255, 204));
        jLabel8.setText("Teknisi");

        cbprioritas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Prioritas--", "NORMAL ", "SEDANG", "DARURAT", " " }));

        cbjenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Jenis Masalah--", "INDIKATOR LOS", "SSID TIDAK TERBACA", "SINYAL LEMAH", "LEMOT", " " }));

        txtdesk.setColumns(20);
        txtdesk.setRows(5);
        jScrollPane2.setViewportView(txtdesk);

        jLabel9.setBackground(new java.awt.Color(0, 255, 204));
        jLabel9.setForeground(new java.awt.Color(0, 255, 204));
        jLabel9.setText("ID Pelanggan");

        bcarip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Search_3.png"))); // NOI18N
        bcarip.setText("Cari");
        bcarip.addActionListener(this::bcaripActionPerformed);

        bcarip1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Search_3.png"))); // NOI18N
        bcarip1.setText("Cari");
        bcarip1.addActionListener(this::bcarip1ActionPerformed);

        jLabel10.setForeground(new java.awt.Color(0, 255, 204));
        jLabel10.setText("Status");

        cbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Status--", "Baru", "Proses", "Selesai", " " }));

        bsimpan.setText("Tambah");
        bsimpan.addActionListener(this::bsimpanActionPerformed);

        bubah.setText("Ubah");
        bubah.addActionListener(this::bubahActionPerformed);

        jLabel11.setForeground(new java.awt.Color(0, 255, 204));
        jLabel11.setText("Nama Pelanggan");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 204));
        jLabel1.setText("Form Tiket");

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        bcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Search_3.png"))); // NOI18N
        bcari.setText("Cari");

        tbltiket.setModel(new javax.swing.table.DefaultTableModel(
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
        tbltiket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltiketMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbltiket);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bcari))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtteknisi)
                                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(bcarip1))
                            .addComponent(txttiket, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bsimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bubah))
                            .addComponent(cbjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtid)
                                    .addComponent(txtnama)
                                    .addComponent(txtlokasi)
                                    .addComponent(cbprioritas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(bcarip)))
                        .addGap(100, 272, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(80, 80, 80)
                                .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bcarip, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txttiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(txtlokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbprioritas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtteknisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bcarip1))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtgl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan)
                    .addComponent(bubah))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(577, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(361, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents

    
    public void itemTerpilih() {
    popuppelanggan Pp = new popuppelanggan();
    Pp.plgn = this;

    txtid.setText(id);
    txtnama.setText(nama_pel);
    txtlokasi.setText(alamat);
    }
     
    private void bcaripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripActionPerformed
        popuppelanggan Pp = new popuppelanggan();
        Pp.plgn = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_bcaripActionPerformed
    
    public void itemTerpilihtekn() {
     txtteknisi.setText(nama + " - " + spesialis);
      id_teknisi = id;
    }
    private void bcarip1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcarip1ActionPerformed
       popupteknisi Te = new popupteknisi();
       Te.tkn = this;
       Te.setVisible(true);
       Te.setResizable(false);
    }//GEN-LAST:event_bcarip1ActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String tgl = sdf.format(jtgl.getDate());

    String sql = "insert into tiket values (?,?,?,?,?,?,?,?)";
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, txttiket.getText());
        stat.setString(2, txtnama.getText());
        stat.setString(3, txtlokasi.getText());
        stat.setString(4, cbjenis.getSelectedItem().toString());
        stat.setString(5, cbprioritas.getSelectedItem().toString());
        stat.setString(6, id_teknisi); 
        stat.setString(7, tgl);
        stat.setString(8, cbstatus.getSelectedItem().toString());
      

        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "data berhasil disimpan");

        kosong();
        autonumber();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "data gagal disimpan" + e);
    }
    datatable();
    autonumber();
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
      
    try {
        

        String sql = "UPDATE tiket SET status=? WHERE no_tiket=?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, cbstatus.getSelectedItem().toString());
        stat.setString(2, txttiket.getText());

        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil diubah");

        kosong();
        autonumber();
        datatable();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e);
    }
    }//GEN-LAST:event_bubahActionPerformed

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
        }
    }//GEN-LAST:event_txtcariKeyPressed

    private void tbltiketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltiketMouseClicked
        int bar = tbltiket.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
         String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();

        txttiket.setText(a);
        txtnama.setText(b);
        txtlokasi.setText(c);
        cbjenis.setSelectedItem(d);
        cbprioritas.setSelectedItem(e);
        txtteknisi.setText(f);
         try {
        java.util.Date date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(g);
        jtgl.setDate(date);
        cbstatus.setSelectedItem(h);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
        
    }//GEN-LAST:event_tbltiketMouseClicked
 
     
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari;
    private javax.swing.JButton bcarip;
    private javax.swing.JButton bcarip1;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.JComboBox<String> cbjenis;
    private javax.swing.JComboBox<String> cbprioritas;
    private javax.swing.JComboBox<String> cbstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JTable tbltiket;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextArea txtdesk;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtlokasi;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtteknisi;
    private javax.swing.JTextField txttiket;
    // End of variables declaration//GEN-END:variables
}
