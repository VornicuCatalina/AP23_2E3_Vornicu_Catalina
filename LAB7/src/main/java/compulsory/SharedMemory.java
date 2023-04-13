package compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SharedMemory {
    private final LinkedList<Token> tokens = new LinkedList<>();

    public SharedMemory(int n) {
        for (int i = 0; i < n; i++) {
            tokens.add(new Token(i));
        }
        Collections.shuffle(tokens);
    }

    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.remove(0));
        }
        return extracted;
    }
}
