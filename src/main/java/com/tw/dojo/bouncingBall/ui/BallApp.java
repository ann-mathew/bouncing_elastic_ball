package com.tw.dojo.bouncingBall;

import com.tw.dojo.bouncingBall.model.BallFactory;
import com.tw.dojo.bouncingBall.ui.BallWorld;

import javax.swing.*;

// DO NOT CHANGE
public class BallApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bouncing Ball Dojo");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setContentPane(
                    new BallWorld(BallFactory.all())
            );
            frame.pack();
            frame.setVisible(true);
        });
    }
}
