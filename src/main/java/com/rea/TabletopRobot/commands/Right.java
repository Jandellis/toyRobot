package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;
import com.rea.TabletopRobot.model.Turn;
import java.util.List;

/**
 * Turn the robot to the Right
 */
public class Right extends Command {

  public Right(Tabletop tableTop) {
    super(tableTop, "RIGHT");
  }

  @Override
  public void execute(List<String> args) {
    tableTop.turnRobot(Turn.RIGHT);
    
  }
}
