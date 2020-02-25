import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;


class Help {
    String helpFile;

    Help(String fName) {
        helpFile = fName;
    }

    boolean helpOn (String instruction) {
        int ch;
        String topic, info;

        try (BufferedReader helpReader = 
            new BufferedReader(new FileReader(helpFile))) {
                
                do {
                    ch = helpReader.read();

                    if(ch == '#') {
                        topic = helpReader.readLine();
                        if(instruction.compareTo(topic) == 0) {
                            do {
                                info = helpReader.readLine();
                                if (info != null) {
                                    System.out.println(info);
                                }
                            } while (info != null && (info.compareTo("") != 0));
                            return true;
                        }
                    }
                } while (ch != -1);
            
        } catch (IOException exc) {
            System.out.println("Error trying to access file.");
            return false;
        }
        return false;
    }


    String getSelection() {
        String topic = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Indicate subject: ");

        try {
            topic = br.readLine();
        } catch (IOException exc) {
            System.out.println("Error reading from console.");
        }
        return topic;
    }
}