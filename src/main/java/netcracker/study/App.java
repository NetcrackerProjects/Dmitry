package netcracker.study;

import netcracker.study.api.controller.Bootstrap;
import netcracker.study.controller.BootstrapImpl;

public class App {
    public static void main(String[] args) {
        final Bootstrap bootstrap = new BootstrapImpl();
        bootstrap.start();
    }
}
