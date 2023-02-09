import java.util.Arrays;
import java.util.*;
import java.io.*;

public class SortArray {
    public static void main(String[] args) {
        Integer[] input = new Integer[]{2, 3, 4, 5,8,9};
        Arrays.sort(input,Collections.reverseOrder());
        sortMyArray(input);
    }

    public static void sortMyArray(Integer[] input) {
        //TODO Add your implementation here
        HashSet<Integer> st1 = new HashSet<Integer>();
        HashSet<Integer> st2 = new HashSet<Integer>();
        int sum1 = 0, sum2 = 0;
        int cnt_ind = 0;
        while(cnt_ind<input.length){
            if(sum1<=sum2){
                st1.add(input[cnt_ind]);
                sum1+=input[cnt_ind];
            }
            else{
                st2.add(input[cnt_ind]);
                sum2+=input[cnt_ind];
            }
            cnt_ind+=1;
        }
        System.out.println(st1);
        System.out.println(st2);


        return;
    }
}