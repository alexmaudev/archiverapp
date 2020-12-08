import static org.junit.jupiter.api.Assertions.assertTrue;

import com.archiver.filemanager.ZipFileManager;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.zeroturnaround.zip.ZipUtil;

class ZipFileManagerTest {

  @TempDir
  Path tempDir;
  
  Path testArchive = Paths.get(String.join(File.separator, "src", "test", "resources", "archive.zip"));

  Path testArchiveToCompare = Paths.get(String.join(File.separator,
      "src", "test", "resources", "archiveToCompare.zip"));

  StringBuilder testForArchivation = new StringBuilder();
  {
    testForArchivation.append(String.join(File.separator, "src", "test", "resources", "test1.txt"))
        .append(" ")
        .append(String.join(File.separator, "src", "test", "resources", "test2.txt"))
        .append(" ")
        .append(String.join(File.separator, "src", "test", "resources", "test3.txt"))
        .append(" ")
        .append(String.join(File.separator, "src", "test", "resources", "test"));
  }

  private final ZipFileManager zipFileManager = new ZipFileManager();

  @Test
  void zipExtractTest() throws Exception {
      zipFileManager.setZipFile(testArchive);
      zipFileManager.extractAll(tempDir);
      File tmpFile = new File(String.valueOf(tempDir.resolve("test1.txt")));
      assertTrue(tmpFile.exists());
  }

  @Test
  void zipCreateTest() throws Exception {
      zipFileManager.setZipFile(Paths
          .get(String.join(File.separator, tempDir.toString(), "archive.zip")));
      zipFileManager.createZip(testForArchivation.toString());
      File tmpFile = new File(String.valueOf(tempDir.resolve("archive.zip")));
      File fileToCompare = new File(testArchiveToCompare.toString());
      assertTrue(tmpFile.exists());
      assertTrue(ZipUtil.archiveEquals(tmpFile, fileToCompare));
  }
}
