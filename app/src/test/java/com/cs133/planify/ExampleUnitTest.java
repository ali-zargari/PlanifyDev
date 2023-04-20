package com.cs133.planify;

import static org.junit.Assert.*;

import com.cs133.planify.backend.Account;
import com.cs133.planify.backend.Calendar;

import org.testng.annotations.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    //create an account, create a calendar, add calendar to account.
    //add it to the database
    @Test
    public void testAccountCalendar() {
    	Account account = new Account();
    	Calendar calendar = new Calendar();
    	account.addCalendar(calendar);
    	assertEquals(account.getCalendars().get(0), calendar);
    }



}