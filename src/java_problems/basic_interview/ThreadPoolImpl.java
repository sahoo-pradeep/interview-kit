package java_problems.basic_interview;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolImpl {

  //Task: Create a threadPool with n = 2 threads and run all tasks using n threads
  public static void main(String[] args) {
    CustomThreadPool threadPool = new CustomThreadPool(2);
    List<Runnable> tasks = getTasks();
    for (Runnable task : tasks) {
      threadPool.execute(task);
    }
  }

  // Custom Thread Pool
  private static class CustomThreadPool {

    private final BlockingQueue<Runnable> queue;

    public CustomThreadPool(int maxThreads) {
      queue = new LinkedBlockingQueue<>();

      for (int i = 0; i < maxThreads; i++) {
        CustomThread thread = new CustomThread(queue);
        thread.start();
      }
    }

    public synchronized void execute(Runnable task) {
      try {
        queue.put(task);
      } catch (InterruptedException e) {
        System.out.println("Thread interrupted: " + Thread.currentThread().getName());
      }
    }
  }

  // Custom Thread class, where all threads are sharing same queue.
  private static class CustomThread extends Thread {

    private final BlockingQueue<Runnable> queue;

    public CustomThread(BlockingQueue<Runnable> queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      while (true) {
        try {
          Runnable task = queue.take();
          task.run();
        } catch (InterruptedException e) {
          System.out.println("Thread interrupted: " + Thread.currentThread().getName());
        }
      }
    }
  }

  // Get 5 tasks
  private static List<Runnable> getTasks() {
    List<Runnable> tasks = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      tasks.add(new RunnableTask(i));
    }

    return tasks;
  }

  private static class RunnableTask implements Runnable {

    private final int taskId;

    public RunnableTask(int taskId) {
      this.taskId = taskId;
    }

    @Override
    public void run() {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(
          "[" + Thread.currentThread().getName() + "] Task " + taskId + " " +
              LocalTime.now().toString());
    }
  }
}
