public class BankOnline {
    public static void main(String[] args) {
        BankOnline customer = new BankOnline();
        try {
            customer.send("1234 5678 9012 3456", 125.9);
            //customer.send("1234 5678 9012 3456", null);
            //customer.send(null, 225.80);
            //customer.send("1111 1111 1111 1111", 1255.2);
            //customer.send("1234 5678 9012 3456", -123.4);
            //customer.send("1234 5678 9012 3456", 60_000.5);
        } catch (InvalidCardNumberException | OutOfLimitTransferException | NullArgumentException |
                 NegativeTransferAmountException | BlockedCardException e) {
            throw new RuntimeException(e);
        }

    }

    public BankOnline() {
    }

    public void send(String cardNumber, Double money) throws InvalidCardNumberException, BlockedCardException, NegativeTransferAmountException, NullArgumentException, OutOfLimitTransferException {
        int limit = 50_000;
        String regex = "[0-9]+";
        String cardNumberWithoutSpaces = cardNumber.replaceAll(" ", "");
        int size = 10;
        String[] BlockCards = new String[size];
        boolean isBlockCards = false;
        BlockCards[0] = "1111 1111 1111 1111";
        BlockCards[1] = "2222 2222 2222 2222";
        BlockCards[2] = "3333 3333 3333 3333";

        for (int index = 0; index < size; index++) {
            if (cardNumber == BlockCards[index]) {
                isBlockCards = true;
                break;
            }
        }

        if ((cardNumberWithoutSpaces.length() != 16) || (!cardNumberWithoutSpaces.matches(regex))) {
            throw new InvalidCardNumberException("Неправильный ввод карты" +
                    "(Номер должен содержать только цифры и их должно быть ровно 16).");
        } else if (isBlockCards) {
            throw new BlockedCardException("Осуществляется перевод на заблокированные карты.");
        } else if (money < 0) {
            throw new NegativeTransferAmountException ("Введена отрицательная сумма перевода.");
        } else if (money > limit) {
            throw new OutOfLimitTransferException("Превышен лимит в " + limit + " рублей.");
        } else if (cardNumber == null || money == null) {
            throw new NullArgumentException("Один из аргументов null.");
        } else {
            System.out.println("Деньги в размере " + money + " рублей были зачислены на номер " + cardNumber);
        }

    }
}
