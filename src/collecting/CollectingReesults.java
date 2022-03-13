package collecting;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingReesults {

    public static Stream<String> noVowels() throws IOException {
        var contents = new String(Files.readAllBytes(Paths.get("../gutenberg/alice30.txt")), StandardCharsets.UTF_8);
        List<String> wordList = List.of(contents.split("\\PL+"));
        Stream<String> words = wordList.stream();
        return words.map(s -> s.replaceAll("[aeiouAEIOU]", ""));
    }


    public static <T> void show(String label, Set<T> set) {
        System.out.print(label + ": " + set.getClass().getName());
        System.out.print("["
        + set.stream().limit(10).map(Object::toString).collect(Collectors.joining(", ")) + "]");
    }

    public static void main(String[] args) throws IOException {
        Iterator<Integer> iterator = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        while(iterator.hasNext())
            System.out.print(iterator.next());

        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();

        try{
            var number = (Integer) numbers[0];
            System.out.println("number: " + number);
            System.out.println("The following statement throws an exception:");
            var number2 = (Integer[]) numbers;
        }catch (ClassCastException ex) {
            System.out.println(ex);
        }

        Integer[] number3 = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
        System.out.println("Integer Array: " + number3);

        Set<String> noVowelSet = noVowels().collect(Collectors.toSet());
        show("noVowelSet", noVowelSet);

        TreeSet<String> noVowelTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
        show("noVowelTreeSet", noVowelTreeSet);

        String result = noVowels().limit(10).collect(Collectors.joining());
        System.out.println("Joining: " + result);
        result = noVowels().limit(10).collect(Collectors.joining(", "));
        System.out.println("Joining with commas: " + result);

        IntSummaryStatistics summaryStatistics = noVowels().collect(Collectors.summarizingInt(String::length));
        double averageWordLength = summaryStatistics.getAverage();
        double maxWordLength = summaryStatistics.getMax();
        System.out.print("Average word length: " + averageWordLength);
        System.out.println("Max word length: " + maxWordLength);
        System.out.println("forEach: ");
        noVowels().limit(10).forEach(System.out::println);
    }

}
