package reptositories.consolereader;


import java.util.Scanner;

public class ConsoleReader {

    public String readAndReturnCity() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter city name: ");
            if (!scanner.hasNext()) {
                System.out.println("empty...");
            } else if (scanner.hasNext()) {
                return scanner.next();
            }
        }
    }


}
