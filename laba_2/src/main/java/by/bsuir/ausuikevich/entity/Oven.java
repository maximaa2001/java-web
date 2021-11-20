package by.bsuir.ausuikevich.entity;

import by.bsuir.ausuikevich.entity.criteria.SearchCriteria;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "oven")
public class Oven extends Appliance {

    public Oven() {
        properties.put(SearchCriteria.Oven.CAPACITY.toString(), null);
        properties.put(SearchCriteria.Oven.DEPTH.toString(), null);
        properties.put(SearchCriteria.Oven.HEIGHT.toString(), null);
        properties.put(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), null);
        properties.put(SearchCriteria.Oven.WEIGHT.toString(), null);
        properties.put(SearchCriteria.Oven.WIDTH.toString(), null);
    }

}
