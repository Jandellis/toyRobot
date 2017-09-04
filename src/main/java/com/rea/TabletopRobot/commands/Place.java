package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;
import com.rea.TabletopRobot.model.Direction;
import com.rea.TabletopRobot.model.Location;
import java.util.List;

/**
 * Please fill me out with a bit of info about this file
 */
public class Place extends Command {

  public Place(Tabletop tableTop) {
    super(tableTop, "PLACE");
  }

  @Override
  public void execute(List<String> args) {
    tableTop.placeRobot(new Location(0,0, Direction.NORTH));

  }
}
