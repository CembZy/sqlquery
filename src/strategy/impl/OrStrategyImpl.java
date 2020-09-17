package strategy.impl;

import enums.OperatorEnum;
import model.Pair;
import model.User;
import strategy.SqlQueryService;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrStrategyImpl implements SqlQueryService {

    @Override
    public List<User> sqlCondidtionDeal(List<User> initData, Pair pair) {
        List<User> userList = new ArrayList<>();
        if (OperatorEnum.NOTEQ.getVal().equals(pair.getCondition())) {
            userList = initData.stream().filter(it -> {
                try {
                    Field field = it.getClass().getDeclaredField((String) pair.getKey());
                    field.setAccessible(true);
                    if (field.get(it) == pair.getValue()) {
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }).collect(Collectors.toList());
        } else if (OperatorEnum.EQ.getVal().equals(pair.getCondition())) {
            userList = initData.stream().filter(it -> {
                try {
                    Field field = it.getClass().getDeclaredField((String) pair.getKey());
                    field.setAccessible(true);
                    if (field.get(it) == pair.getValue()) {
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }).collect(Collectors.toList());
        }
        return userList;
    }
}
