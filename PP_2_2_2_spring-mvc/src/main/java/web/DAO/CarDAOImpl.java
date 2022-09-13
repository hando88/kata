package web.DAO;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAOImpl implements CarDAO {
    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Audi", "A6", 2.5));
        cars.add(new Car("Volvo", "XC90", 3.0));
        cars.add(new Car("Ford", "Mondeo", 1.6));
        cars.add(new Car("BMW", "G30", 3.0));
        cars.add(new Car("Mercedes", "GLE", 5.0));
    }

    @Override
    public List<Car> getCar(int id) {
        if (id > cars.size()) {
            return cars;
        }
        return cars.stream().limit(id).collect(Collectors.toList());
    }
}
