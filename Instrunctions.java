import java.util.Arrays;
import java.util.ArrayList;

public class Instrunctions {
   static int[] memo = new int[65536];
   static int[] flags = {0, 0, 0, 0};// zero, subtraction, half carry and carry
   static short[] registers = {257,0,0,0}; //AF, BC, DE, HL
   //static byte registers = {0, 0, 0, 0, 0, 0, 0 ,0};
   static ArrayList<Integer> stack = new ArrayList<Integer>();
   static short PC = 0; // program counter 
   static short SP = 0; // stack pointer
   static boolean progress = true;
   static boolean parar = false;

    public int zeroFlag(int result) {
        return result == 0 ? 1 : 0;
    }

    public int subFlag(int ogVal, int newVal) {
        return ogVal > newVal ? 1 : 0;
    }
    
    public int carryFlag(byte ogVal, byte newVal) {
        return (ogVal + newVal) > 127 || (ogVal + newVal) < -127 ? 1 : 0;
    }

    public String halfCarry(short register) {
        String binary = Integer.toBinaryString(0xFFFF & register);
        while(binary.length() < 16) binary = "0" + binary;
        String[] bits = new String[] {binary};
        String firstHalf = String.join(",", Arrays.copyOfRange(bits, 0, 1));    
        System.out.println(firstHalf);
        return "";
    }

    public void Conversor16Para8Bits(short register) {
        short valor16Bits = (short) 0xABCD; // Exemplo de valor de 16 bits

        // Separando em bytes
        byte byteAlto = (byte) (valor16Bits >> 8);
        byte byteBaixo = (byte) valor16Bits;

        System.out.println("Valor de 16 bits: " + valor16Bits);
        System.out.println("Byte alto: " + byteAlto);
        System.out.println("Byte baixo: " + byteBaixo);
    }

    public void Instrunctions(String type, int target1, int target2){
        switch(type) {
            case "nop" : PC++; break;
            case "load" : break; 
            case "halt" : parar = true; break;
            case "ADD" : registers[0] += registers[target1]; break;
            case "ADDX" : registers[target1] += registers[target2]; break;
            case "ADDHL" : registers[3] += registers[target1]; break;
            //case "ADDHL" : registers[0] += registers[target1] * 256 + virtualregisters[3]; break;
            case "ADDC" : registers[0] += registers[target2] + flags[3]; break;
            case "SUB" : registers[0] -= registers[target1];break;
            case "SBC" :registers[0] += registers[target2] + flags[3]; break;
            case "INC" : ++registers[target1]; break;
            case "DEC" : --registers[target1]; break;
            case "CCF" : flags[3] = (flags[3] == 1 ? 0 : 1); break;
            case "SCF" : flags[3] = 1; break;
            case "RESET" : registers[target1]|= ~(1 << target2); break;
            case "SET" : registers[target1]|= 1 << target2; break;
            //case "cp" : static compare = registers[target1] - registers[target2];
            case "CPL" : for (int temp = 1; temp <= registers[0]; temp = temp << 1) registers[0] ^= temp; break;
            case "AND" : registers[0] &= registers[target1]; break;
            case "OR" : registers[0] |= registers[target1]; break;
            case "XOR" : registers[0] ^= registers[target1]; break;
            case "SRL" : registers[target1] >>>= 1; break;
            case "BIT" : progress = ((registers[target1] & (1 <<target2)) != 0); break;
            case "SRA" : registers[target1] >>= 1; break;
            case "SLA" : registers[target1] <<= 1; break;
            case "push" : stack.add(target1);
            case "pop" : stack.remove(0);
            default : break;
        }
   } 
}