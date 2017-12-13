package codingpizza.com.pizzapedia;

/**
 * Created by giuseppe on 11/12/17.
 */

public class Pizza {
    String name;
    int pizza_img;
    String Description;

    public Pizza(String name, int pizza_img, String description) {
        this.name = name;
        this.pizza_img = pizza_img;
        Description = description;
    }

    public String getName() {
        return name;
    }


    public int getPizza_img() {
        return pizza_img;
    }


    public String getDescription() {
        return Description;
    }

}
