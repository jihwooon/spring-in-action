package com.example.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPool implements Executor {

    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    private final Thread[] threads;
    private final AtomicBoolean stated = new AtomicBoolean();

    public ThreadPool(int numThreads) {
        threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                try {
                    for (; ; ) {
                        final Runnable task = queue.take();
                        task.run();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    @Override
    public void execute(Runnable command) {
        if (stated.compareAndSet(false, true)) {
            for (Thread thread : threads) {
                thread.start();
            }
        }

        queue.add(command);
    }
}
