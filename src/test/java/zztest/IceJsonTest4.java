package zztest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icexxx.util.IceJsonUtil;

public class IceJsonTest4 {

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
        Product product1 = new Product();
        product1.setName("素材");
        product1.setCount(33);
        Product product2 = new Product();
        product2.setName("测试");
        product2.setCount(55);
        List<Product> listProduct = new ArrayList<Product>();
        listProduct.add(product1);
        listProduct.add(product2);
        user.setList2(listProduct);
        List<String> listStr = new ArrayList<String>();
        listStr.add("zzz");
        listStr.add("rrr");
        listStr.add("ttt");
        listStr.add("yyy");
        user.setList1(listStr);
        String json = null;
        json = IceJsonUtil.format(listStr);
        System.out.println(json);
    }

}
