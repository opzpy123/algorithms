package competeTest.orther.lanqiaoTest3_5;

import java.util.Calendar;

public class C {
    public static void main(String[] args) {
        int count = 0;
        Calendar c = Calendar.getInstance();
        for (int year = 2000; year <= 2020; year++) {
            for (int i = 1; i <= 12; i++) {
                c.set(year, i, 0); //输入类型为int类型
                int manyDays = c.get(Calendar.DAY_OF_MONTH);
                for (int j = 1; j <= manyDays; j++) {
                    c.set(year, i, j); //输入类型为int类型
                    int week = c.get(Calendar.DAY_OF_WEEK);
                    System.out.println(year + "年" + i + "月" + j + "日" + ",星期" + week);
                    if (j == 1 || week == 1) {
                        count += 2;
                        System.out.println("count+2");
                    } else {
                        count += 1;
                        System.out.println("count+1");
                    }
                    if (year == 2020 && i == 10 && j == 1) {
                        System.out.println(count);
                        return;
                    }
                }
            }
        }

    }
}
