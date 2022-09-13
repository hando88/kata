package web.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

public class Car {

    private String brand;

    private String model;

    private double engine;

    public Car(String brand, String model, double engine) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Auto: " +
                "brand = " + brand +
                ", model = " + model +
                ", engine = " + engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (engine != car.engine) return false;
        if (!Objects.equals(brand, car.brand)) return false;
        return Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        temp = Double.doubleToLongBits(engine);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
