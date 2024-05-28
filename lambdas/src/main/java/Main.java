import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Sounding> sounds = new ArrayList<>();
        sounds.add(new Cat());
        sounds.add(new Bat());


        sounds.add(new Sounding() {
            @Override
            public void sound() {
                System.out.println("Bzz");
            }
        });


        sounds.add(() -> System.out.println("Snort"));


        sounds.add(new Bear()::makeBearSound);


        sounds.forEach(Sounding::sound);
    }
}
