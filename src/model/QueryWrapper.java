package model;

import enums.OperatorEnum;
import enums.LogicEnum;
import enums.ConiditionEnum;

import java.util.*;

/**
 * 条件构造
 */
public class QueryWrapper {

    private LinkedIdentityHashMap querys;

    private List<String> orderQuerys;

    private String logic;

    private QueryWrapper(LinkedIdentityHashMap querysMap) {
        this.orderQuerys = new ArrayList<>();
        this.querys = querysMap;
    }

    public static QueryWrapper bulid() {
        return new QueryWrapper(new LinkedIdentityHashMap());
    }

    public QueryWrapper and() {
        this.logic = new String(LogicEnum.AND.getName());
        return this;
    }

    public QueryWrapper or() {
        this.logic = new String(LogicEnum.OR.getName());
        return this;
    }

    public QueryWrapper eq(String column, Object val) {
        put(null == this.logic ? new String(LogicEnum.AND.getName()) : this.logic, new Pair<>(column, OperatorEnum.EQ.getVal(), val));
        return this;
    }

    public QueryWrapper notEq(String column, Object val) {
        put(null == this.logic ? new String(LogicEnum.AND.getName()) : this.logic, new Pair<>(column, OperatorEnum.NOTEQ.getVal(), val));
        return this;
    }

    public QueryWrapper groupBy(String... column) {
        put(new String(ConiditionEnum.GROUPBY.getName()), new Pair<>(column, null, null));
        return this;
    }

    public QueryWrapper orderByDesc(String... column) {
        put(new String(ConiditionEnum.ORDERBY.getName()), new Pair<>(column, OperatorEnum.DESC.getVal(), null));
        return this;
    }

    public QueryWrapper orderByAsc(String... column) {
        put(new String(ConiditionEnum.ORDERBY.getName()), new Pair<>(column, OperatorEnum.ACS.getVal(), null));
        return this;
    }

    public QueryWrapper limit(Integer start, Integer limit) {
        put(new String(ConiditionEnum.LIMIT.getName()), new Pair<>(start, OperatorEnum.LIMIT.getVal(), limit));
        return this;
    }

    public QueryWrapper limit(Integer limit) {
        put(new String(ConiditionEnum.LIMIT.getName()), new Pair<>(null, OperatorEnum.LIMIT.getVal(), limit));
        return this;
    }

    private void put(String key, Pair pair) {
        String newKey = new String(key);
        querys.put(newKey, pair);
        this.logic = newKey;
    }

    public LinkedIdentityHashMap getQuerys() {
        return querys;
    }

    public List<String> getOrderQuerys() {
        return orderQuerys;
    }
}
