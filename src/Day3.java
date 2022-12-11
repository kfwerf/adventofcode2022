import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day3 {

  public Day3(Path path) throws IOException {
    var alphabet = List.of(
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    );
    var result = Files.lines(path).map(line -> {
      var occurances = new HashMap<Character, Integer>();
      var compartmentA = line.substring(0, line.length() /2);
      var compartmentB = line.substring(line.length() /2);

      for(var i = 0; i < compartmentA.length(); i++) {
        var charA = compartmentA.charAt(i);
        if (-1 != compartmentB.indexOf(charA)) {
          occurances.compute(charA, (key, val) -> val == null ? 1 : val + 1);
        };
      }

      return occurances.entrySet().stream()
          .filter((entry) -> entry.getValue() > 0)
          .map(Map.Entry::getKey)
          .map(key -> {
            var isUppercase = key.toString().toUpperCase().equals(key.toString());
            var count = 1 + alphabet.indexOf(key.toString().toUpperCase());
            return isUppercase ? count + 26 : count;
          }).reduce(0, (a, b) -> a + b);
    }).reduce(0, (a,b) -> a+ b);


    var list = Files.lines(path).collect(Collectors.toList());
    var grouped = new ArrayList<ArrayList<String>>();
    for (int i = 0; i < list.size(); i += 3) {
      var newList = new ArrayList<String>();
      newList.add(list.get(i));
      newList.add(list.get(i+1));
      newList.add(list.get(i+2));
      grouped.add(newList);
    }

    var resultB = grouped.stream().map(rucksacks -> {
      var occurances = new HashMap<Character, Integer>();
      for(var i = 0; i < rucksacks.get(0).length(); i++) {
        var charA = rucksacks.get(0).charAt(i);
        if (-1 != rucksacks.get(1).indexOf(charA) && -1 != rucksacks.get(2).indexOf(charA)) {
          occurances.compute(charA, (key, val) -> val == null ? 1 : val + 1);
        };
      }

      return occurances.entrySet().stream()
          .filter((entry) -> entry.getValue() > 0)
          .map(Map.Entry::getKey)
          .map(key -> {
            var isUppercase = key.toString().toUpperCase().equals(key.toString());
            var count = 1 + alphabet.indexOf(key.toString().toUpperCase());
            return isUppercase ? count + 26 : count;
          }).reduce(0, (a, b) -> a + b);
    }).reduce(0, (a,b) -> a+ b);

    System.out.println(resultB);
  }
}
