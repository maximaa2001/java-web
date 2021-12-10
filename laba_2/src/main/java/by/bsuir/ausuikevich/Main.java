package by.bsuir.ausuikevich;

import by.bsuir.ausuikevich.dao.impl.ApplianceDaoImpl;
import by.bsuir.ausuikevich.entity.*;
import by.bsuir.ausuikevich.entity.criteria.Criteria;
import by.bsuir.ausuikevich.entity.criteria.SearchCriteria;
import by.bsuir.ausuikevich.exception.ServiceException;
import by.bsuir.ausuikevich.parser.JAXBSerializer;
import by.bsuir.ausuikevich.service.ApplianceService;
import by.bsuir.ausuikevich.service.impl.ApplianceServiceImpl;

import javax.xml.bind.JAXBException;
import java.io.IOException;

;

public class Main {
    public static void main(String[] args) throws ServiceException, ClassNotFoundException, JAXBException, IOException {
      //    initShop();
        ApplianceService service = new ApplianceServiceImpl(new ApplianceDaoImpl(new JAXBSerializer("file.xml")));


        Criteria criteriaLaptop = new Criteria(SearchCriteria.Laptop.class.getName());//  Laptop with MEMORY_ROM = 8000
        criteriaLaptop.add(SearchCriteria.Laptop.MEMORY_ROM.toString(), 8000);
       // PrintApplianceInfo.print(service.find(criteriaLaptop));


        criteriaLaptop.add(SearchCriteria.Laptop.OS.toString(), "Windows");// Laptop with MEMORY_ROM = 8000 and OS = Windows
      //  PrintApplianceInfo.print(service.find(criteriaLaptop));

        Criteria criteriaSpeakers = new Criteria(SearchCriteria.Speakers.class.getName());
        criteriaSpeakers.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(), 3);// Speakers with NUMBER_OF_SPEAKERS = 3 and
        criteriaSpeakers.add(SearchCriteria.Speakers.CORD_LENGTH.toString(), 3);// CORD_LENGTH = 3 and CORD_LENGTH=1000
        criteriaSpeakers.add(SearchCriteria.Appliance.PRICE.toString(), 1000);
      //  PrintApplianceInfo.print(service.find(criteriaSpeakers));

        Criteria allRefrigerators = new Criteria(SearchCriteria.Refrigerator.class.getName()); // All Refrigerators
      //  PrintApplianceInfo.print(service.find(allRefrigerators));

        Criteria cheapestProduct = new Criteria(SearchCriteria.Appliance.class.getName()); // Cheapest product
      //  PrintApplianceInfo.print(service.find(cheapestProduct));

    }

    public static void initShop() throws JAXBException, IOException {
        Laptop laptopOne = new Laptop();
        laptopOne.add(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(), 1);
        laptopOne.add(SearchCriteria.Laptop.OS.toString(), "Windows");
        laptopOne.add(SearchCriteria.Laptop.MEMORY_ROM.toString(), 4000);
        laptopOne.add(SearchCriteria.Laptop.SYSTEM_MEMORY.toString(), 1000);
        laptopOne.add(SearchCriteria.Laptop.CPU.toString(), 1.2);
        laptopOne.add(SearchCriteria.Laptop.DISPLAY_INCHES.toString(), 18);
        laptopOne.add(SearchCriteria.Appliance.PRICE.toString(), 5000);


        Laptop laptopTwo = new Laptop();
        laptopTwo.add(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(), 1.5);
        laptopTwo.add(SearchCriteria.Laptop.OS.toString(), "Linux");
        laptopTwo.add(SearchCriteria.Laptop.MEMORY_ROM.toString(), 8000);
        laptopTwo.add(SearchCriteria.Laptop.SYSTEM_MEMORY.toString(), 1000);
        laptopTwo.add(SearchCriteria.Laptop.CPU.toString(), 2.2);
        laptopTwo.add(SearchCriteria.Laptop.DISPLAY_INCHES.toString(), 19);
        laptopTwo.add(SearchCriteria.Appliance.PRICE.toString(), 8000);


        Laptop laptopThree = new Laptop();
        laptopThree.add(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(), 3);
        laptopThree.add(SearchCriteria.Laptop.OS.toString(), "Windows");
        laptopThree.add(SearchCriteria.Laptop.MEMORY_ROM.toString(), 8000);
        laptopThree.add(SearchCriteria.Laptop.SYSTEM_MEMORY.toString(), 1500);
        laptopThree.add(SearchCriteria.Laptop.CPU.toString(), 3.2);
        laptopThree.add(SearchCriteria.Laptop.DISPLAY_INCHES.toString(), 22);
        laptopThree.add(SearchCriteria.Appliance.PRICE.toString(), 3000);


        Oven ovenOne = new Oven();
        ovenOne.add(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), 1000);
        ovenOne.add(SearchCriteria.Oven.WEIGHT.toString(), 10);
        ovenOne.add(SearchCriteria.Oven.CAPACITY.toString(), 32);
        ovenOne.add(SearchCriteria.Oven.DEPTH.toString(), 60);
        ovenOne.add(SearchCriteria.Oven.HEIGHT.toString(), 45.5);
        ovenOne.add(SearchCriteria.Oven.WIDTH.toString(), 59.5);
        ovenOne.add(SearchCriteria.Appliance.PRICE.toString(), 8000);


        Oven ovenTwo = new Oven();
        ovenTwo.add(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), 1500);
        ovenTwo.add(SearchCriteria.Oven.WEIGHT.toString(), 12);
        ovenTwo.add(SearchCriteria.Oven.CAPACITY.toString(), 33);
        ovenTwo.add(SearchCriteria.Oven.DEPTH.toString(), 60);
        ovenTwo.add(SearchCriteria.Oven.HEIGHT.toString(), 45);
        ovenTwo.add(SearchCriteria.Oven.WIDTH.toString(), 68);
        ovenTwo.add(SearchCriteria.Appliance.PRICE.toString(), 1500);


        Oven ovenThree = new Oven();
        ovenThree.add(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), 2000);
        ovenThree.add(SearchCriteria.Oven.WEIGHT.toString(), 11);
        ovenThree.add(SearchCriteria.Oven.CAPACITY.toString(), 33);
        ovenThree.add(SearchCriteria.Oven.DEPTH.toString(), 60);
        ovenThree.add(SearchCriteria.Oven.HEIGHT.toString(), 40);
        ovenThree.add(SearchCriteria.Oven.WIDTH.toString(), 70);
        ovenThree.add(SearchCriteria.Appliance.PRICE.toString(), 1200);

        Refrigerator refrigeratorOne = new Refrigerator();
        refrigeratorOne.add(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), 100);
        refrigeratorOne.add(SearchCriteria.Refrigerator.WEIGHT.toString(), 20);
        refrigeratorOne.add(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), 10);
        refrigeratorOne.add(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(), 300);
        refrigeratorOne.add(SearchCriteria.Refrigerator.HEIGHT.toString(), 200);
        refrigeratorOne.add(SearchCriteria.Refrigerator.WIDTH.toString(), 70);
        refrigeratorOne.add(SearchCriteria.Appliance.PRICE.toString(), 4500);


        Refrigerator refrigeratorTwo = new Refrigerator();
        refrigeratorTwo.add(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), 200);
        refrigeratorTwo.add(SearchCriteria.Refrigerator.WEIGHT.toString(), 30);
        refrigeratorTwo.add(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), 15);
        refrigeratorTwo.add(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(), 300);
        refrigeratorTwo.add(SearchCriteria.Refrigerator.HEIGHT.toString(), 180);
        refrigeratorTwo.add(SearchCriteria.Refrigerator.WIDTH.toString(), 80);
        refrigeratorTwo.add(SearchCriteria.Appliance.PRICE.toString(), 6000);


        VacuumCleaner vacuumCleanerOne = new VacuumCleaner();
        vacuumCleanerOne.add(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString(), 100);
        vacuumCleanerOne.add(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString(), "A");
        vacuumCleanerOne.add(SearchCriteria.VacuumCleaner.BAG_TYPE.toString(), "A2");
        vacuumCleanerOne.add(SearchCriteria.VacuumCleaner.WAND_TYPE.toString(), "all-in-one");
        vacuumCleanerOne.add(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString(), 3000);
        vacuumCleanerOne.add(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString(), 20);
        vacuumCleanerOne.add(SearchCriteria.Appliance.PRICE.toString(), 7000);

        VacuumCleaner vacuumCleanerTwo = new VacuumCleaner();
        vacuumCleanerTwo.add(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString(), 110);
        vacuumCleanerTwo.add(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString(), "B");
        vacuumCleanerTwo.add(SearchCriteria.VacuumCleaner.BAG_TYPE.toString(), "AA-89");
        vacuumCleanerTwo.add(SearchCriteria.VacuumCleaner.WAND_TYPE.toString(), "all-in-one");
        vacuumCleanerTwo.add(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString(), 2900);
        vacuumCleanerTwo.add(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString(), 25);
        vacuumCleanerTwo.add(SearchCriteria.Appliance.PRICE.toString(), 7500);


        TabletPC tabletPCOne = new TabletPC();
        tabletPCOne.add(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString(), 3);
        tabletPCOne.add(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), 14);
        tabletPCOne.add(SearchCriteria.TabletPC.MEMORY_ROM.toString(), 8000);
        tabletPCOne.add(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString(), 2);
        tabletPCOne.add(SearchCriteria.TabletPC.COLOR.toString(), "blue");
        tabletPCOne.add(SearchCriteria.Appliance.PRICE.toString(), 1000);

        TabletPC tabletPCTwo = new TabletPC();
        tabletPCTwo.add(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString(), 4);
        tabletPCTwo.add(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), 15);
        tabletPCTwo.add(SearchCriteria.TabletPC.MEMORY_ROM.toString(), 8000);
        tabletPCTwo.add(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString(), 6);
        tabletPCTwo.add(SearchCriteria.TabletPC.COLOR.toString(), "red");
        tabletPCTwo.add(SearchCriteria.Appliance.PRICE.toString(), 800);


        Speakers speakersOne = new Speakers();
        speakersOne.add(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(), 15);
        speakersOne.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(), 2);
        speakersOne.add(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), "2-4");
        speakersOne.add(SearchCriteria.Speakers.CORD_LENGTH.toString(), 2);
        speakersOne.add(SearchCriteria.Appliance.PRICE.toString(), 500);


        Speakers speakersTwo = new Speakers();
        speakersTwo.add(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(), 20);
        speakersTwo.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(), 3);
        speakersTwo.add(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), "3-4");
        speakersTwo.add(SearchCriteria.Speakers.CORD_LENGTH.toString(), 3);
        speakersTwo.add(SearchCriteria.Appliance.PRICE.toString(), 1000);

        Shop shop = new Shop();
        shop.add(laptopOne);
        shop.add(laptopTwo);
        shop.add(laptopThree);
        shop.add(speakersOne);
        shop.add(speakersTwo);
        shop.add(ovenOne);
        shop.add(ovenTwo);
        shop.add(ovenThree);
        shop.add(refrigeratorOne);
        shop.add(refrigeratorTwo);
        shop.add(vacuumCleanerOne);
        shop.add(vacuumCleanerTwo);
        shop.add(tabletPCOne);
        shop.add(tabletPCTwo);

        JAXBSerializer jaxbSerializer = new JAXBSerializer("file.xml");
        jaxbSerializer.serialize(Shop.class, shop);
    }
}
