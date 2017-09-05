package com.rea.TabletopRobot.model;

/**
 * The possible turn options
 */
public enum Turn {
  RIGHT(90),
  LEFT(-90);

  private int degree;


  Turn(int degree) {
    this.degree = degree;
  }

  public int getDegree() {
    return degree;
  }
}
