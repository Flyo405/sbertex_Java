package task.two;

public class task {
    public static void main(String[] args) {
        int[] numbers = new int[10];

        for (int order = 0; order < numbers.length; order++) {
            numbers[order] = (int) (Math.random() * 100) + 1;
        }

        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }

        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double average = (double) sum / numbers.length;

        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println(" ");
        System.out.println("Max: " + max);
        System.out.println("Avg: " + average);
    }

}

