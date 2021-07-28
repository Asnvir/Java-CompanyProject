package company.util;

import java.util.regex.Pattern;

public class CompanyUtil {
    public static String convertTime(int time) {
        if (time < 24) return String.valueOf(time);
        else return time - 24 +" (+1 day)";
    }

    public static boolean isNameCorrect(String name) {
        Pattern pattern = Pattern.compile("[a-zA-Z ]+");
        return pattern.matcher(name).matches();
    }

    public static boolean isTimeCorrect(int time) {
        return time >= 0 && time < 24;
    }
}
