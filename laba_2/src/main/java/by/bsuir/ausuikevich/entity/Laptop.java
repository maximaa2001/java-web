package by.bsuir.ausuikevich.entity;

import by.bsuir.ausuikevich.entity.criteria.SearchCriteria;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(name = "laptop")
@XmlAccessorType(XmlAccessType.FIELD)
public class Laptop extends Appliance {

    public Laptop() {
        properties.put(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(), null);
        properties.put(SearchCriteria.Laptop.CPU.toString(), null);
        properties.put(SearchCriteria.Laptop.OS.toString(), null);
        properties.put(SearchCriteria.Laptop.DISPLAY_INCHES.toString(), null);
        properties.put(SearchCriteria.Laptop.MEMORY_ROM.toString(), null);
        properties.put(SearchCriteria.Laptop.SYSTEM_MEMORY.toString(), null);
    }
}
