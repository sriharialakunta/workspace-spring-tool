package com.example.demo;

import static org.junit.Assert.assertEquals;
import org.junit.contrib.java.lang.system.SystemOutRule;


import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAss1ApplicationTests {

    @Autowired
    private SpringBootAss1Application application;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testRun() throws Exception {
        application.run("arg1", "arg2");

        assertEquals("Hello world this from commandLineRunner.", systemOutRule.getLog());
    }
}

