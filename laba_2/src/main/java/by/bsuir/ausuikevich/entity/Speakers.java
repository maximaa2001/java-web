package by.bsuir.ausuikevich.entity;

import by.bsuir.ausuikevich.entity.criteria.SearchCriteria;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Speakers extends Appliance {

    public Speakers() {
        properties.put(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(), null);
        properties.put(SearchCriteria.Speakers.CORD_LENGTH.toString(), null);
        properties.put(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), null);
        properties.put(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(), null);
    }
}
