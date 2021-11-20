package by.bsuir.ausuikevich.entity;

import by.bsuir.ausuikevich.entity.criteria.SearchCriteria;

import javax.xml.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Laptop.class, Oven.class, Refrigerator.class, Speakers.class, TabletPC.class, VacuumCleaner.class})
public class Appliance {
    private static long generate = 0;
    private long id;
    protected Map<String, Object> properties;

    public Appliance() {
        id = ++generate;
        properties = new HashMap<>();
        properties.put(SearchCriteria.Appliance.PRICE.toString(), null);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<String, Object> getProperties() {
        return new HashMap<>(properties);
    }

    public void add(String key, Object value) {
        Optional<String> any = properties.keySet().stream()
                .filter(el -> el.equals(key))
                .findAny();
        if (any.isPresent()) {
            properties.put(key, value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appliance appliance = (Appliance) o;
        return id == appliance.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "id=" + id +
                '}';
    }
}
