import java.util.Collections;
import java.util.List;

public class SwapElements {

    public static <T> boolean swapElements(List<? extends T> list, int index1, int index2) {
        if (index1 < 0 || index1 >= list.size() || index2 < 0 || index2 >= list.size()) {
            return false;
        }

        Collections.swap(list, index1, index2);
        return true;
    }
}
