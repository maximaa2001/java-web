package by.bsuir.ausuikevich.dao.impl;

import by.bsuir.ausuikevich.dao.ApplianceDao;
import by.bsuir.ausuikevich.entity.Appliance;
import by.bsuir.ausuikevich.entity.criteria.Criteria;
import by.bsuir.ausuikevich.entity.criteria.SearchCriteria;
import by.bsuir.ausuikevich.exception.DaoException;
import by.bsuir.ausuikevich.parser.JAXBSerializer;

import javax.xml.xpath.XPathExpressionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplianceDaoImpl implements ApplianceDao {
    private static final String START_BY_PARAM = "/shop/appliance[@xsi:type='CLASS'][properties/entry[key='KEY' and value='VALUE'] ";
    private static final String ADD_CONDITION = " and properties/entry[key='KEY' and value='VALUE']";
    private static final String END_BY_PARAM = "]";
    private static final String COUNT_ALL_PRODUCT = "count(/shop/appliance)";
    private static final String GET_PRODUCT_BY_ID = "/shop/appliance[ID]";
    private static final String GET_PRODUCT_BY_CLASS = "/shop/appliance[@xsi:type='CLASS']";
    private JAXBSerializer serializer;

    public ApplianceDaoImpl(JAXBSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public List<Appliance> find(Criteria criteria) throws DaoException {
        List<Appliance> appliances = new ArrayList<>();
        try {
            String request = "";
            if (criteria.getCriteria().size() == 0) {
                if (criteria.getName().equals(SearchCriteria.Appliance.class.getName())) {
                    return getCheapestProduct();
                } else {
                    return findConcreteProduct(Class.forName(criteria.getName()));
                }
            } else {
                request = formParserRequestByPram(criteria, Class.forName(criteria.getName()));
            }
            appliances = serializer.deserialize(request, Appliance.class);
        } catch (ClassNotFoundException | XPathExpressionException e) {
            throw new DaoException(e);
        }
        return appliances;
    }

    public List<Appliance> findConcreteProduct(Class<?> clazz) throws XPathExpressionException {
        String requestCount = GET_PRODUCT_BY_CLASS.replace("CLASS", clazz.getSimpleName().toLowerCase());
        return serializer.deserialize(requestCount, Appliance.class);
    }

    private List<Appliance> getCheapestProduct() throws XPathExpressionException {
        int count = (int) serializer.getCountProduct(COUNT_ALL_PRODUCT);
        Appliance appliance = null;
        int maxCount = Integer.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            String request = GET_PRODUCT_BY_ID.replace("ID", String.valueOf(i + 1));
            List<Appliance> listProd = serializer.deserialize(request, Appliance.class);
            if (listProd.get(0).getProperties().get(SearchCriteria.Appliance.PRICE.toString()) != null
                    && (int) (listProd.get(0).getProperties().get(SearchCriteria.Appliance.PRICE.toString())) <= maxCount) {
                appliance = listProd.get(0);
                maxCount = (int) listProd.get(0).getProperties().get(SearchCriteria.Appliance.PRICE.toString());
            }
        }
        List<Appliance> appliances = new ArrayList<>();
        appliances.add(appliance);
        return appliances;
    }


    private String formParserRequestByPram(Criteria criteria, Class<?> clazz) {
        List<Map.Entry<String, Object>> collect = new ArrayList<>(criteria.getCriteria().entrySet());
        StringBuilder request = new StringBuilder();
        for (int i = 0; i < collect.size(); i++) {
            if (i == 0) {
                String clazzStr = START_BY_PARAM.replaceAll("CLASS",clazz.getSimpleName().toLowerCase());
                String key = clazzStr.replaceAll("KEY", collect.get(i).getKey());
                String keyAndValue = key.replaceAll("VALUE", collect.get(i).getValue().toString());
                request.append(keyAndValue);
            }
            if (i > 0 && i <= collect.size() - 1) {
                String key = ADD_CONDITION.replaceAll("KEY", collect.get(i).getKey());
                String keyAndValue = key.replaceAll("VALUE", collect.get(i).getValue().toString());
                request.append(keyAndValue);
            }
            if (i == collect.size() - 1) {
                request.append(END_BY_PARAM);
            }
        }
        return request.toString();
    }
}
