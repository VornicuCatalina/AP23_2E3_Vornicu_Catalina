package compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800 , H=600;
    private int numVertices=10;
    private double edgeProbability=0.2;
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
        drawVertices();
        drawLines();
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
        graphics.setColor(Color.BLACK);
        for(int i=0;i<numVertices-1;i++){
            for(int j=0;j<numVertices;j++){
                if(i!=j){
                    int rand= (int)(Math.random()*100);
                    if(edgeProbability*100>=rand){
                        graphics.drawLine(x[i],y[i],x[j],y[j]);
                    }
                }
            }
        }
    }

    private void drawVertices(){
        graphics.setColor(Color.BLACK);
        for(int i=0;i<numVertices;i++){
            super.paintComponent(graphics);
            graphics.drawOval(x[i],y[i],10,10);
            graphics.fillOval(x[i],y[i],10,10);
        }
    }
    /*this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();
                    if(x>createButton.getX()&&y>createButton.getY()&&x<27&&y<550){
                        System.out.println("merge");
                    }
                    repaint();
                }
            });*/
    @Override
    public void update(Graphics g){}
    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(image, 0, 0 ,this);
    }
}
