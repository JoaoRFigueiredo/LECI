package v5;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
/*notas da doc pra usar



*/
public class Visitador {

	public AtomicLong Walker(String pathString, Boolean inside) {
		final AtomicLong size = new AtomicLong(0); // Para usar dentro do visitor
		try {
			Path path = Paths.get(pathString);
			String[] stringArrayPath = (path + "").split("/");
			String stringPath = String.join("/", stringArrayPath);
			Files.walkFileTree(path, new FileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					if (!inside && path != dir) { // Continua sem visitar este directory
						return FileVisitResult.SKIP_SUBTREE;
					}
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					String[] filePath = (file + "").split("/");
					String[] filePath1 = Arrays.copyOf(filePath, filePath.length - 1);
					String dirname = String.join("/", filePath1);
					long fileSize = attrs.size(); // filezie in kb
					
					if (dirname.equals(stringPath)) {
						System.out.println(filePath[filePath.length - 1] + ": " + fileSize + " kB");
					} else if (inside && !dirname.equals(stringPath)) {
						System.out.println(diff(dirname, stringPath) + "->" + filePath[filePath.length - 1] + ":"
								+ fileSize + " kB");
					}
					size.addAndGet(fileSize); // Adiconar ao AtomicLong para usar dentro do visitor
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
					System.err.println("Error visiting: " + file);
					System.err.println("Stopping...");
					return FileVisitResult.TERMINATE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					if (path == dir) {
						System.out.println("Total: " + size.get() + " kB");
					}
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}

	private String diff(String str1, String str2) {
		int index = str1.lastIndexOf(str2);
		if (index > -1) {
			return str1.substring(str2.length());
		}
		return str1;
	}
}