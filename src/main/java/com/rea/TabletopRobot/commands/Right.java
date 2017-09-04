package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;
import com.rea.TabletopRobot.model.Turn;

/**
 * Please fill me out with a bit of info about this file
 */
public class Right extends Command {

  public Right(Tabletop tableTop) {
    super(tableTop, "RIGHT");
  }

  @Override
  public void execute(String[] args) {
    tableTop.turnRobot(Turn.RIGHT);
    
  }
}
