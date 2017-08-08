package com.BookService.Books.resourceTests;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Books.model.Users;
import Books.resource.UsersResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static java.util.Collections.emptyList;


@RunWith(SpringRunner.class)
@WebMvcTest(value = UsersResource.class, secure = false)
public class UsersResourceTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UsersResource usersResource;

    private List <Users> mockFullList = Arrays.asList(new Users(1, "Ricky", "Clevinger","email","password",1),
            new Users(2, "Ben", "Coalson","email","password",1),
            new Users(3, "Jack", "Sparrow","email","password",1));
    private List <Users> mockMem;
    private String expected;
    private String notEqualsExpected;

    @Test
    public void getAllTest() throws Exception {

        //Returns mockFullList when getAll is called.
        Mockito.when(
                usersResource.getAll()).thenReturn(mockFullList);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/all").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        expected = "[{id:1,fname:Ricky,lname:Clevinger},{id:2,fname:Ben,lname:Coalson}, {id:3,fname:Jack,lname:Sparrow}]";
        notEqualsExpected = "[]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
        JSONAssert.assertNotEquals(notEqualsExpected, result.getResponse().getContentAsString(), false);
    }//end getAllTest


    @Test
    public void getByValidIdTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = Collections.singletonList(mockFullList.get(1));

        //Returns mockFullList when getAll is called.
        Mockito.when(
                usersResource.getById(2)).thenReturn(mockMem);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/id/2").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        expected = "[{id:2,fname:Ben,lname:Coalson}]";
        notEqualsExpected = "[]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
        JSONAssert.assertNotEquals(notEqualsExpected, result.getResponse().getContentAsString(), false);
    }//end getByValidIdTest

    @Test
    public void getByInValidIdTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = emptyList();

        //Returns mockFullList when getAll is called.
        Mockito.when(
                usersResource.getById(Integer.MAX_VALUE)).thenReturn(mockMem);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/id/" + Integer.MAX_VALUE).accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        expected = "[]";
        notEqualsExpected = "[{id:3,fname:Jack,lname:Sparrow}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
        JSONAssert.assertNotEquals(notEqualsExpected, result.getResponse().getContentAsString(), false);
    }//end getByInValidIdTest


    @Test
    public void getByValidFNameTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = Collections.singletonList(mockFullList.get(2));

        //Returns mockFullList when getAll is called.
        Mockito.when(
                usersResource.getByFName("Jack")).thenReturn(mockMem);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/fname/Jack").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        expected = "[{id:3,fname:Jack,lname:Sparrow}]";
        notEqualsExpected = "[]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
        JSONAssert.assertNotEquals(notEqualsExpected, result.getResponse().getContentAsString(), false);
    }//end getByValidFNameTest

    @Test
    public void getByInValidFNameTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = emptyList();

        //Returns mockFullList when getAll is called.
        Mockito.when(
                usersResource.getByFName("455gre3")).thenReturn(mockMem);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/fname/455gre3").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        expected = "[]";
        notEqualsExpected = "[{id:3,fname:Jack,lname:Sparrow}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
        JSONAssert.assertNotEquals(notEqualsExpected, result.getResponse().getContentAsString(), false);
    }//end getByInValidFNameTest


    @Test
    public void getByValidLNameTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = Collections.singletonList(mockFullList.get(2));

        //Returns mockFullList when getAll is called.
        Mockito.when(
                usersResource.getByLName("Sparrow")).thenReturn(mockMem);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/lname/Sparrow").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        expected = "[{id:3,fname:Jack,lname:Sparrow}]";
        notEqualsExpected = "[]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
        JSONAssert.assertNotEquals(notEqualsExpected, result.getResponse().getContentAsString(), false);
    }//end getByValidLNameTest

    @Test
    public void getByInValidLNameTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = emptyList();

        //Returns mockFullList when getAll is called.
        Mockito.when(
                usersResource.getByLName("!12432gtret234")).thenReturn(mockMem);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/lname/12432gtret234").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        expected = "[]";
        notEqualsExpected = "[{id:3,fname:Jack,lname:Sparrow}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
        JSONAssert.assertNotEquals(notEqualsExpected, result.getResponse().getContentAsString(), false);
    }//end getByInValidLNameTest

}