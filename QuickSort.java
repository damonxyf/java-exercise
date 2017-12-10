import java.util.Arrays;

public class QuickSort {
    public static void QuickSort(int[] a ,int p, int r){
        if ( p < r ) {
            int q = Quick(a, p, r) ;
            QuickSort(a,p,q-1);
            QuickSort(a,q+1,r);
        }

    }
    public static int Quick(int[]a,int p,int r ) {
        int x = a[r];
        int temp;
        int i = p-1;
        for ( int j=p;j < r ;j++) {

                if ((a[j] <= x)&&(i < r-1) ) {
                    i = i+1;
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
        }
        temp = a[i+1];
        a[i+1] = a[r];
        a[r] = temp;
        return i+1;
    }

    public static void main(String[] args) {
        int n = (int) (Math.random() * 1000);
        int[] a = new int[n];

        int i;
        for (i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * 1000);
        }
        System.out.println(Arrays.toString(a));
       QuickSort(a,0,n-1);
        System.out.println(Arrays.toString(a));
        System.out.println(a.length);
    }
}