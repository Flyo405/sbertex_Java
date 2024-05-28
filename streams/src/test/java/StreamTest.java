import org.junit.Test;

import java.util.stream.IntStream;

import static org.testng.AssertJUnit.assertEquals;

public class StreamTest {

    @Test
    public void testStreamOperation() {
        IntStream intStream = IntStream.range(1, 11);

        IntStream sortedStream = intStream
                .filter(x -> x >= 10 && x < 100)
                .sorted();

        double average = sortedStream.average().orElse(0);

        assertEquals(10.0, average);
    }
}
