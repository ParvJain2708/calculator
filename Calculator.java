import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField tf;
    double a = 0, b = 0, result = 0;
    char op;

    Calculator() {
        tf = new JTextField();
        tf.setBounds(30, 40, 230, 30);
        add(tf);

        String[] btns = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
        int x = 30, y = 80;
        for (String s : btns) {
            JButton b = new JButton(s);
            b.setBounds(x, y, 50, 40);
            b.addActionListener(this);
            add(b);
            x += 60;
            if (x > 200) { x = 30; y += 50; }
        }

        setLayout(null);
        setSize(300, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.equals(".")) {
            tf.setText(tf.getText() + s);
        } else if (s.equals("=")) {
            b = Double.parseDouble(tf.getText());
            switch (op) {
                case '+': result = a + b; break;
                case '-': result = a - b; break;
                case '*': result = a * b; break;
                case '/': result = a / b; break;
            }
            tf.setText("" + result);
        } else {
            a = Double.parseDouble(tf.getText());
            op = s.charAt(0);
            tf.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
