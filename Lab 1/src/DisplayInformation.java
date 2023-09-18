import java.io.IOException;

public class DisplayInformation {
    private IpAddressGenerator ipAddressGenerator;
    private IpInfoInterface ipInformation;

    public DisplayInformation(IpAddressGenerator ipAddressGenerator, IpInfoInterface ipInformation) {
        this.ipAddressGenerator = ipAddressGenerator;
        this.ipInformation = ipInformation;
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
}