package com.BookService.Books.resourceTests;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import Books.model.Member;
import Books.resource.MembersResource;
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
@WebMvcTest(value = MembersResource.class, secure = false)
public class MembersResourceTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected MembersResource membersResource;

    private List <Member> mockFullList = Arrays.asList(new Member(1, "Ricky", "Clevinger"),
            new Member(2, "Ben", "Coalson"), new Member(3, "Jack", "Sparrow"));
    private List <Member> mockMem;

    @Test
    public void getAllTest() throws Exception {

        //Returns mockFullList when getAll is called.
        Mockito.when(
                membersResource.getAll()).thenReturn(mockFullList);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/all").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[{id:1,fname:Ricky,lname:Clevinger},{id:2,fname:Ben,lname:Coalson}, {id:3,fname:Jack,lname:Sparrow}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getAllTest


    @Test
    public void getByValidIdTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = Collections.singletonList(mockFullList.get(1));

        //Returns mockFullList when getAll is called.
        Mockito.when(
                membersResource.getById(2)).thenReturn(mockMem);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/id/2").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[{id:2,fname:Ben,lname:Coalson}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getByValidIdTest

    @Test
    public void getByInValidIdTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = emptyList();

        //Returns mockFullList when getAll is called.
        Mockito.when(
                membersResource.getById(Integer.MAX_VALUE)).thenReturn(mockMem);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/id/" + Integer.MAX_VALUE).accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getByInValidIdTest


    @Test
    public void getByValidFNameTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = Collections.singletonList(mockFullList.get(2));

        //Returns mockFullList when getAll is called.
        Mockito.when(
                membersResource.getByFName("Jack")).thenReturn(mockMem);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/fname/Jack").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[{id:3,fname:Jack,lname:Sparrow}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getByValidFNameTest

    @Test
    public void getByInValidFNameTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = emptyList();

        //Returns mockFullList when getAll is called.
        Mockito.when(
                membersResource.getByFName("455gre3")).thenReturn(mockMem);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/fname/455gre3").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getByInValidFNameTest


    @Test
    public void getByLNameTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = Collections.singletonList(mockFullList.get(2));

        //Returns mockFullList when getAll is called.
        Mockito.when(
                membersResource.getByLName("Sparrow")).thenReturn(mockMem);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/lname/Sparrow").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[{id:3,fname:Jack,lname:Sparrow}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getByLNameTest

}