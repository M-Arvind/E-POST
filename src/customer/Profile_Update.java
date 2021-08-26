package customer;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import main.main;
public class Profile_Update extends JPanel implements MouseListener{
	//JPanel ViewPanel;
	Icon ProfIcon,EditIcon,BackIcon;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	JLabel UserNameTop;
	JLabel CustomerIDLabel,FirstNameLabel,LastNameLabel,DOBLabel,AgeLabel,ContactNumberLabel,GenderLabel,AddressLabel,AccountNumberLabel;
	JTextArea CustomerIDValue,FirstNameValue,LastNameValue,DOBValue,AgeValue,ContactNumberValue,AddressValue,AccountNumberValue;
	JLabel Collon1,Collon2,Collon3,Collon4,Collon5,Collon6,Collon7,Collon8,Collon9;
	JButton ProfIconLabel,BackIconLabel,EditIconLabel;
	JButton SaveButton;
        ButtonGroup bg;
        JRadioButton rb1,rb2;
	int X=230,Y=90;
	int R=34,G=34,B=45;
	int labelFontSize=20;
	public Profile_Update() {
		// TODO Auto-generated constructor stub
		
		
		
		//profile image
		
		ProfIcon=new ImageIcon(getClass().getResource("/Images/ProfileImage.png"));
		ProfIconLabel=new JButton(ProfIcon);
		ProfIconLabel.setBounds(X-150,Y-70,120,120);
		ProfIconLabel.setVisible(true);
		ProfIconLabel.setBackground(new Color(R,G,B));
                ProfIconLabel.setContentAreaFilled(false);
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
		
		UserNameTop=new JLabel("Kishore P");
		UserNameTop.setBounds(X,Y-80,1000,150);
		UserNameTop.setFont(new Font("Bold",Font.BOLD,labelFontSize+20));
		UserNameTop.setForeground(Color.WHITE);
		add(UserNameTop);
		
		
		// customer id label 
		/**
		CustomerIDLabel=new JLabel("Customer ID");
		CustomerIDLabel.setBounds(X,Y,200,150);
		CustomerIDLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		CustomerIDLabel.setForeground(Color.WHITE);
		Collon1=new JLabel(":");
		Collon1.setBounds(X+200,Y,20,150);
		Collon1.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon1.setForeground(Color.WHITE);
		
		//costumer id value label
		
		CustomerIDValue=new JTextArea("ID");
		CustomerIDValue.setBounds(X+240,Y+62,800,25);
		CustomerIDValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		//UserNameValue.setBackground(new Color(R,G,B));
		CustomerIDValue.setForeground(Color.BLACK);
		
		add(CustomerIDLabel);
		add(Collon1);
		add(CustomerIDValue);
		*/
		
		//firstname label
		
		FirstNameLabel=new JLabel("First Name");
		FirstNameLabel.setBounds(X,Y+30,200,150);
		FirstNameLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		FirstNameLabel.setForeground(Color.WHITE);
		Collon2=new JLabel(":");
		Collon2.setBounds(X+200,Y+30,20,150);
		Collon2.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon2.setForeground(Color.WHITE);
		
		//firstname value label
		
		FirstNameValue=new JTextArea();
		FirstNameValue.setBounds(X+240,Y+94,800,35);
		FirstNameValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		FirstNameValue.setForeground(Color.BLACK);
		//ContactNoValue.setBackground(new Color(R,G,B));
		
		add(FirstNameLabel);
		add(Collon2);
		add(FirstNameValue);
		
		
		//lastname label
		
		LastNameLabel=new JLabel("Last Name");
		LastNameLabel.setBounds(X,Y+100,200,150);
		LastNameLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		LastNameLabel.setForeground(Color.WHITE);
		Collon3=new JLabel(":");
		Collon3.setBounds(X+200,Y+100,20,150);
		Collon3.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon3.setForeground(Color.WHITE);
		
		//last name value label
		
		LastNameValue=new JTextArea();
		LastNameValue.setBounds(X+240,Y+164,800,35);
		LastNameValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		//DOBValue.setBackground(new Color(R,G,B));
		LastNameValue.setForeground(Color.BLACK);
		
		add(LastNameLabel);
		add(Collon3);
		add(LastNameValue);
		
		
		//dob label
		
		DOBLabel=new JLabel("DOB");
		DOBLabel.setBounds(X,Y+180,200,150);
		DOBLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		DOBLabel.setForeground(Color.WHITE);
		Collon4=new JLabel(":");
		Collon4.setBounds(X+200,Y+180,20,150);
		Collon4.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon4.setForeground(Color.WHITE);
		
		//dob value label
		
		DOBValue=new JTextArea();
		DOBValue.setBounds(X+240,Y+244,800,35);
		DOBValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		//AgeValue.setBackground(new Color(R,G,B));
		DOBValue.setForeground(Color.BLACK);
		
		add(DOBLabel);
		add(Collon4);
		add(DOBValue);
		
		//age label 
		
		AgeLabel=new JLabel("Age");
		AgeLabel.setBounds(X,Y+260,200,150);
		AgeLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		AgeLabel.setForeground(Color.WHITE);
		Collon5=new JLabel(":");
		Collon5.setBounds(X+200,Y+260,20,150);
		Collon5.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon5.setForeground(Color.WHITE);
		
		//age value label
		
		AgeValue=new JTextArea();
		AgeValue.setBounds(X+240,Y+324,800,35);
		AgeValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		AgeValue.setForeground(Color.BLACK);
		//JoinDateValue.setBackground(new Color(R,G,B));
		
		add(AgeLabel);
		add(Collon5);
		add(AgeValue);
		
		//ContactNumber Label
		
		ContactNumberLabel=new JLabel();
		ContactNumberLabel.setBounds(X,Y+340,200,150);
		ContactNumberLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		ContactNumberLabel.setForeground(Color.WHITE);
		Collon6=new JLabel(":");
		Collon6.setBounds(X+200,Y+340,20,150);
		Collon6.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon6.setForeground(Color.WHITE);
		
		//ContactNumber value label
		
		ContactNumberValue=new JTextArea();
		ContactNumberValue.setBounds(X+240,Y+404,800,35);
		ContactNumberValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		//PAddressValue.setBackground(new Color(R,G,B));
		ContactNumberValue.setForeground(Color.BLACK);
		ContactNumberValue.setLineWrap(true);
		
		
		add(ContactNumberLabel);
		add(Collon6);
		add(ContactNumberValue);
		
		//Gender Label
		
		GenderLabel=new JLabel("Gender");
		GenderLabel.setBounds(X,Y+410,200,150);
		GenderLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		GenderLabel.setForeground(Color.WHITE);
		Collon7=new JLabel(":");
		Collon7.setBounds(X+200,Y+410,20,150);
		Collon7.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon7.setForeground(Color.WHITE);
		
		//gender radio box
		
                rb1=new JRadioButton("Male");
                rb2=new JRadioButton("Female");
                rb1.setBounds(X+240,Y+470,80,35);
                rb1.setFont(new Font("Bold",Font.BOLD,labelFontSize));
                rb1.setForeground(Color.white);
                rb1.setBackground(new Color(R,G,B));
                
                rb2.setBounds(X+240+100,Y+470,150,35);
                rb2.setFont(new Font("Bold",Font.BOLD,labelFontSize));
                rb2.setForeground(Color.white);
                rb2.setBackground(new Color(R,G,B));
                bg=new ButtonGroup();
                
                bg.add(rb1);
                bg.add(rb2);
               
		add(GenderLabel);
		add(Collon7);
		add(rb1);
                add(rb2);
		
		
		//Address label
		
		AddressLabel=new JLabel("Address");
		AddressLabel.setBounds(X,Y+470,200,150);
		AddressLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		AddressLabel.setForeground(Color.WHITE);
		Collon8=new JLabel(":");
		Collon8.setBounds(X+200,Y+470,20,150);
		Collon8.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon8.setForeground(Color.WHITE);
		
		//address value label
		
		AddressValue=new JTextArea();
		AddressValue.setBounds(X+240,Y+535,800,55);
		AddressValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		//MaritalValue.setBackground(new Color(R,G,B));
		AddressValue.setForeground(Color.BLACK);
		
		add(AddressLabel);
		add(Collon8);
		add(AddressValue);
		
		//account number label
		
		AccountNumberLabel=new JLabel("Account Number");
		AccountNumberLabel.setBounds(X,Y+560,200,150);
		AccountNumberLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		AccountNumberLabel.setForeground(Color.WHITE);
		Collon9=new JLabel(":");
		Collon9.setBounds(X+200,Y+560,20,150);
		Collon9.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon9.setForeground(Color.WHITE);
		
		//account number value label
		
		AccountNumberValue=new JTextArea();
		AccountNumberValue.setBounds(X+240,Y+625,800,25);
		AccountNumberValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		//DesignationValue.setBackground(new Color(R,G,B));
		AccountNumberValue.setForeground(Color.BLACK);
		
		add(AccountNumberLabel);
		add(Collon9);
		add(AccountNumberValue);
		
		//button
		
		
		
		SaveButton=new JButton("Save");
		SaveButton.setBounds(X+400,Y+690,100,30);
		SaveButton.setForeground(Color.black);
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
            main.switchPage("Profile");
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
