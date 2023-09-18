import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            var ipAddressRandomGenerator = new IpAddressRandomGenerator();
            var ip = ipAddressRandomGenerator.getIpAddress();
            System.out.println(ip);
        } catch (IOException errorRandom) {
            errorRandom.printStackTrace();
        }
        try {
            var ipifyApi = new IpifyApi("https://api.ipify.org?format=json");
            var ip = ipifyApi.getIpAddress();
            System.out.println(ip);
        } catch (IOException errorIpify) {
            errorIpify.printStackTrace();
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
        } catch (IOException errorIpinfo) {
            errorIpinfo.printStackTrace();
        }
    }
}
