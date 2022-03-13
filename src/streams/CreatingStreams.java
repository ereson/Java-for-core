package streams;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CreatingStreams {
    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> firstElements = stream.limit(SIZE + 1)
                .collect(Collectors.toList());
        System.out.println(title + ":");
        for(int i = 0; i < firstElements.size(); i++) {
            if (i > 0) System.out.print(",");
            if (i < SIZE) System.out.print(firstElements.get(i));
            else System.out.print("...");
        }
    }

    public static  void main(String[] args) throws Exception {
        //代码中使用相对路径来读取文件是从文件夹的跟路径下面进行读取的
        Path path = Paths.get("/Users/xiongwei/workspace/java_for_core/Java-for-core/README.md");
        var contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        Stream<String> words = Stream.of(contents.split("PL+"));
        show("words", words);
        Stream<String> song = Stream.of("gentty", "sdown", "the", "stream");
        show("song", song);
        //产生一个不包含任何元素的流
        Stream<String> silence = Stream.empty();
        show("silence", silence);

        //产生一个无限流，通过反复调用函数产生
        Stream<String> echos = Stream.generate(() -> "Echo");
        show("echos", echos);

        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms", randoms);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE,
                n -> n.add(BigInteger.ONE));
        show("integers", integers);

        Stream<String> wordsAnotherWay = Pattern.compile("PL+").splitAsStream(contents);
        show("wordsAnotherway", wordsAnotherWay);

        try(Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            show("lines", lines);
        }

        Iterable<Path> interable = FileSystems.getDefault().getRootDirectories();
        Stream<Path> rootDirectories = StreamSupport.stream(interable.spliterator(), false);
        show("rootDiretories", rootDirectories);

        Iterator<Path> iterator = Paths.get("../README.md").iterator();
        Stream<Path> pathStream = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator,Spliterator.ORDERED), false);
        show("pathStream", pathStream);
    }
}
