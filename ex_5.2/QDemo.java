class Queue {
    char q[];
    int getLoc, putLoc;

    Queue (int size) {
        q = new char[size];
        getLoc = putLoc = 0;
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
        System.out.print("Alphabet in bigQueue: ");
        for (int i = 0; i < 26; i++) {
            ch = bigQ.get();
            System.out.print(ch + " ");
        }
        System.out.println();
    }
}