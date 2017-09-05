package com.rea.TabletopRobot.controler;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RunnerTest {

  @Autowired
  Runner runner;

  @Test
  public void runBadCommand() throws Exception {
    runner.runCommand("MOVE1", new ArrayList<>());
    assertThat(runner.getTabletop().getRobot().isPlaced(), is(false));
  }

  @Test
  public void runBadPlaceCommand() throws Exception {
    runner.runCommand("PLACE", Stream.of("1", "4", "dir").collect(Collectors.toList()));
    assertThat(runner.getTabletop().getRobot().isPlaced(), is(false));
  }

  @Test
  public void runBadPlaceCommandDirectionOnly() throws Exception {
    runner.runCommand("PLACE", Stream.of(Direction.EAST.name()).collect(Collectors.toList()));
    assertThat(runner.getTabletop().getRobot().isPlaced(), is(false));
  }

  @Test
  public void runCommandsWithoutPlaceFirst() throws Exception {

    runner.runCommand("MOVE", new ArrayList<>());
    runner.runCommand("RIGHT", new ArrayList<>());
    assertThat(runner.getTabletop().getRobot().isPlaced(), is(false));
    runner.runCommand("PLACE", Stream.of("4", "4", Direction.EAST.name()).collect(Collectors.toList()));

    Location resultLocation = runner.getTabletop().getRobot().getLocation();
    Location expectedLocation = new Location(4, 4, Direction.EAST);

    assertThat(resultLocation, is(expectedLocation));
  }

  @Test
  public void tryPlaceOffTable() throws Exception {
    runner.runCommand("PLACE", Stream.of("40", "4", Direction.EAST.name()).collect(Collectors.toList()));

    assertThat(runner.getTabletop().getRobot().isPlaced(), is(false));
  }

  @Test
  public void runAllCommands() throws Exception {
    runner.runCommand("PLACE", Stream.of("1", "0", Direction.NORTH.name()).collect(Collectors.toList()));
    runner.runCommand("MOVE", new ArrayList<>());
    runner.runCommand("MOVE", new ArrayList<>());
    runner.runCommand("LEFT", new ArrayList<>());
    runner.runCommand("LEFT", new ArrayList<>());
    runner.runCommand("LEFT", new ArrayList<>());
    runner.runCommand("MOVE", new ArrayList<>());
    runner.runCommand("REPORT", new ArrayList<>());
    runner.runCommand("RIGHT", new ArrayList<>());

    Location resultLocation = runner.getTabletop().getRobot().getLocation();
    Location expectedLocation = new Location(2, 2, Direction.SOUTH);

    assertThat(resultLocation, is(expectedLocation));
  }

}