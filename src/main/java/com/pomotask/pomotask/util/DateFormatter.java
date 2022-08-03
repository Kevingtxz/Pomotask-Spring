package com.pomotask.pomotask.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateFormatter {


    final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat(
                    "yyyy-MM-dd'T'HH:mm:ssZ",
                    new Locale("pt","BR"));
    final SimpleDateFormat DAY_DATE_FORMAT =
            new SimpleDateFormat(
                    "yyyy-MM-ddZ",
                    new Locale("pt","BR"));


}
