package strategy.impl;

import model.Pair;
import model.User;
import strategy.SqlQueryService;

import java.util.ArrayList;
import java.util.List;

public class LimitStrategyImpl implements SqlQueryService {

    @Override
    public List<User> sqlCondidtionDeal(List<User> addList, Pair pair) {
        List<User> userList = new ArrayList<>();
        Integer start = (Integer) pair.getKey();
        Integer limit = (Integer) pair.getValue();
        if (null != limit) {
            if (limit > addList.size()) {
                limit = addList.size();
            }
            if (null != start) {
                userList = addList.subList(start, limit);
            } else {
                userList = addList.subList(0, limit);
            }
        }
        return userList;
    }
}
