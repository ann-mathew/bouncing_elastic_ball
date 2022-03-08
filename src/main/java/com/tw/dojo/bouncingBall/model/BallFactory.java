package com.tw.dojo.bouncingBall.model;

import static java.util.Arrays.asList;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, Ball.DEFAULT_RADIUS, Bounce.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, Elasticity.SHRINK),
                bouncingElasticBall(425, 150, Ball.DEFAULT_RADIUS, Bounce.DOWN, Elasticity.SHRINK)
        };
    }

    public static Ball bouncingElasticBall(int centerX, int centerY, int radius, int direction, int growthDirection) {
        return new Ball(centerX, centerY, radius, asList(new Bounce(direction),
                new Elasticity(growthDirection)));
    }

    public static Ball bouncingBall(int centerX, int centerY, int radius, int direction) {
        return new Ball(centerX, centerY, radius, asList(new Bounce(direction)));
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int growthDirection) {
        return new Ball(centerX, centerY, radius, asList(new Elasticity(growthDirection)));
    }
}
