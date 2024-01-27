import java.util.*;

public class StudentsService {
    public static Students[] arrStudents = null;
    public static Scanner scanner = new Scanner(System.in);
    private InputInfo inputInfo = new InputInfo();

    public void add() {
        System.out.print("Input numstudent: ");
        String numstudent = scanner.nextLine();

        while (!ValidationUtils.validateInteger(numstudent)) {
            System.out.print("Invalid numstudent for a person re-enter: ");
            numstudent = scanner.nextLine();
        }
        arrStudents = new Students[Integer.parseInt(numstudent)];

        for (int i = 0; i < Integer.parseInt(numstudent); i++) {
            Students students = new Students();
            System.out.println("student: " + (i + 1));
            students.setId(i + 1);
            System.out.println("person id: " + (i + 1));

            System.out.print("Input student name: ");
            students.setName(inputInfo.inputName(scanner.nextLine()));

            System.out.print("Input student address: ");
            students.setAddress(inputInfo.inputAddress(scanner.nextLine()));

            System.out.print("Input student birthDateStr (yyyy-MM-dd): ");
            students.setBirthDate(ValidationUtils.parseDate(inputInfo.inputBirthDateStr(scanner.nextLine())));

            System.out.print("Input student height: ");
            students.setHeight(Double.parseDouble(inputInfo.inputHeight(scanner.nextLine())));

            System.out.print("Input student weight: ");
            students.setWeight(Double.parseDouble(inputInfo.inputWeight(scanner.nextLine())));

            System.out.print("Input student studentId: ");
            students.setStudentId(inputInfo.inputStudentId(scanner.nextLine()));

            System.out.print("Input student currentUniversity: ");
            students.setCurrentUniversity(inputInfo.inputCurrentUniversity(scanner.nextLine()));

            System.out.print("Input student startYear: ");
            students.setStartYear(inputInfo.inputStartYear(scanner.nextLine()));

            System.out.print("Input student CumulativeGpa: ");
            students.setCumulativeGpa(Double.parseDouble(inputInfo.inputCumulativeGpa(scanner.nextLine())));

            double averageScore = ValidationUtils.calculateAverageScore(students);
            students.setAcademicPerformance(ValidationUtils.calculateAcademicPerformance(averageScore));

            arrStudents[i] = students;
        }

        if (arrStudents != null) {
            for (int i = 0; i < Integer.parseInt(numstudent); i++) {
                System.out.println(arrStudents[i].toString());
            }
        }
    }
    public Students searchStudentForId() {
        System.out.print("Enter personId to search: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        if (arrStudents != null) {
            for (Students students : arrStudents) {
                if (students != null && Objects.equals(students.getId(), id)) {
                    return students;
                }
            }
            System.out.println("Person " + id + " not found");
        } else {
            System.out.println("Enter data before searching");
        }
        return null;
    }

    public void updateStudentForId() {
        Students student = searchStudentForId();
        String choose = null;
        if (student != null) {
            System.out.println(student);
            System.out.println("-----------menuUpdate------------");
            System.out.println("1. Update student name ");
            System.out.println("2. Update student address ");
            System.out.println("3. Update student birthDateStr  ");
            System.out.println("4. Update student height ");
            System.out.println("5. Update student weight  ");
            System.out.println("6. Update student studentId ");
            System.out.println("7. Update student currentUniversity ");
            System.out.println("8. Update student startYear ");
            System.out.println("9. Update student CumulativeGpa ");
            System.out.println("---------------------------");
            System.out.print("Please choose: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.print("Input student name: ");
                    student.setName(inputInfo.inputName(scanner.nextLine()));
                    break;
                case "2":
                    System.out.print("Input student address: ");
                    student.setAddress(inputInfo.inputAddress(scanner.nextLine()));
                    break;
                case "3":
                    System.out.print("Input student birthDateStr (yyyy-MM-dd): ");
                    student.setBirthDate(ValidationUtils.parseDate(inputInfo.inputBirthDateStr(scanner.nextLine())));
                    break;
                case "4":
                    System.out.print("Input student height: ");
                    student.setHeight(Double.parseDouble(inputInfo.inputHeight(scanner.nextLine())));
                    break;
                case "5":
                    System.out.print("Input student weight: ");
                    student.setWeight(Double.parseDouble(inputInfo.inputWeight(scanner.nextLine())));
                    break;
                case "6":
                    System.out.print("Input student studentId: ");
                    student.setStudentId(inputInfo.inputStudentId(scanner.nextLine()));
                    break;
                case "7":
                    System.out.print("Input student currentUniversity: ");
                    student.setCurrentUniversity(inputInfo.inputCurrentUniversity(scanner.nextLine()));
                    break;
                case "8":
                    System.out.print("Input student startYear: ");
                    student.setStartYear(inputInfo.inputStartYear(scanner.nextLine()));
                    break;
                case "9":
                    System.out.print("Input student CumulativeGpa: ");
                    student.setCumulativeGpa(Double.parseDouble(inputInfo.inputCumulativeGpa(scanner.nextLine())));
                    break;
                default:
                    System.out.print("invalid! please choose action in below menu:");
                    break;
            }
            double averageScore = ValidationUtils.calculateAverageScore(student);
            student.setAcademicPerformance(ValidationUtils.calculateAcademicPerformance(averageScore));
        }
        System.out.println("student after update: ");
        System.out.print(student);
    }

    public void deleteStudentForId() {
        Students studentDelete = searchStudentForId();
        if (studentDelete != null) {
            int indexToDelete = -1;

            // Tìm vị trí của sinh viên cần xóa trong mảng
            for (int i = 0; i < arrStudents.length; i++) {
                if (arrStudents[i] != null && arrStudents[i].equals(studentDelete)) {
                    indexToDelete = i;
                    break;
                }
            }
            if (indexToDelete != -1) {
                for (int i = indexToDelete; i < arrStudents.length - 1; i++) {
                    arrStudents[i] = arrStudents[i + 1];
                }

                // Kiểm tra trường hợp mảng trống sau khi xoá
                if (arrStudents.length > 1) {
                    arrStudents = Arrays.copyOf(arrStudents, arrStudents.length - 1);
                } else {
                    arrStudents = null;
                }

                System.out.println("Deleted student. Updated array:");

                // In thông tin các sinh viên còn lại sau khi xoá
                if (arrStudents != null) {
                    for (Students s : arrStudents) {
                        if (s != null) System.out.println(s);
                    }
                }
            } else {
                System.out.println("Error: Student not found in the array.");
            }
        } else {
            System.out.println("Error: Student for deletion not found.");
        }
    }

    public void displayPercentageByAcademicPerformance() {
        if (arrStudents != null) {
            // Đếm số lượng sinh viên theo từng học lực
            Map<AcademicPerformance, Integer> academicPerformanceCounts = new HashMap<>();
            for (Students student : arrStudents) {
                academicPerformanceCounts.merge(student.getAcademicPerformance(), 1, Integer::sum);
            }

            // Tính % và hiển thị
            System.out.println("Percentage of student's academic performance:");
            for (Map.Entry<AcademicPerformance, Integer> entry : academicPerformanceCounts.entrySet()) {
                AcademicPerformance academicPerformance = entry.getKey();
                int count = entry.getValue();
                double percentage = (double) count / arrStudents.length * 100.0;

                System.out.println(academicPerformance + ": " + ValidationUtils.formatPercentage(percentage));
            }
        } else {
            System.out.println("Student list is empty.");
        }
    }

    public void displayPercentageByCumulativeGpaRange() {

        if (arrStudents != null) {
            // Đếm số lượng sinh viên theo từng khoảng CumulativeGpa
            Map<Double, Integer> cumulativeGpaCounts = new HashMap<>();
            for (Students student : arrStudents) {
                double cumulativeGpa = student.getCumulativeGpa();
                cumulativeGpaCounts.merge(cumulativeGpa, 1, Integer::sum);
            }

            // Tính % và hiển thị
            System.out.println("Percentage of student's CumulativeGpa:");
            for (Map.Entry<Double, Integer> entry : cumulativeGpaCounts.entrySet()) {
                double cumulativeGpa = entry.getKey();
                int count = entry.getValue();
                double percentage = (double) count / arrStudents.length * 100.0;

                System.out.println(cumulativeGpa + ": " + ValidationUtils.formatPercentage(percentage));
            }
        } else {
            System.out.println("Student list is empty.");
        }
    }


    public void searchStudentForAcademicPerformance() {
        System.out.print("Input academic performance to search: ");
        String academicPerformanceToSearch = scanner.nextLine();
        if (arrStudents != null) {
            boolean found = false;  // Sử dụng biến này để kiểm tra xem có sinh viên nào thỏa mãn không
            for (Students students : arrStudents) {
                AcademicPerformance academicPerformance = students.getAcademicPerformance();
                if (academicPerformanceToSearch.equalsIgnoreCase(academicPerformance.toString())) {
                    System.out.println(students);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No students found with academic performance: " + academicPerformanceToSearch);
            }
        } else {
            System.out.println("Enter data before searching");
        }
    }
}
