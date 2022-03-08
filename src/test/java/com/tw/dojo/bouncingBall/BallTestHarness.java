package com.tw.dojo.bouncingBall;

import com.tw.dojo.bouncingBall.model.Ball;
import com.tw.dojo.bouncingBall.model.BouncingBall;
import com.tw.dojo.bouncingBall.model.ElasticBall;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BallTestHarness {
    public static void assertCenterYCoordinateIs(int expectedCenterY, Ball ball) {
        assertThat("Ball is at the wrong y-coordinate!", ball.center().y, is(expectedCenterY));
    }

    public static int oneStepDownFrom(int centerY) {
        return centerY + BouncingBall.MOVEMENT_SPEED;
    }

    public static int oneStepUpFrom(int centerY) {
        return centerY - BouncingBall.MOVEMENT_SPEED;
    }


    public static void assertRadiusIs(int expectedRadius, Ball ball) {
        assertThat("Ball does not have the correct radius", ball.radius(), is(expectedRadius));
    }

    public static int oneStepInwardsFrom(int radius) {
        return radius - ElasticBall.GROWTH_RATE;
    }

    public static int oneStepOutwardsFrom(int radius) {
        return radius + ElasticBall.GROWTH_RATE;
    }
}
