package zztest;

import java.util.Date;

import com.icexxx.util.IceJsonUtil;

public class IceJsonTest {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("zs");
        user.setPassword("pass");
        user.setAge(18L);
        user.setBirthday(new Date());
        user.setPrice(3.14159265358);
        user.setCars(15);
        user.setEmpty(null);
        user.setSex(true);
        user.setCars(23);
        String json = null;
        json = IceJsonUtil.format(user);
        System.out.println(json);
    }

}
