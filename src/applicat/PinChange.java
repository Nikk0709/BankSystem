package applicat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);
        
        JLabel pintext = new JLabel("NEW PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);
        
        JLabel retext = new JLabel("RE ENTER PIN");
        retext.setForeground(Color.WHITE);
        retext.setFont(new Font("System", Font.BOLD, 16));
        retext.setBounds(165, 360, 400, 25);
        image.add(retext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== change){
        try{
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "PIN doest not match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "PIN is Empty");
                return;
            }
            
            if (rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter PIN Again");
                return;
            }
            
            Conn con = new Conn();
            String q = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
            String q1 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
            String q2 = "update signup33 set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
            
            con.s.executeUpdate(q);
            con.s.executeUpdate(q1);
            con.s.executeUpdate(q2);
            
            JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
        
            setVisible(false);
            new Transactions(rpin).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
