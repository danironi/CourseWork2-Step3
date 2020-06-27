package tests;

import org.junit.jupiter.api.Test;
import step3.Car;
import step3.Dealership;
import step3.Make;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testAddingCars {
    @Test

    void testWithAddingCars() throws Exception {

        Dealership dealership = new Dealership();
        Make make1 = new Make("Ford");

        dealership.addMake(make1);

        Car car1 = new Car("NA90 LJK","Fiesta","Red");

        make1.addCar(car1);

        int expectedResult = 1;
        int actualResult = make1.getCars().size();

        assertEquals(expectedResult,actualResult);
    }
}
