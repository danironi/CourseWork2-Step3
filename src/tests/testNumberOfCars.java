package tests;

import org.junit.jupiter.api.Test;
import step3.Car;
import step3.Dealership;
import step3.Make;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testNumberOfCars {
    @Test

    void testWithNumberOfCarsAvailable() throws Exception {
        Dealership dealership = new Dealership();

        Make make1 = new Make("Ford");
        Make make2 = new Make("Aston Martin");

        dealership.addMake(make1);

        Car car1 = new Car("NA90 LJK","Fiesta","Red");
        Car car2 = new Car("AW10 LKJ","Focus","Blue");
        Car car3 = new Car("NA90 PJK","Fiesta","Red");
        Car car4 = new Car("NY80 LJK","Fiesta","Red");
        Car car5 = new Car("LK90 GFD","Bla","Black");

        make1.addCar(car1);
        make1.addCar(car2);
        make1.addCar(car3);
        make1.addCar(car4);
        make2.addCar(car5);

        int expectedResult = 3;
        int actualResult = make1.getCarNumbers("Fiesta");

        int expectedResult2 = 1;
        int actualResult2 = make1.getCarNumbers("Focus");

        int expectedResult3 = 1;
        int actualResult3 = make2.getCarNumbers("Bla");

        assertEquals(expectedResult,actualResult);
        assertEquals(expectedResult2,actualResult2);
        assertEquals(expectedResult3,actualResult3);

    }
}
