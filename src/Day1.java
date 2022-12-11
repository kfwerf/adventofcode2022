import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Day1 {

  public Day1(Path path) throws IOException {
    var csv = Files.lines(path).collect(Collectors.joining(","));
    var counted = Arrays.stream(csv.split(",,"))
        .map(elf ->
            Arrays.stream(elf.split(","))
              .map(Integer::valueOf)
              .reduce(0, (a, b) -> a + b)
        ).collect(Collectors.toList());

    counted.sort((a, b) -> b - a);

    var totalThree = counted.subList(0, 3).stream().reduce(0, (a,b) -> a + b);


    System.out.println("total top: " + counted.get(0));
    System.out.println("total three: " + totalThree);
  }
}
