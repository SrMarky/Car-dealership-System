package dealership.object;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarObject {
    private String model;
    private String description;
    private String date;
    private String color;
    private String seller;

    public CarObject() {
    }

    public CarObject(String model, String description, String date, String color, String seller) {
        this.model = model;
        this.description = description;
        this.date = date;
        this.color = color;
        this.seller = seller;
    }

}
