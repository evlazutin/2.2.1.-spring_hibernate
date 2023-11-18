package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);

      Car car = new Car("Москвич", 3);
      Car car1 = new Car("Жига", 6);
      User user = new User("User1", "Lastname1", "user1@mail.ru");
      User user1 = new User("User2", "Lastname2", "user2@mail.ru");
      user.setCar(car);
      user1.setCar(car1);
      userService.add(user);
      userService.add(user1);
      System.out.println(userService.findUserByCarModelAndSeries("Москвич", 3));
      System.out.println(userService.findUserByCarModelAndSeries("Жига", 6));
      context.close();
   }
}
