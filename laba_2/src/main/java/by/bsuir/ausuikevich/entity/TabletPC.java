package by.bsuir.ausuikevich.entity;

import by.bsuir.ausuikevich.entity.criteria.SearchCriteria;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TabletPC extends Appliance{

    public TabletPC(){
        properties.put(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString(), null);
        properties.put(SearchCriteria.TabletPC.MEMORY_ROM.toString(), null);
        properties.put(SearchCriteria.TabletPC.COLOR.toString(), null);
        properties.put(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), null);
        properties.put(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString(), null);
    }
}
