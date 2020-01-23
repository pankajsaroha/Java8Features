package org.java.design.patterns;

/* Structural Design Pattern */

public class Proxy {

    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutorProxy("Pankaj", "saroha");
        try {
            executor.runCommand("netsh");
            executor.runCommand("ls -lrt");
            executor.runCommand("rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception message : " + e.getMessage());
        }
    }
}

interface CommandExecutor {
    public void runCommand(String cmd) throws Exception;
}

class CommandExecutorImpl implements CommandExecutor {

    @Override
    public void runCommand(String cmd) throws Exception {
        // some heavy implementation
        Runtime.getRuntime().exec(cmd);
        System.out.println("'" + cmd + "' command executed.");
    }

}

class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String user, String pwd) {
        if ("Pankaj".equals(user) && "saroha".equals(pwd)) {
            isAdmin = true;
        }
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if (isAdmin) {
            executor.runCommand(cmd);
        } else {
            if (cmd.trim().startsWith("rm")) {
                throw new Exception("rm command is not allowed for non-admin users.");
            } else {
                executor.runCommand(cmd);
            }
        }
    }

}