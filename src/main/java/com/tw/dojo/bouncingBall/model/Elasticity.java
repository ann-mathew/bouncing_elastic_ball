package com.tw.dojo.bouncingBall.model;

public class Elasticity implements Property {

    private int radius;
    private int growthDirection;
    private int DEFAULT_RADIUS;

    public static final int GROWTH_RATE = 2;
    public static final int GROW = 1;
    public static final int SHRINK = -1;

    Elasticity(int growthDirection) {
        this.DEFAULT_RADIUS = Ball.DEFAULT_RADIUS;
        this.growthDirection = growthDirection;
    }

    @Override
    public void transform(Ball ball) {
        radius = ball.radius();
        growthDirection = reverseGrowthDirectionIfNecessary();
        radius = next();
        ball.setRadius(radius);
    }

    /***********************************************************************************
     *
     * Do not change Elastic ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) {
            return switchDirection();
        }

        return this.growthDirection;
    }

    private boolean shrinkingTooSmall() {
        return radius <= 0 && shrinking();
    }

    private boolean growingTooBig() {
        return radius >= DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    private int next() {
        return radius + (GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == SHRINK;
    }

    private boolean growing() {
        return growthDirection == GROW;
    }
}
