import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Map2StreamTest {

    @Test
    void testStreamOperation() {
        Map<String, List<StreamContainer>> map = new HashMap<>();

        List<StreamContainer> result = map.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        assertEquals(0, result.size());
    }
}
