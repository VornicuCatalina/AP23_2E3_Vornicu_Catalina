package compulsory;

import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    private int[][] visited;
    //Cell should be a wrapper or alias for List<Token>
    private int size;

    public ExplorationMap(int m) {
        size = m;
        matrix = new Cell[m][m];
        visited = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = new Cell();
                visited[i][j] = 0;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (matrix[row][col].getTokenList().isEmpty()) {
                if (visited[row][col] == 0) {
                    List<Token> tokensExtracted = robot.sharedMemory.extractTokens(5);
                    matrix[row][col].setTokenList(tokensExtracted);
                    visited[row][col] = 1;
                    System.out.println("New cell has been explored by robot " + robot.getName() + " at cords " + row + " and " + col);
                } else {
                    System.out.println("This cell has been visited before");
                }
                System.out.println("Left tokens :" + matrix[row][col].sumToken());
                //the robot extract tokens
                //and store the tokens in the cell (it becomes visited)
                //display a success message
                return true;
            } else {
                System.out.println("It is empty");
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (Cell cell : matrix[i]) {
                stringBuilder.append(cell);
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        String string = new String(stringBuilder);
        return string;
    }

}
