import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MealPlan {
    private List<Meal> meals;
    private List<Meal> weekPlan;
    private final File MEAL_FILE = new File("src\\database\\meal.csv");
    private final File MEAL_PLAN_FILE = new File("src\\database\\mealPlan.csv");

    public MealPlan() {
        String line = "";
        List<Meal> allMeal = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(MEAL_FILE));
            while ((line = reader.readLine()) !=null){
                String[] row = line.split(",");
                Meal meal = new Meal(row[0],row[1],row[2],row[3],row[4]);
                allMeal.add(meal);
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("File write unSuccess");
        }
        meals = allMeal;
    }

    public void getWeekPlan(int week){
        String line = "";
        List<Meal> wP = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(MEAL_PLAN_FILE));
            while ((line = reader.readLine()) !=null){
                String[] row = line.split(",");
                String theWeek = row[0];
                if(theWeek.equals(week+"")){
                    String[] mealName = row[1].split(" ");
                    for (String m : mealName){
                        for (Meal M : meals){
                            if(M.getName().equals(m)){
                                wP.add(M);
                            }
                        }
                    }
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("File write unSuccess");
        }

        weekPlan = wP;
    }

    public String displayMealPlan(Student student){
        int num = 1;
        int i = 0;
        String output = "";
        for (Meal m : weekPlan){
            if(i<3){  //just display the first three meal Ingredient and -Step of Cooking:
                output+="-------------------------\n"+
                        "-"+num+": "+ m.getName()+"\n"+
                        "-Ingredient:\n"+
                        m.getIngredient()+"\n"+
                        "-Step of Cooking:\n"+
                        m.getStepOfCooking()+"\n";
                i++;
            }
            else {
                output+="-------------------------\n"+
                        "-"+num+": "+ m.getName()+"\n";
            }
            // If there is allergenic which student has, there will display the Warning
            for (String ag: student.getAllergens()){
                if (m.getAllergens().toLowerCase().contains(ag.toLowerCase())){
                    output+="-Warning: There is "+ag+" in this meal\n";
                }
            }
            output+="------------------------\n";
            num++;
        }
        return output;
    }



    public List<Meal> getMeals() {
        return meals;
    }
    public List<Meal> getWeekPlan() {
        return weekPlan;
    }

}
