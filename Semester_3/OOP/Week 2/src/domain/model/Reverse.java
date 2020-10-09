package domain.model;

public class Reverse implements Encryptor {
    @Override
    public String encrypt(String inputString) {
        return new StringBuilder(inputString).reverse().toString();
    }
}
