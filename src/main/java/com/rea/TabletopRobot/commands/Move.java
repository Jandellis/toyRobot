package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;
import java.util.List;

/**
 * Please fill me out with a bit of info about this file
 */
public class Move extends Command {

  public Move(Tabletop tableTop) {
    super(tableTop, "MOVE");
  }

  @Override
  public void execute(List<String> args) {
    tableTop.moveRobot();

  }
}
