package com.archiver;

import com.archiver.command.CommandExecutor;
import com.archiver.command.Operation;
import com.archiver.console.ConsoleHelper;
import java.io.IOException;

public class Archiver {

  public static void main(String[] args) {
    Operation operation = null;
    do {
      try {
        operation = askOperation();
        CommandExecutor.execute(operation);
      }  catch (IOException e) {
        ConsoleHelper.writeMessage("Error. Please check entered data.");
      }
    } while (operation != Operation.EXIT);
  }

  public static Operation askOperation() throws IOException {
    ConsoleHelper.writeMessage("Please choose the operation:");
    ConsoleHelper.writeMessage(String.format("\t %d - pack files to archive", Operation.CREATE.ordinal()));
    ConsoleHelper.writeMessage(String.format("\t %d - extract archive", Operation.EXTRACT.ordinal()));
    ConsoleHelper.writeMessage(String.format("\t %d - exit", Operation.EXIT.ordinal()));
    return Operation.values()[ConsoleHelper.readInt()];
  }
}
