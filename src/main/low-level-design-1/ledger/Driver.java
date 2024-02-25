package ledger;

import ledger.command.CommandManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class
Driver {
    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager();
//        String filePath = "E:\\jobhunt\\codebase\\github\\low-level-design\\src\\main\\low-level-design-1\\ledger\\files\\input01.txt";
//        String filePath = "src\\main\\low-level-design-1\\ledger\\input.txt";
//        String filePath = "src/main/low-level-design-1/ledger/input.txt";
        String filePath = "input/ledger.txt";
        Path path = Paths.get(filePath);
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(commandManager::executeCommand);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
