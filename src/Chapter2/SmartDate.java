package Chapter2;
import edu.princeton.cs.algs4.Date;

public class SmartDate {
    private int year;
    private int month;
    private int day;

    public SmartDate(int year, int month, int day) throws Exception  //throws表示要抛出一个异常
    {
        if (year < 0 || month < 0 || day < 0) {
            Exception exception = new Exception("date should be positive");
            throw exception;  //throw表示抛出异常的动作，为祈使句，没有s
        }
        if (month > 12) {
            Exception exception = new Exception("month should be <12");
            throw exception;
        }

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                if (day > 31) {
                    Exception exception = new Exception("day should be <31");
                    throw exception;
                }
            }
            break;
            case 2: {
                if (day > 29) {
                    Exception exception = new Exception("days of Feb should be <30");
                    throw exception;
                }
                int leapyear = year % 4;
                if (leapyear == 0)//如果2月是28天
                {
                    if (day > 28) {
                        Exception exception = new Exception(month + "month should be <29 days");
                        throw exception;
                    }
                }
            }
            break;
            case 4:
            case 6:
            case 9:
            case 11: {
                if (day > 30) {
                    Exception exception = new Exception(month + " month should be <=30 days");
                }
            }
            break;

            default:
                break;
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /*
    Zeller formula w=[c/4] -2c + y + [y/4] + [13(m+1)/5] + d -1
    []表示向下取整
    */
    public String dayOfTheWeek() {
        int month = this.month;
        int year = this.year;
        if (month <= 2) {
            month += 12;
            year--;
        }
        int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;

        switch (week) {
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
            case 5:
                return "Saturday";
            case 6:
                return "Sunday";
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        try {
            SmartDate date = new SmartDate(m, d, y);
            System.out.println(date);
            System.out.println(date.dayOfTheWeek());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
