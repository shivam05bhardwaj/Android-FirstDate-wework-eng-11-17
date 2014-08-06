package com.flatironschool.firstdate;

import android.util.Log;

import org.apache.http.impl.cookie.DateParseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by altyus on 8/6/14.
 */
public class FirstDate {

    private ArrayList<String>mPossibleDates;
    private Date mScheduledDate;


    public FirstDate(ArrayList<String>possibleDates){
        mPossibleDates = possibleDates;
    }

    public boolean scheduleDate(Date date){
        if (mPossibleDates == null){
            return false;
        }
        for (String dateString :mPossibleDates){
            SimpleDateFormat format = getDateFormat();
            try {
                Date currentDate = format.parse(dateString);
                if (currentDate.equals(date)){
                    mScheduledDate = currentDate;
                    return true;
                }
            } catch (ParseException e){
                Log.d("TAG", "Exception: ", e);
            }
        }
        
        return false;
    }

    public static Date getDate(String dateString){
        try {
            return getDateFormat().parse(dateString);
        } catch (ParseException e){
            Log.d(FirstDate.class.toString(), "Exception: ", e);
            return null;
        }
    }
    public boolean isScheduled() {
        return mScheduledDate != null;
    }

    public Date getScheduledDate() {
        return mScheduledDate;
    }

    public boolean cancelDate(){
        if (mScheduledDate != null) {
            mScheduledDate = null;
            return true;
        }
        return false;
    }

    private static SimpleDateFormat getDateFormat(){
        return new SimpleDateFormat("MM/dd/yyyy");
    }
}
