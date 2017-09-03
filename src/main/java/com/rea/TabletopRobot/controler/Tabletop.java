package com.rea.TabletopRobot.controler;

import com.rea.TabletopRobot.model.Location;
import com.rea.TabletopRobot.model.Robot;
import com.rea.TabletopRobot.model.Turn;

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

  public Robot getRobot() {
    return robot;
  }

  public Boolean placeRobot(Location location) {
    if (!isLocationOnTable(location)) {
      return false;
    }
    robot.setLocation(location);
    robot.setPlaced(true);
    return true;
  }

  public Boolean moveRobot() {
    if (!robot.isPlaced()) {
      return false;
    }
    int x = 0;
    int y = 0;
    switch (robot.getLocation().getDirection()) {
      case NORTH:
        y = 1;
        break;
      case EAST:
        x = 1;
        break;
      case SOUTH:
        y = -1;
        break;
      case WEST:
        x = -1;
        break;
    }
    Location toMove = new Location(robot.getLocation().getX() + x, robot.getLocation().getY() + y,
        robot.getLocation().getDirection());
    if (!isLocationOnTable(toMove)) {
      return false;
    }
    robot.setLocation(toMove);
    return true;
  }

  public Boolean turnRobot(Turn turn) {
    if (!robot.isPlaced()) {
      return false;
    }
    return false;
  }

  private Boolean isLocationOnTable(Location location) {
    return (location.getX() <= xSize && location.getX() >= 0) && (location.getY() <= ySize && location.getY() >= 0);
  }
}
