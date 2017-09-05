package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Please fill me out with a bit of info about this file
 */
public class Report extends Command {
  private static final Logger LOGGER = LoggerFactory.getLogger(Report.class);

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
