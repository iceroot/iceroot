package com.icexxx.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期封装类
 * 
 * @author IceWater
 * @version 2.0.3
 */
public class IceDate extends Date {
    private static final long serialVersionUID = 3097619038228693170L;

    public IceDate() {

    }

    public IceDate(String str) {
        SimpleDateFormat sdf = IceConst.TIME_FORMAT;
        try {
            Date date = sdf.parse(str);
            this.setTime(date.getTime());
        } catch (ParseException e) {
            sdf = IceConst.DATE_FORMAT;
            try {
                Date date = sdf.parse(str);
                this.setTime(date.getTime());
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = IceConst.TIME_FORMAT;
        return sdf.format(this);
    }
}
