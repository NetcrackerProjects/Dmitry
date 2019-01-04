package netcracker.study.command;

import netcracker.study.api.controller.Bootstrap;
import netcracker.study.controller.BootstrapImpl;
import netcracker.study.error.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public abstract class AbstractCommand {

    protected BootstrapImpl bootstrap;

    public abstract void execute() throws InvalidInputException, IOException, ClassNotFoundException;

    public abstract String command();

    public abstract String description();

    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(BootstrapImpl bootstrap) {
        this.bootstrap = bootstrap;
    }

    private String nextLine(Scanner scanner) {
        return scanner.nextLine();
    }

    private Integer nextInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return null;
        }
    }
}
