package com.BookService.Books.modelTests;

import Books.model.Transaction;
import org.junit.Assert;
import org.junit.Test;
import java.sql.Timestamp;

public class TransactionTest {

    Transaction mockTran = new Transaction();

    @Test
    public void getSetTranTest() throws Exception {

        //setter
        mockTran.setTran(1);

        //Sets the result using getter
        String result = mockTran.getTran() + "";

        //What the expected result is
        String expected = "1";

        //Compares expected result with the actual result.
        Assert.assertEquals(expected, result);
    }//end getSetTranTest

    @Test
    public void getSetBookIdTest() throws Exception {

        //setter
        mockTran.setBookId(2);

        //Sets the result using getter
        String result = mockTran.getBookId() + "";

        //What the expected result is
        String expected = "2";

        //Compares expected result with the actual result.
        Assert.assertEquals(expected, result);
    }//end getSetBookIdTest

    @Test
    public void getSetLNameTest() throws Exception {

        //setter
        mockTran.setTDate(new Timestamp(0));

        //Sets the result using getter
        String result = mockTran.getTDate() + "";

        //What the expected result is
        String expected = new Timestamp(0) + "";

        //Compares expected result with the actual result.
        Assert.assertEquals(expected, result);
    }//end getSetLNameTest
    
}