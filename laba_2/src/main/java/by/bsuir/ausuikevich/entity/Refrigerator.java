package by.bsuir.ausuikevich.entity;

import by.bsuir.ausuikevich.entity.criteria.SearchCriteria;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Refrigerator extends Appliance {

    public Refrigerator() {
        properties.put(SearchCriteria.Refrigerator.HEIGHT.toString(), null);
        properties.put(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), null);
        properties.put(SearchCriteria.Refrigerator.WEIGHT.toString(), null);
        properties.put(SearchCriteria.Refrigerator.WIDTH.toString(), null);
        properties.put(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), null);
        properties.put(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(), null);
    }
}
