package com.rea.TabletopRobot.controler;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.rea.TabletopRobot.model.Direction;
import com.rea.TabletopRobot.model.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Please fill me out with a bit of info about this file
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RunnerTest {

  @Autowired
  Runner runner;

  /*@Test
  public void runBadCommand() throws Exception {
    String[] args = new String[0];
    runner.RunCommand("MOVE1", args);
  }*/

  @Test
  public void runGoodCommand() throws Exception {
    String[] args = new String[0];
    runner.RunCommand("PLACE", args);
    runner.RunCommand("RIGHT", args);

    Location resultLocation = runner.getTabletop().getRobot().getLocation();
    Location expectedLocation = new Location(0, 0, Direction.WEST);

    assertThat(resultLocation, is(expectedLocation));
  }

}