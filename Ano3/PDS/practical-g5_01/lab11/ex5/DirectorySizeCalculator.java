package lab11.ex5;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;


public class DirectorySizeCalculator {
    public AtomicLong Walker(String path, boolean recursiveFlag){
        Path dir;

        try{
            dir = Paths.get(path);
            AtomicLong size = new AtomicLong(0);

            Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String[] path = (file.toString()).split("/");
                    String[] rootDir = (dir.toString()).split("/");


                    String dirName = path[path.length-2]; //gets the current dir
                    String fileName = path[path.length-1]; //gets the current file

                    if(!dirName.equals(rootDir[rootDir.length-1]))
                        if(recursiveFlag)
                            fileName = dirName + "/" + fileName;
                        else
                            return FileVisitResult.CONTINUE;

                    long fileSize = attrs.size();
                    System.out.println("\t"+fileName + " - " + fileSize + " bytes");

                    size.addAndGet(attrs.size()/1024);
                    return FileVisitResult.CONTINUE;
                }
            });
            return size;

        } catch(Exception e) {
            System.out.println("Error! Path couldn't be processed.");
            System.exit(1);
        }
        return null;
    }
}