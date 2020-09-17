package strategy.impl;

import model.Pair;
import model.User;
import strategy.SqlQueryService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByStrategyImpl implements SqlQueryService {

    @Override
    public List<User> sqlCondidtionDeal(List<User> addList, Pair pair) {
        Map<Object, List<User>> result = addList.stream().collect(Collectors.groupingBy(it -> {
            try {
                String[] keys = (String[]) pair.getKey();
                if (null != keys && keys.length > 0) {
                    for (String key : keys) {
                        Field field = it.getClass().getDeclaredField(key);
                        field.setAccessible(true);
                        if (key.equals(field.getName())) {
                            return field.get(it);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }));
        addList.clear();
        List<User> finalAddList = addList;
        result.forEach((k1, v1) -> {
            if (v1.size() > 1) {
                boolean flag = false;
                for (int i = 0; i < v1.size(); i++) {
                    for (int j = i + 1; j < v1.size(); j++) {
                        if (!v1.get(i).equals(v1.get(j))) {
                            finalAddList.add(v1.get(i));
                        } else {
                            if (!flag) {
                                finalAddList.add(v1.get(i));
                            }
                            flag = true;
                        }
                    }
                }
            } else {
                finalAddList.addAll(v1);
            }
        });
        return finalAddList;
    }
}
