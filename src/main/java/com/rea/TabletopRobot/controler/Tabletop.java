package com.rea.TabletopRobot.controler;

import com.rea.TabletopRobot.model.Location;
import com.rea.TabletopRobot.model.Robot;

/**
 * Created by james_000 on 3/09/2017.
 */
public class Tabletop {

  private Robot robot;
  final private int xSize = 4;
  final private int ySize = 4;

  public Tabletop() {
    robot = new Robot();

  }

  public Boolean placeRobot(Location location) {
    if (!isLocationOnTable(location)) {
      return false;
    }
    robot.setLocation(location);
    robot.setPlaced(true);
    return true;
  }

  private Boolean isLocationOnTable(Location location) {
    return (location.getX() <= xSize && location.getX() >= 0) && (location.getY() <= ySize && location.getY() >= 0);
  }
}
