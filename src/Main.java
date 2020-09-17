import model.QueryWrapper;
import model.User;
import util.SqlQueryUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<User> data = new ArrayList<>();

    static {
        data.add(new User("1", "zhangsan1", 22, 1));
        data.add(new User("1", "zhangsan1", 22, 1));
        data.add(new User("1", "zhangsan1", 22, 1));
        data.add(new User("3", "zhangsan3", 14, 3));
        data.add(new User("4", "zhangsan4", 15, 4));
        data.add(new User("5", "zhangsan5", 16, 5));
    }

    public static void main(String[] args) {
        int i = 4;
        int sum = 0;
        if (test1()) {
            sum++;
        }
        if (test2()) {
            sum++;
        }
        if (test3()) {
            sum++;
        }
        if (test4()) {
            sum++;
        }
        System.out.println("测试总次数：" + i);
        System.out.println("通过次数:" + sum);
    }

    public static boolean test1() {
        QueryWrapper queryWrapper = QueryWrapper.bulid()
                .eq("id", "1")
                .or()
                .eq("age", 14)
                .groupBy("id")
                .orderByAsc("age")
                .limit(5);
        List<User> query = SqlQueryUtil.query(data, queryWrapper);
        query.forEach(it -> {
            System.out.println("测试1结果：" + it.toString());
        });
        return query.size() == 2 ? true : false;
    }

    public static boolean test2() {
        QueryWrapper queryWrapper = QueryWrapper.bulid()
                .eq("id", "1")
                .and()
                .eq("age", 14)
                .orderByAsc("age")
                .limit(2);
        List<User> query = SqlQueryUtil.query(data, queryWrapper);
        query.forEach(it -> {
            System.out.println("测试2结果：" + it.toString());
        });
        return query.size() == 0 ? true : false;
    }

    public static boolean test3() {
        QueryWrapper queryWrapper = QueryWrapper.bulid()
                .eq("id", "1")
                .and()
                .eq("age", 22)
                .limit(5);
        List<User> query = SqlQueryUtil.query(data, queryWrapper);
        query.forEach(it -> {
            System.out.println("测试3结果：" + it.toString());
        });
        return query.size() == 3 ? true : false;
    }


    public static boolean test4() {
        QueryWrapper queryWrapper = QueryWrapper.bulid()
                .eq("id", "1")
                .or()
                .eq("age", 22)
                .limit(2);
        List<User> query = SqlQueryUtil.query(data, queryWrapper);
        query.forEach(it -> {
            System.out.println("测试4结果：" + it.toString());
        });
        return query.size() == 2 ? true : false;
    }
}
