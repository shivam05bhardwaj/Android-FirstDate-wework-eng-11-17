package com.flatironschool.firstdate;

import android.test.AndroidTestCase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by altyus on 8/6/14.
 */
public class FirstDateTests extends AndroidTestCase {
    private ArrayList<String> mValidPossibleDates;
    private FirstDate mFirstDate;

    @Override
    protected void setUp(){
        mValidPossibleDates = FirstDateTests.getValidPossibleDates();
        mFirstDate = new FirstDate(mValidPossibleDates);
    }


    public void testConstructDateActivity(){
        FirstDate firstDate = new FirstDate(mValidPossibleDates);
        assertNotNull(firstDate);
        assertEquals(firstDate.getClass(), FirstDate.class);
    }

    public void testScheduleValidDate(){
       assertTrue(mFirstDate.scheduleDate(FirstDate.getDate("09/04/2014")));
        assertTrue(mFirstDate.isScheduled());
        assertEquals(FirstDate.getDate("09/04/2014"), mFirstDate.getScheduledDate());
    }

    public void testScheduleInvalidDate(){
        assertFalse(mFirstDate.scheduleDate(FirstDate.getDate("09/05/2014")));
        assertFalse(mFirstDate.isScheduled());
        assertNull(mFirstDate.getScheduledDate());
    }

    public void testCancelDate(){
        mFirstDate.scheduleDate(FirstDate.getDate("09/04/2014"));
        assertTrue(mFirstDate.isScheduled());

        assertTrue(mFirstDate.cancelDate());
        assertFalse(mFirstDate.isScheduled());
    }

    public void testGetDate(){
        Calendar cal = new GregorianCalendar(2014,8,4); // Note Java Calendar is 0 based which
        // is horrendous but it is... So 8 is September not August
        assertEquals(FirstDate.getDate("09/04/2014"), cal.getTime());
    }
    private static ArrayList<String>getValidPossibleDates(){
        ArrayList<String>possibleDates = new ArrayList<String>();
        possibleDates.add("09/04/2014");
        possibleDates.add("10/15/2014");
        possibleDates.add("11/16/2014");
        possibleDates.add("10/14/2014");
        possibleDates.add("11/12/2014");

        return possibleDates;
    }
    @Override
    protected void tearDown(){}
}


