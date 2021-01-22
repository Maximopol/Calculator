package com.maximopol.mycalc.logic;

import junit.framework.TestCase;

public class OperationTest extends TestCase {

    public void testGetOperations() {
    }

    public void testGetCountOfOperand() {
    }

    public void testGetPriority() {
    }

    public void testAction() {
    }

    public void testTestAction() {
    }

    public void testIsDoubleInputStringNumberWithFResultTrue() {
        String number = "5f";
        boolean excepted = true;
        boolean actual=Operation.isDouble(number);
        assertEquals(excepted,actual );
    }
    public void testIsDoubleInputStringNumberResultTrue() {
        String number = "5";
        boolean excepted = true;
        boolean actual=Operation.isDouble(number);
        assertEquals(excepted,actual );
    }
    public void testIsDoubleInputStringResultFalse() {
        String number = "g";
        boolean excepted = false;
        boolean actual=Operation.isDouble(number);
        assertEquals(excepted,actual );
    }
}