package com.rea.TabletopRobot.model;

/**
 * Please fill me out with a bit of info about this file
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
