package util;

import enums.LogicEnum;
import model.LinkedIdentityHashMap;
import model.Pair;
import model.QueryWrapper;
import model.User;
import strategy.SqlQueryStrategyFactory;

import java.util.*;
import java.util.stream.Collectors;

public class SqlQueryUtil {

    public static List<User> query(List<User> data, QueryWrapper queryWrapper) {
        if (null == data || data.size() == 0) {
            return null;
        }
        if (null != queryWrapper) {
            LinkedIdentityHashMap querys = queryWrapper.getQuerys();
            List<User> addList = new ArrayList<>();
            List<User> initData = new ArrayList<>(data);
            boolean falg = true;
            for (int index = 0; index < querys.size(); index++) {
                Pair pair = querys.get(index);
                String k = querys.getKey(index);
                if (LogicEnum.AND.getName().equals(k)) {
                    if (falg) {
                        addList.addAll(SqlQueryStrategyFactory.newInstance()
                                .getSqlQueryStrategy(k).sqlCondidtionDeal(data, pair));
                        falg = false;
                    } else {
                        addList = SqlQueryStrategyFactory.newInstance()
                                .getSqlQueryStrategy(k).sqlCondidtionDeal(addList, pair);
                    }
                } else if (LogicEnum.OR.getName().equals(k)) {
                    addList.addAll(SqlQueryStrategyFactory.newInstance()
                            .getSqlQueryStrategy(k).sqlCondidtionDeal(initData, pair));
                } else {
                    addList = SqlQueryStrategyFactory.newInstance()
                            .getSqlQueryStrategy(k).sqlCondidtionDeal(addList, pair);
                }
            }
            return addList.stream().distinct().collect(Collectors.toList());
        }

        return null;
    }


}
