package netcracker.study.command;

import netcracker.study.api.controller.IBootstrap;
import netcracker.study.controller.Bootstrap;
import netcracker.study.error.InvalidInputException;

import java.io.IOException;

public abstract class AbstractCommand {

    protected Bootstrap bootstrap;

    public abstract void execute() throws InvalidInputException, IOException, ClassNotFoundException;

    public abstract String command();

    public abstract String description();

    public IBootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }
}
