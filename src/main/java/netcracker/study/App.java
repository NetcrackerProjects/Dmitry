package netcracker.study;

import netcracker.study.api.controller.IBootstrap;
import netcracker.study.controller.Bootstrap;

public class App {
    public static void main(String[] args) {
        final IBootstrap bootstrap = new Bootstrap();
        bootstrap.start();
    }
}
