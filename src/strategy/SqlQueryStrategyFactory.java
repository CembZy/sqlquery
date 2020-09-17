package strategy;

import enums.ConiditionEnum;
import enums.LogicEnum;
import strategy.impl.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SqlQueryStrategyFactory {

    private static final Map<String, SqlQueryService> strategyMap = new ConcurrentHashMap<>();

    static {
        strategyMap.put(LogicEnum.AND.getName(), new AddStrategyImpl());
        strategyMap.put(LogicEnum.OR.getName(), new OrStrategyImpl());
        strategyMap.put(ConiditionEnum.GROUPBY.getName(), new GroupByStrategyImpl());
        strategyMap.put(ConiditionEnum.ORDERBY.getName(), new OrderByStrategyImpl());
        strategyMap.put(ConiditionEnum.LIMIT.getName(), new LimitStrategyImpl());
    }

    private SqlQueryStrategyFactory() {
    }

    public static SqlQueryStrategyFactory newInstance() {
        return LazyHolder.factory;
    }

    public SqlQueryService getSqlQueryStrategy(String type) {
        return strategyMap.get(type);
    }

    private static class LazyHolder {
        private final static SqlQueryStrategyFactory factory = new SqlQueryStrategyFactory();
    }
}