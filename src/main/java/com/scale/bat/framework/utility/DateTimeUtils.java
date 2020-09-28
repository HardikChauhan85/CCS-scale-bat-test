package com.scale.bat.framework.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

	public String dateWithSpecificFormatt(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}
}
