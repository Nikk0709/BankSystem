package applicat;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signuptwo extends JFrame implements ActionListener{
    
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox caste, category, occupation, income, education;
    String formno;
    
    Signuptwo(String formno){
        this.formno = formno;
        setLayout(null);
       
        setTitle("New Account Application - Page 2");
        
       
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel castes = new JLabel("Caste:");
        castes.setFont(new Font("Raleway", Font.BOLD, 20));
        castes.setBounds(100, 140, 100, 30);
        add(castes);
        
        String valcaste[] = {"General", "OBC", "SC", "ST"};
        caste= new JComboBox(valcaste); 
        caste.setBounds(300, 140, 400, 30);
        caste.setBackground(Color.white);
        add(caste);
        
        
        
        JLabel categories = new JLabel("Category:");
        categories.setFont(new Font("Raleway", Font.BOLD, 20));
        categories.setBounds(100, 190, 200, 30);
        add(categories);
        
        String valcategory[] = {"Normal Account", "NetBanking"};
        category= new JComboBox(valcategory); 
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel inc = new JLabel("Income:");
        inc.setFont(new Font("Raleway", Font.BOLD, 20));
        inc.setBounds(100, 240, 200, 30);
        add(inc);
        
        String valincome[] = {"<1,00,000", "<2,50,000", "<5,00,000", ">5,00,000"};
        income= new JComboBox(valincome); 
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
       
        JLabel educations = new JLabel("Qualification:");
        educations.setFont(new Font("Raleway", Font.BOLD, 20));
        educations.setBounds(100, 290, 200, 30);
        add(educations);
        
        String educationvalues[] = {"Non-Graduate", "Graduate", "Post-Graduation", "None"};
        education= new JComboBox(educationvalues); 
        education.setBounds(300, 290, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        JLabel occupations = new JLabel("Occupation:");
        occupations.setFont(new Font("Raleway", Font.BOLD, 20));
        occupations.setBounds(100, 340, 200, 30);
        add(occupations);
        
        
        String occupationValues[] = {"Salaried", "Self-Employed", "Buisness Man", "Student", "Others"};
        occupation= new JComboBox(occupationValues); 
        occupation.setBounds(300, 340, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel panno = new JLabel("PAN No:");
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        panno.setBounds(100, 390, 200, 30);
        add(panno);
        
        pan = new JTextField();
        pan.setFont(new Font("Serif", Font.BOLD, 14));
        pan.setBounds(300, 390, 400, 30);
        add(pan);
        
        JLabel adhar = new JLabel("Aadhar No:");
        adhar.setFont(new Font("Raleway", Font.BOLD, 20));
        adhar.setBounds(100, 440, 200, 30);
        add(adhar);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Serif", Font.BOLD, 14));
        aadhar.setBounds(300, 440, 400, 30);
        add(aadhar);
        
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 490, 200, 30);
        add(senior);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 490, 200, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(480, 490, 200, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup s = new ButtonGroup();
        s.add(syes);
        s.add(sno);
        
        JLabel exist = new JLabel("Existing Account:");
        exist.setFont(new Font("Raleway", Font.BOLD, 20));
        exist.setBounds(100, 540, 200, 30);
        add(exist);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 540, 200, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(480, 540, 200, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup e = new ButtonGroup();
        e.add(eyes);
        e.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 590, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setVisible(true);
        setLocation(350, 10);
    }
    
    public void actionPerformed(ActionEvent ae){
        String scaste = (String)caste.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String educat = (String) education.getSelectedItem();
        String occup = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        } else if(sno.isSelected()){
            seniorcitizen = "No";
        } 
        
        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        } else if(eno.isSelected()){
            existingaccount = "No";
        }
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try {
                    Conn con1 = new Conn();
                    String q = "insert into signup2 values('"+formno+"', '"+scaste+"', '"+scategory+"', '"+sincome+"', '"+educat+"', '"+occup+"', '"+seniorcitizen+"', '"+span+"', '"+saadhar+"', '"+existingaccount+"')";
                    con1.s.executeUpdate(q);
                    
                    setVisible(false);
                    new SignupThree(formno).setVisible(true);
                }
            catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public static void main(String args[]){
        new Signuptwo("");
    }
    
}

