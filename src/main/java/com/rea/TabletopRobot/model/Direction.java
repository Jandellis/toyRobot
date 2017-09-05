package com.rea.TabletopRobot.model;

import java.util.Optional;

/**
 * Created by james_000 on 3/09/2017.
 */
public enum Direction {
  NORTH(0, "NORTH"),
  EAST(90, "EAST"),
  SOUTH(180, "SOUTH"),
  WEST(270, "WEST");



  private int degree;
  private String name;

  Direction(int degree, String name) {
    this.degree = degree;
    this.name = name;
  }

  public int getDegree() {
    return degree;
  }

  public static Optional<Direction> degreesToDirection(int degree) {
    switch (degree) {
      case 360:
      case 0:
        return Optional.of(NORTH);
      case 90:
        return Optional.of(EAST);
      case 180:
        return Optional.of(SOUTH);
      case 270:
      case -90:
        return Optional.of(WEST);
    }
    return Optional.empty();
  }

  public static Optional<Direction> fromName(String name) {
    switch (name) {
      case "NORTH":
        return Optional.of(NORTH);
      case "EAST":
        return Optional.of(EAST);
      case "SOUTH":
        return Optional.of(SOUTH);
      case "WEST":
        return Optional.of(WEST);
    }
    return Optional.empty();
  }
}
