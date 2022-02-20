package streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CountLongWords {
    public static void main(String[] args) throws IOException {
        var contents = new String (Files.readAllBytes(Paths.get("/Users/xiongwei/workspace/java_for_core/Java-for-core/README.md")), StandardCharsets.UTF_8);
        List<String> words = List.of (contents.split ("\\PL+"));

        //splitAsStream方法可以将提供的CharSequence对象通过正则表达式进行切分
        Stream<String> wordsOne = Pattern.compile("\\PL+").splitAsStream(contents);

        //产生一个符号器的扫描流，产生一个单词流
        Stream<String> wordsTwo = new Scanner(contents).tokens();
        long count = 0;
        for (String w : words) {
            if (w.length() > 12) count++;
        }

        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
    }

}
