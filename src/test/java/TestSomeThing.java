import com.khh.common.bean.UserRegisterBean;
import com.khh.web.domain.Person;
import com.khh.web.domain.User;
import com.khh.web.utils.BeanUtilEx;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Date;

/**
 * Created by 951087952@qq.com on 2017/5/17.
 */
public class TestSomeThing {

    public static void main(String[] args) throws Exception {
//        test1();


    }

    public static void  test1() throws Exception{
        UserRegisterBean u = new UserRegisterBean();
        u.setPhone("18927766631");
        u.setAccount("kuanghh");
        u.setBirthday(new Date());
        u.setEmail("951087952@qq.com");
        u.setName("haohua");
        u.setPassword("123456");


        Person person = (Person) BeanUtilEx.copyProperties2(new Person(), u);
        User user = (User) BeanUtilEx.copyProperties2(new User(), u);

        System.out.println(person.toString());
        System.out.println(user.toString());

        System.out.println(person.getId());
        System.out.println(user.getId());

        System.out.println(person.getAccount());
        System.out.println(user.getAccount());
    }
}
