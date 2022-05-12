import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Achievement {
    private int numOfDiscount = 0; //0
    private int numOfReferral = 0; //1
    private int numOfMeal = 0; //2
    private final String ACHIEVEMENT_FILE = "src\\database\\achievement.csv";

    public void getStudentAchievement(Student student, String start, String end) {
        String line = "";
        Date startTime = formatDate(start);
        Date endTime = formatDate(end);

        try{
            BufferedReader reader = new BufferedReader(new FileReader(ACHIEVEMENT_FILE));
            while ((line = reader.readLine()) !=null){
                String[] row = line.split(",");
                if (row[0].equals(student.getEmail())){
                   Date time = formatDate(row[2]);
                    if (time.compareTo(startTime)>=0 && time.compareTo(endTime)<=0){
                        if (row[1].equals("0")){
                            numOfDiscount++;
                        }else if (row[1].equals("1")){
                            numOfReferral++;
                        }else if (row[1].equals("2")){
                            numOfMeal++;
                        }
                    }
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("File write unSuccess");
        }
    }

    public Date formatDate(String time){
        Date date = null;
        try{
            date = new SimpleDateFormat("dd-MM-yyyy").parse(time);
        } catch (ParseException e) {
            System.out.println("Format the date unSuccessful");
        }
        return date;
    }

    public String toString(String start, String end) {
        return
            "From "+start +" To "+ end+"\n"+
            "The number/amount of discounts you have received: "+numOfDiscount+"\n"+
            "The number of referrals you have accrued: "+numOfReferral+"\n"+
            "The number of meals the you have prepared: "+numOfMeal+"\n"+
            "------------------------------------------------\n";
    }

    public int getNumOfDiscount() {
        return numOfDiscount;
    }
    public void setNumOfDiscount(int numOfDiscount) {
        this.numOfDiscount = numOfDiscount;
    }
    public int getNumOfReferral() {
        return numOfReferral;
    }
    public void setNumOfReferral(int numOfReferral) {
        this.numOfReferral = numOfReferral;
    }
    public int getNumOfMeal() {
        return numOfMeal;
    }
    public void setNumOfMeal(int numOfMeal) {
        this.numOfMeal = numOfMeal;
    }
}
