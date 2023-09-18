import java.io.IOException;

public class IpinfoApi extends Api {
    public IpinfoApi(String apiBaseUrl) {
        super(apiBaseUrl);
    }

    public String getIPGeolocation(String ipAddress) throws IOException {
        return this.sendGetRequest(ipAddress + "/geo");
    }

    public String getISPInformation(String ipAddress) throws IOException {
        return this.sendGetRequest(ipAddress + "/org");
    }

    public String getIPAddressDetails(String ipAddress) throws IOException {
        return this.sendGetRequest(ipAddress);
    }




}
