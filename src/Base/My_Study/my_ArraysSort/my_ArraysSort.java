package Base.My_Study.my_ArraysSort;

import java.util.Arrays;
import java.util.Comparator;

public class my_ArraysSort {
    public static void main(String[] args){
        int[] arr = {4,12,52,2,1,34,33};
        //MaoPao(arr);
        MaoPao02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;  //向下转型
                Integer i2 = (Integer) o2;
                return i2-i1;   // 目前降序 反之升序
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    //先使用冒泡排序
    public static void MaoPao(int[] arr){
        int temp = 0;
        for(int i = 0; i < arr.length-1; ++i){
            for(int j = 0; j < arr.length-1-i; ++j){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //结合冒泡+定制
    public static void MaoPao02(int[] arr, Comparator c){   //匿名内部类
        int temp = 0;
        for(int i = 0; i < arr.length-1; ++i){
            for(int j = 0; j < arr.length-1-i; ++j){
                if(c.compare(arr[j],arr[j+1]) > 0){ //这里动态绑定
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
