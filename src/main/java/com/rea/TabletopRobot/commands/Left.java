package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;
import com.rea.TabletopRobot.model.Turn;
import java.util.List;

/**
 * Turn the robot to the Left
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
