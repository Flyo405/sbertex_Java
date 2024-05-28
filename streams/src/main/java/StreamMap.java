import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("3", "2", "1");

        Map<Long, String> map = stringStream
                .map(s -> new StreamContainer(s, new Random().nextLong()))
                .peek(System.out::println)
                .collect(Collectors.toMap(StreamContainer::getCount, StreamContainer::getName));

        System.out.println(map);
    }
}
