package com.java.observer.swingexample;

import javax.swing.*;
import java.awt.*;

/**
 * @author ll
 */
public class SwingObserverExample {
    JFrame jFrame;

    public static void main(String[] args) {
        SwingObserverExample e = new SwingObserverExample();
        e.go();
    }

    public void go() {
        jFrame = new JFrame();

        JButton jButton = new JButton("Should I do it?");
        jButton.addActionListener((event) -> System.out.println("Dont't do it, you might regret it!"));
        jButton.addActionListener((event)-> System.out.println("Come on, do it!"));
        jFrame.getContentPane().add(BorderLayout.CENTER, jButton);
    }
}
