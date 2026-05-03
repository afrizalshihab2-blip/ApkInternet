/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package apkinternet;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;


/**
 *
 * @author Admin
 */
public class ApkInternet {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
    try {
        FlatLightLaf.setup();

        
        UIManager.put("TextComponent.arc", 15);
        UIManager.put("Component.focusWidth", 2);
        UIManager.put("Component.innerFocusWidth", 1);
        UIManager.put("TextComponent.margin", new java.awt.Insets(8, 10, 8, 10));
        
        UIManager.put("Button.arc", 20); // sudut rounded
        UIManager.put("Component.arc", 15);

        UIManager.put("Button.focusWidth", 2);
        UIManager.put("Button.innerFocusWidth", 1);

        UIManager.put("Button.borderWidth", 0); // hilangin border jadul

        UIManager.put("Button.background", new java.awt.Color(79, 70, 229)); // warna utama (ungu modern)
        UIManager.put("Button.foreground", java.awt.Color.WHITE);

        UIManager.put("Button.hoverBackground", new java.awt.Color(99, 102, 241));
        UIManager.put("Button.pressedBackground", new java.awt.Color(67, 56, 202));
        
        UIManager.put("Button.margin", new java.awt.Insets(2, 20, 2, 20));
        
        UIManager.put("Button.shadowWidth", 2);

    } catch (Exception e) {
        e.printStackTrace();
    }

    java.awt.EventQueue.invokeLater(() -> {
        new FormLogin.form_login1().setVisible(true);
    });
}
}
  