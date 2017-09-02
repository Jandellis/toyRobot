package com.rea.TabletopRobot.model;

/**
 * Created by james_000 on 3/09/2017.
 */
public class Robot {
    private Location location;
    private boolean placed = false;

    public Location getLocation() {
        return location;
    }

    public Robot setLocation(Location location) {
        this.location = location;
        return this;
    }

    public boolean isPlaced() {
        return placed;
    }

    public Robot setPlaced(boolean placed) {
        this.placed = placed;
        return this;
    }
}
