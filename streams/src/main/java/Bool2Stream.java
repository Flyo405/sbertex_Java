public class Bool2Stream {
    public static void main(String[] args) {
        String binaryString = "1011110000";

        Boolean booleanStream = binaryString.chars()
                .mapToObj(ch -> ch == '1')
                .reduce(Boolean::logicalAnd)
                .orElse(false);

        System.out.println("Result: " + booleanStream);
    }
}
