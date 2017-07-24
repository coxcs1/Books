package com.BookService.Books;

import Books.model.Books;
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
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MembersResource.class, secure = false)
public class BooksResourceTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BooksResource booksResource;

    List<Books> mockFullList = Arrays.asList(new Books(1, "HarryPotter", "Joanne", "Rowling", 1, 1, 0),
            new Books(2, "DresdenFiles", "Jim", "Butcher", 1, 1, 0),
            new Books(3, "PeterRabbit", "Beatrix", "Potter", 1, 2, 6));
    List<Books> mockBooks;


    @Test
    public void getAllTest() throws Exception {

        //Returns mockFullList when getAll is called.
        Mockito.when(
                booksResource.getAll()).thenReturn(mockFullList);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/books/all").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[{bookId:1,title:HarryPotter,authFName:Joanne, authLName:Rowling, libId:1,check:1,mid:0}," +
                "{bookId:2,title:DresdenFiles,authFName:Jim, authLName:Butcher, libId:1,check:1,mid:0}," +
                "{bookId:3,title:PeterRabbit,authFName:Beatrix, authLName:Potter, libId:1,check:2,mid:6}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getAllTest

    @Test
    public void getByTitleTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockBooks = Arrays.asList(mockFullList.get(0));

        //Returns mockFullList when getAll is called.
        Mockito.when(
                booksResource.getByTitle("HarryPotter")).thenReturn(mockBooks);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/books/title/HarryPotter").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[{bookId:1,title:HarryPotter,authFName:Joanne, authLName:Rowling, libId:1,check:1,mid:0}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getByTitleTest

    @Test
    public void getByFNameTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockBooks = Arrays.asList(mockFullList.get(2));

        //Returns mockFullList when getAll is called.
        Mockito.when(
                booksResource.getByFName("Beatrix")).thenReturn(mockBooks);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/books/authFName/Beatrix").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[{bookId:3,title:PeterRabbit,authFName:Beatrix,authLName:Potter,libId:1,check:2,mid:6}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getByFNameTest


    @Test
    public void getByLNameTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockBooks = Arrays.asList(mockFullList.get(2));

        //Returns mockFullList when getAll is called.
        Mockito.when(
                booksResource.getByLName("Potter")).thenReturn(mockBooks);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/books/authLName/Potter").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[{bookId:3,title:PeterRabbit,authFName:Beatrix,authLName:Potter,libId:1,check:2,mid:6}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getByLNameTest


    @Test
    public void getByBookIdTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockBooks = Arrays.asList(mockFullList.get(1));

        //Returns mockFullList when getAll is called.
        Mockito.when(
                booksResource.getByBookId(2)).thenReturn(mockBooks);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/books/bookId/2").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[{bookId:2,title:DresdenFiles,authFName:Jim,authLName:Butcher,libId:1,check:1,mid:0}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getByBookId


    @Test
    public void getByCheckTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockBooks = Arrays.asList(mockFullList.get(0),mockFullList.get(1));

        //Returns mockFullList when getAll is called.
        Mockito.when(
                booksResource.getByCheck(1)).thenReturn(mockBooks);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/books/check/1").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[{bookId:1,title:HarryPotter,authFName:Joanne, authLName:Rowling, libId:1,check:1,mid:0}," +
                "{bookId:2,title:DresdenFiles,authFName:Jim,authLName:Butcher,libId:1,check:1,mid:0}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getByBookId


    @Test
    public void getByLibIdTest() throws Exception {

        // Creates a list of one to return of specific element in mockFullList
        mockBooks = Arrays.asList(mockFullList.get(0),mockFullList.get(1),mockFullList.get(2));

        //Returns mockFullList when getAll is called.
        Mockito.when(
                booksResource.getByLibId(1)).thenReturn(mockBooks);

        //Builds the request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/books/libId/1").accept(
                MediaType.APPLICATION_JSON);

        //Sets the result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        //What the expected result is
        String expected = "[{bookId:1,title:HarryPotter,authFName:Joanne, authLName:Rowling, libId:1,check:1,mid:0}," +
                "{bookId:2,title:DresdenFiles,authFName:Jim,authLName:Butcher,libId:1,check:1,mid:0}," +
                "{bookId:3,title:PeterRabbit,authFName:Beatrix,authLName:Potter,libId:1,check:2,mid:6}]";

        //Compares expected result with the actual result.
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }//end getByBookId

}