package tw.per.allen.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

	/**
	 * 根據傳入的生日，計算當前年齡。
	 * 
	 * @param birthDate 生日
	 * @return Integer 年齡
	 */
	public static Integer calculateAge(Date birthDate) {
		LocalDate b = toLocalDate(birthDate);
		LocalDate n = LocalDate.now();

		return n.getYear() - b.getYear();
	}

	/**
	 * 將 Date 轉換為 LocalDate。
	 * 
	 * @param date Date
	 * @return LocalDate
	 */
	public static LocalDate toLocalDate(Date date) {
		if (date == null) {
			return null;
		}
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/**
	 * 將 LocalDate 轉換為 Date。
	 * 
	 * @param localDate LocalDate
	 * @return Date
	 */
	public static Date toDate(LocalDate localDate) {
		if (localDate == null) {
			return null;
		}
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
