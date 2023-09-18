import java.io.IOException;

public class IpAddressGeneratorConstructor implements IpAddressGenerator {
    private IpAddressGenerator ipGenerator;

    public IpAddressGeneratorConstructor(IpAddressGenerator ipGenerator) {
        this.ipGenerator = ipGenerator;
    }

    @Override
    public String getIpAddress() throws IOException {
        return ipGenerator.getIpAddress();
    }
}

