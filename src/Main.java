import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("Hello World!");
        var day1 = Paths.get(Main.class.getClassLoader()
                .getResource("resources/day1.txt").toURI());
        //new Day1(input);

        var day2 = Paths.get(Main.class.getClassLoader()
            .getResource("resources/day2.txt").toURI());
        //new Day2(day2);

        var day3 = Paths.get(Main.class.getClassLoader()
            .getResource("resources/day3.txt").toURI());
        //new Day3(day3);

        var day4 = Paths.get(Main.class.getClassLoader()
            .getResource("resources/day4.txt").toURI());
        new Day4(day4);
    }
}
