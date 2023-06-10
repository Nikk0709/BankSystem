package applicat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
   
    JButton h, fh, t, twt, ft, tt, back;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        h = new JButton("100");
        h.setBounds(170, 415, 150, 30);
        h.addActionListener(this);
        image.add(h);
        
        fh = new JButton("500");
        fh.setBounds(355, 415, 150, 30);
        fh.addActionListener(this);
        image.add(fh);
        
        t = new JButton("1000");
        t.setBounds(170, 450, 150, 30);
        t.addActionListener(this);
        image.add(t);
        
        twt = new JButton("2000");
        twt.setBounds(355, 450, 150, 30);
        twt.addActionListener(this);
        image.add(twt);
        
        ft = new JButton("5000");
        ft.setBounds(170, 485, 150, 30);
        ft.addActionListener(this);
        image.add(ft);
        
        tt = new JButton("10000");
        tt.setBounds(355, 485, 150, 30);
        tt.addActionListener(this);
        image.add(tt);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
               ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
               int balance = 0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                   } else {
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
               }
               
               if(ae.getSource()!= back && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   return;
               }
               
               Date date = new Date();
               String q = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
               c.s.executeUpdate(q);
               JOptionPane.showMessageDialog(null, "Debited Successfully");
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
            
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new FastCash("");
    }
    
}
