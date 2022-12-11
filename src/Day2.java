import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

  public Day2(Path path) throws IOException {
    var opponent = List.of("A", "B", "C");
    var you = List.of("X", "Y", "Z");

    var resultA = Files.lines(path)
      .map(line -> {
        var split = line.split(" ");
        var a = split[0];
        var b = split[1];

        var oppIdx = opponent.indexOf(a);
        var youIdx = you.indexOf(b);

        var handMultiplier = youIdx + 1;

        if (youIdx == 0 && oppIdx == 2 || oppIdx == youIdx - 1) {
          return 6 + handMultiplier;
        }

        if (oppIdx == youIdx) {
          return 3 + handMultiplier;
        }


        return 0 + handMultiplier;
      }).reduce((a,b) -> a + b);

    var resultB = Files.lines(path)
        .map(line -> {
          var split = line.split(" ");
          var a = split[0];
          var b = split[1];

          var oppIdx = opponent.indexOf(a);

          if (b.equals("Z")) {
            var idx = oppIdx == 2 ? 0 : oppIdx + 1;
            return 6 + 1 + idx;
          }

          if (b.equals("Y")) {
            return 3 + 1 + oppIdx;
          }


          var idx = oppIdx == 0 ? 2 : oppIdx - 1;

          return 0 + 1 + idx;
        }).reduce((a,b) -> a + b);


    System.out.println(resultB);
  }
}
