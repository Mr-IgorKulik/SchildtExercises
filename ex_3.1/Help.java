class Help {
    public static void main(String[] args) 
        throws java.io.IOException {
            
        char choice;

        System.out.println("Help:");
        System.out.println("1. if");
        System.out.println("2. switch");
        System.out.print("Make a choice: ");
    
        choice = (char) System.in.read();

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
            default:
            System.out.println("Request not found!");
        }
    }
}