package web.service;

import org.springframework.stereotype.Service;
import web.DAO.CarDAO;
import web.DAO.CarDAOImpl;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    CarDAO carDAO = new CarDAOImpl();

    @Override
    public List<?> getCar(int id) {
        return carDAO.getCar(id);
    }
}
