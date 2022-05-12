import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentLogin {
    private Student student = null;
    private final File STUDENT_FILE = new File("src\\database\\student.csv");
    private List<String[]> allStudent = new ArrayList<>();


    public void loginProcess(){
        readStudentDB();
        Scanner sc = new Scanner(System.in);
        System.out.println("--Enter your monash email (hint: @monash.edu or @student.monash.edu):");
        String email = sc.next();
        System.out.println("--Enter your password:");
        String pd = sc.next();

        for (String[] row: allStudent){
            if (row[0].equals(email) && row[1].equals(pd)){
                student = new Student(row[0],row[1],row[2],row[3],row[4],Integer.parseInt(row[5]),row[6].split("/"),row[7]);
            }
        }

        if(student == null){
            System.out.println("!!!Check your email or password!!!");
            Navigator.welcome();
        }else {
            System.out.println("~~~Login successful~~~~");
            Navigator.mainMenu(student);
        }
    }


    public void readStudentDB(){
        String line = "";
        List<String[]> Students = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(STUDENT_FILE));
            while ((line = reader.readLine()) !=null){
                String[] row = line.split(",");
                Students.add(row);
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("File write unsucces");
        }
        allStudent = Students;
    }

}
