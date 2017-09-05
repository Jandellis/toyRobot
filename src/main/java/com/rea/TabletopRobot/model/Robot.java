package com.rea.TabletopRobot.model;

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
