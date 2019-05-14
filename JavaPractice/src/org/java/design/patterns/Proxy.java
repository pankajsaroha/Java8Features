package org.java.design.patterns;

interface CommandExecutor {
	public void runCommand(String cmd) throws Exception; 
}

class CommandExecutorImpl implements CommandExecutor {

	@Override
	public void runCommand(String cmd) throws Exception {
		Runtime.getRuntime().exec(cmd);
	}
	
}

class CommandExecutorProxy implements CommandExecutor {
	
	private boolean isAdmin;
	private CommandExecutor executor;
	
	public CommandExecutorProxy(String user, String pass) {
		if("Pankaj".equalsIgnoreCase(user) || "password".equalsIgnoreCase(pass)) {
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
				throw new Exception("Only admin can execute this command");
			} else {
				executor.runCommand(cmd);
			}
		}
	}
}

public class Proxy {

	public static void main(String args[]) {
		CommandExecutor ex = new CommandExecutorProxy("pankaj", "password");
		try {
			ex.runCommand("netsh");
			ex.runCommand("dir");
			ex.runCommand("rm -rf abc.pdf");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
