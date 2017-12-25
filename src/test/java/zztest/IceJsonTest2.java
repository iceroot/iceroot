package zztest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.icexxx.util.IceJsonUtil;

public class IceJsonTest2 {

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
        Product product = new Product();
        product.setName("素材");
        product.setCount(33);
        Map<String, String> table = new HashMap<String, String>();
        table.put("aaa", "bbb");
        table.put("eee", "fff");
        table.put("ggg", "hhh");
        product.setTable(table);
        user.setProduct(product);
        String json = null;
        json = IceJsonUtil.format(user);
        System.out.println(json);
    }

}
