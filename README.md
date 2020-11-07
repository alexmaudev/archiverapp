# Archiver Application

The app has been manually tested on Ubuntu 20.04.1 LTS and Windows 10 Home v. 2004

How to build the app?
Input from terminal or cmd commands below:
1) cd /../ArchiverApp (ex. /home/user/Documents/ArchiverApp)
2) mvn clean install

The target folder with executing jar file will be generated.

How to run the app?
Input from terminal or cmd commands below:

3) cd ./target (if you are still in ArchiverApp directory) or 
   cd /../ArchiverApp/target (ex. /home/user/Documents/ArchiverApp/target)
4) java -jar ArchiverApp-1.0.jar

In ArchiverApp you can archive files/directories or extract it to archive location.

For archivation first you need input archive location and name. (ex. /home/user/Documents/archive.zip)

After that please input file names with location and directories separated by space. 
(Space symbol in file/directory name not allowed ex. /home/user/Documents/Dir /home/user/Documents/test1.txt)

For extracting just input archive name with location. (ex. /home/user/Documents/archive.zip)
