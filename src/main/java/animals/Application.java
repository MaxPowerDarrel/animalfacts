package animals;

import animals.services.CatFactService;
import animals.services.DogFactService;
import animals.ui.UI;

public class Application {
    public static void main(String[] arguments) {
        new UI(new DogFactService(), new CatFactService());
    }
}
