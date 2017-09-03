package com.rea.TabletopRobot.controler;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.rea.TabletopRobot.model.Direction;
import com.rea.TabletopRobot.model.Location;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Please fill me out with a bit of info about this file
 */
public class TabletopTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void placeValidRobotSouthWestCorner() throws Exception {
    Location location = new Location(0, 0, Direction.NORTH);
    Tabletop tabletop = new Tabletop();
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(true));
  }

  @Test
  public void placeValidRobotSouthEastCorner() throws Exception {
    Location location = new Location(4, 0, Direction.EAST);
    Tabletop tabletop = new Tabletop();
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(true));
  }

  @Test
  public void placeValidRobotNorthWestCorner() throws Exception {
    Location location = new Location(0, 4, Direction.WEST);
    Tabletop tabletop = new Tabletop();
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(true));
  }

  @Test
  public void placeValidRobotNorthEastCorner() throws Exception {
    Location location = new Location(4, 4, Direction.SOUTH);
    Tabletop tabletop = new Tabletop();
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(true));
  }

  @Test
  public void placeInvalidRobotYHigh() throws Exception {
    Location location = new Location(0, 5, Direction.NORTH);
    Tabletop tabletop = new Tabletop();
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(false));
  }

  @Test
  public void placeInvalidRobotYLow() throws Exception {
    Location location = new Location(0, -1, Direction.NORTH);
    Tabletop tabletop = new Tabletop();
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(false));
  }

  @Test
  public void placeInvalidRobotXHigh() throws Exception {
    Location location = new Location(5, 2, Direction.NORTH);
    Tabletop tabletop = new Tabletop();
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(false));
  }

  @Test
  public void placeInvalidRobotXLow() throws Exception {
    Location location = new Location(-1, 3, Direction.NORTH);
    Tabletop tabletop = new Tabletop();
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(false));
  }


  @Test
  public void placeInvalidRobotBothHigh() throws Exception {
    Location location = new Location(5, 20, Direction.NORTH);
    Tabletop tabletop = new Tabletop();
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(false));
  }

  @Test
  public void placeInvalidRobotBothLow() throws Exception {
    Location location = new Location(-1, -3, Direction.NORTH);
    Tabletop tabletop = new Tabletop();
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(false));
  }


  @Test
  public void moveRobot() throws Exception {
    Location location = new Location(0, 0, Direction.NORTH);
    Tabletop tabletop = new Tabletop();
    tabletop.placeRobot(location);
    boolean result = tabletop.moveRobot();

    Location resultLocation = tabletop.getRobot().getLocation();
    Location expectedLocation = new Location(0, 1, Direction.NORTH);

    assertThat(result, is(true));
    assertThat(resultLocation, is(expectedLocation));
  }

  @Test
  public void moveRobotOffTable() throws Exception {
    Location startLocation = new Location(0, 0, Direction.SOUTH);
    Tabletop tabletop = new Tabletop();
    tabletop.placeRobot(startLocation);
    boolean result = tabletop.moveRobot();
    Location resultLocation = tabletop.getRobot().getLocation();

    assertThat(result, is(false));
    assertThat(resultLocation, is(startLocation));
  }

  @Test
  public void moveRobotNotPlaced() throws Exception {
    Tabletop tabletop = new Tabletop();
    boolean result = tabletop.moveRobot();

    assertThat(result, is(false));
  }
}