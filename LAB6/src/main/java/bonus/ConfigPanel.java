package bonus;

import javax.swing.*;
import java.util.Vector;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    Vector<Float> items=new Vector<>();
    public int nrDots;
    public float edgeProb;

    public ConfigPanel(MainFrame frame){
        this.frame=frame;
        for(int i=1;i<=10;i++){
            items.add((float)(0.1*i));
        }
        init();
    }

    private void init(){
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6,3,100,1));

        linesLabel=new JLabel("Line probability:");
        linesCombo=new JComboBox<>(items);
        createButton=new JButton("Create New Game");

        add(dotsLabel);
        add(dotsSpinner);

        //test
        add(linesLabel);
        add(linesCombo);
        add(createButton);
        click();
    }
    public void click(){
        createButton.addActionListener(e -> {
            frame.canvas.createBoard();
        });
    }

}
