import java.util.Arrays; 
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {   
   public static void main(String[] args) {
          Display Display = new Display();
          Instrunctions Instrunctions = new Instrunctions(); 
          short test = 400;
          Display.Interface(Instrunctions.registers, Instrunctions.flags, Instrunctions.PC, Instrunctions.SP); 
          Instrunctions.Conversor16Para8Bits(test);
   }
   /*
   public int ReadByte(int address) {
        return memo[address];
   }

   public void WriteByte(int address , int value) {
        memo[address] = value;
   }*/
}