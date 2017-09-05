package com.rea.TabletopRobot.commands;

import com.rea.TabletopRobot.controler.Tabletop;
import com.rea.TabletopRobot.model.Direction;
import com.rea.TabletopRobot.model.Location;
import java.util.List;
import java.util.Optional;

/**
 * Please fill me out with a bit of info about this file
 */
public class Place extends Command {

  public Place(Tabletop tableTop) {
    super(tableTop, "PLACE");
  }

  @Override
  public void execute(List<String> args) {
    if (args.size() < 3) {
      return;
    }
    int x;
    int y;

    try {
      x = Integer.valueOf(args.get(0));
      y = Integer.valueOf(args.get(1));
    } catch (NumberFormatException e) {
      return;
    }
    Optional<Direction> direction = Direction.fromName(args.get(2));
    if (direction.isPresent()) {

      tableTop.placeRobot(new Location(x, y, direction.get()));
    }

  }
}
