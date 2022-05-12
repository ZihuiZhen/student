import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Navigator {
    private static Calendar calendar = Calendar.getInstance();

    public static void welcome() {
        System.out.println(
                "======================\n" +
                        "Welcome to MMKS System\n" +
                        "======================\n" +
                        "--Select your option:\n" +
                        "1.Login\n" +
                        "2.Register\n" +
                        "3.Exit");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (Integer.parseInt(option) == 1) {
            StudentLogin studentLogin = new StudentLogin();
            studentLogin.loginProcess();
        } else if (Integer.parseInt(option) == 2) {
            System.out.println("Do not implement in this stage");
        } else if (Integer.parseInt(option) == 3) { //Referral Management
            System.out.println("Do not implement in this stage");
        } else {
            System.out.println("!!!Check your Input!!!");
            welcome();
        }
    }

    public static void mainMenu(Student student) {
        System.out.println(
                "================================\n" +
                        "Hello " + student.getEmail() + "\n" +
                        "================================\n" +
                        "--What do you want to do? Select your option:\n" +
                        "1.Manage Meal Plan\n" +
                        "2.My Meal Recipe\n" +
                        "3.Referral Management\n" +
                        "4.My Achievement\n" +
                        "5.Log out"
        );
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (Integer.parseInt(option) == 1) {
            orderMenu(student);
        } else if (Integer.parseInt(option) == 2) {
            System.out.println("Do not implement in this stage");
        } else if (Integer.parseInt(option) == 3) {
            System.out.println("Do not implement in this stage");
        } else if (Integer.parseInt(option) == 4) {
            myAchievement(student);
        } else if (Integer.parseInt(option) == 5) {
            System.out.println("Do not implement in this stage");
        } else {
            System.out.println("!!!Check your Input!!!");
            mainMenu(student);
        }
    }

    public static void myAchievement(Student student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--Please enter the period you want to check");
        System.out.println("--Please enter the start time(hint: input should be dd-MM-yyyy):");
        //Check the format of input
        String pattern = "\\d{2}-\\d{2}-\\d{4}"; // regular exp
        String start = sc.next();
        while (!Pattern.matches(pattern, start) || check(start)) {
            System.out.println("!!!Check your start time!!!");
            start = sc.next();
        }
        System.out.println("--Please enter the end time(hint: input should be dd-MM-yyyy):  ");
        String end = sc.next();
        while (!Pattern.matches(pattern, end) || check(end)) {
            System.out.println("!!!Check your end time!!!");
            end = sc.next();
        }
        if (isLegal(start, end)) {
            Achievement achievement = new Achievement();
            achievement.getStudentAchievement(student, start, end);
            System.out.println(
                    "================================\n" +
                            "Hello " + student.getEmail() + "\n" +
                            "================================\n" +
                            "*********My Achievement*********\n" +
                            achievement.toString(start, end));
            System.out.println("--What do you want to do? Select your option:\n 1.Back");
            String option = sc.next();
            if (option.equals("1")) {
                mainMenu(student);
            } else {
                System.out.println("!!!Check your Input!!!");
            }
        } else {
            System.out.println("!!!The end date must be greater than or equal to the start date!!!");
            myAchievement(student);
        }
    }

    private static boolean isLegal(String start, String end) {
        if (check(start) || check(end))
            return false;
        int s = time2Int(start);
        int e = time2Int(end);
        return s <= e;
    }

    private static int time2Int(String time) {
        StringBuilder builder = new StringBuilder();
        String[] strings = time.split("-");
        for (int i = strings.length - 1; i >= 0; i--) {
            builder.append(strings[i]);
        }
        return Integer.parseInt(builder.toString());
    }

    static boolean check(String time) {
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        try {
            sd.setLenient(false);
            sd.parse(time);
        } catch (Exception e) {
            return true;
        }
        return false;
    }


    public static void orderMenu(Student student) {
        System.out.println(
                "================================\n" +
                        "Hello " + student.getEmail() + "\n" +
                        "================================\n" +
                        "********Manage Meal Plan********\n" +
                        "--What do you want to do? Select your option:\n" +
                        "1.Order current Week\n" +
                        "2.View Past 4 Weeks Meal Plan\n" +
                        "3.View Future 4 Weeks Meal Plan\n" +
                        "4.Back\n"
        );
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (Integer.parseInt(option) == 1) {
            orderCurrentWeek(student);
        } else if (Integer.parseInt(option) == 2) {
            viewPastWeekPlanMenu(student);
        } else if (Integer.parseInt(option) == 3) {
            viewFutureWeekPlanMenu(student);
        } else if (Integer.parseInt(option) == 4) {
            Navigator.mainMenu(student);
        } else {
            System.out.println("!!!Check your Input!!!");
            mainMenu(student);
        }
    }

    public static void orderCurrentWeek(Student student) {
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        String title = "Current week";
        displayMealPlanScreen(student, currentWeek, title);
    }

    public static void viewPastWeekPlanMenu(Student student) {
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println(
                "********Manage Meal Plan********\n" +
                        " ******View Past Meal Plan***** \n" +
                        "--What do you want to do? Select your option:\n" +
                        "1.Past 1 week\n" +
                        "2.Past 2 week\n" +
                        "3.Past 3 week\n" +
                        "3.Past 4 week\n" +
                        "4.Back\n"
        );
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (Integer.parseInt(option) == 1) {
            currentWeek = currentWeek - 1;
            String title = "Past 1 week";
            displayMealPlanScreen(student, currentWeek, title);
        } else if (Integer.parseInt(option) == 2) {
            currentWeek = currentWeek - 2;
            String title = "Past 2 week";
            displayMealPlanScreen(student, currentWeek, title);
        } else if (Integer.parseInt(option) == 3) {
            System.out.println("Do not implement in this stage");
        } else if (Integer.parseInt(option) == 4) {
            orderMenu(student);
        } else {
            System.out.println("!!!Check your Input!!!");
            orderMenu(student);
        }
    }

    public static void viewFutureWeekPlanMenu(Student student) {
        Calendar calendar = Calendar.getInstance();
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println(
                "********Manage Meal Plan********\n" +
                        " ******View Future Meal Plan***** \n" +
                        "--What do you want to do? Select your option:\n" +
                        "1.Future 1 week\n" +
                        "2.Future 2 week\n" +
                        "3.Future 3 week\n" +
                        "3.Future 4 week\n" +
                        "4.Back\n"
        );
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (Integer.parseInt(option) == 1) {
            currentWeek = currentWeek + 1;
            String title = "Future 1 week";
            displayMealPlanScreen(student, currentWeek, title);
        } else if (Integer.parseInt(option) == 2) {
            currentWeek = currentWeek + 2;
            String title = "Future 1 week";
            displayMealPlanScreen(student, currentWeek, title);
        } else if (Integer.parseInt(option) == 3) {
            System.out.println("Do not implement in this stage");
        } else if (Integer.parseInt(option) == 4) {
            orderMenu(student);
        } else {
            System.out.println("!!!Check your Input!!!");
            orderMenu(student);
        }
    }

    public static void displayMealPlanScreen(Student student, int currentWeek, String title) {
        MealPlan mealPlan = new MealPlan();
        mealPlan.getWeekPlan(currentWeek);
        String mP = mealPlan.displayMealPlan(student);
        System.out.println(
                "********Manage Meal Plan********\n" +
                        " *****    " + title + "     ***** \n" +
                        mP + "\n" +
                        "--What do you want to do? Select your option:\n" +
                        "1.Back\n"
        );
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (Integer.parseInt(option) == 1) {
            if (currentWeek < calendar.get(Calendar.WEEK_OF_YEAR)) {
                viewPastWeekPlanMenu(student);
            } else if (currentWeek > calendar.get(Calendar.WEEK_OF_YEAR)) {
                viewFutureWeekPlanMenu(student);
            } else {
                orderCurrentWeek(student);
            }

        } else {
            System.out.println("!!!Check your Input!!!");
            displayMealPlanScreen(student, currentWeek, title);
        }
    }
}
