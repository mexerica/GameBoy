import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
   public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file: ");
        String file = scan.nextLine(); 
        scan.close();
        try {
            FileReader reader = new FileReader(file);
            int data = reader.read();
            while (data != -1) {
                System.out.println((char) data); 
                data = reader.read();
            }
            reader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
   }
}