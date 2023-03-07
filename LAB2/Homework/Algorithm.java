package LAB2.Homework;

import java.util.ArrayList;

public class Algorithm {
    private double[][] matrix;
    private ArrayList<String> help;
    private boolean valid;
    private void solve(Problem p){
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
    }
    public Algorithm(Problem p){
        help=new ArrayList<String>(p.getNoLocation());
        for(int j=0;j<p.getNoLocation();j++){
            help.add(p.getLocations(j).getNameLocation());
        }
        matrix=new double[p.getNoLocation()][p.getNoLocation()];
        for(int i=0;i<p.getNoRoads();i++){
            matrix[help.indexOf(p.getRoads(i).getA().getNameLocation())][help.indexOf(p.getRoads(i).getB().getNameLocation())]=1;
            matrix[help.indexOf(p.getRoads(i).getB().getNameLocation())][help.indexOf(p.getRoads(i).getA().getNameLocation())]=1;
        }
        solve(p);
    }
    public void existenceOfRoute(Location i,Location j,Problem p){
        if(!(p.checkerLocation(i))&&!(p.checkerLocation(j))){
            StringBuilder sd=new StringBuilder("The route from ");
            sd.append(i.getNameLocation());
            sd.append(" to ");
            sd.append(j.getNameLocation());
            if(matrix[help.indexOf(i.getNameLocation())][help.indexOf(j.getNameLocation())]==1){
                sd.append(" EXISTS");
                valid=true;
            }
            else{
                sd.append(" DOES NOT EXIST");
                valid=false;
            }
            System.out.println(sd);
        }
        else{
            System.err.println("INVALID CALL OF LOCATIONS");
        }

    }
}
