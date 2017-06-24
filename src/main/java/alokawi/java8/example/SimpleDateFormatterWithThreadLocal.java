package alokawi.java8.example;

import java.text.SimpleDateFormat;

public class SimpleDateFormatterWithThreadLocal {
	private static final ThreadLocal<SimpleDateFormat> DATE_FORMATTER = ThreadLocal
			.<SimpleDateFormat>withInitial(() -> {
				return new SimpleDateFormat("yyyyMMdd HHmm");
			});

	public static void main(String[] args) {
		Runnable r1 = () -> {
			SimpleDateFormat simpleDateFormat = DATE_FORMATTER.get();
			System.out.println(simpleDateFormat);
		};
		r1.run();
		Runnable r2 = () -> {
			SimpleDateFormat simpleDateFormat = DATE_FORMATTER.get();
			System.out.println(simpleDateFormat);
		};
		r2.run();
	}
}
