package bonus;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame(){
        super("My drawing application!");
        init();
    }

    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas= new DrawingPanel(this);
        configPanel=new ConfigPanel(this);
        controlPanel=new ControlPanel(this);

        add(canvas,CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(configPanel,BorderLayout.NORTH);

        pack();
    }
}
