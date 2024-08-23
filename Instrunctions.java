public class Instrunctions {
    public int zeroFlag(int val) {
        return val == 0 ? 1 : 0;
    }

    public int subFlag(int val1, int val2) {
        return val1 > val2 ? 1 : 0;
    }
    
    public int carryFlag(byte val1, byte val2) {
        return (val1 + val2) > 127 || (val1 + val2) < -127 ? 1 : 0;
    }

    public int halfCarry(byte val) {
        return 1;
    }
    /*
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
   } */
}