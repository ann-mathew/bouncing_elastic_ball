package com.tw.dojo.bouncingBall.model;

import java.awt.*;
import java.util.List;

public class Ball {
    static final int DEFAULT_RADIUS = 50;
    private int x;
    private int y;
    private int radius;
    private final List<Property> properties;

    protected Ball(int x, int y, int radius, List<Property> properties) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.properties = properties;
    }

    public int y() {
        return this.y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setY(int y) {
        this.y = y;
    }

    // DO NOT CHANGE
    public int radius() {
        return radius;
    }

    // DO NOT CHANGE
    public Point center() {
        return new Point(x, y);
    }

    public void update() {
        for (Property property : properties) {
            property.transform(this);
        }
    }
}
