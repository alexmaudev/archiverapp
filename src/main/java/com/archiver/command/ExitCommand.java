package com.archiver.command;

import com.archiver.console.ConsoleHelper;

public class ExitCommand implements Command {

  @Override
  public void execute() {
    ConsoleHelper.writeMessage("Goodbye");
  }
}
