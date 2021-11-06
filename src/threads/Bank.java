package threads;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;

    //初始化账户
    public Bank(int n, double initialBalance){
        accounts = new double[10];
        Arrays.fill(accounts,initialBalance);
    }

    /**转账**/
    public void transfer(int from, int to, double amount){
        if(accounts[from] < amount) return ;
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf("Total Balance: %10.2f%n", getTotalBalance());
    }

    /**所有账户的总金额**/
    public double getTotalBalance(){
        double sum = 0;
        for(double a : accounts){
            sum += a;
        }

        return sum;
    }

    public int size(){
        return accounts.length;
    }
}
