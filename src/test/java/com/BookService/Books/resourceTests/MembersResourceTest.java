package com.BookService.Books.resourceTests;


import java.util.Arrays;
import java.util.List;
import Books.model.Member;
import Books.resource.BooksResource;
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


@RunWith(SpringRunner.class)
@WebMvcTest(value = MembersResource.class, secure = false)
public class MembersResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MembersResource membersResource;

    List <Member> mockFullList = Arrays.asList(new Member(1, "Ricky", "Clevinger"),
            new Member(2, "Ben", "Coalson"), new Member(3, "Jack", "Sparrow"));
    List <Member> mockMem;

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
    public void getByIdTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = Arrays.asList(mockFullList.get(1));

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
    }//end getByIdTest


    @Test
    public void getByFNameTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = Arrays.asList(mockFullList.get(2));

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
    }//end getByFNameTest


    @Test
    public void getByLNameTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockMem = Arrays.asList(mockFullList.get(2));

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