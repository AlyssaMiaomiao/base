package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatToView {
	public static String toViewDate(long date) {
		SimpleDateFormat format=new SimpleDateFormat("YYYY年MM月ZZ日");
		return format.format(new Date(date));
	}
	public static long toDbDate(String date) throws ParseException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-DD");
		return dateFormat.parse(date).getTime();
	}

}
