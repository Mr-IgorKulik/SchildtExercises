import sun.awt.www.content.audio.wav;

class Help {
    public static void main(String[] args) 
        throws java.io.IOException {
            
        char choice, ignore;

        for (;;) {
            do {
                System.out.println();
                System.out.println("Help:");
                System.out.println("    1. if");
                System.out.println("    2. switch");
                System.out.println("    3. for");
                System.out.println("    4. while");
                System.out.println("    5. do - while");
                System.out.println("    6. break");
                System.out.println("    7. continue\n");
                System.out.print("Make a choice (q - exit): ");
        
                choice = (char) System.in.read();

                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } while (choice < '1' | choice > '7' & choice != 'q');

            if (choice == 'q') break;

            System.out.println("\n");

            switch (choice) {
                case '1': 
                    System.out.println("if instructions:\n");
                    System.out.println("if (condition) instruction;");
                    System.out.println("else instruction;");
                    break;

                case '2':
                    System.out.println("switch instructions:\n");
                    System.out.println("switch (expression) {");
                    System.out.println("    case const:");
                    System.out.println("        instructions...");
                    System.out.println("        break;");
                    System.out.println("    // ...");
                    System.out.println("}");
                    break;

                case '3':
                    System.out.println("for loop:\n");
                    System.out.println("for (initialization; condition; iteration) {");
                    System.out.println("    instructions ... \n}");
                    break;

                case '4':
                    System.out.println("while loop:\n");
                    System.out.println("while (condition) {");
                    System.out.println("    instructions ... \n}");
                    break;

                case '5':
                    System.out.println("do - while loop:\n");
                    System.out.println("do {\n  instructions... \n} while (condition);");
                    break;

                case '6':
                    System.out.println("break instruction:\n");
                    System.out.println("break; OR break mark;");
                    break;

                case '7':
                    System.out.println("continue instructions:\n");
                    System.out.println("continue; OR continue mark;");
                    break;
                
                default:
                System.out.println("Request not found!");
            }
        }
    }
} 