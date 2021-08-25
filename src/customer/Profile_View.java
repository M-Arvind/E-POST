package customer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import main.main;
public class Profile_View extends JPanel implements ActionListener, MouseListener  {
	//JPanel ViewPanel;
	Icon ProfIcon,EditIcon,BackIcon;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	JLabel UserNameTop;
	JLabel UserNameLabel,ContactNoLabel,DOBLabel,AgeLabel,JoinDateLabel,PAddressLabel,TAddressLabel,MaritalStatusLabel,DesignationLabel;
	JLabel UserNameValue,ContactNoValue,DOBValue,AgeValue,JoinDateValue,PAddressValue,TAddressValue,MaritalValue,DesignationValue;
	JLabel Collon1,Collon2,Collon3,Collon4,Collon5,Collon6,Collon7,Collon8,Collon9;
	JButton ProfIconLabel,BackIconLabel,EditIconLabel;
	JButton SaveButton;
	
	int X=230,Y=90;
	int R=34,G=34,B=45;
	int labelFontSize=20;
	public Profile_View() {
		// TODO Auto-generated constructor stub
		
		/**
		setBounds(0,0,1350,890);
		setBackground(new Color(R,G,B));
		setLayout(null);
		setVisible(true);
		**/
		
		//profile image
		
				ProfIcon=new ImageIcon(getClass().getResource("/Images/ProfileImage.png"));
				ProfIconLabel=new JButton(ProfIcon);
				ProfIconLabel.setBounds(X-150,Y-70,120,120);
				ProfIconLabel.setVisible(true);
				ProfIconLabel.setBackground(new Color(R,G,B));
				ProfIconLabel.setBorder(emptyBorder);
                                ProfIconLabel.setContentAreaFilled(false);
				add(ProfIconLabel);
				
				//back icon
				
				BackIcon=new ImageIcon(getClass().getResource("/Images/arrow_back_button.png"));
				BackIconLabel=new JButton(BackIcon);
				BackIconLabel.setBounds(10,10,30,30);
				BackIconLabel.setBackground(new Color(R,G,B));
				BackIconLabel.setBorder(emptyBorder);
				BackIconLabel.setVisible(true);
                                BackIconLabel.setContentAreaFilled(false);
				BackIconLabel.addMouseListener(this);
				add(BackIconLabel);
				
				//Edit icon
				
				EditIcon=new ImageIcon(getClass().getResource("/Images/edit_white.png"));
				EditIconLabel=new JButton(EditIcon);
				EditIconLabel.setBounds(X+1000,Y-45,48,48);
				EditIconLabel.setBackground(new Color(R,G,B));
				EditIconLabel.setBorder(emptyBorder);
				EditIconLabel.setVisible(true);
                                EditIconLabel.setContentAreaFilled(false);
				EditIconLabel.addActionListener(this);
				
				add(EditIconLabel);
		
		//Usernametop
		
		UserNameTop=new JLabel("Hello world");
		UserNameTop.setBounds(X,Y-80,1000,150);
		UserNameTop.setFont(new Font("Bold",Font.BOLD,labelFontSize+20));
		UserNameTop.setForeground(Color.WHITE);
		add(UserNameTop);
		
		
		// usernamelabel 
		
		UserNameLabel=new JLabel("Username");
		UserNameLabel.setBounds(X,Y,200,150);
		UserNameLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		UserNameLabel.setForeground(Color.WHITE);
		Collon1=new JLabel(":");
		Collon1.setBounds(X+200,Y,20,150);
		Collon1.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon1.setForeground(Color.WHITE);
		
		//usernamevalue label
		
		UserNameValue=new JLabel("Username");
		UserNameValue.setBounds(X+240,Y,800,150);
		UserNameValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		
		UserNameValue.setForeground(Color.WHITE);
		
		add(UserNameLabel);
		add(Collon1);
		add(UserNameValue);
		
		
		//contactno label
		
		ContactNoLabel=new JLabel("Contact Number");
		ContactNoLabel.setBounds(X,Y+60,200,150);
		ContactNoLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		ContactNoLabel.setForeground(Color.WHITE);
		Collon2=new JLabel(":");
		Collon2.setBounds(X+200,Y+60,20,150);
		Collon2.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon2.setForeground(Color.WHITE);
		
		//contactno value label
		
		ContactNoValue=new JLabel("Contact Number");
		ContactNoValue.setBounds(X+240,Y+60,800,150);
		ContactNoValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		ContactNoValue.setForeground(Color.WHITE);
		
		add(ContactNoLabel);
		add(Collon2);
		add(ContactNoValue);
		
		
		//doblabel
		
		DOBLabel=new JLabel("DOB");
		DOBLabel.setBounds(X,Y+120,200,150);
		DOBLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		DOBLabel.setForeground(Color.WHITE);
		Collon3=new JLabel(":");
		Collon3.setBounds(X+200,Y+120,20,150);
		Collon3.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon3.setForeground(Color.WHITE);
		
		//dob value label
		
		DOBValue=new JLabel("DOB");
		DOBValue.setBounds(X+240,Y+120,800,150);
		DOBValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		DOBValue.setForeground(Color.WHITE);
		
		add(DOBLabel);
		add(Collon3);
		add(DOBValue);
		
		
		//agelabel
		
		AgeLabel=new JLabel("Age");
		AgeLabel.setBounds(X,Y+180,200,150);
		AgeLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		AgeLabel.setForeground(Color.WHITE);
		Collon4=new JLabel(":");
		Collon4.setBounds(X+200,Y+180,20,150);
		Collon4.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon4.setForeground(Color.WHITE);
		
		//age value label
		
		AgeValue=new JLabel("Age");
		AgeValue.setBounds(X+240,Y+180,800,150);
		AgeValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		AgeValue.setForeground(Color.WHITE);
		
		add(AgeLabel);
		add(Collon4);
		add(AgeValue);
		
		//joindatelabel
		
		JoinDateLabel=new JLabel("Join Date");
		JoinDateLabel.setBounds(X,Y+240,200,150);
		JoinDateLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		JoinDateLabel.setForeground(Color.WHITE);
		Collon5=new JLabel(":");
		Collon5.setBounds(X+200,Y+240,20,150);
		Collon5.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon5.setForeground(Color.WHITE);
		
		//joindate value label
		
		JoinDateValue=new JLabel("Join Date ");
		JoinDateValue.setBounds(X+240,Y+240,800,150);
		JoinDateValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		JoinDateValue.setForeground(Color.WHITE);
		
		add(JoinDateLabel);
		add(Collon5);
		add(JoinDateValue);
		
		//permanent address label
		
		PAddressLabel=new JLabel("Permanent Address");
		PAddressLabel.setBounds(X,Y+300,200,150);
		PAddressLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		PAddressLabel.setForeground(Color.WHITE);
		Collon6=new JLabel(":");
		Collon6.setBounds(X+200,Y+300,20,150);
		Collon6.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon6.setForeground(Color.WHITE);
		
		//permanent address value label
		
		PAddressValue=new JLabel("Address");
		PAddressValue.setBounds(X+240,Y+300,800,150);
		PAddressValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		PAddressValue.setForeground(Color.WHITE);
		
		
		add(PAddressLabel);
		add(Collon6);
		add(PAddressValue);
		
		//temperory address label
		
		TAddressLabel=new JLabel("Temperory Address");
		TAddressLabel.setBounds(X,Y+390,200,150);
		TAddressLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		TAddressLabel.setForeground(Color.WHITE);
		Collon7=new JLabel(":");
		Collon7.setBounds(X+200,Y+390,20,150);
		Collon7.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon7.setForeground(Color.WHITE);
		
		//temperory address value label
		
		TAddressValue=new JLabel("Address");
		TAddressValue.setBounds(X+240,Y+390,800,150);
		TAddressValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		TAddressValue.setForeground(Color.WHITE);
		
		add(TAddressLabel);
		add(Collon7);
		add(TAddressValue);
		
		
		//marital status label
		
		MaritalStatusLabel=new JLabel("Marital Status");
		MaritalStatusLabel.setBounds(X,Y+470,200,150);
		MaritalStatusLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		MaritalStatusLabel.setForeground(Color.WHITE);
		Collon8=new JLabel(":");
		Collon8.setBounds(X+200,Y+470,20,150);
		Collon8.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon8.setForeground(Color.WHITE);
		
		//marital status value label
		
		MaritalValue=new JLabel("Marital Status");
		MaritalValue.setBounds(X+240,Y+470,800,150);
		MaritalValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		MaritalValue.setForeground(Color.WHITE);
		
		add(MaritalStatusLabel);
		add(Collon8);
		add(MaritalValue);
		
		//designation label
		
		DesignationLabel=new JLabel("Designation");
		DesignationLabel.setBounds(X,Y+530,200,150);
		DesignationLabel.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		DesignationLabel.setForeground(Color.WHITE);
		Collon9=new JLabel(":");
		Collon9.setBounds(X+200,Y+530,20,150);
		Collon9.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		Collon9.setForeground(Color.WHITE);
		
		//designation value label
		
		DesignationValue=new JLabel("Designation");
		DesignationValue.setBounds(X+240,Y+530,800,150);
		DesignationValue.setFont(new Font("Bold",Font.BOLD,labelFontSize));
		DesignationValue.setForeground(Color.WHITE);
		
		add(DesignationLabel);
		add(Collon9);
		add(DesignationValue);
		
		setBounds(0,0,1350,890);
		setBackground(new Color(R,G,B));
		setLayout(null);
		setVisible(true);
		
		
		
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        main.switchPage("Profile update");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == BackIconLabel){
            main.switchPage("customerPanel");
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
