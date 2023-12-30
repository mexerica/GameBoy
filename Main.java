import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
   private int[] memo = new int[65536]; 
   private int PC = 0;
   private int SP = 0;
    
   public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file: ");
        String file = scan.nextLine(); 
        scan.close();   
        try {
            FileReader reader = new FileReader(file);
            int data = reader.read();
            String content = "";
            while (data != -1) {
                content += (char) data;
                data = reader.read();
            }
            reader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
   }

   public int ReadByte( int address) {
    return memo[address];
   }

   public void WriteByte(int address , int value) {
    memo[address] = value;
   }
}