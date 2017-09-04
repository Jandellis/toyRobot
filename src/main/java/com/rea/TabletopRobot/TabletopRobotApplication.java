package com.rea.TabletopRobot;

import com.rea.TabletopRobot.controler.Tabletop;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabletopRobotApplication {

  @Autowired
  private static Tabletop tabletop;

  public static void main(String[] args) {
    SpringApplication.run(TabletopRobotApplication.class, args);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter your nationality: ");
    String nationality = scanner.nextLine();

    System.out.print("Enter your age: ");
    int age = scanner.nextInt();
  }
}
