package com.archiver;

import com.archiver.command.Command;
import com.archiver.command.ExitCommand;
import com.archiver.command.ZipCreateCommand;
import com.archiver.command.ZipExtractCommand;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

public class CommandExecutor {

  private static final Map<Operation, Command> allKnownCommandsMap = new EnumMap<>(Operation.class);

  private CommandExecutor() {
  }

  static {
    allKnownCommandsMap.put(Operation.CREATE, new ZipCreateCommand());
    allKnownCommandsMap.put(Operation.EXTRACT, new ZipExtractCommand());
    allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
  }

  public static void execute(Operation operation) throws IOException {
    allKnownCommandsMap.get(operation).execute();
  }
}
