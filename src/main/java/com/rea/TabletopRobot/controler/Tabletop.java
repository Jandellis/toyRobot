package com.rea.TabletopRobot.controler;

import com.rea.TabletopRobot.model.Direction;
import com.rea.TabletopRobot.model.Location;
import com.rea.TabletopRobot.model.Robot;
import com.rea.TabletopRobot.model.Turn;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Class to control the robot and move it around on the table
 */
@Component
public class Tabletop {

  private Robot robot;
  private int xSize;
  private int ySize;

  @Autowired
  public Tabletop(@Value("${tabletop.x.size}") int xSize, @Value("${tabletop.y.size}") int ySize) {
    this.xSize = xSize;
    this.ySize = ySize;
    robot = new Robot();

  }

  public Robot getRobot() {
    return robot;
  }

  /**
   * Place the robot onto the table
   *
   * @param location the location to place
   * @return true if the robot was placed successfully on the table
   */
  public Boolean placeRobot(Location location) {
    if (!isLocationOnTable(location)) {
      return false;
    }
    robot.setLocation(location);
    robot.setPlaced(true);
    return true;
  }

  /**
   * Moves the robot forward one title
   * @return true if the robot was moved
   */
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

  /**
   * Turn the robot 90 degrees in a direction
   * @param turn the direction to turn
   * @return true if the turn was executed
   */
  public Boolean turnRobot(Turn turn) {
    if (!robot.isPlaced()) {
      return false;
    }
    Optional<Direction> direction = Direction
        .degreesToDirection(robot.getLocation().getDirection().getDegree() + turn.getDegree());
    if (!direction.isPresent()) {
      return false;
    }

    Location toTurn = new Location(robot.getLocation().getX(), robot.getLocation().getY(), direction.get());

    robot.setLocation(toTurn);
    return true;
  }

  private Boolean isLocationOnTable(Location location) {
    return (location.getX() <= xSize && location.getX() >= 0) && (location.getY() <= ySize && location.getY() >= 0);
  }
}
