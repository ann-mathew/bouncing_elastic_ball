package com.tw.dojo.bouncingBall.model;

import com.tw.dojo.bouncingBall.ui.BallWorld;

public class Bounce implements Property {

    public static final int MOVEMENT_SPEED = 12;
    public static final int DOWN = 1;
    public static final int UP = -1;

    private int y;
    private int radius;
    private int direction;

    Bounce(int direction) {
        this.direction = direction;
    }

    @Override
    public void transform(Ball ball) {
        y = ball.y();
        radius = ball.radius();
        direction = reverseDirectionIfNecessary();
        y = move();
        ball.setY(y);
    }

    /***********************************************************************************
     *
     * Do not change Bouncing ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            return switchDirection();
        }

        return this.direction;
    }

    private boolean movingTooLow() {
        return y + radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh() {
        return y - radius <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? UP : DOWN;
    }

    private int move() {
        return y + (MOVEMENT_SPEED * direction);
    }

    private boolean movingDown() {
        return direction == DOWN;
    }

    private boolean movingUp() {
        return direction == UP;
    }
}
