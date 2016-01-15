package com.springblog.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by rogalsp1 on 15.01.2016.
 */
public class DateUtils {

    public static Timestamp now() {
        return Timestamp.valueOf(LocalDateTime.now());
    }

}
