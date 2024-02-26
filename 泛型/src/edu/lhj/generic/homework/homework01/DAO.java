package edu.lhj.generic.homework.homework01;

import java.util.*;

@SuppressWarnings({"all"})
public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return (T) map.get(id);
    }

    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }else {
            System.out.println("你输入的id不存在");
        }
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();
        Set<String> keySet = map.keySet();
        for (String id : keySet) {
            list.add(map.get(id));
        }
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }
}
