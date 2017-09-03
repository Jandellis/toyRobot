package com.rea.TabletopRobot.model;

/**
 * Created by james_000 on 3/09/2017.
 */
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
}
