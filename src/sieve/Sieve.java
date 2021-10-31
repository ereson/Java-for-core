package sieve;

import java.util.BitSet;

/**
 * 埃拉托色尼算法，计算素数个数
 */
public class Sieve {
    public static void main(String[] args){
        int n = 2000000;
        long start = System.currentTimeMillis();
        var bitSet = new BitSet(n + 1);
        int count = 0;
        int i ;
        //将位集全部设置为开
        for(i = 2; i <= n; i++){
            bitSet.set(i);
        }
        i = 2;
        //将所有素数对倍数全部设置为关的状态 剩下的都是质数
        while(i * i <= n){
            if(bitSet.get(i)){
                count++;
                int k = 2 * i;
                while(k <= n){
                    bitSet.clear(k);
                    k += i;
                }
            }
            i++;
        }
        //计算素数的个数
        while(i <= n){
            if(bitSet.get(i)) count++;
            i++;
        }

        long end = System.currentTimeMillis();
        System.out.println(count + "primes");
        System.out.println((end - start) + "milliseconds");
    }
}
