package by.bsuir.ausuikevich.service.impl;

import by.bsuir.ausuikevich.dao.ApplianceDao;
import by.bsuir.ausuikevich.dao.impl.ApplianceDaoImpl;
import by.bsuir.ausuikevich.entity.Appliance;
import by.bsuir.ausuikevich.entity.criteria.Criteria;
import by.bsuir.ausuikevich.exception.DaoException;
import by.bsuir.ausuikevich.exception.ServiceException;
import by.bsuir.ausuikevich.service.ApplianceService;
import by.bsuir.ausuikevich.service.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {
    private ApplianceDao applianceDao;

    public ApplianceServiceImpl(ApplianceDaoImpl applianceDao) {
        this.applianceDao = applianceDao;
    }

    @Override
    public List<Appliance> find(Criteria criteria) throws ServiceException {
        List<Appliance> appliances = new ArrayList<>();
        try {
            if (Validator.criteriaValidator(criteria)) {
                appliances = applianceDao.find(criteria);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return appliances;
    }
}
