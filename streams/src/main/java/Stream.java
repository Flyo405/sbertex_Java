import java.util.stream.IntStream;

public class Stream {
    public static void stream(String[] args) {
        IntStream intStream = IntStream.range(1, 11);

        IntStream sortedStream = intStream
                .filter(x -> x >= 10 && x < 100)
                .sorted();

        double average = sortedStream.average().orElse(0);

        System.out.println("Average: " + average);
    }
}
