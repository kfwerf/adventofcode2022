import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("Hello World!");
        var input = Paths.get(Main.class.getClassLoader()
                .getResource("resources/day1.txt").toURI());
        var output = new Day1(input);
    }
}
