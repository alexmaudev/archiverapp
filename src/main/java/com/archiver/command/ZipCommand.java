package com.archiver.command;

import com.archiver.ConsoleHelper;
import com.archiver.ZipFileManager;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface ZipCommand extends Command {

  default ZipFileManager getZipFileManager() throws IOException {
    ConsoleHelper.writeMessage("Please enter path where to archive with the full archive name:");
    Path zipPath = Paths.get(ConsoleHelper.readString());
    ZipFileManager zipFileManager = new ZipFileManager();
    zipFileManager.setZipFile(zipPath);
    return zipFileManager;
  }
}
