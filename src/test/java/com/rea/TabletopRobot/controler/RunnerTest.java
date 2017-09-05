package com.rea.TabletopRobot.controler;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.rea.TabletopRobot.model.Direction;
import com.rea.TabletopRobot.model.Location;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Please fill me out with a bit of info about this file
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RunnerTest {

  @Autowired
  Runner runner;

  @Test
  public void runBadCommand() throws Exception {
    runner.runCommand("MOVE1", new ArrayList<>());
  }

  @Test
  public void runGoodCommand() throws Exception {
    runner.runCommand("PLACE", Stream.of("0", "0", Direction.NORTH.name()).collect(Collectors.toList()));
    runner.runCommand("RIGHT", new ArrayList<>());

    Location resultLocation = runner.getTabletop().getRobot().getLocation();
    Location expectedLocation = new Location(0, 0, Direction.EAST);

    assertThat(resultLocation, is(expectedLocation));
  }

  @Test
  public void runGoodCommand2() throws Exception {
    runner.runCommand("PLACE", Stream.of("0", "0",Direction.NORTH.name()).collect(Collectors.toList()));
    runner.runCommand("LEFT", new ArrayList<>());
    runner.runCommand("REPORT", new ArrayList<>());

    Location resultLocation = runner.getTabletop().getRobot().getLocation();
    Location expectedLocation = new Location(0, 0, Direction.WEST);

    assertThat(resultLocation, is(expectedLocation));
  }

}