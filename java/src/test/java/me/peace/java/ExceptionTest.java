package me.peace.java;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {
    @Test
    public void testExceptionAndState(){
        List<Object> list = new ArrayList<>();
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                ()->list.add(1,new Object()));
        assertEquals("Index: 1, Size: 0",exception.getMessage());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testExceptionMessage(){
        List<Object> list = new ArrayList<>();

        try{
            list.get(0);
            fail("Expected an IndexOutOfBoundException to be thrown");
        }catch (IndexOutOfBoundsException e){
            assertThat(e.getMessage(),is("Index: 0, Size: 0"));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void empty() {
        new ArrayList<Object>().get(0);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldTEstExceptionMessage() throws IndexOutOfBoundsException{
        List<Object> list = new ArrayList<>();

        expectedException.expect(IndexOutOfBoundsException.class);
//        expectedException.expectMessage("Index: 0, Size: 0");
        expectedException.expectMessage(CoreMatchers.containsString("Index 0"));
        list.get(0);
    }

    @Ignore("Test is ignored as a demonstration")
    @Test
    public void testSame() {
        assertThat(1, is(1));
    }
}
