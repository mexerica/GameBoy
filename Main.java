import java.util.Arrays; 
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {   
   static int[] memo = new int[65536];
   static int[] flags = {0, 0, 0, 0};// zero, subtraction, half carry and carry
   static short[] registers = {0,0,0,0}; //AF, BC, DE, HL
   //static byte registers = {0, 0, 0, 0, 0, 0, 0 ,0};
   static short PC = 0; // program counter 
   static short SP = 0; // stack pointer
   
   public static void main(String[] args) {
        Display Display = new Display();
        Instrunctions Instrunctions = new Instrunctions();  
        Display.Interface(); 
   } 

   public int ReadByte(int address) {
        return memo[address];
   }

   public void WriteByte(int address , int value) {
        memo[address] = value;
   }
}