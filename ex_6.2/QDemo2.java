class Queue {
    private char q[];
    private int getLoc, putLoc;

    Queue (int size) {
        q = new char[size];
        getLoc = putLoc = 0;
    }

    Queue (Queue obj) {
        getLoc = obj.getLoc;
        putLoc = obj.putLoc;
        q = new char[obj.q.length];

        for (int i = getLoc; i < putLoc; i++) {
            q[i] = obj.q[i];
        }
    }

    Queue (char[] chArr) {
        getLoc = putLoc = 0;
        q = new char[chArr.length + 1];

        for (int i = 0; i < chArr.length; i++) {
            put(chArr[i]);
        }
    }

    void put(char ch) {
        if (putLoc == q.length) {
            System.out.println("Queue is full!");
            return;
        }

        q[putLoc] = ch;
        putLoc++;
    }

    char get() {
        if (putLoc == getLoc) {
            System.out.println("Queue is empty!");
            return '0';
        }

        return q[getLoc++];
    }
}

class QDemo {
    public static void main(String[] args) {
        Queue bigQ = new Queue(26);
        char ch;

        System.out.println("Using big Queue to save alphabet");
        for (int i = 0; i < 26; i++) {
            bigQ.put( (char) ('A' + i));
        }
        Queue q2 = new Queue(bigQ);
        System.out.print("Alphabet in bigQueue: ");
        for (int i = 0; i < 26; i++) {
            ch = bigQ.get();
            System.out.print(ch + " ");
        }
        System.out.println();

        char name[] = {'I', 'g', 'o', 'r'};
        Queue q1 = new Queue(name);
        System.out.print("Using constructor with char array: ");
        for (int i = 0; i < 4; i++) {
            ch = q1.get();
            System.out.print(ch);
        }
        System.out.println();

        
        System.out.print("Using constructor with object Queue (alphabet again):  ");
        for (int i = 0; i < 26; i++) {
            ch = q2.get();
            System.out.print(ch + " ");
        }
    }
}