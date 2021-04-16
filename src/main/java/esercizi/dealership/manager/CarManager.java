package esercizi.dealership.manager;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CarManager {
    private String model;
    private String description;
    private String date;
    private String color;
    private String seller;

    public CarManager() {}

    public CarManager(String model, String description, String date, String color, String seller) {
        this.model = model;
        this.description = description;
        this.date = date;
        this.color = color;
        this.seller = seller;
    }

}
