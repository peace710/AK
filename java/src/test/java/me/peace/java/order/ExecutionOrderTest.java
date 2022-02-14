package me.peace.java.order;

import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;

@OrderWith(Alphanumeric.class)
public class ExecutionOrderTest {
    @Test
    public void testA(){
        System.out.println("first");
    }

    @Test
    public void testB(){
        System.out.println("second");
    }

    @Test
    public void testC(){
        System.out.println("third");
    }
}
