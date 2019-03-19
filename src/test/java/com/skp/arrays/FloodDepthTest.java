package com.skp.arrays;

import com.sumant.arrays.FloodDepth;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class FloodDepthTest {

    FloodDepth fd;
    @Before
    public void setUp() throws Exception {
        fd = new FloodDepth();
    }

    @Test
    public void solutionTest()
    {

        int [] a = {10,8};
        System.out.println(fd.solution(a));
        assertEquals(6,fd.solution(a));
    }
}