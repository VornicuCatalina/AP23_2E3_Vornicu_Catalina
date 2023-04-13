package compulsory;

public class Token {
    private int number;

    public Token(int n) {
        this.number = n;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Token's number is" + number;
    }
}
