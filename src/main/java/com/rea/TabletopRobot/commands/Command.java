package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;

/**
 * Please fill me out with a bit of info about this file
 */
public abstract class Command {

  protected Tabletop tableTop;

  protected String name;

  public Command(Tabletop tableTop, String name) {
    this.tableTop = tableTop;
    this.name = name;
  }

  public abstract void execute(String[] args);

  public String getName() {
    return name;
  }

}
