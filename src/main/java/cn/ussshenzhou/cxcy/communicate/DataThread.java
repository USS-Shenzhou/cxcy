package cn.ussshenzhou.cxcy.communicate;

import cn.ussshenzhou.cxcy.utils.LogManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author USS_Shenzhou
 */
public class DataThread extends Thread {

    private LinkedBlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
    private boolean isStopping = false;

    int i = 0;

    @Override
    public void run() {
        while (!isStopping) {
            if (!tasks.isEmpty()) {
                Runnable r = (Runnable) tasks.poll();
                r.run();
                i++;
                //LogManager.LOGGER.info(String.valueOf(i));
            }
        }
    }

    public void end() {
        this.isStopping = true;
    }

    public void add(Runnable runnable) {
        tasks.offer(runnable);
    }
}
