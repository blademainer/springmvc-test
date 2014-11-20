package com.kingray.spring.http.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.xiongyingqi.util.EntityHelper.print;

/**
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/20 0020.
 */
public class UtilDateConverter implements Converter<String, Date> {
    public UtilDateConverter() {
        print("converter");
    }

    @Override
    public Date convert(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            Long time = Long.valueOf(s);
            date = new Date(time);
        } catch (Exception e) {
        }
        if (date == null) {
            try {
                date = dateFormat.parse(s);
            } catch (ParseException e) {
            }
        }

        if (date == null) {
            try {
                date = dateFormat2.parse(s);
            } catch (ParseException e) {
            }
        }
//        dateFormat.setLenient(false);

        return date;
    }

}
