package homework;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    int numVertices;
    float edgeProbability;
    boolean start = false;
    int[] x, y;
    private int node1X, node2X, node1Y, node2Y;
    int player = 1;
    boolean finished = false;
    public boolean saving = false;
    BufferedImage image;
    Graphics2D graphics;

    //to check edges
    Graph<List<Integer>, DefaultEdge> graphJGraphT;
    Map<List<Integer>, Integer> nodesToUser; // 0 -nobody ; 1-player1 ; 2-player2

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        this.setBackground(Color.WHITE);
        createOffscreenImage();
        initPanel();
    }

    private void settingNode1CordsZero() {
        node1X = 0;
        node1Y = 0;
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (saving) {
                    try {
                        savePNG();
                    } catch (AWTException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (start) {
                    int x1 = e.getX();
                    int y1 = e.getY();
                    for (int i = 0; i < numVertices; i++) {
                        if (x1 >= x[i] && y1 >= y[i] && x1 <= x[i] + 10 && y1 <= y[i] + 10) {
                            if (node1X == 0 && node1Y == 0) {
                                node1X = x[i];
                                node1Y = y[i];
                                //to be more beautiful, to color it
                                if (player == 1) {
                                    graphics.setColor(Color.BLUE);
                                } else {
                                    graphics.setColor(Color.RED);
                                }
                                graphics.drawOval(node1X, node1Y, 10, 10);
                                graphics.fillOval(node1X, node1Y, 10, 10);
                            } else {
                                node2X = x[i];
                                node2Y = y[i];
                                graphics.setColor(Color.BLACK);
                                graphics.drawOval(node1X, node1Y, 10, 10);
                                graphics.fillOval(node1X, node1Y, 10, 10);
                                if (graphJGraphT.containsEdge(Arrays.asList(node1X, node1Y), Arrays.asList(node2X, node2Y))) {
                                    List<Integer> list = new ArrayList<>(Arrays.asList(node1X, node1Y, node2X, node2Y));
                                    if (nodesToUser.get(list) == 0) {
                                        if (player == 1) {
                                            graphics.setColor(Color.BLUE);
                                            nodesToUser.replace(list, 1);
                                            nodesToUser.replace(Arrays.asList(node2X, node2Y, node1X, node1Y), 1);
                                            player = 2;
                                            graphics.setColor(Color.WHITE);
                                            graphics.drawString("Player 1", 50, 50);
                                            graphics.setColor(Color.PINK);
                                            graphics.drawString("Player 2", 50, 50);
                                            graphics.setColor(Color.BLUE);
                                        } else {
                                            graphics.setColor(Color.RED);
                                            nodesToUser.replace(list, 2);
                                            nodesToUser.replace(Arrays.asList(node2X, node2Y, node1X, node1Y), 2);
                                            player = 1;
                                            graphics.setColor(Color.WHITE);
                                            graphics.drawString("Player 2", 50, 50);
                                            graphics.setColor(Color.PINK);
                                            graphics.drawString("Player 1", 50, 50);
                                            graphics.setColor(Color.RED);
                                        }
                                        graphics.drawLine(node1X, node1Y, node2X, node2Y);
                                        node2Y = 0;
                                        node2X = 0;
                                        settingNode1CordsZero();
                                    } else {
                                        settingNode1CordsZero();
                                    }
                                } else {
                                    settingNode1CordsZero();
                                }
                            }
                        }
                    }
                    checkingWinner();
                    if (!finished) {
                        checkingDraw();
                    }
                }
                repaint();
            }
        });
    }

    private void savePNG() throws AWTException, IOException {
        repaint();
        File outputfile = new File("C:/Users/User/Documents/AP23_2E3_Vornicu_Catalina/LAB6/src/main/java/png/pic.png");
        Rectangle rectangle = new Rectangle(W, H + 100);
        BufferedImage bufferedImage = new Robot().createScreenCapture(rectangle);
        ImageIO.write(bufferedImage, "png", outputfile);
        saving = false;
    }

    private void checkingWinner() {
        int flag;
        for (List<Integer> key : nodesToUser.keySet()) {
            LinkedList<Integer> var1 = new LinkedList<>(Arrays.asList(key.get(0), key.get(1)));
            for (List<Integer> key2 : nodesToUser.keySet()) {
                LinkedList<Integer> var2 = new LinkedList<>(Arrays.asList(key2.get(0), key2.get(1)));
                LinkedList<Integer> var3 = new LinkedList<>(Arrays.asList(key2.get(2), key2.get(3)));
                if (graphJGraphT.containsEdge(var1, var2) && graphJGraphT.containsEdge(var2, var3) && graphJGraphT.containsEdge(var1, var3)) {
                    flag = nodesToUser.get(Arrays.asList(var1.get(0), var1.get(1), var2.get(0), var2.get(1)));
                    if (flag != 0) {
                        if (nodesToUser.get(Arrays.asList(var3.get(0), var3.get(1), var2.get(0), var2.get(1))) == flag && nodesToUser.get(Arrays.asList(var3.get(0), var3.get(1), var1.get(0), var1.get(1))) == flag) {
                            graphics.setColor(Color.ORANGE);
                            if (flag == 1) {
                                graphics.drawString("PLAYER 1 WON", 700, 50);
                            } else {
                                graphics.drawString("PLAYER 2 WON", 700, 50);
                            }
                            start = false;
                            finished = true;
                            saving = true;
                        }
                    }
                }
            }
        }
        //need 4 variable of type int[2]/linkedlist(2), cords of nodes
        //going through keys
        //checking its type; player 1 or 2
        //new loop through keys and checking type mandatory
        //var1_1=first loop value : first pair of nodes
        //var1_2=first loop value : second pair of nodes
        //var2=second loop value: first pair of nodes
        //var3=second loop value: second pair of nodes
        //var1-var2 && var2-var3 &&var3-var1
        //check if edge exists between them. if it does -> declaring the winner
    }

    private void checkingDraw() {
        int counter = 0;
        for (Integer i : nodesToUser.values()) {
            if (i != 0) {
                counter++;
            }
        }
        graphics.setColor(Color.ORANGE);
        if (counter == nodesToUser.size()) {
            graphics.drawString("DRAW", 700, 50);
            start = false;
            saving = true;
            finished = true;
        }
        repaint();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    private void initializingVariables() {
        start = true;
        finished = false;
        player = 1;
        settingNode1CordsZero();
    }

    final void createBoard() {
        numVertices = (int) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (float) frame.configPanel.linesCombo.getSelectedItem();
        graphJGraphT = new DefaultUndirectedGraph<>(DefaultEdge.class);
        nodesToUser = new HashMap<>();
        initializingVariables();
        createOffscreenImage();
        createVertices();
        drawVertices();
        drawLines();
        graphics.setColor(Color.PINK);
        graphics.drawString("Player 1", 50, 50);
        repaint();
    }

    final void restartingGame() {
        createOffscreenImage();
        drawVertices();
        graphics.setColor(Color.BLACK);
        for (List<Integer> key : nodesToUser.keySet()) {
            graphics.drawLine(key.get(0), key.get(1), key.get(2), key.get(3));
            nodesToUser.replace(key, 0);
        }
        graphics.setColor(Color.PINK);
        graphics.drawString("Player 1", 50, 50);
        initializingVariables();
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2;
        int radius = H / 2 - 10;
        double alpha = 2 * Math.PI / numVertices;
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
            graphJGraphT.addVertex(Arrays.asList(x[i], y[i]));
        }
    }

    private void drawLines() {
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < numVertices - 1; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i != j) {
                    int rand = (int) (Math.random() * 100);
                    if (edgeProbability * 100 >= rand) {
                        graphics.drawLine(x[i], y[i], x[j], y[j]);
                        graphJGraphT.addEdge(Arrays.asList(x[i], y[i]), Arrays.asList(x[j], y[j]));
                        nodesToUser.put(Arrays.asList(x[i], y[i], x[j], y[j]), 0);
                        nodesToUser.put(Arrays.asList(x[j], y[j], x[i], y[i]), 0);
                    }
                }
            }
        }
        repaint();
    }

    private void drawVertices() {
        graphics.setColor(Color.BLACK);
        super.paintComponent(graphics);
        for (int i = 0; i < numVertices; i++) {
            graphics.drawOval(x[i], y[i], 10, 10);
            graphics.fillOval(x[i], y[i], 10, 10);
        }
        repaint();
    }


    //for last point of loading the game //
    void loadingGame(SerializationHelper serializationHelper) {
        System.out.println("hey,works!");
        this.numVertices = serializationHelper.numVertices;
        this.edgeProbability = serializationHelper.edgeProbability;
        this.player = serializationHelper.player;
        this.x = serializationHelper.x;
        this.y = serializationHelper.y;
        this.finished = serializationHelper.finished;
        this.start = true;
        this.saving = finished;
        this.nodesToUser = serializationHelper.nodesToUser;
        this.graphJGraphT = serializationHelper.graphJGraphT;

        createOffscreenImage();
        drawVertices();
        for (List<Integer> key : nodesToUser.keySet()) {
            int color = nodesToUser.get(key);
            switch (color) {
                case 0:
                    graphics.setColor(Color.BLACK);
                    break;
                case 1:
                    graphics.setColor(Color.BLUE);
                    break;
                default:
                    graphics.setColor(Color.RED);
            }
            graphics.drawLine(key.get(0), key.get(1), key.get(2), key.get(3));
        }
        repaint();
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
