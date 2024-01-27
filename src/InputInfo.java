import java.time.LocalDate;
import java.util.Scanner;

public class InputInfo {
    public static Scanner scanner = new Scanner(System.in);
    public String inputName(String name) {
        while (name.trim().isEmpty() ||name ==null|| name.length() >= Constants.MAX_NAME_LENGTH) {
            System.out.println("Input student name invalid re-enter the inputName (< 100 character)");
            System.out.print("Input student name: ");
            name = scanner.nextLine();
        }
        return name;
    }

    public String inputAddress(String address) {
        while (address == null || address.length() >= Constants.MAX_ADDRESS_LENGTH) {
            System.out.println("Invalid address for a person re-enter ");
            System.out.print("Input student address (<300 character): ");
            address = scanner.nextLine();
        }
        return address;
    }

    public String inputBirthDateStr(String birthDateStr) {
        int currentYear = LocalDate.now().getYear();
        LocalDate currentYearAsDate = LocalDate.of(currentYear, 1, 1);
        while (birthDateStr == null || !ValidationUtils.isValidDate(birthDateStr) ||
                (LocalDate.parse(birthDateStr).isBefore(Constants.MIN_BIRTHDATE) || LocalDate.parse(birthDateStr).isAfter(currentYearAsDate))) {
            System.out.println("Invalid birth date for a person re-enter (>=1900) and <yearNow");
            System.out.print("Input student birthDateStr (yyyy-MM-dd): ");
            birthDateStr = scanner.nextLine();
        }
        return birthDateStr;
    }

    public String inputHeight(String height) {
        while (!ValidationUtils.validateDouble(height) || !(Constants.MIN_HEIGHT <= Double.parseDouble(height) && Double.parseDouble(height) <= Constants.MAX_HEIGHT)) {
            System.out.println("Invalid height for a person re-enter: ");
            System.out.print("Input student height (50-300) cm: ");
            height = scanner.nextLine();
        }
        return height;
    }

    public String inputWeight(String weight) {
        while (!ValidationUtils.validateDouble(weight) || !(Constants.MIN_WEIGHT <= Double.parseDouble(weight) && Double.parseDouble(weight) <= Constants.MAX_WEIGHT)) {
            System.out.println("Invalid weight for a person re-enter");
            System.out.print("Input student weight (5-1000) kg: ");
            weight = scanner.nextLine();
        }
        return weight;
    }

    public String inputStudentId(String studentId) {
        while (!ValidationUtils.stringCheck(studentId) || (studentId == null) || (studentId.length() != Constants.MAX_STUDENT_ID_LENGTH)) {
            System.out.println("Invalid student ID ");
            System.out.print("Input student studentId have string of (10 characters) and do not repeat each other: ");
            studentId = scanner.nextLine();
        }
        return studentId;
    }

    public String inputCurrentUniversity(String currentUniversity) {
        while (currentUniversity == null || currentUniversity.isEmpty() || currentUniversity.length() >= Constants.MAX_UNIVERSITY_NAME_LENGTH) {
            System.out.println("Invalid current university name");
            System.out.print("Input student currentUniversity (<200 character): ");
            currentUniversity = scanner.nextLine();
        }
        return currentUniversity;
    }

    public String inputStartYear(String startYear) {
        while (!ValidationUtils.validateInteger(startYear) || startYear.isEmpty() || !ValidationUtils.isValidYearFormat(startYear) || Integer.parseInt(startYear) < Constants.MIN_START_YEAR) {
            System.out.println("Invalid start year for university");
            System.out.print("Input student startYear >=1900: ");
            startYear = scanner.nextLine();
        }
        return startYear;
    }

    public String inputCumulativeGpa(String cumulativeGpa) {
        while (!ValidationUtils.validateDouble(cumulativeGpa) || !(Constants.MIN_GPA <= Double.parseDouble(cumulativeGpa) && Double.parseDouble(cumulativeGpa) <= Constants.MAX_GPA)) {
            System.out.println("Invalid cumulative GPA: ");
            System.out.print("Input student CumulativeGpa (0-10): ");
            cumulativeGpa = scanner.nextLine();
        }
        return cumulativeGpa;
    }
}
