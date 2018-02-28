package icessm;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iceyyy.icessm.pojo.User;
import com.iceyyy.icessm.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-mybatis.xml" })
public class UserSpringTest {
    @Autowired
    private UserService userService;

    // @Test
    public void add() {
        User user = new User();
        // user.setId(1002);
        user.setUsername("李四");
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
