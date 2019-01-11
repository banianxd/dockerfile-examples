package me.chanjar.docker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  @Value("${target.host}")
  private static String host;
//  String host;

  public static void main(String[] args) {
    System.out.println("============== ARGUMENTS main==============");
    System.out.println(host);
    if (args != null && args.length > 0) {
      for (String arg : args) {
        System.out.println(arg);
      }
    }
    SpringApplication.run(Application.class, args);
  }

}
