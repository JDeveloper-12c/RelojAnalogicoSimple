package relojanalogicosimplecomponente;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;

import java.awt.Graphics2D;

import java.awt.RenderingHints;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.JPanel;

public class RelojAnalogico extends JPanel {
    //---
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
    private SimpleDateFormat formatoSegundoActual = new SimpleDateFormat("ss");
    private SimpleDateFormat formatoMinutoActual = new SimpleDateFormat("mm");
    private SimpleDateFormat formatoHoraActual = new SimpleDateFormat("hh");
    private String fechaD = "dd/mm/aaaa";
    private String horaD = "hh:mm:ss";
    private int segundoActual = 0;
    private int minutoActual = 0;
    private int horaActual = 0;
    private Float centroX = new Float(100);
    private Float centroY = new Float(100);
    private Float radio = new Float(100);
    private Float X = new Float(0);
    private Float Y = new Float(0);
    private Float[][] circuloPerimetroXY = new Float[2][61]; //Iniciar en jbInit()
    Graphics2D g2=null;
    Date dateSistema=null;
    GradientPaint gradientPaintAgujaSegundos = new GradientPaint(8, 10, Color.RED, 8, 40, Color.BLACK, true);
    GradientPaint gradientPaintNumerosHora = new GradientPaint(8, 10, Color.ORANGE, 8, 40, Color.BLACK, true);
    BasicStroke BasicStrokeSegundos = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
    BasicStroke BasicStrokeMinutos = new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
    BasicStroke BasicStrokeHora = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
    
    Escuchador escuchador = new Escuchador(){
        @Override
        public void lanzador() {
            dateSistema = new Date();
            fechaD = formatoFecha.format(dateSistema);
            horaD = formatoHora.format(dateSistema);
            segundoActual = Integer.valueOf(formatoSegundoActual.format(dateSistema));
            minutoActual = Integer.valueOf(formatoMinutoActual.format(dateSistema));
            horaActual = Integer.valueOf(formatoHoraActual.format(dateSistema));
            miRepaint();
        }
    };
    private BorderLayout borderLayout1 = new BorderLayout();

    public RelojAnalogico() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout(borderLayout1);
        this.setSize(new Dimension(301, 226));
        this.setBackground(new Color(247, 247, 247));
        int x=0;
        Float radianes = new Float(0);
        for(int i=0-84; i<366-84; i=i+6) { //360°/6=60 
            radianes=(float)(Math.PI*i)/180;
            circuloPerimetroXY[0][x]=(float)Math.cos(radianes);
            circuloPerimetroXY[1][x]=(float)Math.sin(radianes);
            x=x+1;
        }
        HiloReloj hiloReloj = new HiloReloj();
        hiloReloj.setVisor(escuchador);
        hiloReloj.start();
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        centroX=(float)this.getWidth()/2;
        centroY=(float)this.getHeight()/2;

        if(centroX.compareTo(centroY)>0){
          radio = centroY-10;    
        }else {
          radio = centroX-10;  
        }
        g2.setPaint(gradientPaintNumerosHora);
        for(int x=0; x<60; x=x+1) {  
          X=centroX+radio*circuloPerimetroXY[0][x];
          Y=centroY+radio*circuloPerimetroXY[1][x];    
          if((x+1)% 5 == 0){      
              g2.fillOval(X.intValue()-4, Y.intValue()-4, 8, 8);
              X=(centroX-1)+(radio-10)*circuloPerimetroXY[0][x];
              Y=(centroY+7)+(radio-10)*circuloPerimetroXY[1][x];    
              g2.drawString("" + ((x+1)/5), X.intValue()-3, Y.intValue()-2);
          }else{
              g2.fillOval(X.intValue()-2, Y.intValue()-2, 4, 4);
          }  
        }
        g2.setColor(Color.BLACK);
        g2.drawString(fechaD.toString(), 10, 20);
        g2.drawString(horaD, this.getWidth()-70, 20);
        
        if(horaActual == 0){
            horaActual=12; 
        }        
        X=centroX+(radio/1.35f)*circuloPerimetroXY[0][horaActual*5-1];
        Y=(centroY)+(radio/1.35f)*circuloPerimetroXY[1][horaActual*5-1]; 
        g2.setColor(Color.GRAY);
        g2.fillOval(centroX.intValue()-15, centroY.intValue()-15, 30, 30);
        g2.setStroke(BasicStrokeHora);
        g2.drawLine(centroX.intValue(), centroY.intValue(), X.intValue(), Y.intValue());
        if(minutoActual == 0){
            minutoActual=60; 
        }        
        X=centroX+(radio/1.25f)*circuloPerimetroXY[0][minutoActual-1];
        Y=centroY+(radio/1.25f)*circuloPerimetroXY[1][minutoActual-1];    
        g2.setColor(Color.BLACK);
        g2.setStroke(BasicStrokeMinutos);
        g2.fillOval(centroX.intValue()-10, centroY.intValue()-10, 20, 20);
        g2.drawLine(centroX.intValue(), centroY.intValue(), X.intValue(), Y.intValue());
        if(segundoActual == 0){
            segundoActual=60; 
        }
        X=centroX+(radio/1.15f)*circuloPerimetroXY[0][segundoActual-1];
        Y=centroY+(radio/1.15f)*circuloPerimetroXY[1][segundoActual-1];    
        //g2.setColor(Color.RED);
        g2.setStroke(BasicStrokeSegundos);
        g2.setPaint(gradientPaintAgujaSegundos);
        g2.fillOval(centroX.intValue()-5, centroY.intValue()-5, 10, 10);
        g2.drawLine(centroX.intValue(), centroY.intValue(), X.intValue(), Y.intValue());

    }

    public void miRepaint() {
        super.repaint();
    }
}
