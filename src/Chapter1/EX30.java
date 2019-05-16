package Chapter1;

public class EX30 {
    public static void print_bool_arr(int N){
        boolean a[][] = new boolean[N][N];
        for (int i = 0;i<N;i++){
            for (int j=0;j<N;j++){
                 if (EX24.Euclid(i,j) == 1) //如果互质
                     a[i][j] = true;
                 else
                     a[i][j] = false;
            }
        }
    }
    public static void main(String[] args){
        print_bool_arr(3);
    }
}
