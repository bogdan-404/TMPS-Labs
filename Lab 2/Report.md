# Creational Design Patterns

## Author: Zlatovcen Bogdan

---

## Objectives:

- Study and understand the Creational Design Patterns

- Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.

- Use some creational design patterns for object instantiation in a sample project.

## Implementation

### Singleton Method

Inside the `DisplayInformation` class, we have a static instance of the class. The constructor is private, and we can create an instance of the class only using the `getInstance` method. Thus, we can have only one instance of the class.

```java
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
    ...
```

Inside the Main class, we create the instance of the class `DisplayInformation` using the `getInstance` method:

```java
DisplayInformation displayInformation = DisplayInformation.getInstance(ipGenerator, ipInformation);
```

### Factory Method

In the `IpAddressGeneratorConstructor` class, we have the constructor which takes as a parameter the type of the generator. Then, we have the `getIpAddressGenerator` method which returns the instance of the class depending on the type of the generator:

```java
public IpAddressGeneratorConstructor(String type) {
    if (type.equals("random")) {
        this.ipGenerator = new IpAddressRandomGenerator();
    } else if (type.equals("actual")) {
        this.ipGenerator = new IpifyApi("https://api.ipify.org?format=json");
    } else {
        System.out.println("Invalid choice.");
    }
}
```

### Prototype Method

The `IpAddressGeneratorConstructor` class implements the `Cloneable` interface. Then, we have the `clone` method which returns a copy of the object:

```java
@Override
public IpAddressGeneratorConstructor clone() throws CloneNotSupportedException {
    return (IpAddressGeneratorConstructor) super.clone();
}
```

In the Main class we create an instance of the class `IpAddressGeneratorConstructor` and then we clone it, and the cloned object gets different parameters from the original object:

```java
IpAddressGeneratorConstructor clonedGenerator = ipGenerator.clone();
clonedGenerator.setIpGenerator("actual");
```

## Conclusions

This laboratory work gave a lot of practical knowledge about thecreational design patterns,applying theoretical knowledge in a real project. I also understood the importance of these design patterns and how their use cases. Deoending on different tasks and goals, we can choose the appropriate design pattern.

The program works as expected. The user can choose to generate randomly the IP Address or to get the actual IP Address. Then, the user gets information about the IP Address.
