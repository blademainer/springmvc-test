package com.kingray.spring.http.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import static com.xiongyingqi.util.EntityHelper.print;

/**
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/20 0020.
 */
public class SqlDateConverter implements Converter<String, Date> {
    public SqlDateConverter() {
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
                date = new Date(dateFormat.parse(s).getTime());
            } catch (ParseException e) {
            }
        }

        if (date == null) {
            try {
                date = new Date(dateFormat2.parse(s).getTime());
            } catch (ParseException e) {
            }
        }
//        dateFormat.setLenient(false);

        return date;
    }

}
