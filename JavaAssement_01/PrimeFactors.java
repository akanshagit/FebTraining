import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class PrimeFactors {
    static int temp = 10000000;
    static boolean[] arr = new boolean[temp]; //For checking if the number is prime or not
    public static void main(String[] args) {
            arr[0]=true;
            Arrays.fill(arr,true);
            for(int i=2;i<temp;i++)
            {
                if(arr[i] == true)
                {
                    for(int j=2;j<temp;j++)
                    {
                        if(i<(temp/j))
                        {
                            arr[i*j]=false;
                        }
                        else
                            break;
                    }
                }
            }
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            computePrimeFactors(num);
    }

    public static void computePrimeFactors(int X) {
        //TODO Add your implementation here
        int y=X-1;
        while(X>0)
        {
            if(arr[y]){
                System.out.print(y+" ");
                X-=y;
                y=X;
            }
            else
                y--;
        }
        return;
    }
}
 