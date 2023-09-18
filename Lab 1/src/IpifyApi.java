import java.io.IOException;

public class IpifyApi extends Api implements IpAddressGenerator {
    public IpifyApi(String apiBaseUrl) {
        super(apiBaseUrl);
    }

    @Override
    public String getIpAddress() throws IOException {
        String response = this.sendGetRequest(null);
        return response.toString();
    }
}
