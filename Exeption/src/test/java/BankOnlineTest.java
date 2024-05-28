import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankOnlineTest {

    @Test
    public void testSendWithNullArgumentsThrowsException() {
        BankOnline bank = new BankOnline();

        assertThrows(NullArgumentException.class, () -> bank.send(null, null));
    }

    @Test
    public void testSendWithInvalidCardNumberThrowsException() {
        BankOnline bank = new BankOnline();

        assertThrows(InvalidCardNumberException.class, () -> bank.send("98765", 100.0));
    }

    @Test
    public void testSendToBlockedCardThrowsException() {
        BankOnline bank = new BankOnline();

        assertThrows(BlockedCardException.class, () -> bank.send("1111 1111 1111 1111", 1255.2));
    }

    @Test
    public void testSendWithNegativeAmountThrowsException() {
        BankOnline bank = new BankOnline();

        assertThrows(NegativeTransferAmountException.class, () -> bank.send("1234 5678 9012 3456", -123.4));
    }

    @Test
    public void testSendAboveLimitThrowsException() {
        BankOnline bank = new BankOnline();

        assertThrows(OutOfLimitTransferException.class, () -> bank.send("1234 5678 9012 3456", 66666.5));
    }
}
