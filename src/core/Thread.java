package core;

public class Thread {
    private Thread thread;

    public Thread (Thread thread) {
        this.thread = thread;
    }

    public void start () {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }
}