package home.hyywk.top;

import java.util.Date;

public class Logger {
	public static void log( String info ) {
		System.out.println( new Date() + "-" + info);
	}
}
