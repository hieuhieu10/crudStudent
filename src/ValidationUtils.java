import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {
    public static Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);
            return date;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid birth date format");
        }
    }
    public static boolean isValidDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public static boolean isValidYearFormat(String yearStr) {
        try {
            DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern("yyyy");
            YEAR_FORMATTER.parse(yearStr);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    public static boolean validateInteger(String integerInput) {
        if (integerInput.isEmpty() || integerInput.isBlank()) {
            return false;
        } else {
            try {
                Integer.parseInt(integerInput);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

    }
    public static boolean validateDouble(String doubleInput) {
        if (doubleInput.isEmpty() || doubleInput.isBlank()) {
            return false;
        } else {
            try {
                Double.parseDouble(doubleInput);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
    public static boolean stringCheck(String string) {
        // Sử dụng HashSet để kiểm tra ký tự trùng nhau
        Set<Character> appeared = new HashSet<>();

        for (char kyTu : string.toCharArray()) {
            // Nếu ký tự đã xuất hiện, trả về false
            if (!appeared.add(kyTu)) {
                return false;
            }
        }
        // Nếu không có ký tự trùng nhau, trả về true
        return true;
    }
    public static double calculateAverageScore(Students student) {
        return student.getCumulativeGpa();
    }
    public static AcademicPerformance calculateAcademicPerformance(double averageScore) {
        if (averageScore < 3) {
            return AcademicPerformance.FAIL;
        }
        if (averageScore < 5) {
            return AcademicPerformance.WEAK;
        }
        if (averageScore < 6.5) {
            return AcademicPerformance.AVERAGE;
        }
        if (averageScore < 7.5) {
            return AcademicPerformance.GOOD;
        }
        if (averageScore < 9) {
            return AcademicPerformance.EXCELLENT;
        }
        {
            return AcademicPerformance.OUTSTANDING;
        }
    }
    public static String formatPercentage(double percentage) {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(percentage) + "%";
    }
}
