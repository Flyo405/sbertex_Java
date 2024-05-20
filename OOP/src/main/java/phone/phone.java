package phone;

class main{
    public static void main(String[] args) {
        phone phone1 = new phone("+79353535365364", "pocoPhone", "7");
        phone phone2 = new phone("+3252634656354", "APhone", "13");
        phone phone3 = new phone("+1463463434668", "androed", "22");

        phone2.receiveCall("Михаил Круг", "+79005558535");

        System.out.println();

        String[] numbers = {"67898987987978", "765857585858", "4564464564546"};
        phone3.sendMessage(numbers);

        System.out.println();

        System.out.println(phone1.toString());
        System.out.println(phone2.toString());
        System.out.println(phone3.toString());
    }
}
public class phone {
    private String number;
    private String model;
    private String weight;

    public phone(String number, String model, String weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public phone() {
    }

    public void receiveCall(String callerName) {
        System.out.println("Звонит " + callerName);
    }

    public String getNumber() {
        return number;
    }

    public void receiveCall(String callerName, String callerNumber) {
        System.out.println("Звонит " + callerName + " номер телефона: " + callerNumber);
    }

    public void sendMessage(String[] numbers) {
        for (String number : numbers) {
            System.out.println(number);
        }
    }

    public String toString() {
        return "Phone {" +
                "Number: " + number + '\'' +
                " Model: " + model + '\'' +
                " Weight: " + weight +
                '}';
    }

}
