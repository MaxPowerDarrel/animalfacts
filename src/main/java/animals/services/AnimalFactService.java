package animals.services;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class AnimalFactService implements AnimalFact {

    private final String url;

    protected AnimalFactService(String url) {
        this.url = url;
    }

    @Override
    public String getFact() {
        try {
            URL urlObject = new URL(url);
            HttpURLConnection connection = (HttpsURLConnection)urlObject.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader data = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while((inputLine = data.readLine()) != null){
                response.append(inputLine);
            }
            data.close();
            return getFactFromString(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "Error getting your fact :(";
        }
    }

    abstract protected String getFactFromString(String fact) throws IOException;
}
