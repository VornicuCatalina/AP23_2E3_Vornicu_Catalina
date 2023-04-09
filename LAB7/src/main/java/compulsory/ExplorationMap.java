package compulsory;

import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    //Cell should be a wrapper or alias for List<Token>
    private int size;
    public ExplorationMap(int m){
        size=m;
        matrix=new Cell[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=new Cell();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (matrix[row][col].getTokenList().isEmpty()) {
                System.out.println("New cell has been explored by robot "+robot.getName()+" at cords "+row+" and "+col);
                List<Token> tokensExtracted= robot.sharedMemory.extractTokens(5);
                matrix[row][col].setTokenList(tokensExtracted);
                //the robot extract tokens
                //and store the tokens in the cell (it becomes visited)
                //display a success message
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<size;i++){
            for(Cell cell:matrix[i]){
                stringBuilder.append(cell);
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        String string=new String(stringBuilder);
        return string;
    }

}
