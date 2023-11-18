package ledger;

import ledger.command.CommandManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Driver
{
    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager();
        String filePath = "E:\\jobhunt\\codebase\\github\\low-level-design\\src\\main\\java\\ledger\\files\\input01.txt";
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
