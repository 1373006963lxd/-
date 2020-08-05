package com.lxd.niukework.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @auther li xiao dong
 * @date 2020/3/29 0029 下午 18:39
 */
public class CallTest  implements Callable {
    @Override
    public Object call() throws Exception {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallTest callTest = new CallTest();
        FutureTask futureTask = new FutureTask(callTest);
        Thread th = new Thread(futureTask);
        th.start();
        System.out.println(futureTask.get());
    }
}
