package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Please fill me out with a bit of info about this file
 */
public abstract class Command {

  protected static final Logger LOGGER = LoggerFactory.getLogger(Command.class);

  Tabletop tableTop;

  String name;

  Command(Tabletop tableTop, String name) {
    this.tableTop = tableTop;
    this.name = name;
  }

  public abstract void execute(List<String> args);

  public String getName() {
    return name;
  }

}
