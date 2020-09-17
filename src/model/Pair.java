package model;

import java.util.Objects;

/**
 * Where条件对象
 *
 * @param <K> key
 * @param <C> 条件语句
 * @param <V> 条件值
 */
public class Pair<K, C, V> {

    private K key;
    private C condition;
    private V value;

    public Pair(K key, C condition, V value) {
        this.key = key;
        this.condition = condition;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public C getCondition() {
        return this.condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof Pair) {
            Pair<?, ?, ?> pair = (Pair<?, ?, ?>) o;
            return Objects.equals(getKey(), pair.getKey()) &&
                    Objects.equals(getValue(), pair.getValue()) &&
                    Objects.equals(getCondition(), pair.getCondition());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", condition=" + condition +
                ", value=" + value +
                '}';
    }
}