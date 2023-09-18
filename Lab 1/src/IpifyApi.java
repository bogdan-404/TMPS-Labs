import java.io.IOException;

public class IpifyApi extends Api {
    public IpifyApi(String apiBaseUrl) {
        super(apiBaseUrl);
    }

    public String getIpAddress() throws IOException {
        String response = this.sendGetRequest(null);
        return response.toString();
    }

}

