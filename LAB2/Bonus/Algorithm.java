package LAB2.Bonus;

import java.util.ArrayList;

public abstract class Algorithm {
    protected Solution s;
    protected int[][] matrix;
    protected ArrayList<String> help;
    //new
    protected double[][] matrixLength;
    protected double[][] matrixFast;
    protected void solve(Problem p){ //used to created the connections between locations that are mentioned in the main function
        for(int i=0;i< p.getNoLocation();i++){
            for(int j=i+1;j<p.getNoLocation()-1;j++){
                if(matrix[i][j]==1){
                    for(int k=j+1;k<p.getNoLocation();k++){
                        if(matrix[i][k]==1){
                            matrix[j][k]=1;
                            matrix[k][j]=1;
                        }
                    }
                }
            }
        }
       solveCase(p.getNoLocation(),1);
        solveCase(p.getNoLocation(), 0);
    }
    public void solveCase(int n,int noCase){ //applied dijkstra
        int i=0;
        int j;
        int k;
        int helper;
        double[] vector=new double[n+1];
        double[] destination=new double[n+1];
        while(i<n){
            for(j=0;j<n;j++){
                vector[j]=0;
                if(noCase==1){ //length
                    destination[j]=matrixLength[i][j];
                }
                else{
                    destination[j]=matrixFast[i][j];
                }
            }
            vector[i]=1;
            destination[n]=Double.POSITIVE_INFINITY;
            destination[i]=0;
            for(k=0;k<n-1;k++) {
                helper = n;
                for (j = 0; j < n; j++)
                    if (vector[j] == 0 && destination[j] < destination[helper])
                        helper = j;
                vector[helper] = 1;
                for (j = 0; j < n; j++) {
                    if (noCase == 1) {
                        if (vector[j] == 0 && destination[j] > destination[helper] + matrixLength[helper][j])
                            destination[j] = destination[helper] + matrixLength[helper][j];
                    } else {
                        if (vector[j] == 0 && destination[j] > destination[helper] + matrixFast[helper][j])
                            destination[j] = destination[helper] + matrixFast[helper][j];
                    }
                }
            }
            if(noCase==1){
                for(j=0;j<n;j++) {
                    if (destination[j] != Double.POSITIVE_INFINITY) {
                        s.setMatrixLength(i, j, destination[j]);
                    } else {
                        s.setMatrixLength(i, j, -1);
                        s.setValue(false);
                    }
                }
            }
            else{
                for(j=0;j<n;j++) {
                    if (destination[j] != Double.POSITIVE_INFINITY) {
                        s.setMatrixFastest(i, j, destination[j]);
                    } else {
                        s.setMatrixFastest(i, j, -1);
                        s.setValue(false);
                    }
                }
            }
            i++;
        }
    }
    public void existenceOfRoute(Location i,Location j,Problem p){
        if(!(p.checkerLocation(i))&&!(p.checkerLocation(j))){ //if both locations exist
            StringBuilder sd=new StringBuilder("The route from ");
            sd.append(i.getNameLocation());
            sd.append(" to ");
            sd.append(j.getNameLocation());
            if(matrix[help.indexOf(i.getNameLocation())][help.indexOf(j.getNameLocation())]==1){
                //accessing the matrix using the property of ArrayList
                sd.append(" EXISTS");
            }
            else{
                sd.append(" DOES NOT EXIST");
            }
            System.out.println(sd);
        }
        else{
            System.err.println("INVALID CALL OF LOCATIONS");
        }

    }
    public Solution solve(){
        return s;
    } //returning Solution object so we do not have to declare it in main by creating a new object
}
