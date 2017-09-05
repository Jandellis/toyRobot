package com.rea.TabletopRobot.model;

public class Location {

  private int x;
  private int y;
  private Direction direction;

  public Location(int x, int y, Direction direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Location) {
      return ((Location) obj).direction == this.direction &&
          ((Location) obj).y == this.y &&
          ((Location) obj).x == this.x;

    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return "Location{" +
        "x=" + x +
        ", y=" + y +
        ", direction=" + direction +
        '}';
  }
}
