package tests;

import org.junit.jupiter.api.Test;
import step3.Dealership;
import step3.Make;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testBinaryTree {
    @Test

    void testWithBinaryTree() throws Exception {

        Dealership dealership = new Dealership();

        Make make1 = new Make("Ford");
        Make make2 = new Make("Aston Martin");
        Make make3 = new Make("Toyota");

        dealership.addMake(make1);
        dealership.addMake(make2);
        dealership.addMake(make3);

        boolean expectedResult = true;
        boolean actualResult = dealership.getRoot()==make1;

        boolean expectedResult2 = true;
        boolean actualResult2 = make1.getLeft()==make2;

        boolean expectedResult3 = true;
        boolean actualResult3 = make1.getRight()==make3;

        assertEquals(expectedResult,actualResult);
        assertEquals(expectedResult2,actualResult2);
        assertEquals(expectedResult3,actualResult3);
    }
}
