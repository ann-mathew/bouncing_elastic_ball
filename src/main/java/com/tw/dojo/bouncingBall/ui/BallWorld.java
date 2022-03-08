package com.tw.dojo.bouncingBall.ui;

import com.tw.dojo.bouncingBall.model.Ball;

import javax.swing.*;
import java.awt.*;

// DO NOT CHANGE
public class BallWorld extends JPanel {
    public static final int BOX_WIDTH = 640;
    public static final int BOX_HEIGHT = 480;

    private static final int REFRESH_RATE_PER_SECOND = 30;

    private final Ball[] balls;

    public BallWorld(Ball... balls) {
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
        this.balls = balls;

        Thread displayThread = new Thread() {
            public void run() {
                while (true) {
                    updateBalls();
                    repaint(); // Callback paintComponent()

                    try {
                        Thread.sleep(1000 / REFRESH_RATE_PER_SECOND);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        displayThread.start();
    }

    private void updateBalls() {
        for (Ball ball : balls) {
            ball.update();
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

        for (Ball ball : balls) {
            paintBall(ball, graphics);
        }
    }

    private void paintBall(Ball ball, Graphics graphics) {
        Point center = ball.center();
        Point upperLeftCoordinate = new Point(center.x - ball.radius(), center.y - ball.radius());
        int diameter = 2 * ball.radius();

        graphics.setColor(Color.GREEN);
        graphics.fillOval(upperLeftCoordinate.x, upperLeftCoordinate.y, diameter, diameter);
    }
}
