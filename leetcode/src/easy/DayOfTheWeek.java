package easy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DayOfTheWeek {
    public static void main(String[] args) {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        System.out.println(dayOfTheWeek.dayOfTheWeek_1(31, 8, 2019));
        System.out.println(dayOfTheWeek.dayOfTheWeek_1(18, 7, 1999));
        System.out.println(dayOfTheWeek.dayOfTheWeek_1(15, 8, 1993));

    }

    /**
     * 蔡勒公式
     * @param day
     * @param month
     * @param year
     * @return
     */
    public String dayOfTheWeek(int day, int month, int year) {
        String[] res = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int y = year, m = month;
        if (month == 1 || month == 2)
        {
            --y;
            m += 12;
        }
        int cY = y / 100, yY = y - cY * 100;
        int indexWeek = (cY / 4 - 2 * cY + yY + yY / 4 + 26 * (m + 1) / 10 + day - 1) % 7;
        if (indexWeek < 0)
            indexWeek += 7;
        return res[indexWeek];

    }

    public String dayOfTheWeek_1(int day, int month, int year) {
        String[] res = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,day);
        return res[calendar.get(Calendar.DAY_OF_WEEK)-1];

    }
}
