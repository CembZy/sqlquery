package strategy.impl;

import enums.OperatorEnum;
import model.Pair;
import model.User;
import strategy.SqlQueryService;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderByStrategyImpl implements SqlQueryService {

    @Override
    public List<User> sqlCondidtionDeal(List<User> addList, Pair pair) {
        List<User> userList = new ArrayList<>();
        if (OperatorEnum.DESC.getName().equals(pair.getCondition())) {
            userList = addList.stream().sorted(Comparator.comparing((User it) -> {
                try {
                    String[] keys = (String[]) pair.getKey();
                    if (null != keys && keys.length > 0) {
                        for (String key : keys) {
                            Field field = it.getClass().getDeclaredField(key);
                            field.setAccessible(true);
                            if (key.equals(field.getName())) {
                                return (Integer) field.get(it);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }).reversed()).collect(Collectors.toList());
        } else if (OperatorEnum.ACS.getName().equals(pair.getCondition())) {
            userList = addList.stream().sorted(Comparator.comparing((User it) -> {
                try {
                    String[] keys = (String[]) pair.getKey();
                    if (null != keys && keys.length > 0) {
                        for (String key : keys) {
                            Field field = it.getClass().getDeclaredField(key);
                            field.setAccessible(true);
                            if (key.equals(field.getName())) {
                                return (Integer) field.get(it);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            })).collect(Collectors.toList());
        }
        return userList;
    }
}
