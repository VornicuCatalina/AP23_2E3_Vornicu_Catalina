package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton resetBtn = new JButton("Reset");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
        exitBtn.addActionListener(this::exitGame);
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
    }

    private void loadGame(ActionEvent e) {
        SerializationHelper serializationHelper = null;
        try {
            FileInputStream fileIn = new FileInputStream("C:/Users/User/Documents/AP23_2E3_Vornicu_Catalina/LAB6/src/main/java/png/game.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            serializationHelper = (SerializationHelper) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        frame.canvas.loadingGame(serializationHelper);
    }

    private void saveGame(ActionEvent e) {
        if (frame.canvas.start) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/User/Documents/AP23_2E3_Vornicu_Catalina/LAB6/src/main/java/png/game.ser");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                SerializationHelper serializationHelper = new SerializationHelper(frame.canvas.numVertices, frame.canvas.edgeProbability, frame.canvas.x, frame.canvas.y, frame.canvas.player, frame.canvas.finished, frame.canvas.graphJGraphT, frame.canvas.nodesToUser);
                objectOutputStream.writeObject(serializationHelper);
                fileOutputStream.close();
                System.out.println("Check \"C:/Users/User/Documents/AP23_2E3_Vornicu_Catalina/LAB6/src/main/java/png/pic.png\"");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private void resetGame(ActionEvent e) {
        frame.canvas.restartingGame();
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}
