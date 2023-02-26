package LAB1;

public class Bonus {
    public static void main(String[] args) {

        //*
        long start1=System.nanoTime();
        int n=5;
        long[][] mat_ini=new long[n][n];
        long[][] mat_help=new long[n][n];
        long[][] mat_new=new long[n][n];
        int i,j,k=2,l;
        System.out.println("Matrix for power "+1);
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(i!=j){
                    mat_ini[i][j]=mat_help[i][j]=2;
                }
                else{
                    mat_ini[i][j]=mat_help[i][j]=0;
                }
                System.out.print(mat_ini[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        while(k<=n){
            System.out.println("Matrix for power "+k);
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    for(l=0;l<n;l++){
                        mat_new[i][j]+=mat_help[i][l]*mat_ini[l][j];
                    }
                    System.out.print(mat_new[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            k++;
            for(i=0;i<n;i++)
                for(j=0;j<n;j++){
                    mat_help[i][j]=mat_new[i][j];
                    mat_new[i][j]=0;
                }
        }
        long end1=System.nanoTime();
        /*
        I used a formula which helps me to calculate the matrices:
        - both are nxn
        - i divided the results into diagonal results and other results
        - the diagonal will be calculated as previous other results (because 0 is on diagonal) * 2(n-1), (n-1) results left,2 value
        - the other results will be calculated as previous diagonal*2 (value) + previous other results*2(n-2), cuz (n-2) variables left
        - it will be done recursively, using previous variables
        - I will use only 4 variables
         */
        long start2=System.nanoTime();
        long diag_prev=0,diag_now,other_prev=2,other_now;
        k=1;
        while(k<=n){
            System.out.println("\n\nMatrix of power "+k+"\n\n");
            diag_now=other_prev*2*(n-1);
            other_now=diag_prev*2+other_prev*2*(n-2);
            for(i=1;i<n;i++){
                for(j=1;j<n;j++){
                    if(i!=j){
                        System.out.print(other_now+" ");
                    }
                    else{
                        System.out.print(diag_now+" ");
                    }
                }
                System.out.println();
            }
            diag_prev=diag_now;
            other_prev=other_now;
            System.out.println();
            k++;
        }
        long end2=System.nanoTime();
        System.out.println("First "+(end1-start1)+" , second "+(end2-start2));



        //**

        /*
        Given: no. of vertices & vertex degree
        As arguments

        In graph theory, a regular graph is a graph where
        each vertex has the same number of neighbors;
         */

        k=0;
        int no_vx,degree;
        no_vx=Integer.parseInt(args[0]);
        degree=Integer.parseInt(args[1]);
        System.out.println("The matrix is made of "+(no_vx)+" vertices and the inner degree is "+degree);
        int[][] vert=new int[no_vx][no_vx];
        for(i=0;i<no_vx;i++){
            for(j=0;j<i;j++)
                if(vert[i][j]==1)
                    k++;
            for(j=i+1;j<no_vx&&k<degree;j++){
                if(i!=j&&vert[i][j]==0){
                    vert[i][j]=vert[j][i]=1;
                    k++;
                }
            }
            k=0;
        }
        for(i=0;i<no_vx;i++){
            for(j=0;j<no_vx;j++){
                System.out.print(vert[i][j]+" ");
            }
            System.out.println();
        }
    }
}
