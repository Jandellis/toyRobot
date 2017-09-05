package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;
import java.util.List;

/**
 * Report the location of the robot
 */
public class Report extends Command {

  public Report(Tabletop tableTop) {
    super(tableTop, "REPORT");
  }

  @Override
  public void execute(List<String> args) {
    if (tableTop.getRobot().isPlaced()) {
      LOGGER.info("Robot location is " + tableTop.getRobot().getLocation());
    }
  }
}
