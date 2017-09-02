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
  public void placeValidRobot() throws Exception {
    Location location = new Location(0,0, Direction.NORTH);
    Tabletop tabletop = new Tabletop();
    boolean result = tabletop.placeRobot(location);
    assertThat(result, is(true));
  }
}