package com.rea.TabletopRobot.controler;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.rea.TabletopRobot.model.Direction;
import com.rea.TabletopRobot.model.Location;
import com.rea.TabletopRobot.model.Turn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TabletopTest {

  @Autowired
  Tabletop tabletop;

  @Test
  public void placeValidRobotSouthWestCorner() throws Exception {
    Location location = new Location(0, 0, Direction.NORTH);
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(true));
  }

  @Test
  public void placeValidRobotSouthEastCorner() throws Exception {
    Location location = new Location(4, 0, Direction.EAST);
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(true));
  }

  @Test
  public void placeValidRobotNorthWestCorner() throws Exception {
    Location location = new Location(0, 4, Direction.WEST);
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(true));
  }

  @Test
  public void placeValidRobotNorthEastCorner() throws Exception {
    Location location = new Location(4, 4, Direction.SOUTH);
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(true));
  }

  @Test
  public void placeInvalidRobotYHigh() throws Exception {
    Location location = new Location(0, 5, Direction.NORTH);
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(false));
  }

  @Test
  public void placeInvalidRobotYLow() throws Exception {
    Location location = new Location(0, -1, Direction.NORTH);
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(false));
  }

  @Test
  public void placeInvalidRobotXHigh() throws Exception {
    Location location = new Location(5, 2, Direction.NORTH);
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(false));
  }

  @Test
  public void placeInvalidRobotXLow() throws Exception {
    Location location = new Location(-1, 3, Direction.NORTH);
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(false));
  }


  @Test
  public void placeInvalidRobotBothHigh() throws Exception {
    Location location = new Location(5, 20, Direction.NORTH);
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(false));
  }

  @Test
  public void placeInvalidRobotBothLow() throws Exception {
    Location location = new Location(-1, -3, Direction.NORTH);
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(false));
  }


  @Test
  public void moveRobot() throws Exception {
    Location location = new Location(0, 0, Direction.NORTH);
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
    tabletop.placeRobot(startLocation);
    boolean result = tabletop.moveRobot();
    Location resultLocation = tabletop.getRobot().getLocation();

    assertThat(result, is(false));
    assertThat(resultLocation, is(startLocation));
  }

  @Test
  public void moveRobotNotPlaced() throws Exception {
    boolean result = tabletop.moveRobot();

    assertThat(result, is(false));
  }

  @Test
  public void turnRobotLeftToNegative90() throws Exception {
    Location location = new Location(0, 0, Direction.NORTH);
    tabletop.placeRobot(location);
    boolean result = tabletop.turnRobot(Turn.LEFT);

    Location resultLocation = tabletop.getRobot().getLocation();
    Location expectedLocation = new Location(0, 0, Direction.WEST);

    assertThat(result, is(true));
    assertThat(resultLocation, is(expectedLocation));
  }

  @Test
  public void turnRobotRightTo360() throws Exception {
    Location location = new Location(0, 0, Direction.WEST);
    tabletop.placeRobot(location);
    boolean result = tabletop.turnRobot(Turn.RIGHT);

    Location resultLocation = tabletop.getRobot().getLocation();
    Location expectedLocation = new Location(0, 0, Direction.NORTH);

    assertThat(result, is(true));
    assertThat(resultLocation, is(expectedLocation));
  }

  @Test
  public void turnRobot() throws Exception {
    Location location = new Location(0, 0, Direction.EAST);
    tabletop.placeRobot(location);
    boolean result = tabletop.turnRobot(Turn.RIGHT);

    Location resultLocation = tabletop.getRobot().getLocation();
    Location expectedLocation = new Location(0, 0, Direction.SOUTH);

    assertThat(result, is(true));
    assertThat(resultLocation, is(expectedLocation));
  }
}