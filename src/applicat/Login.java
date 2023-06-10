package applicat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, clear, signup;
    JTextField accountTextField;
    JPasswordField pinTextField;

Login(){
    
    setTitle("Create Bank Account");
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/download.png"));
    Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    label.setBounds(70, 10, 90, 90);
    add(label);
    JLabel text = new JLabel("Welcome To Bank");
    text.setFont(new Font("Serif", Font.BOLD, 38));
    text.setBounds(200, 20, 600, 70);
    add(text);
    
    
    JLabel account_no = new JLabel("Account No:");
    account_no.setFont(new Font("Raleway", Font.BOLD, 28));
    account_no.setBounds(120, 150, 1500, 30);
    add(account_no);
    
    accountTextField = new JTextField();
    accountTextField.setBounds(300, 150, 250, 30);
    accountTextField.setFont(new Font("Arial", Font.BOLD, 14));
    add(accountTextField);
    
    JLabel pin = new JLabel("Pin:");
    pin.setFont(new Font("Raleway", Font.BOLD, 28));
    pin.setBounds(120, 220, 250, 30);
    add(pin);
    
    pinTextField = new JPasswordField();
    pinTextField.setBounds(300, 220, 250, 30);
    pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
    add(pinTextField);
    
    login = new JButton("Sign In");
    login.setBounds(300, 300, 100, 30);
    login.setBackground(Color.BLACK);
    login.setForeground(Color.WHITE);
    login.addActionListener(this);
    add(login);
    
    clear = new JButton("Clear");
    clear.setBounds(430, 300, 100, 30);
    clear.setBackground(Color.BLACK);
    clear.setForeground(Color.WHITE);
    clear.addActionListener(this);
    add(clear);
    
    signup = new JButton("Sign Up");
    signup.setBounds(300, 350, 230, 30);
    signup.setBackground(Color.BLACK);
    signup.setForeground(Color.WHITE);
    signup.addActionListener(this);
    add(signup);
    
    getContentPane().setBackground(Color.white);
    setSize(800,480);
    setVisible(true);
    setLocation(350,200);
}

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            accountTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource()== login){
            Conn con = new Conn();
            String accountno = accountTextField.getText();
            String pinnumber = pinTextField.getText();
            String q = "select * from login where accountnumber = '"+accountno+"'and PIN = '"+pinnumber+"'";
        
            try{
                ResultSet rs = con.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Details");
                }
            } catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource()== signup){
            setVisible(false);
            new Signupone().setVisible(true);
            
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
