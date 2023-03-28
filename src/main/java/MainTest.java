import com.alibaba.fastjson.JSONObject;
import com.sun.corba.se.impl.orb.ParserTable;
import org.example.ZolResult;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class MainTest {
    public static void main(String[] args) {
        int[] a = {0, 1, 3, 5, 7, 9};
        System.out.println(binSearch(a, 3));

        int[] b = {9, 1, 4, 3, 6, 7, 0};
        //int[] tmp = new int[b.length];
        quickSort(b, 0, b.length - 1);
        //mergeSort(b, 0, b.length - 1, tmp);
        System.out.println(Arrays.toString(b));

    }

    public static int binSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else if (a[mid] > key) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void quickSort(int[] a, int start, int end) {
        if (start>=end){
            return;
        }
        int partition=divide(a,start,end);
        quickSort(a,start,partition-1);
        quickSort(a,partition+1,end);
    }

    public static int divide(int[] a,int start,int end){
        int base=a[end];
        while (start<end){
            while (start<end&&a[start]<=base){
                start++;
            }
            if (a[start]>base){
                int temp=a[start];
                a[start]=a[end];
                a[end]=temp;
                end--;
            }
            while (start<end&&a[end]>=base){
                end--;
            }
            if(a[end]<base){
                int temp=a[start];
                a[start]=a[end];
                a[end]=temp;
                start++;
            }
        }
        return start;
    }


    public static class Test {
        private static volatile ZolResult zolResult = null;

        private Test() {

        }

        public static ZolResult getInstance() {
            if (zolResult == null) {
                synchronized (Test.class) {
                    if (zolResult == null) {
                        return new ZolResult();
                    }
                }
            }
            return zolResult;
        }

    }

    public static class DaoInstance {
        private static volatile Test test = null;

        private DaoInstance() {

        }

        public static Test getTestInstance() {
            if (test == null) {
                synchronized (DaoInstance.class) {
                    if (test == null) {
                        test = new Test();
                    }
                }
            }
            return test;
        }


    }

}


