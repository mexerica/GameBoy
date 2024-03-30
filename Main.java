import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class Main {   
   private int[] memo = new int[65536];
   private boolean[] flags = new boolean[4]; // zero, subtraction, half carry and carry
   private byte[] registers = new byte[8]; // A, B, C, D, E, F, H, L
   private short[] virtualregisters = new short[4]; //AF, BC, DE, HL
   private int PC = 0; // program counter 
   private int SP = 0; // stack pointer
   private boolean progress = true;
   
   public static void main(String[] args) {
        JPanel[][] arr = new JPanel[160][144];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = new JPanel();
                arr[i][j].setBackground(Color.black);
                arr[i][j].setBounds(i * 1, j * 1,1,1);
            }
        }
        JPanel panel = new JPanel();
        panel.setBackground(Color.red);
        panel.setBounds(0,0,25,25);
        
        JFrame frame = new JFrame();
        frame.setSize(750,750);
        //frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Isso aqui é um titulo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < arr.length; i++) for (int j = 0; j < arr[i].length; j++) frame.add(arr[i][j]);
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
            case "ADD" : 
                registers[0] += registers[target1]; 
            break;
            case "ADDX" : 
                registers[target1] += registers[target2]; 
            break;
            case "ADDHL" : 
                registers[0] += registers[target1] * 256 + virtualregisters[3]; 
            break;
            case "ADDC" : 
                registers[0] += registers[target2] + (flags[3] ? 1 : 0); 
            break;
            case "SUB" : 
                registers[0] -= registers[target1];
            break;
            case "SBC" :
                registers[0] += registers[target2] + (flags[3] ? 1 : 0);
             break;
            case "INC" : 
                ++registers[target1]; 
            break;
            case "DEC" : 
                --registers[target1]; 
            break;
            case "CCF" : 
                flags[3] = !flags[3]; 
            break;
            case "SCF" : 
                flags[3] = true; 
            break;
            case "RESET" : 
                int maskr = 1 << registers[target1]; 
                //registers[target1] = (byte) (registers[target1] & ~maskr) | ((0 << registers[target2]) & maskr); 
            break;
            case "SET" : 
                int masks = 1 << registers[target1]; 
                //registers[target1] = (byte) (registers[target1] & ~masks) | ((1 << registers[target2]) & masks); 
            break;
            case "CPL" : 
                for (int temp = 1; temp <= registers[0]; temp = temp << 1) 
                    registers[0] ^= temp; 
            break;
            case "AND" : 
                registers[0] &= registers[target1];
            break;
            case "OR" : 
                registers[0] |= registers[target1]; 
            break;
            case "XOR" : 
                registers[0] ^= registers[target1]; 
            break;
            case "SRL" : 
                registers[target1] >>= 1; 
            break;
            default : break;
        }
   }
}

/*        
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
*/