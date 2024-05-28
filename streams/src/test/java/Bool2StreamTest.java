import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Bool2StreamTest {

    @Test
    public void testBinaryString() {
        String binaryString = "1011110000";

        boolean result = binaryString.chars()
                .mapToObj(ch -> ch == '1')
                .reduce(Boolean::logicalAnd)
                .orElse(false);

        assertEquals(false, result);
    }
}
