package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;
import java.util.List;

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

  public abstract void execute(List<String> args);

  public String getName() {
    return name;
  }

}
