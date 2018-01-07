package com.roll.comical;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class BrokenPrimeProducer extends  Thread{
    private final BlockingQueue<BigInteger> queue;

    private volatile boolean cancelled = false;

    BrokenPrimeProducer(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }

    @Override
    public void run(){
        try {
            BigInteger p = BigInteger.ONE;
            while(!cancelled){
                queue.put(p = p.nextProbablePrime());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void cancel(){
        cancelled = true;
    }

    void consumePrimes() throws InterruptedException{
        BlockingQueue<BigInteger> primes = null;
        BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
        producer.start();
    }
}


