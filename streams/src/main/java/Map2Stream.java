import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Map2Stream {
    public static void main(String[] args) {
        Map<String, List<StreamContainer>> map = new HashMap<>();

        List<StreamContainer> result = map.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        long count = result.stream().count();

        System.out.println("Count: " + count);
    }
}
