package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;
import java.util.List;

/**
 * Please fill me out with a bit of info about this file
 */
public class Report extends Command {

  public Report(Tabletop tableTop) {
    super(tableTop, "REPORT");
  }

  @Override
  public void execute(List<String> args) {
    if (tableTop.getRobot().isPlaced()) {
      LOGGER.info("Robot location is " + tableTop.getRobot().getLocation());
    } else {
      LOGGER.info("Robot is not yet placed");
    }
  }
}
