package com.BookService.Books;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

import Books.model.Books;
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
@WebMvcTest(value = BooksResource.class, secure = false)
public class MembersResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MembersResource membersResource;

    List <Member> mockFullList = Arrays.asList(new Member(1, "Ricky", "Clevinger"),
            new Member(2, "Ben", "Coalson"));
    List <Member> mockMem;

    String exampleMemberJson = "{\"id\":\"1\",\"fname\":\"Ricky\",\"lname\":Clevinger}";

    @Test
    public void getAllTest() throws Exception {

        Mockito.when(
                membersResource.getAll()).thenReturn(mockFullList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/all").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "[{id:1,fname:Ricky,lname:Clevinger},{id:2,fname:Ben,lname:Coalson}]";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
        //System.out.println(result.getResponse().getContentAsString());
    }


    @Test
    public void getIdTest() throws Exception {

        mockMem = Arrays.asList(mockFullList.get(1));

        Mockito.when(
                membersResource.getId(2)).thenReturn(mockMem);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/members/id/2").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "[{id:2,fname:Ben,lname:Coalson}]";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
        System.out.println(result.getResponse().getContentAsString());
    }

}