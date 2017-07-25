package com.BookService.Books.resourceTests;


import Books.model.Transaction;
import Books.resource.BooksResource;
import Books.resource.TransactionsResource;
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
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@WebMvcTest(value = TransactionsResource.class, secure = false)
public class TransactionsResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionsResource transactionsResource;

    Timestamp timestamp = null;
    List <Transaction> mockFullList = Arrays.asList(new Transaction(1, 1, timestamp,1,1));


    @Test
    public void getAllTest() throws Exception {

        //Returns mockFullList when getAll is called.
        Mockito.when(
                transactionsResource.getAll()).thenReturn(mockFullList);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/trans/all").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[{\"tran\":1,\"bookId\":1,\"check\":1,\"mid\":1,\"tdate\":null}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getAllTest



}