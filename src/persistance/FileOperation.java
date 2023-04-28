package src.persistance;
import java.util.List;

public interface FileOperation {
    List<String> readAllLines();

    void addLine(String line);

    void saveAllLines(List<String> lines);
}
