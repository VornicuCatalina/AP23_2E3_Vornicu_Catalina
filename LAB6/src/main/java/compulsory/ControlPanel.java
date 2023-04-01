package compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton resetBtn= new JButton("Reset");
    JButton saveBtn=new JButton("Save");
    JButton loadBtn=new JButton("Load");
    public ControlPanel(MainFrame frame){
        this.frame=frame;
        init();
    }

    private void init(){
        setLayout(new GridLayout(1,4));
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
        exitBtn.addActionListener(this::exitGame);
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
    }
    private void loadGame(ActionEvent e){

    }
    private void saveGame(ActionEvent e){

    }
    private void resetGame(ActionEvent e){

    }

    private void exitGame(ActionEvent e){
        frame.dispose();
    }
}
