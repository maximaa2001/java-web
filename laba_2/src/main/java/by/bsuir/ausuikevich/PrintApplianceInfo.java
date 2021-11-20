package by.bsuir.ausuikevich;

import by.bsuir.ausuikevich.entity.Appliance;

import java.util.List;
import java.util.Map;

public class PrintApplianceInfo {

    public static void print(Appliance appliance) {
        Map<String, Object> properties = appliance.getProperties();
        for (Map.Entry<String, Object> next : properties.entrySet()) {
            System.out.println(next.getKey() + " -> " + next.getValue());
        }
        System.out.println();
    }

    public static void print(List<Appliance> appliances) {
        for (int i = 0; i < appliances.size(); i++) {
            print(appliances.get(i));
        }
    }
}
