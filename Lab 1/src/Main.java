import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            var ipifyApi = new IpifyApi("https://api.ipify.org?format=json");
            var ip = ipifyApi.getIpAddress();
            System.out.println(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        var ipinfoApi = new IpinfoApi("https://ipinfo.io/");
        var ip = "158.239.124.21";
        try {
            var ipGeolocation = ipinfoApi.getIPGeolocation(ip);
            System.out.println(ipGeolocation);
            var ispInformation = ipinfoApi.getISPInformation(ip);
            System.out.println(ispInformation);
            var ipAddressDetails = ipinfoApi.getIPAddressDetails(ip);
            System.out.println(ipAddressDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
