package com.BookService.Books.modelTests;

import Books.model.Users;
import org.junit.Assert;
import org.junit.Test;

public class UsersTest {

    Users mockMem = new Users();

    @Test
    public void getSetIdTest() throws Exception {

        //setter
        mockMem.setId(1);

        //Sets the result using getter
        String result = mockMem.getId() + "";

        //What the expected result is
        String expected = "1";

        //Compares expected result with the actual result.
        Assert.assertEquals(expected, result);
    }//end getSetIdTest

    @Test
    public void getSetFNameTest() throws Exception {

        //setter
        mockMem.setFName("Jack");

        //Sets the result using getter
        String result = mockMem.getFName();

        //What the expected result is
        String expected = "Jack";

        //Compares expected result with the actual result.
        Assert.assertEquals(expected, result);
    }//end getSetFNameTest

    @Test
    public void getSetLNameTest() throws Exception {

        //setter
        mockMem.setLname("Sparrow");

        //Sets the result using getter
        String result = mockMem.getLname();

        //What the expected result is
        String expected = "Sparrow";

        //Compares expected result with the actual result.
        Assert.assertEquals(expected, result);
    }//end getSetLNameTest

}