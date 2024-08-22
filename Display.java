import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
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
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    select.setEnabled(false);
                }
            }
        });
        return select;
    }
}