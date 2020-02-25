class UseMain {
    public static void main(String[] args) {
        Thread thrd;

        thrd = Thread.currentThread();

        System.out.println("Main thread name: " + thrd.getName());
        System.out.println("Main thread priority: " + thrd.getPriority());
        System.out.println();

        System.out.println("Setting the name and the priority of the main thread: ");
        thrd.setName("Thread #1");
        thrd.setPriority(Thread.NORM_PRIORITY+3);

        System.out.println("New main thread name: " + thrd.getName());
        System.out.println("New main thread priority: " + thrd.getPriority());
    }
}