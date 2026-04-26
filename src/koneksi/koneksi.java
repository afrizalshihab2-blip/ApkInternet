/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.*;
public class koneksi {
    private Connection koneksi;
    public Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Berhasil Konek");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Gagal Koneksi" +ex);
        }
        String url = "jdbc:mysql://localhost/putra_net";
        try{
            koneksi=DriverManager.getConnection(url,"root","");
            System.out.println("Berhasil Koneksi database");
        }
        catch(SQLException ex){
            System.out.println("Gagal koneksi database"+ex);
        }
        return koneksi;
    }
}
