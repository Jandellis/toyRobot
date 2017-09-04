package com.rea.TabletopRobot.model;

/**
 * Created by james_000 on 3/09/2017.
 */
public enum Direction {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270);

    private int degree;

    Direction(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    public static Direction degreesToDirection(int degree) {
        switch (degree) {
            case 360:
            case 0:
                return NORTH;
            case 90:
                return EAST;
            case 180:
                return SOUTH;
            case 270:
            case -90:
                return WEST;
        }
        return null;
    }
}
