package domain.api;

import java.io.IOException;

public class IpinfoApi extends Api implements IpInfoInterface {
    public IpinfoApi(String apiBaseUrl) {
        super(apiBaseUrl);
    }

    @Override
    public String getIPGeolocation(String ipAddress) throws IOException {
        return this.sendGetRequest(ipAddress + "/geo");
    }

    @Override
    public String getISPInformation(String ipAddress) throws IOException {
        return this.sendGetRequest(ipAddress + "/org");
    }
}
