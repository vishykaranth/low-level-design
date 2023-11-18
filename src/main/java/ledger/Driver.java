package ledger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Driver
{
    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager();
        String filePath = "D:\\2023\\coding\\low-level-design\\ledger\\src\\files\\input02.txt";
        Path path = Paths.get(filePath);
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(
                    fileLine -> commandManager.executeCommand(fileLine)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
