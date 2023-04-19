package homework;

public class Token {
    private int number;

    public Token(int n) {
        this.number = n;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int newNumber) {
        if (this.number - newNumber <= 0) {
            this.number = 0;
        } else {
            this.number = this.number - newNumber;
        }
    }

    @Override
    public String toString() {
        return "Token's number is" + number;
    }
}
