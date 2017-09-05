package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A command to be executed on the robot
 */
public abstract class Command {

  static final Logger LOGGER = LoggerFactory.getLogger(Command.class);

  Tabletop tableTop;

  private String name;

  Command(Tabletop tableTop, String name) {
    this.tableTop = tableTop;
    this.name = name;
  }

  /**
   * Execute the command
   *
   * @param args the arguments of the command
   */
  public abstract void execute(List<String> args);

  public String getName() {
    return name;
  }

}
