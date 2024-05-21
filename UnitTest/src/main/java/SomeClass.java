import org.mockito.Mockito;

public class SomeClass {

    public static void main(String[] args) {
        bClass mockB = Mockito.mock(bClass.class);
        aClass a1 = new aClass(mockB);
        a1.methodWithException(0);
    }

    private String privateMethod(){
        return "Hello world";
    }

    private String privateMethodWithArgument(String a){
        return a;
    }

}

class aClass {
    public aClass(bClass mockB) {
    }

    public aClass() {
    }

    public void callMethodA() {
        System.out.println("Вызван метод A");
    }

    public void callMethodB(bClass bclass) {
        System.out.println("Вызов метода B из A");
        bclass.callMethodB();
    }

    public void methodWithException(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Значение должно быть больше или равно нулю");
        } else {
            System.out.println("Да");
        }
    }



}

class bClass {
    public bClass(aClass mockA) {
    }

    public bClass() {
    }

    public void callMethodB() {
        System.out.println("Вызов метода B");
    }

    public void callMethodA(aClass aclass) {
        System.out.println("Вызов метода A из B");
        aclass.callMethodA();
    }
}
