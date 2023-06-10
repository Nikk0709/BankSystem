package applicat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    MiniStatement(String pinnumber){
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("Bank Name");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel account = new JLabel();
        account.setBounds(20, 80, 300, 20);
        add(account);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300, 20);
        add(balance);
        
        try{
            Conn con = new Conn();
            
            ResultSet rs = con.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                account.setText("Account Number: "+rs.getString("accountnumber").substring(0, 4)+"XXXXXXXX"+rs.getString("accountnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn con = new Conn();
            int bal = 0;
            ResultSet rs = con.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
               if(rs.getString("type").equals("Deposit")){
                       bal += Integer.parseInt(rs.getString("amount"));
                   } else {
                       bal -= Integer.parseInt(rs.getString("amount"));
                   }  
            }
            balance.setText("Your Account Balance is Rs"+bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        mini.setBounds(20, 140, 400, 200);
        
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
//        setUndecorated(true);
        setVisible(true);
    }
    
    
    public static void main(String args[]){
        new MiniStatement("");
    }
    
}
