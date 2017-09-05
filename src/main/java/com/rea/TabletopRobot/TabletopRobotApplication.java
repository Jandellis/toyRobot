package com.rea.TabletopRobot;

import com.rea.TabletopRobot.controler.Runner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TabletopRobotApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext app = SpringApplication.run(TabletopRobotApplication.class, args);

    Runner runner = (Runner) app.getBean("runner");
    runner.init();

  }
}
