package model;


import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;


/**
 * 构造有序的IdentityHashMap
 */
public class LinkedIdentityHashMap {

    private Map identityHashMap;

    private List<String> orderKey;

    public LinkedIdentityHashMap() {
        this.identityHashMap = new IdentityHashMap();
        this.orderKey = new ArrayList<>();
    }

    public void put(String key, Pair value) {
        this.identityHashMap.put(new String(key), value);
        this.orderKey.add(key + "&" + value.toString());
    }

    public int size() {
        return this.identityHashMap.size();
    }

    public String getKey(int index) {
        String v = this.orderKey.get(index);
        String[] keyAndValue = v.split("&");
        return keyAndValue[0];
    }

    public Pair get(int index) {
        String v = this.orderKey.get(index);
        String[] keyAndValue = v.split("&");
        String key = keyAndValue[0];
        String defaultValue = keyAndValue[1];
        AtomicReference<Pair> pair = new AtomicReference<>();
        this.identityHashMap.forEach((k, v1) -> {
            if (key.equals(k) && defaultValue.equals(v1.toString())) {
                pair.set((Pair) v1);
            }
        });
        return pair.get();
    }

//    public static void main(String[] args) {
//        LinkedIdentityHashMap linkedIdentityHashMap = new LinkedIdentityHashMap();
//        linkedIdentityHashMap.put("1", 1);
//        linkedIdentityHashMap.put("1", 2);
//        linkedIdentityHashMap.put("1", 3);
//
//        for (int i = 0; i < linkedIdentityHashMap.size(); i++) {
//            System.out.println(linkedIdentityHashMap.get(i));
//        }
//    }

}
