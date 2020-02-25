class MyThread extends Thread {
    MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " - start.");

        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + getName() + ", counter is: " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(getName() + " - stopped.");
        }

        System.out.println(getName() + " - completion.");
    }
}

class ExtendThread {
    public static void main(String[] args) {
        System.out.println("Main thread start.");

        MyThread mt1 = new MyThread("Spawned Thread #1");
        MyThread mt2 = new MyThread("Spawned Thread #2");
        MyThread mt3 = new MyThread("Spawned Thread #3");
        mt1.start();
        mt2.start();
        mt3.start();

        for(int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Main thread interruption.");
            }
        }
        System.out.println("Completion of the main thread.");
    }
}