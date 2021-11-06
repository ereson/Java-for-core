package synch2;

import java.util.Arrays;
/**同步**/
public class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException{
            while(accounts[from] < amount){
                wait();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n",getTotalBalace());
            notifyAll();
    }

    public synchronized double getTotalBalace(){
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

