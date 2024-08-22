import java.util.Arrays; 
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {   
   static int[] memo = new int[65536];
   static boolean[] flags = {true, true, true,true};//new boolean[4]; // zero, subtraction, half carry and carry
   static byte[] registers = {0,0,0,0,0,0,0,0}; // A, B, C, D, E, F, H, L
   static short[] virtualregisters = {0,0,0,0}; //AF, BC, DE, HL
   static int PC = 0; // program counter 
   static int SP = 0; // stack pointer
   static boolean progress = true; 
   
   public static void main(String[] args) {
        Display Display = new Display();

        JPanel[][] screen = Display.Screen();
        
        JFrame frame = new JFrame();
        frame.setSize(320,416);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Isso aqui é um titulo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < screen.length; i++) 
            for (int j = 0; j < screen[i].length; j++) frame.add(screen[i][j]);
        frame.add(Display.Select());
        frame.add(Display.Reset());
        frame.setVisible(true);         
   }

   public int ReadByte(int address) {
        return memo[address];
   }

   public void WriteByte(int address , int value) {
        memo[address] = value;
   }


   public void Instrunctions(String type, int target1, int target2){
        switch(type) {
            case "ADD" : registers[0] += registers[target1]; break;
            case "ADDX" : registers[target1] += registers[target2]; break;
            case "ADDHL" : registers[0] += registers[target1] * 256 + virtualregisters[3]; break;
            case "ADDC" : registers[0] += registers[target2] + (flags[3] ? 1 : 0); break;
            case "SUB" : registers[0] -= registers[target1];break;
            case "SBC" :registers[0] += registers[target2] + (flags[3] ? 1 : 0); break;
            case "INC" : ++registers[target1]; break;
            case "DEC" : --registers[target1]; break;
            case "CCF" : flags[3] = !flags[3]; break;
            case "SCF" : flags[3] = true; break;
            case "RESET" : registers[target1]|= ~(1 << target2); break;
            case "SET" : registers[target1]|= 1 << target2; break;
            case "CPL" : for (int temp = 1; temp <= registers[0]; temp = temp << 1) registers[0] ^= temp; break;
            case "AND" : registers[0] &= registers[target1]; break;
            case "OR" : registers[0] |= registers[target1]; break;
            case "XOR" : registers[0] ^= registers[target1]; break;
            case "SRL" : registers[target1] >>>= 1; break;
            case "BIT" : progress = ((registers[target1] & (1 <<target2)) != 0); break;
            case "SRA" : registers[target1] >>= 1; break;
            case "SLA" : registers[target1] <<= 1; break;
            default : break;
        }
   }
}