package Admin;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import main.main;
public class AdminProfileUpdate extends JPanel implements MouseListener{
	//JPanel ViewPanel;
	Icon ProfIcon,EditIcon,BackIcon;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	JLabel UserNameTop;
	JLabel firstNameLabel,lastNameLabel, contactNoLabel,DOBLabel,ageLabel,JoinDateLabel,pAddressLabel,tAddressLabel,martialLabel,designationLabel, salaryLabel, stateLabel, districtLabel;
	JTextField firstNameValue,lastNameValue,contactNoValue,DOBValue,ageValue,JoinDateValue,martialValue,designationValue, salaryValue, stateValue, districtValue;
	JLabel Collon1,Collon2,Collon3,Collon4,Collon5,Collon6,Collon7,Collon8,Collon9, Collon10, Collon11, Collon12;
	JButton ProfIconLabel,BackIconLabel,EditIconLabel;
	JButton SaveButton;
        JTextArea pAddressValue, tAddressValue;
	int X=230,Y=90;
	int R=34,G=34,B=45;
	int labelFontSize=20;
	public AdminProfileUpdate() {
		// TODO Auto-generated constructor stub
		
		
		
		//profile image
		
		ProfIcon=new ImageIcon(getClass().getResource("/Images/ProfileImage.png"));
		ProfIconLabel=new JButton(ProfIcon);
		ProfIconLabel.setBounds(X-130,Y-75,120,120);
		ProfIconLabel.setVisible(true);
		ProfIconLabel.setBackground(new Color(R,G,B));
		ProfIconLabel.setBorder(emptyBorder);
		add(ProfIconLabel);
		
		//back icon
		
		BackIcon=new ImageIcon(getClass().getResource("/Images/arrow_back_button.png"));
		BackIconLabel=new JButton(BackIcon);
		BackIconLabel.setBounds(10,10,30,30);
		BackIconLabel.setVisible(true);
		BackIconLabel.setBackground(new Color(R,G,B));
		BackIconLabel.setBorder(emptyBorder);
                BackIconLabel.setContentAreaFilled(false);
                BackIconLabel.addMouseListener(this);
		add(BackIconLabel);
		
		
		//Usernametop
		
		UserNameTop=new JLabel("Hello world");
		UserNameTop.setBounds(X,Y-90,1000,150);
		UserNameTop.setFont(new Font("Bold",Font.BOLD,labelFontSize+20));
		UserNameTop.setForeground(Color.WHITE);
		add(UserNameTop);
		
		
		// usernamelabel 
		
		firstNameLabel=new JLabel("FIRST NAME");
		firstNameLabel.setBounds(X-150,Y,200,150);
		firstNameLabel.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		firstNameLabel.setForeground(Color.WHITE);
		Collon1=new JLabel(":");
		Collon1.setBounds(X+60+30,Y,20,150);
		Collon1.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		Collon1.setForeground(Color.WHITE);
		
		//usernamevalue label
		
		firstNameValue=new JTextField("First Name");
		firstNameValue.setBounds(X+240-120,Y+60,300,35);
		firstNameValue.setFont(new Font("Segoe UI",Font.PLAIN,labelFontSize));
                firstNameValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		firstNameValue.setBackground(Color.WHITE);
		firstNameValue.setForeground(Color.GRAY);
                firstNameValue.addMouseListener(this);
		
		add(firstNameLabel);
		add(Collon1);
		add(firstNameValue);
                
                lastNameLabel=new JLabel("LAST NAME");
		lastNameLabel.setBounds(X+240+220,Y,200,150);
		lastNameLabel.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		lastNameLabel.setForeground(Color.WHITE);
		Collon2=new JLabel(":");
		Collon2.setBounds(X+450+150+40+30+10,Y,20,150);
		Collon2.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon2.setForeground(Color.WHITE);
		
		//usernamevalue label
		
		lastNameValue=new JTextField("Last Name");
		lastNameValue.setBounds(X+240+300+100+60+10,Y+60,300,35);
		lastNameValue.setFont(new Font("Segoe UI",Font.PLAIN,labelFontSize));
                lastNameValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		lastNameValue.setBackground(Color.WHITE);
		lastNameValue.setForeground(Color.GRAY);
                lastNameValue.addMouseListener(this);
		
		add(lastNameLabel);
		add(Collon2);
		add(lastNameValue);
                
                DOBLabel=new JLabel("DOB");
		DOBLabel.setBounds(X-150,Y+70,200,150);
		DOBLabel.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		DOBLabel.setForeground(Color.WHITE);
		Collon3=new JLabel(":");
		Collon3.setBounds(X+60+30,Y+70,20,150);
		Collon3.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		Collon3.setForeground(Color.WHITE);
		
		//usernamevalue label
		
		DOBValue=new JTextField("DOB");
		DOBValue.setBounds(X+240-120,Y+60+70,300,35);
		DOBValue.setFont(new Font("Segoe UI",Font.PLAIN,labelFontSize));
                DOBValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		DOBValue.setBackground(Color.WHITE);
		DOBValue.setForeground(Color.GRAY);
                DOBValue.addMouseListener(this);
		
		add(DOBLabel);
		add(Collon3);
		add(DOBValue);
                
                ageLabel=new JLabel("AGE");
		ageLabel.setBounds(X+240+220,Y+70,200,150);
		ageLabel.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		ageLabel.setForeground(Color.WHITE);
		Collon4=new JLabel(":");
		Collon4.setBounds(X+450+150+40+30+10,Y+70,20,150);
		Collon4.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon4.setForeground(Color.WHITE);
		
		//usernamevalue label
		
		ageValue=new JTextField("AGE");
		ageValue.setBounds(X+240+300+100+60+10,Y+60+70,300,35);
		ageValue.setFont(new Font("Segoe UI",Font.PLAIN,labelFontSize));
                ageValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		ageValue.setBackground(Color.WHITE);
		ageValue.setForeground(Color.GRAY);
                ageValue.addMouseListener(this);
		
		add(ageLabel);
		add(Collon4);
		add(ageValue);
                
                contactNoLabel=new JLabel("CONTACT NUMBER");
		contactNoLabel.setBounds(X-150,Y+70+70,200,150);
		contactNoLabel.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		contactNoLabel.setForeground(Color.WHITE);
		Collon5=new JLabel(":");
		Collon5.setBounds(X+60+30,Y+70+70,20,150);
		Collon5.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		Collon5.setForeground(Color.WHITE);
		
		//usernamevalue label
		
		contactNoValue=new JTextField("Contact Number");
		contactNoValue.setBounds(X+240-120,Y+60+70+70,300,35);
		contactNoValue.setFont(new Font("Segoe UI",Font.PLAIN,labelFontSize));
                contactNoValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		contactNoValue.setBackground(Color.WHITE);
		contactNoValue.setForeground(Color.GRAY);
                contactNoValue.addMouseListener(this);
		
		add(contactNoLabel);
		add(Collon5);
		add(contactNoValue);
                
                martialLabel=new JLabel("MARTIAL STATUS");
		martialLabel.setBounds(X+240+220,Y+70+70,200,150);
		martialLabel.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		martialLabel.setForeground(Color.WHITE);
		Collon6=new JLabel(":");
		Collon6.setBounds(X+450+150+40+30+10,Y+70+70,20,150);
		Collon6.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon6.setForeground(Color.WHITE);
		
		//usernamevalue label
		
		martialValue=new JTextField("Martial Status");
		martialValue.setBounds(X+240+300+100+60+10,Y+60+70+70,300,35);
		martialValue.setFont(new Font("Segoe UI",Font.PLAIN,labelFontSize));
                martialValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		martialValue.setBackground(Color.WHITE);
		martialValue.setForeground(Color.GRAY);
                martialValue.addMouseListener(this);
		
		add(martialLabel);
		add(Collon6);
		add(martialValue);
		
                
                salaryLabel=new JLabel("SALARY");
		salaryLabel.setBounds(X-150,Y+70+70+70,200,150);
		salaryLabel.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		salaryLabel.setForeground(Color.WHITE);
		Collon7=new JLabel(":");
		Collon7.setBounds(X+60+30,Y+70+70+70,20,150);
		Collon7.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		Collon7.setForeground(Color.WHITE);
		
		//usernamevalue label
		
		salaryValue=new JTextField("Salary");
		salaryValue.setBounds(X+240-120,Y+60+70+70+70,300,35);
		salaryValue.setFont(new Font("Segoe UI",Font.PLAIN,labelFontSize));
                salaryValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		salaryValue.setBackground(Color.WHITE);
		salaryValue.setForeground(Color.GRAY);
                salaryValue.addMouseListener(this);
		
		add(salaryLabel);
		add(Collon7);
		add(salaryValue);
                
                designationLabel=new JLabel("DESIGNATION");
		designationLabel.setBounds(X+240+220,Y+70+70+70,200,150);
		designationLabel.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		designationLabel.setForeground(Color.WHITE);
		Collon8=new JLabel(":");
		Collon8.setBounds(X+450+150+40+30+10,Y+70+70+70,20,150);
		Collon8.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon8.setForeground(Color.WHITE);
		
		//usernamevalue label
		
		designationValue=new JTextField("Designation");
		designationValue.setBounds(X+240+300+100+60+10,Y+60+70+70+70,300,35);
		designationValue.setFont(new Font("Segoe UI",Font.PLAIN,labelFontSize));
                designationValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		designationValue.setBackground(Color.WHITE);
		designationValue.setForeground(Color.GRAY);
                designationValue.addMouseListener(this);
		
		add(designationLabel);
		add(Collon8);
		add(designationValue);
                
                stateLabel=new JLabel("STATE");
		stateLabel.setBounds(X-150,Y+70+70+70+70,200,150);
		stateLabel.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		stateLabel.setForeground(Color.WHITE);
		Collon9=new JLabel(":");
		Collon9.setBounds(X+60+30,Y+70+70+70+70,20,150);
		Collon9.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		Collon9.setForeground(Color.WHITE);
		
		//usernamevalue label
		
		stateValue=new JTextField("State");
		stateValue.setBounds(X+240-120,Y+60+70+70+70+70,300,35);
		stateValue.setFont(new Font("Segoe UI",Font.PLAIN,labelFontSize));
                stateValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		stateValue.setBackground(Color.WHITE);
		stateValue.setForeground(Color.GRAY);
                stateValue.addMouseListener(this);
		
		add(stateLabel);
		add(Collon9);
		add(stateValue);
                
                districtLabel=new JLabel("DISTRICT");
		districtLabel.setBounds(X+240+220,Y+70+70+70+70,200,150);
		districtLabel.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		districtLabel.setForeground(Color.WHITE);
		Collon10=new JLabel(":");
		Collon10.setBounds(X+450+150+40+30+10,Y+70+70+70+70,20,150);
		Collon10.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon10.setForeground(Color.WHITE);
                
                districtValue=new JTextField("District");
		districtValue.setBounds(X+240+300+100+60+10,Y+60+70+70+70+70,300,35);
		districtValue.setFont(new Font("Segoe UI",Font.PLAIN,labelFontSize));
                districtValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		districtValue.setBackground(Color.WHITE);
		districtValue.setForeground(Color.GRAY);
                districtValue.addMouseListener(this);
		
		add(districtLabel);
		add(Collon10);
		add(districtValue);
		
		
                
                pAddressLabel=new JLabel("PERMANENT ADDRESS");
		pAddressLabel.setBounds(X-150,Y+70+70+70+70+70,230,150);
		pAddressLabel.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		pAddressLabel.setForeground(Color.WHITE);
		Collon11=new JLabel(":");
		Collon11.setBounds(X+60+30,Y+70+70+70+70+70,20,150);
		Collon11.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		Collon11.setForeground(Color.WHITE);
		
		//usernamevalue label
		
		pAddressValue=new JTextArea("Permanent Address");
		pAddressValue.setBounds(X+240-120,Y+60+70+70+70+70+70,300,100);
		pAddressValue.setFont(new Font("Segoe UI",Font.PLAIN,labelFontSize));
                pAddressValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		pAddressValue.setBackground(Color.WHITE);
		pAddressValue.setForeground(Color.GRAY);
                pAddressValue.setLineWrap(true);
                pAddressValue.setWrapStyleWord(true);
                pAddressValue.addMouseListener(this);
		
		add(pAddressLabel);
		add(Collon11);
		add(pAddressValue);
                
                tAddressLabel=new JLabel("TEMPRORY ADDRESS");
		tAddressLabel.setBounds(X+240+220,Y+70+70+70+70+70,230,150);
		tAddressLabel.setFont(new Font("Segoe UI",Font.BOLD,labelFontSize));
		tAddressLabel.setForeground(Color.WHITE);
		Collon12=new JLabel(":");
		Collon12.setBounds(X+450+150+40+30+10,Y+70+70+70+70+70,20,150);
		Collon12.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon12.setForeground(Color.WHITE);
                
                tAddressValue=new JTextArea("Temprory Address");
		tAddressValue.setBounds(X+240+300+100+60+10,Y+60+70+70+70+70+70,300,100);
		tAddressValue.setFont(new Font("Segoe UI",Font.PLAIN,labelFontSize));
                tAddressValue.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		tAddressValue.setBackground(Color.WHITE);
		tAddressValue.setForeground(Color.GRAY);
                tAddressValue.setLineWrap(true);
                tAddressValue.setWrapStyleWord(true);
                tAddressValue.addMouseListener(this);
		
		add(tAddressLabel);
		add(Collon12);
		add(tAddressValue);
                
		//contactno label
		
//		ContactNoLabel=new JLabel("Contact Number");
//		ContactNoLabel.setBounds(X,Y+60,200,150);
//		ContactNoLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		ContactNoLabel.setForeground(Color.WHITE);
//		Collon2=new JLabel(":");
//		Collon2.setBounds(X+200,Y+60,20,150);
//		Collon2.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		Collon2.setForeground(Color.WHITE);
//		
//		//contactno value label
//		
//		ContactNoValue=new JTextArea("Contact Number");
//		ContactNoValue.setBounds(X+240,Y+124,800,25);
//		ContactNoValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		ContactNoValue.setForeground(Color.WHITE);
//		ContactNoValue.setBackground(new Color(R,G,B));
//		
//		add(ContactNoLabel);
//		add(Collon2);
//		add(ContactNoValue);
//		
//		
//		//doblabel
//		
//		DOBLabel=new JLabel("DOB");
//		DOBLabel.setBounds(X,Y+120,200,150);
//		DOBLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		DOBLabel.setForeground(Color.WHITE);
//		Collon3=new JLabel(":");
//		Collon3.setBounds(X+200,Y+120,20,150);
//		Collon3.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		Collon3.setForeground(Color.WHITE);
//		
//		//dob value label
//		
//		DOBValue=new JTextArea("DOB");
//		DOBValue.setBounds(X+240,Y+184,800,25);
//		DOBValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		DOBValue.setBackground(new Color(R,G,B));
//		DOBValue.setForeground(Color.WHITE);
//		
//		add(DOBLabel);
//		add(Collon3);
//		add(DOBValue);
//		
//		
//		//agelabel
//		
//		AgeLabel=new JLabel("Age");
//		AgeLabel.setBounds(X,Y+180,200,150);
//		AgeLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		AgeLabel.setForeground(Color.WHITE);
//		Collon4=new JLabel(":");
//		Collon4.setBounds(X+200,Y+180,20,150);
//		Collon4.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		Collon4.setForeground(Color.WHITE);
//		
//		//age value label
//		
//		AgeValue=new JTextArea("Age");
//		AgeValue.setBounds(X+240,Y+244,800,25);
//		AgeValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		AgeValue.setBackground(new Color(R,G,B));
//		AgeValue.setForeground(Color.WHITE);
//		
//		add(AgeLabel);
//		add(Collon4);
//		add(AgeValue);
//		
//		//joindatelabel
//		
//		JoinDateLabel=new JLabel("Join Date");
//		JoinDateLabel.setBounds(X,Y+240,200,150);
//		JoinDateLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		JoinDateLabel.setForeground(Color.WHITE);
//		Collon5=new JLabel(":");
//		Collon5.setBounds(X+200,Y+240,20,150);
//		Collon5.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		Collon5.setForeground(Color.WHITE);
//		
//		//joindate value label
//		
//		JoinDateValue=new JTextArea("Join Date ");
//		JoinDateValue.setBounds(X+240,Y+304,800,25);
//		JoinDateValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		JoinDateValue.setForeground(Color.WHITE);
//		JoinDateValue.setBackground(new Color(R,G,B));
//		
//		add(JoinDateLabel);
//		add(Collon5);
//		add(JoinDateValue);
//		
//		//permanent address label
//		
//		PAddressLabel=new JLabel("Permanent Address");
//		PAddressLabel.setBounds(X,Y+300,200,150);
//		PAddressLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		PAddressLabel.setForeground(Color.WHITE);
//		Collon6=new JLabel(":");
//		Collon6.setBounds(X+200,Y+300,20,150);
//		Collon6.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		Collon6.setForeground(Color.WHITE);
//		
//		//permanent address value label
//		
//		PAddressValue=new JTextArea("Address");
//		PAddressValue.setBounds(X+240,Y+364,800,50);
//		PAddressValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		PAddressValue.setBackground(new Color(R,G,B));
//		PAddressValue.setForeground(Color.WHITE);
//		PAddressValue.setLineWrap(true);
//		
//		
//		add(PAddressLabel);
//		add(Collon6);
//		add(PAddressValue);
//		
//		//temperory address label
//		
//		TAddressLabel=new JLabel("Temporary Address");
//		TAddressLabel.setBounds(X,Y+390,200,150);
//		TAddressLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		TAddressLabel.setForeground(Color.WHITE);
//		Collon7=new JLabel(":");
//		Collon7.setBounds(X+200,Y+390,20,150);
//		Collon7.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		Collon7.setForeground(Color.WHITE);
//		
//		//temperory address value label
//		
//		TAddressValue=new JTextArea("Address");
//		TAddressValue.setBounds(X+240,Y+454,800,50);
//		TAddressValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		TAddressValue.setBackground(new Color(R,G,B));
//		TAddressValue.setForeground(Color.WHITE);
//		TAddressValue.setLineWrap(true);
//		
//		add(TAddressLabel);
//		add(Collon7);
//		add(TAddressValue);
//		
//		
//		//marital status label
//		
//		MaritalStatusLabel=new JLabel("Marital Status");
//		MaritalStatusLabel.setBounds(X,Y+470,200,150);
//		MaritalStatusLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		MaritalStatusLabel.setForeground(Color.WHITE);
//		Collon8=new JLabel(":");
//		Collon8.setBounds(X+200,Y+470,20,150);
//		Collon8.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		Collon8.setForeground(Color.WHITE);
//		
//		//marital status value label
//		
//		MaritalValue=new JTextArea("Marital Status");
//		MaritalValue.setBounds(X+240,Y+530,800,25);
//		MaritalValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		MaritalValue.setBackground(new Color(R,G,B));
//		MaritalValue.setForeground(Color.WHITE);
//		
//		add(MaritalStatusLabel);
//		add(Collon8);
//		add(MaritalValue);
//		
//		//designation label
//		
//		DesignationLabel=new JLabel("Designation");
//		DesignationLabel.setBounds(X,Y+530,200,150);
//		DesignationLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		DesignationLabel.setForeground(Color.WHITE);
//		Collon9=new JLabel(":");
//		Collon9.setBounds(X+200,Y+530,20,150);
//		Collon9.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		Collon9.setForeground(Color.WHITE);
//		
//		//designation value label
//		
//		DesignationValue=new JTextArea("Designation");
//		DesignationValue.setBounds(X+240,Y+590,800,25);
//		DesignationValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
//		DesignationValue.setBackground(new Color(R,G,B));
//		DesignationValue.setForeground(Color.WHITE);
//		
//		add(DesignationLabel);
//		add(Collon9);
//		add(DesignationValue);
//		
//		//button
//		
//		
//		
		SaveButton=new JButton("Save");
		SaveButton.setBounds(X+400,Y+600,100,30);
		SaveButton.setForeground(Color.WHITE);
		SaveButton.setBackground(new Color(71,63,145));
		add(SaveButton);
		
		setBounds(0,0,1350,890);
		setBackground(new Color(R,G,B));
		setLayout(null);
		setVisible(true);
		
		
		
	}

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == BackIconLabel){
            main.switchPage("AdminProfileView");
        }
        else if(e.getSource() == firstNameValue){
            firstNameValue.setText("");
        }
        else if(e.getSource() == lastNameValue){
            lastNameValue.setText("");
        }
        else if(e.getSource() == DOBValue){
            DOBValue.setText("");
        }
        else if(e.getSource() == ageValue){
            ageValue.setText("");
        }
        else if(e.getSource() == contactNoValue){
            contactNoValue.setText("");
        }
        else if(e.getSource() == martialValue){
            martialValue.setText("");
        }
        else if(e.getSource() == salaryValue){
            salaryValue.setText("");
        }
        else if(e.getSource() == designationValue){
            designationValue.setText("");
        }
        else if(e.getSource() == stateValue){
            stateValue.setText("");
        }
        else if(e.getSource() == districtValue){
            districtValue.setText("");
        }
        else if(e.getSource() == pAddressValue){
            pAddressValue.setText("");
        }
        else if(e.getSource() == tAddressValue){
            tAddressValue.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

}
