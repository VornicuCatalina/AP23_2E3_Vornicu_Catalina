package compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800 , H=600;
    private int numVertices;
    private double edgeProbability;
    private int[] x,y;

    BufferedImage image;
    Graphics2D graphics;
    public DrawingPanel(MainFrame frame){
        this.frame=frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel(){
        setPreferredSize(new Dimension(W,H));
        setBorder(BorderFactory.createEtchedBorder());
    }

    private void createOffscreenImage(){
        image=new BufferedImage(W,H,BufferedImage.TYPE_INT_ARGB);
        graphics= image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,800,600);
    }

    final void createBoard(){
        //numVertices= (Integer) frame.configPanel.dotsLabel.getValue();
        //edgeProbability=(Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
    }
    private void createVertices(){
        int x0=W/2;
        int y0=H/2;
        int radius= H/2-10;
        double alpha = 2* Math.PI / numVertices;
        x= new int[numVertices];
        y=new int[numVertices];
        for(int i=0;i<numVertices;i++){
            x[i]=x0+(int) (radius*Math.cos(alpha*i));
            y[i]=y0+(int) (radius*Math.sin(alpha*i));
        }
    }

    private void drawLines(){

    }

    private void drawVertices(){

    }

    @Override
    public void update(Graphics g){}
    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(image, 0, 0 ,this);
    }
}
