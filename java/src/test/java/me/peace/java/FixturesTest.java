package me.peace.java;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Closeable;
import java.io.IOException;

public class FixturesTest {
    private static ExpensiveManagedResource expensiveManagedResource;
    private ManageResource manageResource;

    static class ExpensiveManagedResource implements Closeable{
        @Override
        public void close() throws IOException {

        }
    }

    static class ManageResource implements Closeable{
        @Override
        public void close() throws IOException {

        }
    }

    @BeforeClass
    public static void setUpClass(){
        System.out.println("@BeforeClass setUpClass");
        expensiveManagedResource = new ExpensiveManagedResource();
    }

    @AfterClass
    public static void tearDownClass() throws IOException{
        System.out.println("@AfterClass tearDownClass");
        expensiveManagedResource.close();
        expensiveManagedResource = null;
    }

    private void println(String str){
        System.out.println(str);
    }

    @Before
    public void setUp(){
        this.println("@Before setUp");
        this.manageResource = new ManageResource();
    }

    @After
    public void tearDown() throws IOException{
        this.println("@After tearDown");
        this.manageResource.close();
        this.manageResource = null;
    }

    @Test
    public void test1(){
        this.println("@Test test1");
    }

    @Test
    public void test2(){
        this.println("@Test test2");
    }
}
