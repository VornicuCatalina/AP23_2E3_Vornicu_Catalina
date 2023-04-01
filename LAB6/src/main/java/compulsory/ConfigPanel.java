package compulsory;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;

    public ConfigPanel(MainFrame frame){
        this.frame=frame;
        init();
    }

    private void init(){
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6,3,100,1));

        linesLabel=new JLabel("Line probability:");
        linesCombo=new JComboBox<>();
        createButton=new JButton("Create New Game");

        add(dotsLabel);
        add(dotsSpinner);

        //test
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }

}
