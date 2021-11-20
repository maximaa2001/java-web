package by.bsuir.ausuikevich.service;

import by.bsuir.ausuikevich.entity.Appliance;
import by.bsuir.ausuikevich.entity.criteria.Criteria;
import by.bsuir.ausuikevich.exception.ServiceException;

import java.util.List;

public interface ApplianceService { ;
    List<Appliance> find(Criteria criteria) throws ServiceException;
}
