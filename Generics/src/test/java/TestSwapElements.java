import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestSwapElements {

    @Test
    public void testSwapElements() {
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(8);
        list.add(9);

        assertTrue(SwapElements.swapElements(list, 0, 2));
        assertEquals(9, list.get(0));
        assertEquals(8, list.get(1));
        assertEquals(7, list.get(2));

        assertFalse(SwapElements.swapElements(list, 0, 3));
    }
}
