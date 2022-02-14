package me.peace.java;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

import java.util.Arrays;

public class AssertTest {
    @Test
    public void testAssertArrayEquals(){
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
//        byte[] actual = "atrial".getBytes();
        assertArrayEquals("failure - byte arrays not same",expected,actual);
    }

    @Test
    public void testAssertEquals(){
        assertEquals("failure - strings are not equal","text","text");
//        assertEquals("failure - strings are not equal","text","test");
    }

    @Test
    public void testAssertFalse(){
        assertFalse("failure - should be false",false);
//        assertFalse("failure - should be false",true);
    }

    @Test
    public void testAssertTrue(){
        assertTrue("failure - should be true",true);
//        assertTrue("failure - should be true",false);
    }

    @Test
    public void testAssertNotNull(){
        assertNotNull("should not be null",new Object());
//        assertNotNull("should not be null",null);
    }

    @Test
    public void testAssertNotSame(){
        assertNotSame("should not be same Object",new Object(),new Object());
//        Object obj = new Object();
//        assertNotSame("should not be same Object",obj,obj);
    }

    @Test
    public void testAssertNull(){
        assertNull("should be null",null);
//        assertNull("should be null",new Object());
    }

    @Test
    public void testAssertSame(){
        Integer numberA = Integer.valueOf(768);
        Integer numberB = Integer.valueOf(768);
        assertSame("should be same",numberA,numberA);
//        assertSame("should be same",numberA,numberB);
    }

    @Test
    public void testAssertThatBothContainsString(){
        assertThat("albumen",both(containsString("a")).and(containsString("b")));
//        assertThat("albumen",both(containsString("a")).and(containsString("c")));
    }

    @Test
    public void testAssertThatHasItem(){
        assertThat(Arrays.asList("one","two","three"),hasItems("one","three"));
//        assertThat(Arrays.asList("one","two","three"),hasItems("one","four"));
    }

    @Test
    public void testAssertThatEveryItemContainsString(){
        assertThat(Arrays.asList(new String[]{"fun","ban","net"}),everyItem(containsString("n")));
//        assertThat(Arrays.asList(new String[]{"fun","ball","net"}),everyItem(containsString("n")));
    }

    @Test
    public void testAssertThatHamcrestCoreMatchers(){
        assertThat("good",allOf(equalTo("good"),startsWith("good")));
        assertThat("good",not(allOf(equalTo("bad"),equalTo("good"))));
        assertThat("good",anyOf(equalTo("bad"),equalTo("good")));
        assertThat(7,not(CombinableMatcher.either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(),not(sameInstance(new Object())));
    }
}
