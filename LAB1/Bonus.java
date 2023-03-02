package LAB1;

public class Bonus {
    public static void main(String[] args) {

        //*
        int n=5;
        long[][] mat_ini=new long[n][n];
        long[][] mat_help=new long[n][n];
        long[][] mat_new=new long[n][n];
        int i,j,k=2,l;
        System.out.println("Matrix for power "+1);
        for(i=0;i<n;i++){
                if(i==0){
                    mat_ini[i][1]=mat_ini[i][n-1]=1;
                    mat_help[i][1]=mat_help[i][n-1]=1;
                }
                else if(i==n-1){
                    mat_ini[i][0]=mat_ini[i][n-2]=1;
                    mat_help[i][0]=mat_help[i][n-2]=1;
                }
                else {
                    mat_ini[i][i - 1] = mat_ini[i][i + 1] = 1;
                    mat_help[i][i-1]=mat_help[i][i+1]=1;
                }
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++){
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
        /*
        The problem can be seen as a sequence of numbers that respects the following properties for every single power:
        - every single row contain the same numbers, but in a different order => the row=i+1 will have the same order from
        the previous one, but we would just move them one position to the right => there is a permutation for every single row
        - always the first row has exactly the same elements as first column , and even in the same order

        ALSO:
        - the sum of neighbors (left & right) is the next power of matrix

        In order to get a more optimised solution, we could use only 2 vectors of n that could be used one by one for finding the
        next matrix exchanging their role: one of them to do the calculus in the other one, the other to be showed on the screen
        and vice-versa
         */

        //More optimised solution
        System.out.println("SECOND SOLUTION\n\n");
        int[] ar1=new int[n];
        int[] ar2=new int[n];
        ar1[1]=ar1[n-1]=1;
        k=1;
        while(k<=n){
            System.out.println("Matrix for power "+k);
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    if(k%2==1){
                        System.out.print(ar1[(n-j+i)%n]+" ");
                    }
                    else{
                        System.out.print(ar2[(n-j+i)%n]+" ");
                    }
                }
                if(k%2==1){
                    if(i==0){
                        ar2[i]=ar1[i+1]+ar1[n-1];
                    }
                    else{
                        ar2[i]=ar1[(i+1)%n]+ar1[i-1];
                    }
                }
                else{
                    if(i==0){
                        ar1[i]=ar2[i+1]+ar2[n-1];
                    }
                    else{
                        ar1[i]=ar2[(i+1)%n]+ar2[i-1];
                    }
                }
                System.out.println();
            }
            System.out.println();
            k++;
        }
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
