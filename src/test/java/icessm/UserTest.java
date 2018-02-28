package icessm;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iceyyy.icessm.pojo.User;
import com.iceyyy.icessm.service.UserService;

public class UserTest {
    private UserService userService;

    @Before
    public void before() {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml", "spring-mybatis.xml" });
        userService = (UserService) ac.getBean("userService");
    }

    @After
    public void after() {

    }

    // @Test
    public void add() {
        User user = new User();
        // user.setId(1001);
        user.setUsername("张三");
        user.setPassword("123456");
        user.setBirthday(new Date());
        user.setSalary(new BigDecimal("9999"));
        user.setLogincount(0);
        user.setPraise(987654321L);
        user.setAccount(12345.67);
        user.setStatus("LOGIN");
        userService.add(user);
    }

    @Test
    public void test() {

    }
}
