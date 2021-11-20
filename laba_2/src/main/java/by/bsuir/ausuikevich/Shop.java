package by.bsuir.ausuikevich;

import by.bsuir.ausuikevich.entity.Appliance;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Shop {

    private List<Appliance> products;

    public Shop() {
        products = new ArrayList<>();
    }

    @XmlElement(name = "appliance")
    public List<Appliance> getProducts() {
        return products;
    }

    public void setProducts(List<Appliance> products) {
        this.products = products;
    }

    public void add(Appliance appliance) {
        products.add(appliance);
    }
}
