package com.archiver.command;

import com.archiver.ConsoleHelper;
import com.archiver.ZipFileManager;
import java.io.IOException;

public class ZipCreateCommand implements ZipCommand {

  @Override
  public void execute() throws IOException {
    ConsoleHelper.writeMessage("Archive creation.");
    ZipFileManager zipFileManager = getZipFileManager();
    ConsoleHelper.writeMessage("Please insert file names or paths for archivation " +
        "separated by space(space in path or file name not allowed):");
    zipFileManager.createZip(ConsoleHelper.readString());
    ConsoleHelper.writeMessage("Archive successfully has been created.");
  }
}
