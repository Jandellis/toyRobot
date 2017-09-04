package com.rea.TabletopRobot.controler;

import com.google.common.collect.Lists;
import com.rea.TabletopRobot.commands.Command;
import com.rea.TabletopRobot.commands.Left;
import com.rea.TabletopRobot.commands.Move;
import com.rea.TabletopRobot.commands.Place;
import com.rea.TabletopRobot.commands.Report;
import com.rea.TabletopRobot.commands.Right;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Please fill me out with a bit of info about this file
 */
@Service
public class Runner {

  private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

  private List<Command> commands;
  private Tabletop tabletop;

  @Autowired
  public Runner(Tabletop tabletop) {
    this.tabletop = tabletop;
    commands = Stream.of(
        new Left(tabletop),
        new Right(tabletop),
        new Move(tabletop),
        new Place(tabletop),
        new Report(tabletop))
        .collect(Collectors.toList());
  }

  public void init() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      LOGGER.info("Enter command...");
      String input = scanner.nextLine();
      List<String> commands = Lists.newArrayList(input.split("[ ,]"));
      String command = commands.remove(0);

      runCommand(command, commands);
    }
  }

  public void runCommand(String commandName, List<String> args) {
    Optional<Command> command = commands.stream()
        .filter(filteredCommand -> filteredCommand.getName().equals(commandName))
        .findFirst();

    if (!command.isPresent()) {
      LOGGER.error("Invalid command : " + commandName);
      return;
    }
    command.get().execute(args);
  }

  public Tabletop getTabletop() {
    return tabletop;
  }
}
