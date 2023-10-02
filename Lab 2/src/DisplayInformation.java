
import java.io.IOException;

import domain.api.IpInfoInterface;
import domain.utils.IpAddressGenerator;

public class DisplayInformation {
    private static DisplayInformation instance;
    private IpAddressGenerator ipAddressGenerator;
    private IpInfoInterface ipInformation;

    private DisplayInformation(IpAddressGenerator ipAddressGenerator, IpInfoInterface ipInformation) {
        this.ipAddressGenerator = ipAddressGenerator;
        this.ipInformation = ipInformation;
    }

    public static DisplayInformation getInstance(IpAddressGenerator ipAddressGenerator, IpInfoInterface ipInformation) {
        if (instance == null) {
            instance = new DisplayInformation(ipAddressGenerator, ipInformation);
        }
        return instance;
    }

    public void run() {
        try {
            String ipAddress = ipAddressGenerator.getIpAddress();
            System.out.println("\nYour IP address is: \n" + ipAddress);
            String ipGeolocation = ipInformation.getIPGeolocation(ipAddress);
            System.out.println("\nYour IP geolocation information: \n" + ipGeolocation);
            String ispInformation = ipInformation.getISPInformation(ipAddress);
            System.out.println("\nYour ISP information: \n" + ispInformation);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public IpAddressGenerator getIpAddressGenerator() {
        return ipAddressGenerator;
    }

    public void setIpAddressGenerator(IpAddressGenerator ipAddressGenerator) {
        this.ipAddressGenerator = ipAddressGenerator;
    }

}