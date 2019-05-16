package Chapter1;

public class EX14 {
    public static int lg(int N){
        int i = 0;
        while (N/2 >= 1) {
            i += 1;
            N = N/2;
        }
        return i;
    }

    public static void main(String []args){
        System.out.println(lg(7));
        System.out.println(lg(8));
    }
}
