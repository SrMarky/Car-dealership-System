package dealership.manager;

import dealership.settings.Field;

public class FieldManager {
    private final String car;
    private final Field field;

    public FieldManager(String car, Field field) {
        this.field = field;
        this.car = car;
        fields();
    }
    private void fields() {
        int c = car.length();

        //TODO DA FINIRE
        switch (field) {
            case DESCRIPTION_CAR:

                break;
            case MODEL_CAR:
                //TODO
                break;
            case DATE_CAR:
                //TODO
                break;
            case COLOR_CAR:
                //TODO
                break;
            case SELLER_CAR:
                //TODO
            default:
                break;
        }
    }
}
