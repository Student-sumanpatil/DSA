import java.util.*;

public class NQueens {
    static int x[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        x = new int[n];
        nQueens(0, n);

    }

    public static void nQueens(int row, int n){

        if(row == n){
            for(int num: x){
                System.out.print((num+1) +" ");
            }
            System.out.println();
            return;
        }

        for(int col=0; col < n; col++){
            if(place( row, col)){
                x[row] = col;
                nQueens(row+1, n);

            }
        }
    }

    public static boolean place(int row, int col){
        for(int j=0; j < row; j++){
            if(x[j] == col || (Math.abs(x[j]-col) == Math.abs(j-row))){
                return false;
            }
        }
        return true;
    }
}
