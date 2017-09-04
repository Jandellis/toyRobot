package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;

/**
 * Please fill me out with a bit of info about this file
 */
public abstract class Command {

  protected Tabletop tableTop;

  public Command(Tabletop tableTop) {
    this.tableTop = tableTop;
  }

  public abstract void execute();

}
