package com.archiver.command;

import com.archiver.ConsoleHelper;
import com.archiver.ZipFileManager;
import java.io.IOException;

public class ZipExtractCommand implements ZipCommand {

  @Override
  public void execute() throws IOException {
      ConsoleHelper.writeMessage("Archive extracting.");
      ZipFileManager zipFileManager = getZipFileManager();
      zipFileManager.extractAll();
      ConsoleHelper.writeMessage("Archive successfully has been extracted.");
  }
}
