package com.pfkj.oas.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	// 每一天的毫秒数
		private static final long MS_EVERY_DAY = 1000 * 60 * 60 * 24;

		// 默认的pattern
		private static final String PATTERN = "yyyyMMdd";

		private static final String PATTERN_TIME = "yyyy-MM-dd HH:mm:ss.S";

		private static final String PATTERN_TIME2 = "yyyy-MM-dd";

		public static final String PATTERN_TIME3 = "yyyy-MM-dd";

		public static final String PATTERN_TIME4 = "yyyyMMddHHmm";

		private static final String PATTERN_TIME5 = "yyyy-MM-dd HH:mm:ss";

		private static final String PATTERN_TIME6 = "yyyy-MM-dd HH:mm:ss,SSS";

		// 日期格式化
		private static SimpleDateFormat dateFormat;

		static {
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		}

		/**
		 * 
		 */
		public DateUtil() {
			super();
		}

		/**
		 * 返回昨天的日期
		 * 
		 * @return
		 */
		public static String getYesterdayDate(int day) {

			java.util.Calendar calendar = java.util.Calendar.getInstance();
			calendar.add(Calendar.DATE, -(day));
			java.util.Date beginDate = calendar.getTime();
			SimpleDateFormat dateFmt = new SimpleDateFormat(PATTERN);
			String yesterdayDate = dateFmt.format(beginDate);

			return yesterdayDate;
		}

		/**
		 * 由日期型转化为"yyyyMMdd"形式的String类型
		 * 
		 * @param date
		 * @return
		 */
		public static String dateToString(Date date) {

			SimpleDateFormat dateFmt = new SimpleDateFormat(PATTERN);
			return dateFmt.format(date);
		}

		/**
		 * 由日期型转化为"yyyyMMdd"形式的String类型
		 * 
		 * @param date
		 * @return
		 */
		public static String dateToString(Date date, String pattern) {

			SimpleDateFormat dateFmt = new SimpleDateFormat(pattern);
			return dateFmt.format(date);
		}

		/**
		 * 由String类型，转化为日期型
		 * 
		 * @param strDate
		 * @return
		 * @throws ParseException
		 */
		public static Date stringToDate(String strDate) throws ParseException {
			DateFormat df = new SimpleDateFormat(PATTERN);
			Date date = df.parse(strDate);
			return date;
		}

		/**
		 * 由String类型，转化为日期型
		 * 
		 * @param strDate
		 * @return
		 * @throws ParseException
		 */
		public static Date stringToDate_Time(String strDate) throws ParseException {
			DateFormat df = new SimpleDateFormat(PATTERN_TIME);
			Date date = df.parse(strDate);
			return date;
		}

		/**
		 * 由String类型，转化为日期型
		 * 
		 * @param strDate
		 *            zhs加
		 * @return
		 * @throws ParseException
		 */
		public static Date stringToDate_Time2(String strDate) throws ParseException {
			DateFormat df = new SimpleDateFormat(PATTERN_TIME2);
			Date date = df.parse(strDate);
			return date;
		}

		/**
		 * 由String类型，转化为日期型
		 * 
		 * @param strDate
		 * @return
		 * @throws ParseException
		 */
		public static Date stringTo_Date_Time2(String strDate)
				throws ParseException {
			DateFormat df = new SimpleDateFormat(PATTERN_TIME3);
			Date date = df.parse(strDate);
			return date;
		}

		/**
		 * 由String类型，转化为日期型
		 * 
		 * @param strDate
		 * @return
		 * @throws ParseException
		 */
		public static Date stringToDate(String strDate, String pattern)
				throws ParseException {
			DateFormat df = new SimpleDateFormat(pattern);
			Date date = df.parse(strDate);
			return date;
		}

		/**
		 * 得到两个日期型数据之间所差的天数,此处为闭区间
		 * 
		 * @param beginDate
		 *            起始的日期
		 * @param endDate
		 *            结束的日期
		 * @return 相差的天数
		 */
		public static long compare(Date beginDate, Date endDate) {
			long beginTime = beginDate.getTime();
			long endTime = endDate.getTime();
			long betweenDays = (endTime - beginTime) / MS_EVERY_DAY;
			if (betweenDays >= 0)
				return betweenDays + 1;

			return betweenDays - 1;
		}

		/**
		 * 取date后第n天的Date
		 * 
		 * @param date
		 * @param n
		 * @return
		 */
		public static Date nextDate(Date date, int n) {
			long day = n * MS_EVERY_DAY;
			Date d = new Date(date.getTime() + day);
			return d;
		}

		/**
		 * 取得n天时间
		 * 
		 * @param n
		 *            n=0 今天 n=1 明天；n=0 今天 n=-1 昨天
		 * @return String 返回n天时间 yyyy-mm-dd
		 */
		public static String getDateList(int n) {

			GregorianCalendar gcDate = new GregorianCalendar();
			String sbDateTodayTime;
			int year = gcDate.get(1);
			int month = gcDate.get(2);
			int date = gcDate.get(5);
			GregorianCalendar oneWeek = new GregorianCalendar(year, month, date);
			oneWeek.add(5, n);
			java.util.Date date2 = oneWeek.getTime();
			sbDateTodayTime = dateFormat.format(date2);
			return sbDateTodayTime;
		}

		/**
		 * 获取当前时间，返回时间格式(如果调用参数为true时返回yyyy-MM-dd HH:mm:ss
		 * ，否则为false时返回yyyy-MM-DD不带日期格式)
		 * 
		 * @param time
		 *            boolean
		 * @return String
		 * 
		 */
		public static String getNowTime(boolean time) {
			Date now = new Date();
			String format = "";
			// yyyy-MM-dd HH:mm:ss:S 年月日时分秒毫杪
			if (time) {
				format = "yyyy-MM-dd ";
			} else {
				format = "yyyy-MM-dd HH:mm:ss.s";
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			String nowtime = sdf.format(now);
			return nowtime;
		}

		public static String getNowTime() {
			Date now = new Date();
			String format = "yyyyMMdd";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			String nowtime = sdf.format(now);
			return nowtime;
		}

		/**
		 * 将10位的日期数据(yyyy-MM-dd)转换为8位的日期数据(yyyyMMdd)
		 * 
		 * @param date
		 *            10位的日期数据(yyyy-MM-dd)
		 * @return 8位的日期数据(yyyyMMdd)
		 */
		public static String convert10DateTo8Date(String date) {
			return date.replaceAll("-", "");
		}

		/**
		 * 将8位的日期数据(yyyyMMdd)转换为10位的日期数据(yyyy-MM-dd)
		 * 
		 * @return String
		 */
		public static String convert8DateTo10Date(String date) {
			String head = date.substring(0, 4);
			String middle = date.substring(4, 6);
			String tail = date.substring(6);
			return head + "-" + middle + "-" + tail;
		}

		/**
		 * 由日期型转化为"yyyy-MM-dd"形式的String类型
		 * 
		 * @param date
		 * @return
		 */
		public static String dateTo10String(Date date) {

			SimpleDateFormat dateFmt = new SimpleDateFormat(PATTERN_TIME2);
			return dateFmt.format(date);
		}

		/**
		 * 把时间转化为日期行
		 * @param sb
		 * @return
		 * @throws ParseException Date
		 */
		public static Calendar StringtoDate(String sb) throws ParseException {

			DateFormat df = new SimpleDateFormat(PATTERN_TIME4);
			Date date = df.parse(sb);
			Calendar cal=Calendar.getInstance();
			cal.setTimeInMillis(date.getTime());
			return cal;

		}
		
		/**
		 * 忽略具体时间的时间比较，把时间转化为字符串进行比较
		 * @param date
		 * @param otherdate
		 * @return
		 */
		public static boolean CompareDate(Date date,Date otherdate){
			DateFormat format=DateFormat.getDateInstance(DateFormat.MEDIUM);
			String datesb1=format.format(date);
			String datesb2=format.format(otherdate);
			return datesb1.equals(datesb2);
		}	

		/**
		 * 由String类型，转化为日期型
		 * 
		 * @param strDate
		 * @return
		 * @throws ParseException
		 */
		public static Date stringToDate_Time5(String strDate) throws ParseException {
			DateFormat df = new SimpleDateFormat(PATTERN_TIME5);
			Date date = df.parse(strDate);
			return date;
		}

		/**
		 * 由String类型，转化为日期型
		 * 
		 * @param strDate
		 * @return
		 * @throws ParseException
		 */
		public static Date stringToDate_Time6(String strDate) throws ParseException {
			DateFormat df = new SimpleDateFormat(PATTERN_TIME6);
			Date date = df.parse(strDate);
			return date;
		}
		
	    /**
	     * 取得年
	     *
	     * @param forDate 日期
	     * @return 年
	     */
	    public static int getYear(String forDate) {
	        return Integer.parseInt(forDate.substring(0, 4));
	    }

	    /**
	     * 取得月
	     *
	     * @param forDate 日期
	     * @return 月份
	     */
	    public static int getMonth(String forDate) {
	        return Integer.parseInt(forDate.substring(5, 7));
	    }

	    /**
	     * 取得天
	     *
	     * @param forDate 日期
	     * @return 天
	     */
	    public static int getDay(String forDate) {
	        return Integer.parseInt(forDate.substring(8, 10));
	    }
	    
	    /**
	     * 取得小时
	     *
	     * @param forDate 日期
	     * @return 小时
	     */
	    public static int getHour(String forDate) {
	        return Integer.parseInt(forDate.substring(11, 13));
	    }

	    /**
	     * 取得分钟
	     *
	     * @param forDate 日期
	     * @return 分钟
	     */
	    public static int getMinute(String forDate) {
	        return Integer.parseInt(forDate.substring(14, 16));
	    }
	    
	    /**
	     * 取得秒
	     *
	     * @param forDate 日期
	     * @return 秒
	     */
	    public static int getSecond(String forDate) {
	        return Integer.parseInt(forDate.substring(17, 19));
	    }
	    
	    /**
	     * 取得毫秒
	     *
	     * @param forDate 日期
	     * @return 毫秒
	     */
	    public static int getMillisecond(String forDate) {
	        return Integer.parseInt(forDate.substring(20, 23));
	    }

	    /**
	     * 日期比较大小(到毫秒).
	     *
	     * @return 0 第一个参数日期较大. 1 第一个参数日期较小.  2 两个日期相等
	     */
	    public static int compDate(String forStrDate1, String forStrDate2) {
	        int intYear1 = getYear(forStrDate1);
	        int intYear2 = getYear(forStrDate2);
	        int intMonth1 = getMonth(forStrDate1);
	        int intMonth2 = getMonth(forStrDate2);
	        int intDay1 = getDay(forStrDate1);
	        int intDay2 = getDay(forStrDate2);
	        int intHour1 = getHour(forStrDate1);
	        int intHour2 = getHour(forStrDate2);
	        int intMinute1 = getMinute(forStrDate1);
	        int intMinute2 = getMinute(forStrDate2);
	        int intSecond1 = getSecond(forStrDate1);
	        int intSecond2 = getSecond(forStrDate2);
	        int intgetMillisecond1 = getMillisecond(forStrDate1);
	        int intgetMillisecond2 = getMillisecond(forStrDate2);

			if (intYear1 > intYear2) {
				return 0;
			} else if (intYear1 < intYear2) {
				return 1;
			} else if (intYear1 == intYear2) {
				if (intMonth1 > intMonth2) {
					return 0;
				} else if (intMonth1 < intMonth2) {
					return 1;
				} else if (intMonth1 == intMonth2) {
					if (intDay1 > intDay2) {
						return 0;
					} else if (intDay1 < intDay2) {
						return 1;
					} else if (intDay1 == intDay2) {
						if (intHour1 > intHour2) {
							return 0;
						} else if (intHour1 < intHour2) {
							return 1;
						} else if (intHour1 == intHour2) {
							if (intMinute1 > intMinute2) {
								return 0;
							} else if (intMinute1 < intMinute2) {
								return 1;
							} else if (intMinute1 == intMinute2) {
								if (intSecond1 > intSecond2) {
									return 0;
								} else if (intSecond1 < intSecond2) {
									return 1;
								} else if (intSecond1 == intSecond2) {
									if (intgetMillisecond1 > intgetMillisecond2) {
										return 0;
									} else if (intgetMillisecond1 < intgetMillisecond2) {
										return 1;
									} else {
										return 2;
									}
								}
							}
						}
					}
				}
			}
			return -1;
		}

		public static Date getYesterdayToDate(int day) {

			java.util.Calendar calendar = java.util.Calendar.getInstance();
			calendar.add(Calendar.DATE, -(day));
			java.util.Date beginDate = calendar.getTime();
			return beginDate;
		}
}
