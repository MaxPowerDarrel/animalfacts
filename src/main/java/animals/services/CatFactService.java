package animals.services;

import animals.domain.CatFact;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CatFactService extends AnimalFactService {

    public CatFactService() {
        super("https://catfact.ninja/fact");
    }

    @Override
    protected String getFactFromString(String fact) throws IOException {
        CatFact catFact = new ObjectMapper().readValue(fact, CatFact.class);
        return catFact.getFact();
    }
}
