package Chapter1;

public class EX24 {
    //欧几里得最大公约数算法
    public static int Euclid(int a, int b){
        int gcd;
        int r; //r是余数
        while (b!=0){
            r = a%b;
            a = b;
            b = r;
        }
        /*
        也可以使用递归算法
        if (a % b == 0) return b;
        else return Euclid(b, b%a);
         */
        gcd = a;
        return gcd;
    }

    public static void main(String []args){
        System.out.println(Euclid(1111111,1234567));
        System.out.println(Euclid(12,18));
    }
}
