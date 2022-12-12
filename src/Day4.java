import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Day4 {
  public Day4(Path path) throws IOException {
    var lines = Files.lines(path);

    var lol = lines.map(line -> {
      var split = line.split(",");
      var a = split[0];
      var b = split[1];

      var rangesA = Arrays.stream(a.split("-")).map(Integer::valueOf).toList();
      var rangesB = Arrays.stream(b.split("-")).map(Integer::valueOf).toList();

      var totalA = rangesA.get(1) - rangesA.get(0) + 1;
      var totalB = rangesB.get(1) - rangesB.get(0) + 1;

      var ranges = new ArrayList<>();
      System.out.println(line);
      if (totalA >= totalB) {
        for (int i = 0; i < totalB; i++) {
          var currentCursor = rangesB.get(0) + i;
          if (currentCursor >= rangesA.get(0) && currentCursor <= rangesA.get(1)) {
            ranges.add(currentCursor);
          }
        }
//        return ranges.size() == totalB ? ranges : new ArrayList<>();
        return ranges;
      }

      for (int i = 0; i < totalA; i++) {
        var currentCursor = rangesA.get(0) + i;
        if (currentCursor >= rangesB.get(0) && currentCursor <= rangesB.get(1)) {
          ranges.add(currentCursor);
        }
      }
      return ranges;
//      return ranges.size() == totalA ? ranges : new ArrayList<>();
    });

   System.out.println(lol.filter(arr -> arr.size() > 0).count());
  }
}
