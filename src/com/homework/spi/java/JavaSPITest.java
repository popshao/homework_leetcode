package com.homework.spi.java;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ServiceLoader;

public class JavaSPITest {

    public static void main(String[] args) throws IOException {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        Enumeration<URL> configs = ClassLoader.getSystemResources("META-INF/services/com.homework.spi.java.Robot");
        serviceLoader.forEach(Robot::sayHello);
    }
}
