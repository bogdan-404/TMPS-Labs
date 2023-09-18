import java.io.IOException;
import java.util.Random;

public class IpAddressRandomGenerator implements IpAddressGenerator {
    private Random random;

    public IpAddressRandomGenerator() {
        random = new Random();
    }

    @Override
    public String getIpAddress() throws IOException {
        try {
            int[] octets = new int[4];

            for (int i = 0; i < 4; i++) {
                octets[i] = random.nextInt(256);
            }

            return String.format("%d.%d.%d.%d", octets[0], octets[1], octets[2], octets[3]);
        } catch (Exception e) {
            throw new IOException("Error generating random IP address");
        }
    }
}
