/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Dashboard;


import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.Timer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Dashboard.*;

import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;

import com.formdev.flatlaf.FlatLightLaf;
/**
 *
 * @author Admin
 */
public class Dashboard1 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard1.class.getName());

    /**
     * Creates new form Dashboard1
     */
    public Dashboard1() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        
        PanelDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        moveIndicator(PanelDashboard);
    }
});
        switchPanel(new Mendash.mendash());
    
    revalidate();
    repaint();
    
        PanelPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            moveIndicator(PanelPelanggan);
        }
    });
        
        
        
        setIconImage(new javax.swing.ImageIcon(
        getClass().getResource("/img/LogoWindows.png")
    ).getImage());
       
        addButtonEffect(btnCari);
        addButtonEffect(btnLogout);
        
        addMenuEffect(txtDashboard, PanelDashboard);
        addMenuEffect(txtPelanggan, PanelPelanggan);
        addMenuEffect(txtPaketInet, PanelPaket);
        addMenuEffect(txtTeknisi, PanelTeknisi);
        addMenuEffect(txtRouter, PanelRouter);
        addMenuEffect(txtLaporan, PanelLaporan);
        addMenuEffect(txtLangganan2, PanelLangganan);
        addMenuEffect(txtTransaksi, PanelTransaksi);
        addMenuEffect(txtTicket, PanelTicket);
        
        
        setActiveMenu(PanelDashboard);
        
        
        
    }
      private void moveIndicator(JPanel menuPanel) {
        
}

    private void setActiveMenu(JPanel panel) {
    if (activeMenu != null) {
        activeMenu.setBackground(new Color(15, 23, 42));
    }

    panel.setBackground(new Color(99, 102, 241));
    activeMenu = panel;
}
    private void switchPanel(JPanel panel) {
    PanelUtama.removeAll();
    PanelUtama.setLayout(new BorderLayout());
    PanelUtama.add(panel, BorderLayout.CENTER);
    PanelUtama.revalidate();
    PanelUtama.repaint();
}
    private JPanel activeMenu = null;

   private void addMenuEffect(JLabel label, JPanel panel) {
    label.setCursor(new Cursor(Cursor.HAND_CURSOR));
    panel.setBackground(new Color(15, 23, 42));

    MouseAdapter adapter = new MouseAdapter() {

        public void mouseEntered(MouseEvent e) {
            if (panel != activeMenu)
                panel.setBackground(new Color(51, 65, 85));
        }

        public void mouseExited(MouseEvent e) {
            if (panel != activeMenu)
                panel.setBackground(new Color(15, 23, 42));
        }

        public void mouseClicked(MouseEvent e) {
            setActiveMenu(panel);
            moveIndicator(panel);
            
            if (label == txtDashboard) {
                switchPanel(new Mendash.mendash());
            } else if (label == txtPelanggan) {
                switchPanel(new FormPelanggan.Pelanggan());
            } else if (label == txtPaketInet) {
                switchPanel(new FormPaket.DaftarPaket());
            } else if (label == txtTeknisi) {
                switchPanel(new FormTeknisi.Teknisi11());
            } else if (label == txtRouter) {
                switchPanel(new FormRouter.Router());
            
            } else if (label == txtLangganan2) {
                switchPanel(new FormLangganan.Langganan());
                
            } else if (label == txtTicket) {
                switchPanel(new FormTiket.tiket());
            
                
              
            }
        }
    };

   
    panel.addMouseListener(adapter);
    label.addMouseListener(adapter);
}

    
    

    private void addButtonEffect(JButton btn) {
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);

        Color normal = new Color(79, 70, 229);
        Color hover = new Color(255, 255, 255);
        Color click = new Color(67, 56, 202);

        btn.setBackground(normal);
        btn.setForeground(Color.WHITE);

        btn.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                btn.setBackground(hover);
            }

            public void mouseExited(MouseEvent e) {
                btn.setBackground(normal);
            }

            
            public void mousePressed(MouseEvent e) {
                btn.setBackground(click);
                btn.setLocation(btn.getX(), btn.getY() + 2);
            }

            public void mouseReleased(MouseEvent e) {
                btn.setBackground(hover);
                btn.setLocation(btn.getX(), btn.getY() - 2);
            }
        });
    }
       
    
        
        
        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        FrameKiri = new javax.swing.JPanel();
        PanelDashboard = new javax.swing.JPanel();
        txtDashboard = new javax.swing.JLabel();
        jLabelLogoHeader = new javax.swing.JLabel();
        PanelPelanggan = new javax.swing.JPanel();
        txtPelanggan = new javax.swing.JLabel();
        PanelPaket = new javax.swing.JPanel();
        txtPaketInet = new javax.swing.JLabel();
        PanelTeknisi = new javax.swing.JPanel();
        txtTeknisi = new javax.swing.JLabel();
        PanelRouter = new javax.swing.JPanel();
        txtRouter = new javax.swing.JLabel();
        PanelLangganan = new javax.swing.JPanel();
        txtLangganan2 = new javax.swing.JLabel();
        PanelTransaksi = new javax.swing.JPanel();
        txtTransaksi = new javax.swing.JLabel();
        PanelLaporan = new javax.swing.JPanel();
        txtLaporan = new javax.swing.JLabel();
        PanelTicket = new javax.swing.JPanel();
        txtTicket = new javax.swing.JLabel();
        Layer1 = new javax.swing.JPanel();
        PanelHeader = new javax.swing.JPanel();
        jDashboard1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        PanelFooter = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PanelUtama = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        FrameKiri.setBackground(new java.awt.Color(15, 23, 42));
        FrameKiri.setForeground(new java.awt.Color(255, 204, 0));
        FrameKiri.setPreferredSize(new java.awt.Dimension(200, 562));

        PanelDashboard.setBackground(new java.awt.Color(11, 26, 51));
        PanelDashboard.setPreferredSize(new java.awt.Dimension(136, 46));

        txtDashboard.setBackground(new java.awt.Color(255, 255, 255));
        txtDashboard.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtDashboard.setForeground(new java.awt.Color(255, 255, 255));
        txtDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Smart Home Connection.png"))); // NOI18N
        txtDashboard.setText("Dashboard");
        txtDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDashboardMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelDashboardLayout = new javax.swing.GroupLayout(PanelDashboard);
        PanelDashboard.setLayout(PanelDashboardLayout);
        PanelDashboardLayout.setHorizontalGroup(
            PanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDashboardLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelDashboardLayout.setVerticalGroup(
            PanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDashboardLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(txtDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabelLogoHeader.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabelLogoHeader.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogoHeader.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\Icon\\Putra.Net.png")); // NOI18N
        jLabelLogoHeader.setMaximumSize(new java.awt.Dimension(100, 100));
        jLabelLogoHeader.setMinimumSize(new java.awt.Dimension(200, 200));

        PanelPelanggan.setBackground(new java.awt.Color(11, 26, 51));
        PanelPelanggan.setForeground(new java.awt.Color(51, 51, 51));
        PanelPelanggan.setPreferredSize(new java.awt.Dimension(136, 46));

        txtPelanggan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        txtPelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/User Account.png"))); // NOI18N
        txtPelanggan.setText("Pelanggan");
        txtPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPelangganMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelPelangganLayout = new javax.swing.GroupLayout(PanelPelanggan);
        PanelPelanggan.setLayout(PanelPelangganLayout);
        PanelPelangganLayout.setHorizontalGroup(
            PanelPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPelangganLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txtPelanggan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPelangganLayout.setVerticalGroup(
            PanelPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPelangganLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPelanggan)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        PanelPaket.setBackground(new java.awt.Color(11, 26, 51));
        PanelPaket.setPreferredSize(new java.awt.Dimension(136, 46));

        txtPaketInet.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPaketInet.setForeground(new java.awt.Color(255, 255, 255));
        txtPaketInet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Wi-Fi Connected.png"))); // NOI18N
        txtPaketInet.setText("Paket Internet");
        txtPaketInet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPaketInetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelPaketLayout = new javax.swing.GroupLayout(PanelPaket);
        PanelPaket.setLayout(PanelPaketLayout);
        PanelPaketLayout.setHorizontalGroup(
            PanelPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPaketLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtPaketInet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPaketLayout.setVerticalGroup(
            PanelPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPaketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPaketInet)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        PanelTeknisi.setBackground(new java.awt.Color(11, 26, 51));
        PanelTeknisi.setPreferredSize(new java.awt.Dimension(136, 46));

        txtTeknisi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTeknisi.setForeground(new java.awt.Color(255, 255, 255));
        txtTeknisi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Tools.png"))); // NOI18N
        txtTeknisi.setText("Teknisi");
        txtTeknisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTeknisiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelTeknisiLayout = new javax.swing.GroupLayout(PanelTeknisi);
        PanelTeknisi.setLayout(PanelTeknisiLayout);
        PanelTeknisiLayout.setHorizontalGroup(
            PanelTeknisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTeknisiLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtTeknisi)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        PanelTeknisiLayout.setVerticalGroup(
            PanelTeknisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTeknisiLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(txtTeknisi)
                .addContainerGap())
        );

        PanelRouter.setBackground(new java.awt.Color(11, 26, 51));
        PanelRouter.setPreferredSize(new java.awt.Dimension(136, 46));

        txtRouter.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtRouter.setForeground(new java.awt.Color(255, 255, 255));
        txtRouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Wi-Fi Router.png"))); // NOI18N
        txtRouter.setText("Router");
        txtRouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRouterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelRouterLayout = new javax.swing.GroupLayout(PanelRouter);
        PanelRouter.setLayout(PanelRouterLayout);
        PanelRouterLayout.setHorizontalGroup(
            PanelRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRouterLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelRouterLayout.setVerticalGroup(
            PanelRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRouterLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(txtRouter)
                .addContainerGap())
        );

        PanelLangganan.setBackground(new java.awt.Color(11, 26, 51));
        PanelLangganan.setPreferredSize(new java.awt.Dimension(136, 46));

        txtLangganan2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtLangganan2.setForeground(new java.awt.Color(255, 255, 255));
        txtLangganan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Contacts_3.png"))); // NOI18N
        txtLangganan2.setText("Langganan");
        txtLangganan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLangganan2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelLanggananLayout = new javax.swing.GroupLayout(PanelLangganan);
        PanelLangganan.setLayout(PanelLanggananLayout);
        PanelLanggananLayout.setHorizontalGroup(
            PanelLanggananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLanggananLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txtLangganan2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLanggananLayout.setVerticalGroup(
            PanelLanggananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLanggananLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLangganan2)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        PanelTransaksi.setBackground(new java.awt.Color(11, 26, 51));

        txtTransaksi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        txtTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Coin Wallet.png"))); // NOI18N
        txtTransaksi.setText("Transaksi");
        txtTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTransaksiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelTransaksiLayout = new javax.swing.GroupLayout(PanelTransaksi);
        PanelTransaksi.setLayout(PanelTransaksiLayout);
        PanelTransaksiLayout.setHorizontalGroup(
            PanelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTransaksiLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtTransaksi)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        PanelTransaksiLayout.setVerticalGroup(
            PanelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTransaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTransaksi)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        PanelLaporan.setBackground(new java.awt.Color(11, 26, 51));

        txtLaporan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtLaporan.setForeground(new java.awt.Color(255, 255, 255));
        txtLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Bookmark_3.png"))); // NOI18N
        txtLaporan.setText("Laporan");
        txtLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLaporanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelLaporanLayout = new javax.swing.GroupLayout(PanelLaporan);
        PanelLaporan.setLayout(PanelLaporanLayout);
        PanelLaporanLayout.setHorizontalGroup(
            PanelLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLaporanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(txtLaporan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLaporanLayout.setVerticalGroup(
            PanelLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLaporanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLaporan)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        PanelTicket.setBackground(new java.awt.Color(11, 26, 51));
        PanelTicket.setPreferredSize(new java.awt.Dimension(136, 46));

        txtTicket.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTicket.setForeground(new java.awt.Color(255, 255, 255));
        txtTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Ticket_1.png"))); // NOI18N
        txtTicket.setText("Ticket");
        txtTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTicketMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelTicketLayout = new javax.swing.GroupLayout(PanelTicket);
        PanelTicket.setLayout(PanelTicketLayout);
        PanelTicketLayout.setHorizontalGroup(
            PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTicketLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtTicket)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTicketLayout.setVerticalGroup(
            PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTicket)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FrameKiriLayout = new javax.swing.GroupLayout(FrameKiri);
        FrameKiri.setLayout(FrameKiriLayout);
        FrameKiriLayout.setHorizontalGroup(
            FrameKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrameKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(PanelDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addComponent(PanelPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addComponent(PanelPaket, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addComponent(PanelRouter, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addComponent(PanelLangganan, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addComponent(PanelTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PanelTeknisi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PanelTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FrameKiriLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLogoHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        FrameKiriLayout.setVerticalGroup(
            FrameKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrameKiriLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelLogoHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(PanelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(PanelPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(PanelPaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(PanelTeknisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(PanelRouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(PanelLangganan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(PanelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(PanelTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(PanelLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanel1.add(FrameKiri, java.awt.BorderLayout.WEST);

        Layer1.setBackground(new java.awt.Color(255, 255, 255));
        Layer1.setLayout(new java.awt.BorderLayout());

        PanelHeader.setBackground(new java.awt.Color(15, 23, 42));
        PanelHeader.setPreferredSize(new java.awt.Dimension(1383, 50));

        jDashboard1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jDashboard1.setForeground(new java.awt.Color(255, 255, 255));
        jDashboard1.setText("SELAMAT BEKERJA!");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/iPhone_Memoji_Laptop1.png"))); // NOI18N

        txtCari.setForeground(new java.awt.Color(204, 204, 204));
        txtCari.setText("Search");
        txtCari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCariFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCariFocusLost(evt);
            }
        });
        txtCari.addActionListener(this::txtCariActionPerformed);
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        btnCari.setBackground(new java.awt.Color(79, 70, 229));
        btnCari.setForeground(new java.awt.Color(255, 255, 255));
        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Search_3.png"))); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(this::btnCariActionPerformed);
        btnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCariKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 822, Short.MAX_VALUE)
                .addComponent(jDashboard1)
                .addGap(6, 6, 6)
                .addComponent(jLabel2))
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2)
                .addGroup(PanelHeaderLayout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(jDashboard1)))
        );

        Layer1.add(PanelHeader, java.awt.BorderLayout.PAGE_START);

        PanelFooter.setBackground(new java.awt.Color(15, 23, 42));
        PanelFooter.setPreferredSize(new java.awt.Dimension(1383, 35));

        btnLogout.setBackground(new java.awt.Color(79, 70, 229));
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Logout_1.png"))); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Workspace_2.png"))); // NOI18N
        jLabel4.setText("Admin-Ver.0.1");

        javax.swing.GroupLayout PanelFooterLayout = new javax.swing.GroupLayout(PanelFooter);
        PanelFooter.setLayout(PanelFooterLayout);
        PanelFooterLayout.setHorizontalGroup(
            PanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFooterLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1156, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addGap(18, 18, 18))
        );
        PanelFooterLayout.setVerticalGroup(
            PanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Layer1.add(PanelFooter, java.awt.BorderLayout.PAGE_END);

        PanelUtama.setLayout(new java.awt.GridLayout());
        Layer1.add(PanelUtama, java.awt.BorderLayout.CENTER);

        jPanel1.add(Layer1, java.awt.BorderLayout.CENTER);

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cariMenu();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariKeyPressed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cariMenu();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCariKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariKeyPressed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed

        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int confirm = javax.swing.JOptionPane.showConfirmDialog(
                    null,
                    "Yakin ingin logout Boss Quuu??",
                    "Logout",
                    javax.swing.JOptionPane.YES_NO_OPTION
                );

                if (confirm == javax.swing.JOptionPane.YES_OPTION) {
                    new FormLogin.form_login1().setVisible(true);
                    dispose();
                }
            }
        });        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void txtLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLaporanMouseClicked
        switchPanel(new Laporan.MenuLaporan());    // TODO add your handling code here:
    }//GEN-LAST:event_txtLaporanMouseClicked

    private void txtTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTransaksiMouseClicked
        switchPanel(new FormTransaksi.Transaksii());   // TODO add your handling code here:
    }//GEN-LAST:event_txtTransaksiMouseClicked

    private void txtLangganan2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLangganan2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLangganan2MouseClicked

    private void txtRouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRouterMouseClicked
        switchPanel(new FormRouter.Router());// TODO add your handling code here:
    }//GEN-LAST:event_txtRouterMouseClicked

    private void txtTeknisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTeknisiMouseClicked
        switchPanel(new FormTeknisi.Teknisi11());// TODO add your handling code here:
    }//GEN-LAST:event_txtTeknisiMouseClicked

    private void txtPaketInetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPaketInetMouseClicked
        // TODO add your handling code here:
        switchPanel(new FormPaket.DaftarPaket());
    }//GEN-LAST:event_txtPaketInetMouseClicked

    private void txtPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPelangganMouseClicked
        switchPanel(new FormPelanggan.Pelanggan());// TODO add your handling code here:
    }//GEN-LAST:event_txtPelangganMouseClicked

    private void txtDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDashboardMouseClicked
        PanelUtama.removeAll();
        PanelUtama.setLayout(new BorderLayout());
        PanelUtama.add(new Mendash.mendash(), BorderLayout.CENTER);
        PanelUtama.revalidate();
        PanelUtama.repaint();// TODO add your handling code here:
    }//GEN-LAST:event_txtDashboardMouseClicked

    private void txtTicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTicketMouseClicked
     switchPanel(new FormTiket.tiket());    // TODO add your handling code here:
    }//GEN-LAST:event_txtTicketMouseClicked

    private void txtCariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCariFocusGained
    if (String.valueOf(txtCari.getText()).equals("Search")) {
            txtCari.setText("");
        }    // TODO add your handling code here:
    }//GEN-LAST:event_txtCariFocusGained

    private void txtCariFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCariFocusLost
    if (txtCari.getText().equals("")) {
            txtCari.setText("Search");    // TODO add your handling code here:
    }
    }//GEN-LAST:event_txtCariFocusLost
private void cariMenu() {
    String key = txtCari.getText().toLowerCase();

    switch(key) {

        case "teknisi" -> switchPanel(new FormTeknisi.Teknisi11());

        case "router" -> switchPanel(new FormRouter.Router());

        case "paket" -> switchPanel(new FormPaket.DaftarPaket());

        case "langganan" -> switchPanel(new FormLangganan.Langganan());
        
        case "pelanggan" -> switchPanel(new FormPelanggan.Pelanggan());
        
        case "transaksi" -> switchPanel(new FormTransaksi.Transaksii());
        
        case "tiket" -> switchPanel(new FormTiket.tiket());
        
        case "laporan" -> switchPanel(new Laporan.MenuLaporan());

        default -> JOptionPane.showMessageDialog(this, "Menu tidak ditemukan!");
    }
}
    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {

    try {
        javax.swing.UIManager.setLookAndFeel(
            new com.formdev.flatlaf.FlatLightLaf()
        );
    } catch (Exception e) {
        e.printStackTrace();
    }
          
    java.awt.EventQueue.invokeLater(() -> {
        new Dashboard.Dashboard1().setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FrameKiri;
    private javax.swing.JPanel Layer1;
    private javax.swing.JPanel PanelDashboard;
    private javax.swing.JPanel PanelFooter;
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JPanel PanelLangganan;
    private javax.swing.JPanel PanelLaporan;
    private javax.swing.JPanel PanelPaket;
    private javax.swing.JPanel PanelPelanggan;
    private javax.swing.JPanel PanelRouter;
    private javax.swing.JPanel PanelTeknisi;
    private javax.swing.JPanel PanelTicket;
    private javax.swing.JPanel PanelTransaksi;
    private javax.swing.JPanel PanelUtama;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jDashboard1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelLogoHeader;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCari;
    private javax.swing.JLabel txtDashboard;
    private javax.swing.JLabel txtLangganan2;
    private javax.swing.JLabel txtLaporan;
    private javax.swing.JLabel txtPaketInet;
    private javax.swing.JLabel txtPelanggan;
    private javax.swing.JLabel txtRouter;
    private javax.swing.JLabel txtTeknisi;
    private javax.swing.JLabel txtTicket;
    private javax.swing.JLabel txtTransaksi;
    // End of variables declaration//GEN-END:variables
}
