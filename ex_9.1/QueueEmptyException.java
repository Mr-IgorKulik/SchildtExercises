public class QueueEmptyException extends Exception {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Queue is empty!";
    }
}