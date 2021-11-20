package by.bsuir.ausuikevich.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {
    private String name;
    private Map<String, Object> criteria;

    public Criteria(String name) {
        this.name = name;
        criteria = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setCriteria(Map<String, Object> criteria) {
        this.criteria = criteria;
    }

    public Map<String, Object> getCriteria() {
        return criteria;
    }

    public void add(String key, Object value) {
        criteria.put(key, value);
    }
}
