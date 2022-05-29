import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws IOException {
        String property = System.getProperty("user.dir");
        Path path = Path.of(property);
        File root = new File("G:\\04. Java-Advanced-Files-and-Streams-Lab-Resources");
//        System.out.println(Files.walk(root.toPath())
//                .map(Path::toFile)
//                .filter(File::isDirectory)
//                .map(File::getName)
//                .collect(Collectors.joining(System.lineSeparator())));
//
//        System.out.println("=========================");
        List<File> dirs = new ArrayList<>();
        ArrayDeque<File> queue = new ArrayDeque<>();

        Arrays.stream(root.listFiles()).filter(File::isDirectory).forEach(queue::offer);

        generateList(queue, dirs);

        dirs.forEach(d -> System.out.println(d.getName()));
        System.out.println(dirs.size() + " folders");

    }

    private static void generateList(ArrayDeque<File> queue, List<File> dirs) {
        while (!queue.isEmpty()) {
            File dir = queue.poll();
            dirs.add(dir);
            Arrays.stream(dir.listFiles()).filter(File::isDirectory).forEach(queue::offer);
        }
    }
}
