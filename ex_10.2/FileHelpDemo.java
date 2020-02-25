class FileHelpDemo {
    public static void main(String[] args) {
        Help hlpObj = new Help("helpfile.txt");
        String topic;

        System.out.println("Use the help system.\n" +
            "Enter the \"stop\" to exit the system");

        do {
            topic = hlpObj.getSelection();
            System.out.println();
            if(!hlpObj.helpOn(topic)) {
                System.out.println("The subject is not found.\n");
            }
        } while (topic.compareTo("stop") != 0);
    }
}