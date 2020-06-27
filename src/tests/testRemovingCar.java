package tests;

import org.junit.jupiter.api.Test;
import step3.Car;
import step3.Dealership;
import step3.Make;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testRemovingCar {
    @Test

    void testWithRemovingCars() throws Exception {
        Dealership dealership = new Dealership();

        Make make1 = new Make("Ford");

        dealership.addMake(make1);

        Car car1 = new Car("NA90 LJK","Fiesta","Red");
        Car car2 = new Car("AW10 LKJ","Focus","Blue");

        make1.addCar(car1);
        make1.addCar(car2);

        make1.removeCar("NA90 LJK");

        boolean expectedResult = false;
        boolean actualResult = dealership.getCarByRegNo("NA90 LJK");

        assertEquals(expectedResult,actualResult);


    }
}
