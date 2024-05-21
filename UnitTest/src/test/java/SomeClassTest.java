import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class SomeClassTest {

    @Test
    public void main() {
        aClass aclass = new aClass();
        System.out.println("Тестирование метода methodA");
        aclass.callMethodA();

        System.out.println("Тестирование вызова метода B из A");
        bClass mockB = new bClass() {
            @Override
            public void callMethodB() {
                System.out.println("Мок-метод B для тестирования");
            }
        };
        aclass.callMethodB(mockB);
    }

    @Test
    public void testCallMethodB() {
        bClass mockB = Mockito.mock(bClass.class);
        aClass aclass = new aClass(mockB);
        aclass.callMethodB(mockB);
        Mockito.verify(mockB, Mockito.times(1)).callMethodB();
    }


    @Test
    public void testMethodB() {
        aClass mockA = Mockito.mock(aClass.class);
        bClass bclass = new bClass(mockA);
        bclass.callMethodA(mockA);
        //b.callMethodA(mockA);
        Mockito.verify(mockA, Mockito.times(1)).callMethodA();
    }

    @Test
    public void testMethodWithException() {
        aClass aclass = new aClass();

        // Проверяем, что при передаче отрицательного значения будет выброшено исключение IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            aclass.methodWithException(-2);
        });

        // Проверяем, что при передаче положительного значения исключение не выбрасывается
        assertDoesNotThrow(() -> {
            aclass.methodWithException(5);
        });
    }


    @Test
    public void testPrivateMethod()  {
        try {
            SomeClass someClass2 = new SomeClass();
            Method method = SomeClass.class.getDeclaredMethod("privateMethod",  null);

            method.setAccessible(true);
            assertEquals("Hello world", method.invoke(someClass2).toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testPrivateMethodWithArgument()  {

        try {
            SomeClass someClass3 = new SomeClass();
            Method method = SomeClass.class.getDeclaredMethod("privateMethodWithArgument", String.class);
            method.setAccessible(true);
            assertEquals("Hello", method.invoke(someClass3, "Hello").toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}