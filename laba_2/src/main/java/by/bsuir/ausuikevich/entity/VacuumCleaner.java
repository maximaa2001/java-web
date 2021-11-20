package by.bsuir.ausuikevich.entity;

import by.bsuir.ausuikevich.entity.criteria.SearchCriteria;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VacuumCleaner extends Appliance{

    public VacuumCleaner(){
        properties.put(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString(), null);
        properties.put(SearchCriteria.VacuumCleaner.BAG_TYPE.toString(), null);
        properties.put(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString(), null);
        properties.put(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString(), null);
        properties.put(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString(), null);
        properties.put(SearchCriteria.VacuumCleaner.WAND_TYPE.toString(), null);

    }
}
