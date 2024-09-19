import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;


public class GameHeader {
    public void Leitura(JFileChooser fileChooser) {
        File file = fileChooser.getSelectedFile();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}