package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SharedMemory {
    private final LinkedList<Token> tokens = new LinkedList<>();
    int cnt = 0;

    public SharedMemory(int n) {
        for (int i = 0; i < n; i++) {
            int rand = (int) (Math.random() * 1000);
            tokens.add(new Token(rand));
        }
        Collections.shuffle(tokens);
    }

    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.isEmpty()) {
                break;
            }
            int number = tokens.get(i).getNumber();
            if (number - howMany <= 0) {
                extracted.add(tokens.get(i));
                cnt++;
                tokens.remove(i);
            } else {
                Token help = new Token(howMany);
                extracted.add(help);
                tokens.get(i).setNumber(number - howMany);
            }
        }
        return extracted;
    }
}
