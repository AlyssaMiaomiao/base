package util.copy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatToView {
	public static String toViewDate(long date) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date(date));
	}
	public static long toDbDate(String date) throws ParseException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.parse(date).getTime();
	}

}
