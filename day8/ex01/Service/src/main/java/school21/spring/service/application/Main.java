package school21.spring.service.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<User> testUsers = createTestUsers();

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml")) {
            UsersRepository usersRepositoryJdbc = context.getBean("usersRepositoryJdbc", UsersRepository.class);
            DriverManagerDataSource ds = context.getBean("DriverManagerDataSource", DriverManagerDataSource.class);
            
            createTableInDb(ds);
            populateDb(usersRepositoryJdbc, testUsers);
            
            UsersRepository usersRepository1 = context.getBean("usersRepositoryJdbc", UsersRepository.class);
            System.out.println(usersRepository1.findAll());


            // Testing
            System.out.println("___Testing usersRepositoryJdbc___");

            //Find All
            List<User> testUserList = usersRepository1.findAll();
            System.out.println("__findAll__");
            for (User u : testUserList) {
                System.out.println(u);
            }
            if (testUsers.equals(testUserList)) {
                System.out.println("OK");
            } else {
                System.out.println("FAIL");
            }

            // Find By ID

            System.out.println("__findByID__");
            System.out.println(usersRepository1.findById(1L));
            System.out.println(usersRepository1.findById(10L));
            System.out.println(usersRepository1.findById(100L));

            // Save

            System.out.println("__save__");
            User testUser = new User(11L, "muchachos@hot.com");
            usersRepository1.save(testUser);
            System.out.println(usersRepository1.findById(11L));

            // Update
            System.out.println("__update__");
            testUser.setEmail("iamhot@hot.com");
            usersRepository1.update(testUser);
            System.out.println(usersRepository1.findById(11L));

            // Find by Email

            System.out.println("__findByEmail__");
            System.out.println(usersRepository1.findByEmail("hellome@gmail.com"));

            // Delete
            System.out.println("__delete__");
            usersRepository1.delete(11L);
            System.out.println(usersRepository1.findById(11L));

            // Tests for JDBC Template
            System.out.println("___Testing usersRepositoryJdbcTemplate___");
            UsersRepository usersRepository2 = context.getBean("usersRepositoryJdbcTemplate", UsersRepository.class);
            System.out.println(usersRepository1.findAll());

            //Find All
            List<User> testUserList2 = usersRepository2.findAll();
            System.out.println("__findAll__");
            for (User u : testUserList2) {
                System.out.println(u);
            }
            if (testUsers.equals(testUserList2)) {
                System.out.println("OK");
            } else {
                System.out.println("FAIL");
            }

            // Find By ID

            System.out.println("__findByID__");
            System.out.println(usersRepository2.findById(1L));
            System.out.println(usersRepository2.findById(10L));
            System.out.println(usersRepository2.findById(100L));

            // Save

            System.out.println("__save__");
            User testUser2 = new User(11L, "chopa@hot.com");
            usersRepository2.save(testUser2);
            System.out.println(usersRepository2.findById(11L));

            // Update
            System.out.println("__update__");
            testUser.setEmail("chupa_chups@hot.com");
            usersRepository2.update(testUser);
            System.out.println(usersRepository2.findById(11L));

            // Find by Email

            System.out.println("__findByEmail__");
            System.out.println(usersRepository2.findByEmail("gosduma@gmail.com"));

            // Delete
            System.out.println("__delete__");
            usersRepository2.delete(11L);
            System.out.println(usersRepository2.findById(11L));
        }
    }

    private static void createTableInDb(DataSource ds) {

        try (Connection conn = ds.getConnection();
             PreparedStatement drop = conn.prepareStatement("drop table if exists public.user");
             PreparedStatement create = conn.prepareStatement("create table public.user (id int, email varchar(64))")) {
            drop.executeUpdate();
            create.executeUpdate();
        } catch (Exception e) {
            System.out.println("Failed to create table: " + e);
        }
    }

    public static void populateDb(UsersRepository usersRepository, List<User> testUsers) {
        for (User user : testUsers) {
            usersRepository.save(user);
        }
    }

    private static List<User> createTestUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "gosduma@gmail.com"));
        users.add(new User(2L, "super_nagibator2007@mail.ru"));
        users.add(new User(3L, "A200MP@ya.ru"));
        users.add(new User(4L, "bjhsbfhjbsdjh@hotmail.com"));
        users.add(new User(5L, "coolman12@outlook.com"));
        users.add(new User(6L, "hellome@gmail.com"));
        users.add(new User(7L, "amatilda@school21.com"));
        users.add(new User(8L, "leet_boy@hotmail.com"));
        users.add(new User(9L, "Z_stands_for_Zebra@mail.ru"));
        users.add(new User(10L, "vostok@gmail.com"));
        return users;
    }
}
