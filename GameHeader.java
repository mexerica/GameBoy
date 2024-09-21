import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;

public class GameHeader {
    public void Leitura(JFileChooser fileChooser) {
        //File bootFile = new File("../[BIOS] Nintendo Game Boy Boot ROM (World).gb");
        File file = fileChooser.getSelectedFile();
        String data = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line = br.readLine(); line != null; line = br.readLine()) data += line;
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        System.out.println(data);
    }
}