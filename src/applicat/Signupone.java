package applicat;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signupone extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, others, married, unmarried;
    JDateChooser dateChooser;
    Signupone(){
        
        setLayout(null);
        
        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Serif", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel fathername = new JLabel("Father's Name:");
        fathername.setFont(new Font("Raleway", Font.BOLD, 20));
        fathername.setBounds(100, 190, 200, 30);
        add(fathername);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Serif", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        others = new JRadioButton("Other");
        others.setBounds(630, 290, 120, 30);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);

        JLabel email = new JLabel("E-Mail:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Serif", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel maritalstatus = new JLabel("Marital Status:");
        maritalstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalstatus.setBounds(100, 390, 200, 30);
        add(maritalstatus);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 120, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        ButtonGroup marital = new ButtonGroup();
        marital.add(married);
        marital.add(unmarried);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Serif", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Serif", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Serif", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Serif", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setVisible(true);
        setLocation(350, 10);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if(female.isSelected()){
            gender = "Female";
        } else if(others.isSelected()){
            gender = "Other";
        }
        
        String email = emailTextField.getText();
        
        String maritalstatus=null;
        if(married.isSelected()){
            gender = "Married";
        } else if(unmarried.isSelected()){
            gender = "Unmarried";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pin = pinTextField.getText();
        String state = stateTextField.getText();
        
        
        try {
                if (nameTextField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the Fields");
                } else {
                    Conn con1 = new Conn();
                    String q = "insert into signup1 values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+maritalstatus+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                    con1.s.executeUpdate(q);
                    setVisible(false);
                    new Signuptwo(formno).setVisible(true);
                    
                    
                }
            }
            catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public static void main(String args[]){
        new Signupone();
    }
    
}
