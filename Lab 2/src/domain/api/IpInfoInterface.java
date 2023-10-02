package domain.api;
import java.io.IOException;

public interface IpInfoInterface {
    String getIPGeolocation(String ipAddress) throws IOException;

    String getISPInformation(String ipAddress) throws IOException;

}
