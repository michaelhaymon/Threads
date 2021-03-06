public class Main {








    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the Main thread.");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread.");
            }
        }.start();

        Thread myRunnableThread= new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "Hello from the anonymous class's interpretation of run().");
                try {
                    anotherThread.join();
                    System.out.println(ThreadColor.ANSI_RED + "AnotherThread terminated, or timed out so I'm running again.");
                } catch (InterruptedException e) {
                    System.out.println(ThreadColor.ANSI_RED +"I couldn't wait after all. I was interrupted." );
                }
            }
        });
        myRunnableThread.start();

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the Main thread");


    }

}
