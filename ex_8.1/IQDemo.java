class FixedQueue implements ICharQ{
    private char chArr[];
    private int putLoc;
    private int getLoc;

    public FixedQueue(int size) {
        chArr = new char[size];
        putLoc = 0;
        getLoc = 0;
    }

    @Override
    public void put(char ch) {
        if(putLoc == chArr.length) {
            System.out.println("Queue is full!");
            return;
        }

        chArr[putLoc] = ch;
        putLoc++;
    }

    @Override
    public char get() {
        if(getLoc == putLoc) {
            System.out.println("Queue is empty!");
            return (char) 0;
        }

        return chArr[getLoc++];
    }
    
    @Override
    public void reset() {
        char ch[] = new char[chArr.length];
        chArr = ch;
        putLoc = 0;
        getLoc = 0;
    }
}

class CircullarQueue implements ICharQ {
    private char chArr[];
    private int putLoc;
    private int getLoc;

    public CircullarQueue(int size) {
        chArr = new char [size + 1];
        putLoc = 0;
        getLoc = 0;
    }

    @Override
    public void put(char ch) {
        if(putLoc + 1 == getLoc | ((putLoc == chArr.length - 1) & (getLoc == 0))) {
            System.out.println("Queue is full!");
            return;
        }

        putLoc++;
        if(putLoc == chArr.length) {
            putLoc = 0;
        }
        chArr[putLoc] = ch;
    }

    @Override
    public char get() {
        if(getLoc == putLoc) {
            System.out.println("Queue is empty!");
            return (char) 0;
        }

        getLoc++;
        if(getLoc == chArr.length) {
            getLoc = 0;
        }
        return chArr[getLoc];
    }

    @Override
    public void reset() {
        char ch[] = new char[chArr.length];
        chArr = ch;
        putLoc = 0;
        getLoc = 0;
    }
}

class DynQueue implements ICharQ {
    private char chArr[];
    private int putLoc;
    private int getLoc;

    public DynQueue (int size) {
        chArr = new char [size];
        putLoc = 0;
        getLoc = 0;
    }

    @Override
    public void put(char ch) {
        if(putLoc == chArr.length) {
            char tmp[] = new char [chArr.length * 2];
            for (int i = 0; i < chArr.length; i++) {
                tmp[i] = chArr[i];
            }

            chArr = tmp;
        }

        chArr[putLoc] = ch;
        putLoc++;
    }

    @Override
    public char get() {
        if(putLoc == getLoc) {
            System.out.println("Queue is empty!");
            return (char) 0;
        }

        return chArr[getLoc++];
    }

    @Override
    public void reset() {
        char ch[] = new char[chArr.length];
        chArr = ch;
        putLoc = 0;
        getLoc = 0;
    }
} 

class DynCircullarQueue implements ICharQ {
    private char chArr[];
    private int putLoc;
    private int getLoc;

    public DynCircullarQueue(int size) {
        chArr = new char [size + 1];
        putLoc = 0;
        getLoc = 0;
    }

    @Override
    public void put(char ch) {
        if(putLoc + 1 == getLoc | ((putLoc == chArr.length) & getLoc == 0)) {
            char tmp[] = new char [chArr.length + 1];
            for (int i = 0; i < putLoc; i++) {
                tmp[i] = chArr[i];
            }
            
            tmp[putLoc] = ch;
            putLoc++;
            
            if(getLoc !=0) {
                getLoc++;
            }
            
            for (int i = putLoc - 1; i < chArr.length; i++) {
                tmp[i + 1] = chArr[i];
            }

            chArr = tmp;
            return;
        }

        chArr[putLoc++] = ch;
        if(putLoc == chArr.length && getLoc != 0) {
            putLoc = 0;
        }
    }

    @Override
    public char get() {
        if(getLoc == putLoc) {
            System.out.println("Queue is empty!");
            return (char) 0;
        }

        char ch = chArr[getLoc++];
    
        if(getLoc == chArr.length) {
            getLoc = 0;
        }
        return ch;
    }

    @Override
    public void reset() {
        char ch[] = new char[chArr.length];
        chArr = ch;
        putLoc = 0;
        getLoc = 0;
    }
}

class IQDemo {
    public static void main(String[] args) {
        FixedQueue fQueue = new FixedQueue(10);
        CircullarQueue cQueue = new CircullarQueue(10);
        DynQueue dQueue = new DynQueue(5);
        DynCircullarQueue dCirQueue = new DynCircullarQueue(10);

        ICharQ iQueue;

        char ch;

        /* ---------------------  Fixed Queue demonstration  ----------------------- */
        iQueue = fQueue;

        // Queuing characters
        for (int i = 0; i < 10; i++) {
            iQueue.put((char) ('A' + i));
        }
        
        // Print characters in Queue
        System.out.print("Fixed Queue: ");
        for (int i = 0; i < 10; i++) {
            ch = iQueue.get();
            System.out.print(ch + " ");
        }
        System.out.println();
        
        // Reset Fixed Queue
        iQueue.reset();

        System.out.print("Resetted Fixed Queue: ");
        ch = iQueue.get();
        System.out.print(ch + " ");
        System.out.println();

        /* -----------------------  Dynamic Queueu demonstration  --------------------- */
        iQueue = dQueue;
        
        // Queuing characters
        for (int i = 0; i < 10; i++) {
            iQueue.put((char) ('A' + i));
        }
        
        // Print characters in Queue
        System.out.print("Dynamic Queue: ");
        for (int i = 0; i < 10; i++) {
            ch = iQueue.get();
            System.out.print(ch + " ");
        }
        System.out.println();

        // Reset Dynamic Queue
        iQueue.reset();

        System.out.print("Resetted Dynamic Queue: ");
        ch = iQueue.get();
        System.out.print(ch + " ");
        System.out.println();


        /* -----------------------  Circullar Queueu demonstration  --------------------- */
        iQueue = cQueue;
        
        // Queuing characters
        for (int i = 0; i < 10; i++) {
            iQueue.put((char) ('A' + i));
        }
        
        // Print characters in Queue
        System.out.print("Circullar Queue: ");
        for (int i = 0; i < 10; i++) {
            ch = iQueue.get();
            System.out.print(ch + " ");
        }
        System.out.println();

        // Queuing extra characters
        for (int i = 10; i < 20; i++) {
            iQueue.put((char) ('A' + i));
        }

        // Print characters in Queue
        System.out.print("Circullar Queue (extra characters): ");
        for (int i = 0; i < 10; i++) {
            ch = iQueue.get();
            System.out.print(ch + " ");
        }
        System.out.println();

        // Using Circullar Queue for extra characters with saving data
        System.out.print("Circullar Queue (with saving): ");
        for (int i = 0; i < 20; i++) {
            iQueue.put((char) ('A' + i));
            ch = iQueue.get();
            System.out.print(ch + " ");
        }
        System.out.println();

        // Reset Circullar Queue
        iQueue.reset();

        System.out.print("Resetted Circullar Queue: "); 
        ch = iQueue.get();
        System.out.print(ch + " ");
        System.out.println();


        /* -----------------------  Dynamic Circullar Queueu demonstration  --------------------- */
        iQueue = dCirQueue;
        
        // Queuing characters
        for (int i = 0; i < 10; i++) {
            iQueue.put((char) ('A' + i));
        }
        
        // Print characters in Queue
        System.out.print("Dynamic Circullar Queue: ");
        for (int i = 0; i < 10; i++) {
            ch = iQueue.get();
            System.out.print(ch + " ");
        }
        System.out.println();

        // Queuing extra characters
        for (int i = 0; i < 20; i++) {
            iQueue.put((char) ('A' + i));
        } 

        for (int i = 20; i < 26; i++) {
            iQueue.put((char) ('A' + i));
        }

        // Print characters in Queue
        System.out.print("Dynamic Circullar Queue (extra characters): ");
        for (int i = 0; i < 26; i++) {
            ch = iQueue.get();
            System.out.print(ch + " ");
        }
        System.out.println();

        // Reset Circullar Queue
        iQueue.reset();

        System.out.print("Resetted Circullar Queue: "); 
        ch = iQueue.get();
        System.out.print(ch + " ");
    }
}