package Chapter1;

public class EX15 {
    public static int[] histogram(int a[], int M){
        int[] array = new int[M];
        for (int i=0; i<M; i++){
            int freq = 0;
            for (int j=0; j<a.length;j++){
                if (a[j] == i)
                    freq += 1;
            }
            array[i] = freq;
        }
        return array;
    }
    /*
    以下为GitHub上一位大神给出的答案，更加简洁高效
    public class Ex15 {
	public static int[] histogram(int[] a, int M) {
		int[] result = new int[M];
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= 0 && a[i] < M) {
				result[a[i]]++;
			}
		}
		return result;
     */

    public static void main(String[] args){
        int arr1[] = {1,2,2,1,6,7,8};
        int result[] = histogram(arr1,2);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
