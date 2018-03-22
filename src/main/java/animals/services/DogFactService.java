package animals.services;

import animals.domain.DogFact;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class DogFactService extends AnimalFactService {

    public DogFactService() {
        super("https://dog-api.kinduff.com/api/facts");
    }

    @Override
    protected String getFactFromString(String fact) throws IOException {
        return new ObjectMapper().readValue(fact, DogFact.class).getFacts()[0];
    }
}
