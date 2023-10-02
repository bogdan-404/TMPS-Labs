package domain.utils;

import java.io.IOException;
import domain.api.*;

public class IpAddressGeneratorConstructor implements IpAddressGenerator, Cloneable {
    private IpAddressGenerator ipGenerator;

    public IpAddressGeneratorConstructor(String type) {
        if (type.equals("random")) {
            this.ipGenerator = new IpAddressRandomGenerator();
        } else if (type.equals("actual")) {
            this.ipGenerator = new IpifyApi("https://api.ipify.org?format=json");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    @Override
    public String getIpAddress() throws IOException {
        return ipGenerator.getIpAddress();
    }

    public IpAddressGenerator getIpGenerator() {
        return ipGenerator;
    }

    public void setIpGenerator(String type) {
        if (type.equals("random")) {
            this.ipGenerator = new IpAddressRandomGenerator();
        } else if (type.equals("actual")) {
            this.ipGenerator = new IpifyApi("https://api.ipify.org?format=json");
        }
    }

    @Override
    public IpAddressGeneratorConstructor clone() throws CloneNotSupportedException {
        return (IpAddressGeneratorConstructor) super.clone();
    }
}
