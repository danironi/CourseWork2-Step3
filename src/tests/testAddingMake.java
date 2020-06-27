package tests;

import org.junit.jupiter.api.Test;
import step3.Dealership;
import step3.Make;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testAddingMake {
    @Test

    void testAddingMakes() throws Exception {

        Dealership dealership = new Dealership();

        Make make1 = new Make("Citroen");
        Make make2 = new Make("Fiat");

        dealership.addMake(make1);
        dealership.addMake(make2);

        boolean expectedResult = true;
        boolean actualResult = dealership.findByMakeName("Fiat");

        boolean expected = true;
        boolean actual = dealership.findByMakeName("Citroen");

        assertEquals(expectedResult,actualResult);
        assertEquals(expected,actual);
    }
}
