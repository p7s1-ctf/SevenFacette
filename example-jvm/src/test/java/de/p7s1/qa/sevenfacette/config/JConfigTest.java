package de.p7s1.qa.sevenfacette.config;

import de.p7s1.qa.sevenfacette.kafka.KConsumer;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JConfigTest {

  @Test
  void loadConfig() {
    //"build/resources/test/test.yml"
    ConfigLoader loader = new ConfigLoader();
    Path configSource = Paths.get("build/resources/test/test.yml");
    ConfigClass configClass = new ConfigClass();

    try {
      configClass = loader.load(ConfigClass.class, configSource);
    } catch (IOException e) {
      System.out.print("FILE not found");
    }

    System.out.println(configClass.banner);
    System.out.println(configClass.profile);
    System.out.println(configClass.user);
    System.out.println(configClass.time);
    System.out.println(configClass.warning);
  }

  @Test
  void loadNestedConfig() {
    ConfigLoader loader = new ConfigLoader();
    //Path configSource = Paths.get("build/resources/test/test.yml");
    Path configSource = Paths.get("build/resources/test/nestedConfig.yml");
    ConfigClass configClass = new ConfigClass();
    try {
      configClass = loader.load(ConfigClass.class, configSource);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    System.out.println(configClass.banner);
    System.out.println(configClass.profile);
    System.out.println(configClass.user);
    System.out.println(configClass.time);
    System.out.println(configClass.warning);
  }

  @Test
  void loadEnvironmentConfig() {



    ConfigLoader loader = new ConfigLoader();
    Path configSource = Paths.get("build/resources/test/test.yml");
    ConfigClass configClass = new ConfigClass();
    try {
      configClass = loader.load(ConfigClass.class, configSource);
    } catch (IOException e) {
      System.out.print("FILE not found");
    }

    System.out.println(configClass.banner);
    System.out.println(configClass.profile);
    System.out.println(configClass.user);
    System.out.println(configClass.time);
    System.out.println(configClass.warning);
  }

  @Test
  void loadCascadingConfig() {
    ConfigLoader loader = new ConfigLoader();
    Path configSource = Paths.get("build/resources/test/test.yml");
    ConfigClass configClass = new ConfigClass();
    try {
      configClass = loader.load(ConfigClass.class, configSource);
    } catch (IOException e) {
      System.out.print("FILE not found");
    }
    System.out.println(configClass.banner);
    System.out.println(configClass.profile);
    System.out.println(configClass.user);
    System.out.println(configClass.time);
    System.out.println(configClass.warning);
  }
}
