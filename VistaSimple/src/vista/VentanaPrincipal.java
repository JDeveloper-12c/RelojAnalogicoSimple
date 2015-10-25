package vista;

import com.sun.awt.AWTUtilities;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;

import java.awt.event.ComponentEvent;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import relojanalogicosimplecomponente.RelojAnalogico;


public class VentanaPrincipal extends JFrame {
    private ImageIcon iconoBarra = new ImageIcon(VentanaPrincipal.class.getResource("reloj.png"));
    private RelojAnalogico jPanel1 = new RelojAnalogico();
    private BorderLayout borderLayout1 = new BorderLayout();

    public VentanaPrincipal() {
        try {
            jbInit();
        } catch (Exception e) {
            String error = e.getMessage();
            JOptionPane.showMessageDialog(null, "Error: " +  error);
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(borderLayout1);
        this.setSize(new Dimension(321, 265));

        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        this.setIconImage(this.iconoBarra.getImage());
        this.setTitle("Reloj Analógico");
        
        this.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    this_mouseEntered(e);
                }

                public void mouseExited(MouseEvent e) {
                    this_mouseExited(e);
                }
            });
      
        setAlwaysOnTop(true);
        //this.setUndecorated(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)screenSize.getWidth()-this.getWidth()-10, 10);
        //AWTUtilities.setWindowOpacity(this, 0.2f);
    }

    private void this_mouseEntered(MouseEvent e) {
       //AWTUtilities.setWindowOpacity(this, 1.0f);
    }

    private void this_mouseExited(MouseEvent e) {
       //AWTUtilities.setWindowOpacity(this, 0.2f);
    }
}
