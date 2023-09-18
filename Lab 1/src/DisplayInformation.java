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
            System.out.println("Your IP address is: \n" + ipAddress + "\n");
            String ipGeolocation = ipInformation.getIPGeolocation(ipAddress);
            System.out.println("Your IP geolocation information: \n" + ipGeolocation + "\n");
            String ispInformation = ipInformation.getISPInformation(ipAddress);
            System.out.println("Your ISP information: \n" + ispInformation + "\n");
            String ipAddressDetails = ipInformation.getIPAddressDetails(ipAddress);
            System.out.println("Your IP address general details: \n" + ipAddressDetails + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}