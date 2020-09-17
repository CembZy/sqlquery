package strategy;

import model.Pair;
import model.User;

import java.util.List;

public interface SqlQueryService {

    List<User> sqlCondidtionDeal(List<User> data, Pair pair);

}
