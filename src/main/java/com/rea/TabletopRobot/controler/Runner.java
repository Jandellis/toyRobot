package com.rea.TabletopRobot.controler;

import com.rea.TabletopRobot.commands.Left;
import com.rea.TabletopRobot.commands.Move;
import com.rea.TabletopRobot.commands.Place;
import com.rea.TabletopRobot.commands.Report;
import com.rea.TabletopRobot.commands.Right;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Please fill me out with a bit of info about this file
 */
public class Runner {

  private Left left;
  private Right right;
  private Move move;
  private Place place;
  private Report report;
  private Tabletop tabletop;

  @Autowired
  public Runner(Tabletop tabletop) {

  }

}
