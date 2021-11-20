package by.bsuir.ausuikevich.dao;

import by.bsuir.ausuikevich.entity.Appliance;
import by.bsuir.ausuikevich.entity.criteria.Criteria;
import by.bsuir.ausuikevich.exception.DaoException;

import java.util.List;

public interface ApplianceDao {
    List<Appliance> find(Criteria criteria) throws DaoException;
}
