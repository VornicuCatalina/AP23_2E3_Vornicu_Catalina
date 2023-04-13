package compulsory;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Token> tokenList;

    public Cell() {
        tokenList = new ArrayList<>();
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public int sumToken() {
        int sum = 0;
        for (int i = 0; i < tokenList.size(); i++) {
            sum += tokenList.get(i).getNumber();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Cell has the tokens:" +
                tokenList;
    }
}
