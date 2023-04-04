package com.java.compound.mvc.view;

import com.java.compound.mvc.controller.ControllerInterface;
import com.java.compound.mvc.model.BPMObserver;
import com.java.compound.mvc.model.BeatModel;
import com.java.compound.mvc.model.BeatModelInterface;
import com.java.compound.mvc.model.BeatObserver;
import javafx.scene.control.ButtonBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ll
 */
public class DJView implements ActionListener, BeatObserver, BPMObserver {

    BeatModelInterface beatModel;
    ControllerInterface controller;

    JFrame viewFrame;
    JPanel viewPanel;
    PopupMenu beatBar;
    JLabel bpmOutputLabel;
    JTextField bpmTextField;
    JPanel bpmPanel;

    JButton setBPMButton;
    JButton increaseBPMButton;
    JButton decreaseBPMButton;

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem startMenuItem;
    JMenuItem stopMenuItem;


    public DJView(BeatModelInterface beatModel, ControllerInterface controller) {
        this.beatModel = beatModel;
        this.controller = controller;
        beatModel.registerObserver((BeatObserver) this);
        beatModel.registerObserver((BPMObserver)this);
    }

    public void createView() {
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
        beatBar = new PopupMenu();

        // beatBar.setValue(0);
        bpmPanel = new JPanel(new GridLayout(2, 1));
        bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
    }

    public void updateBPM() {
        int bpm = beatModel.getBPM();
        if (bpm == 0) {
            bpmOutputLabel.setText("offline");
        } else {
            bpmOutputLabel.setText("Current BPM: " + beatModel.getBPM());
        }
    }

    public void updateBeat() {
        // beatBar.setValue(100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == setBPMButton) {
            int bpm = Integer.parseInt(bpmTextField.getText());
            controller.setBPM(bpm);
        } else if (e.getSource() == increaseBPMButton) {
            controller.increaseBPM();
        } else if (e.getSource() == decreaseBPMButton) {
            controller.decreaseBPM();
        }
    }

    public void createControls() {
        // ...
    }

    public void disableStopMenuItem() {
        // ...
    }

    public void enableStartMenuItem() {
        // ...
    }

    public void disableStartMenuItem() {
        // ..
    }

    public void enableStopMenuItem() {
        // ..
    }
}
