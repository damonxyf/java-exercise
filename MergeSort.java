import java.util.Arrays;

public class MergeSort {
    public static void MergeSort(int[] a) {
        int n = a.length;
        int middle = n/2 ;
        if(n>1){

            int[]left=Arrays.copyOfRange(a,0,middle);//拷贝数组a的左半部分
            int[]right=Arrays.copyOfRange(a,middle,n);//拷贝数组a的右半部分
            MergeSort(left);//递归a的左半部分
            MergeSort(right);//递归a的右半部分
            Merge(a,left,right);//数组左半部分、右半部分合并到a

    }

    }
    //合并数组，升序
    private static void Merge(int[]result,int[]left,int[]right){

        int i=0,l=0,r=0;

        while(l<left.length&&r<right.length){

            if(left[l]<right[r]){
                result[i]=left[l];
                i++;
                l++;
            }else{
                result[i]=right[r];
                i++;
                r++;
            }
        }

        while(r<right.length){//如果右边剩下合并右边的
            result[i]=right[r];
            r++;
            i++;
        }

        while(l<left.length){//如果左边剩下合并左边的
            result[i]=left[l];
            l++;
            i++;
        }
    }

        public static void main(String[] args) {
        int n = (int)(Math.random()*1000);
            int[] a = new int[n];

            int i;
            for(i = 0;i < n;i++){
                a[i] = (int)(Math.random()*1000);
            }
            MergeSort(a);
            System.out.println(Arrays.toString(a));
            System.out.println(a.length);

        }
    }