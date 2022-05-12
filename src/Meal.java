import java.util.List;

public class Meal {
    private String name;
    private String ingredient;
    private String stepOfCooking;
    private String allergens;
    private String isVeg;


    public Meal(String name, String ingredient, String stepOfCooking, String allergens, String isVeg) {
        this.name = name;
        this.ingredient = ingredient;
        this.stepOfCooking = stepOfCooking;
        this.allergens = allergens;
        this.isVeg = isVeg;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIngredient() {
        return ingredient;
    }
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
    public String getStepOfCooking() {
        return stepOfCooking;
    }
    public void setStepOfCooking(String stepOfCooking) {
        this.stepOfCooking = stepOfCooking;
    }
    public String getAllergens() {
        return allergens;
    }
    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }
    public String getIsVeg() {
        return isVeg;
    }
    public void setIsVeg(String isVeg) {
        this.isVeg = isVeg;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", stepOfCooking='" + stepOfCooking + '\'' +
                ", allergens='" + allergens + '\'' +
                ", isVeg=" + isVeg +
                '}';
    }
}
