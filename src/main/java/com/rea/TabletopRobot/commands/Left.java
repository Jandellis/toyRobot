package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;
import com.rea.TabletopRobot.model.Turn;
import java.util.List;

/**
 * Please fill me out with a bit of info about this file
 */
public class Left extends Command {

  public Left(Tabletop tableTop) {
    super(tableTop, "LEFT");
  }

  @Override
  public void execute(List<String> args) {
tableTop.turnRobot(Turn.LEFT);
  }
}
