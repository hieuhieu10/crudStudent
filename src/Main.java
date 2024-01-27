import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String chooseArr = null;
        StudentsService studentsService = new StudentsService();
        StudentsServiceDynamic studentsServiceDynamic = new StudentsServiceDynamic();
        chooseArr();
        while (true) {
            chooseArr = scanner.nextLine();
            boolean exit = false;
            switch (chooseArr) {
                case "1":
                    String choose = null;
                    showMenu();
                    while (true) {
                        choose = scanner.nextLine();
                        switch (choose) {
                            case "1":
                                studentsService.add();
                                break;
                            case "2":
                                System.out.println(studentsService.searchStudentForId());
                                break;
                            case "3":
                                studentsService.updateStudentForId();
                                break;
                            case "4":
                                studentsService.deleteStudentForId();
                                break;
                            case "5":
                                studentsService.displayPercentageByAcademicPerformance();
                                break;
                            case "6":
                                studentsService.displayPercentageByCumulativeGpaRange();
                                break;
                            case "7":
                                studentsService.searchStudentForAcademicPerformance();
                                break;
                            case "0":
                                System.out.println("exited!");
                                exit = true;
                                break;
                            default:
                                System.out.print("invalid! please choose action in below menu:");
                                break;
                        }
                        if (exit) {
                            break;
                        }
                        System.out.println();
                        // show menu
                        showMenu();
                    }
                    break;
                case "2":
                    String chooseDynamic = null;
                    showMenu();
                    while (true) {
                        chooseDynamic = scanner.nextLine();
                        switch (chooseDynamic) {
                            case "1":
                                studentsServiceDynamic.add();
                                break;
                            case "2":
                                System.out.println(studentsServiceDynamic.searchStudentForId());
                                break;
                            case "3":
                                studentsServiceDynamic.updateStudentForId();
                                break;
                            case "4":
                                studentsServiceDynamic.deleteStudentForId();
                                break;
                            case "5":
                                studentsServiceDynamic.displayPercentageByAcademicPerformance();
                                break;
                            case "6":
                                studentsServiceDynamic.displayPercentageByCumulativeGpaRange();
                                break;
                            case "7":
                                studentsServiceDynamic.searchStudentForAcademicPerformance();
                                break;
                            case "0":
                                studentsServiceDynamic.saveStudentsToFile();
                                System.out.println("exited!");
                                exit = true;
                                break;
                            default:
                                System.out.print("invalid! please choose action in below menu:");
                                break;
                        }

                        if (exit) {
                            break;
                        }
                        showMenu();
                    }
                        break;
                        case "0":
                            System.out.println("exited!");
                            exit = true;
                            break;
                        default:
                            System.out.println("invalid! please choose action in below menuArr:");
                            break;
                    }
                    if (exit) {
                        break;
                    }
                    chooseArr();
            }
        }

        public static void chooseArr () {
            System.out.println("-----------menuArr------------");
            System.out.println("1. Static arrays.");
            System.out.println("2. Dynamic arrays.");
            System.out.println("0. exit.");
            System.out.println("------------------------------");
            System.out.print("Please choose: ");
        }

        public static void showMenu () {
            System.out.println("-----------menu------------");
            System.out.println("1. Add student.");
            System.out.println("2. Search student by id.");
            System.out.println("3. Update student by id.");
            System.out.println("4. Delete student by id.");
            System.out.println("5. Sort students decrease by academic performance.");
            System.out.println("6. CumulativeGpa score percentage of students.");
            System.out.println("7. Search students by academicPerformance.");
            System.out.println("0. exit.");
            System.out.println("---------------------------");
            System.out.print("Please choose: ");
        }
    }