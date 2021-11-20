package by.bsuir.ausuikevich.service.validation;

import by.bsuir.ausuikevich.entity.criteria.Criteria;
import by.bsuir.ausuikevich.entity.criteria.SearchCriteria;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Validator {

    public static boolean criteriaValidator(Criteria criteria) {
        deleteNullValue(criteria);
        try {
            if (!removeWrongKeys(criteria)) {
                return false;
            }
            if (criteria.getCriteria().containsKey(SearchCriteria.Appliance.PRICE.toString())) {
                checkIntPrice(criteria);
            }
        } catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    }

    private static void deleteNullValue(Criteria criteria) {
        Map<String, Object> props = criteria.getCriteria();
        Map<String, Object> copy = new HashMap<>(props);
        for (Map.Entry<String, Object> next : copy.entrySet()) {
            if (next.getValue() == null) {
                props.remove(next.getKey());
            }
        }
    }

    private static boolean removeWrongKeys(Criteria criteria) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(criteria.getName());
        Field[] fields = aClass.getFields();
        SearchCriteria.Appliance[] commonFields = SearchCriteria.Appliance.values();
        Map<String, Object> copy = new HashMap<>(criteria.getCriteria());
        for (Map.Entry<String, Object> next : copy.entrySet()) {
            boolean isExist = false;
            for (int i = 0; i < fields.length; i++) {
                if (next.getKey().equals(fields[i].getName())) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                for (int i = 0; i < commonFields.length; i++) {
                    if (next.getKey().equals(commonFields[i].name())) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkIntPrice(Criteria criteria) {
        try {
            Integer.parseInt((String) criteria.getCriteria().get(SearchCriteria.Appliance.PRICE.toString()));
        } catch (ClassCastException e) {
            return false;
        }
        return true;
    }
}
