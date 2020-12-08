package com.archiver.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;
import lombok.Data;
import org.zeroturnaround.zip.ZipUtil;
import org.zeroturnaround.zip.commons.FileUtilsV2_2;

@Data
public class ZipFileManager {

  /**
   * Path of the archive where to archive or to extract.
   */
  private Path zipFile;

  /**
   * Compresses the given directories and all its sub-directories and files into a ZIP file.
   * Put all files from input into a temp directory and then compresses it.
   * The ZIP file must not be a directory and its parent directory must exist.
   * Will not include the root directory name in the archive.
   *
   * @param input
   *          directories and files have to be archived separated by space
   *          (can not include space symbol).
   */
  public void createZip(String input) throws IOException {
    Deque<Path> sourcePaths = Arrays.stream(input.split(" "))
        .map(Paths::get)
        .collect(Collectors.toCollection(ArrayDeque::new));

    Path tempDir = Files.createTempDirectory("tempDir");
    while (!sourcePaths.isEmpty()) {
      Path sourcePath = sourcePaths.pop();
      File source = new File(sourcePath.toString());
      File target;
      if (!Files.isDirectory(sourcePath)) {
        target = new File(tempDir.toString());
        FileUtilsV2_2.copyFileToDirectory(source, target);
      } else {
        target = new File(tempDir.toString() + File.separator + source.getName());
        FileUtilsV2_2.copyDirectory(source, target);
      }
    }
    ZipUtil.pack(new File(tempDir.toString() + File.separator),
        new File(zipFile.toString()));
  }

  /**
   * Unpacks a ZIP file to the given directory.
   * Method used only for tests.
   * The ZIP file will be first renamed (using a temporary name).
   * After the extraction it will not be deleted.
   *
   * @param outputFolder
   *          folder where zip file has to be unpacked.
   */
  public void extractAll(Path outputFolder) {
    ZipUtil.unpack(new File(zipFile.toString()), new File(outputFolder.toString()));
  }

  /**
   * Unpacks a ZIP file to its own location.
   * The ZIP file will be first renamed (using a temporary name). After the
   * extraction it will not be deleted.
   */

  public void extractAll() {
    ZipUtil.unpack(new File(zipFile.toString()), new File(zipFile.getParent().toString()));
  }
}
