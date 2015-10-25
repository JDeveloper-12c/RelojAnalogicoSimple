package vistatransparencia;

import com.sun.awt.AWTUtilities;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

import java.awt.event.ComponentEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
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
    private JToolBar jToolBar1 = new JToolBar();
    private JLabel jLabel1 = new JLabel();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JButton jButton4 = new JButton();

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
        this.setSize(new Dimension(266, 232));

        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        jToolBar1.add(jLabel1, null);
        jToolBar1.add(jButton4, null);
        jToolBar1.add(jButton1, null);
        jToolBar1.add(jButton2, null);
        jToolBar1.add(jButton3, null);
        jToolBar1.setFloatable(false);
        jToolBar1.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    jToolBar1_mouseEntered(e);
                }

                public void mouseExited(MouseEvent e) {
                    jToolBar1_mouseExited(e);
                }
            });
        this.getContentPane().add(jToolBar1, BorderLayout.NORTH);
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

        jLabel1.setText("Reloj Analógico");
        jLabel1.setMaximumSize(new Dimension(100000, 14));
        jLabel1.addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    jLabel1_mouseDragged(e);
                }
            });
        jLabel1.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    jLabel1_mouseEntered(e);
                }

                public void mouseExited(MouseEvent e) {
                    jLabel1_mouseExited(e);
                }

                public void mouseClicked(MouseEvent e) {
                    jLabel1_mouseClicked(e);
                }
            });
        jButton1.setText("_");
        jButton1.setFocusable(false);
        jButton1.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    jButton1_mouseEntered(e);
                }

                public void mouseExited(MouseEvent e) {
                    jButton1_mouseExited(e);
                }
            });
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jButton2.setText("=");
        jButton2.setFocusable(false);
        jButton2.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    jButton2_mouseEntered(e);
                }

                public void mouseExited(MouseEvent e) {
                    jButton2_mouseExited(e);
                }
            });
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2_actionPerformed(e);
                }
            });
        jButton3.setText("X");
        jButton3.setFocusable(false);
        jButton3.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    jButton3_mouseEntered(e);
                }

                public void mouseExited(MouseEvent e) {
                    jButton3_mouseExited(e);
                }
            });
        jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton3_actionPerformed(e);
                }
            });
        jButton4.setText("!");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton4_actionPerformed(e);
                }
            });
        jButton4.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent e) {
                    jButton4_mouseExited(e);
                }

                public void mouseEntered(MouseEvent e) {
                    jButton4_mouseEntered(e);
                }
            });
        setAlwaysOnTop(true);
        this.setUndecorated(true);
        AWTUtilities.setWindowOpacity(this, 0.2f);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)screenSize.getWidth()-this.getWidth()-10, 10);
    }

    private void this_mouseEntered(MouseEvent e) {
       AWTUtilities.setWindowOpacity(this, 1.0f);
    }

    private void this_mouseExited(MouseEvent e) {
       AWTUtilities.setWindowOpacity(this, 0.2f);
    }

    private void jToolBar1_mouseEntered(MouseEvent e) {
        AWTUtilities.setWindowOpacity(this, 1.0f);
    }

    private void jToolBar1_mouseExited(MouseEvent e) {
        AWTUtilities.setWindowOpacity(this, 0.2f);
    }

    private void jButton3_mouseEntered(MouseEvent e) {
        AWTUtilities.setWindowOpacity(this, 1.0f);
    }

    private void jButton2_mouseEntered(MouseEvent e) {
        AWTUtilities.setWindowOpacity(this, 1.0f);
    }

    private void jButton1_mouseEntered(MouseEvent e) {
        AWTUtilities.setWindowOpacity(this, 1.0f);
    }

    private void jButton3_mouseExited(MouseEvent e) {
        AWTUtilities.setWindowOpacity(this, 0.2f);
    }

    private void jButton2_mouseExited(MouseEvent e) {
        AWTUtilities.setWindowOpacity(this, 0.2f);
    }

    private void jButton1_mouseExited(MouseEvent e) {
        AWTUtilities.setWindowOpacity(this, 0.2f);
    }

    private void jButton3_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    private int estado = 0;
    private void jButton2_actionPerformed(ActionEvent e) {
        if(estado == 0) {
            this.setExtendedState(this.MAXIMIZED_BOTH);
            this.jButton2.setText("-");
            estado=1;
        }else{
            this.setExtendedState(this.NORMAL);
            this.jButton2.setText("=");
            estado=0;
        }
    }

    private void jButton1_actionPerformed(ActionEvent e) {
        this.setExtendedState(this.ICONIFIED);
    }

    private void jLabel1_mouseDragged(MouseEvent mme) {
        setLocation(
           //this.getX() + mme.getX() - this.getWidth() / 2,
           //this.getY() + mme.getY() - this.getHeight() / 2
           this.getX() + mme.getX() - jLabel1.getWidth() / 2,
           this.getY() + mme.getY() - jLabel1.getHeight() / 2
        );
    }
    Cursor cursorMover = new Cursor(Cursor.MOVE_CURSOR);
    private void jLabel1_mouseEntered(MouseEvent e) {
        AWTUtilities.setWindowOpacity(this, 1.0f);
        jLabel1.setCursor(cursorMover);
    }
    Cursor cursorNormal = new Cursor(Cursor.DEFAULT_CURSOR);
    private void jLabel1_mouseExited(MouseEvent e) {
        AWTUtilities.setWindowOpacity(this, 0.2f);
        jLabel1.setCursor(cursorNormal);
    }
    private boolean flotante = true;
    private void jButton4_actionPerformed(ActionEvent e) {
        if(flotante){
            setAlwaysOnTop(false);
            this.jButton4.setText("!");
            flotante=false;
        }else{
            setAlwaysOnTop(true);
            this.jButton4.setText("¡");
            flotante=true;
        }
    }

    private void jButton4_mouseExited(MouseEvent e) {
        AWTUtilities.setWindowOpacity(this, 0.2f);
    }

    private void jButton4_mouseEntered(MouseEvent e) {
        AWTUtilities.setWindowOpacity(this, 1.0f);
    }


    private void jLabel1_mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            if(estado == 0) {
                this.setExtendedState(this.MAXIMIZED_BOTH);
                this.jButton2.setText("-");
                estado=1;
            }else{
                this.setExtendedState(this.NORMAL);
                this.jButton2.setText("=");
                estado=0;
            }            
        }
    }
}
