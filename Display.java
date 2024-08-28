import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;  
import java.awt.Color;

public class Display {
    public JPanel[][] Screen() {
        JPanel[][] screen = new JPanel[160][144];
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[i].length; j++) {
                screen[i][j] = new JPanel();
                screen[i][j].setBackground(Color.black);
                screen[i][j].setBounds(i * 2, j * 2,2,2);
            }
        }
        return screen;
    }


    public JButton Reset() {
        JButton resetBtn = new JButton();
        resetBtn.setText("Resete o console");
        resetBtn.setBounds(0, 338, 320, 50);
        resetBtn.setEnabled(false);
        return resetBtn;
    }

    public JButton Select() {
        JButton select = new JButton();
        select.setText("Selecione  o arquivo");
        select.setBounds(0, 288, 320, 50);
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("game boy roms", "gb");
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    select.setText("Selecione outro arquivo");
                    select.setEnabled(false);
                }
            }
        });
        return select;
    }

    public JLabel Info(short[] registers) {
        JLabel Info = new JLabel();
        final String n = "AF " + registers[0] + "AF " + registers[0];
        Info.setSize(300,100); 

        Info.setText(n);
        Info.setBounds(330, 0, 50, 50);
        Info.setVisible(true);
        return Info;
    }

    public JFrame Interface(short[] registers) {
        JPanel[][] screen = Screen();
        JFrame frame = new JFrame();
        frame.setSize(480,416);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Isso aqui é um titulo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < screen.length; i++) 
            for (int j = 0; j < screen[i].length; j++) frame.add(screen[i][j]);
        frame.add(Select());
        frame.add(Reset());
        frame.add(Info(registers));
        frame.setVisible(true);  
        return frame;
    }
}