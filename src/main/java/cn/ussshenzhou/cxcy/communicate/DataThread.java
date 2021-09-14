package cn.ussshenzhou.cxcy.communicate;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author USS_Shenzhou
 */
public class DataThread extends Thread {

    private ArrayList<Runnable> tasks = new ArrayList<>();
    private boolean isStopping = false;

    @Override
    public void run() {
        while (!isStopping) {
            if (!tasks.isEmpty()) {
                Runnable r = tasks.get(0);
                tasks.remove(0);
                r.run();
            }
        }
    }

    public void end() {
        this.isStopping = true;
    }

    public void add(Runnable runnable) {
        tasks.add(runnable);
    }

    public void add(Runnable... runnables) {
        tasks.addAll(Arrays.asList(runnables));
    }
}
