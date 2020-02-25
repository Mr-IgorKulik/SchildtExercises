import java.io.*;

class CompFiles {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;

        if(args.length != 2) {
            System.out.println("Usage: CompFiles file1 file2");
            return;
        }

        try (FileInputStream file1 = new FileInputStream(args[0]);
        FileInputStream file2 = new FileInputStream(args[1]);) 
        {
            do {
                i = file1.read();
                j = file2.read();
                if(i != j) break;
             } while (i != -1 && j != -1);

             if (i != j) {
                 System.out.println("Files are different.");
             } else {
                System.out.println("Files are the same.");
             }
            
        } catch (IOException exc) {
            System.out.println("Input-output exception: " + exc);
        }
    }
}
