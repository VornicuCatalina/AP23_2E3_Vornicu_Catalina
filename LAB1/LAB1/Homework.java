package LAB1;

public class Homework {
    public static void main(String[] args) {
        //****
        long start=System.nanoTime();

        //*
        try {
            Integer.parseInt(args[0]);
            System.out.println("It is valid");

            //**
            /*
            I am going to make the matrix in an ordered / sorted way increasing
            */
            int n=Integer.parseInt(args[0]);
            int[][] latin=new int[n][n];
            int i,j;
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    latin[i][j]=(i+j)%n+1;
                }
            }
            if(n<=100){
                System.out.println("\nThe matrix has "+n+" rows and columns");
                for(i=0;i<n;i++){
                    for(j=0;j<n;j++){
                        System.out.print(latin[i][j]+" ");
                    }
                    System.out.println();
                }
                System.out.println();

                //***
                /*
                I am going to choose to do this for every line
                */
                System.out.println("The strings are:");
                String[] lines=new String[n];
                for(i=0;i<n;i++){
                    lines[i]=Integer.toString(latin[i][0]);
                    for(j=1;j<n;j++){
                        lines[i]=lines[i]+latin[i][j];
                    }
                    System.out.println(lines[i]);
                }
                System.out.println();
            }

        } catch(NumberFormatException e){
            System.out.println("NOT valid");
        }
        long end=System.nanoTime();
        System.out.println(end-start);

    }
}
