class QuickSort {

    private static void qs (char items[], int left, int right) {
        int i, j;
        char centralEl, tmp;

        i = left;
        j = right;

        centralEl = items[(left + right) / 2];

        do {
            while ((items[i] < centralEl) && (i < right)) i++;
            while ((items[j] > centralEl) && (j > left)) j--;
            
            if (i <= j) {
                tmp = items[i];
                items[i] = items[j];
                items[j] = tmp;
                i++;
                j--;
            }
        } while (i <= j);

        if (left < j) qs(items, left, j);
        if (i < right) qs(items, i, right);

    }

    static void qSort (char items[]) {
        qs(items, 0, items.length - 1);
    }
}

class QSDemo {
    public static void main(String[] args) {
        char chArr[] = { 'd', 'x', 'a', 'r', 'p', 'j', 'i' };

        System.out.println("Source array: ");
        for (int i = 0; i < chArr.length; i++) {
            System.out.print(chArr[i] + " ");
        }
        System.out.println();

        QuickSort.qSort(chArr);

        System.out.println("Sorted array: ");
        for (int i = 0; i < chArr.length; i++) {
            System.out.print(chArr[i] + " ");
        }
        System.out.println();
    }
}