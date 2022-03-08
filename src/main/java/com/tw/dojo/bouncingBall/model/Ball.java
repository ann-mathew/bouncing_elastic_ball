package com.tw.dojo.bouncingBall.model;

import java.awt.*;

public abstract class Ball {
    protected static final int DEFAULT_RADIUS = 50;
    protected int x;
    protected int y;
    protected int radius;

    protected Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    protected Ball(int x, int y) {
        this(x, y, DEFAULT_RADIUS);
    }

    // DO NOT CHANGE
    public int radius() {
        return radius;
    }

    // DO NOT CHANGE
    public Point center() {
        return new Point(x, y);
    }

    public abstract void update();
}
