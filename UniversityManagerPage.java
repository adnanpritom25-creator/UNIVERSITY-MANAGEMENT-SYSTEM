package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.*;
import File.*;
public class UniversityManagerPage extends JFrame implements ActionListener{
	Font font15 = new Font("Cambria",Font.BOLD,15);
	Font font20 = new Font("Cambria",Font.BOLD,20);
	Font font25 = new Font("Cambria",Font.BOLD,25);
	
	JLabel title, universitySubTitle, studentSubTitle;
	JLabel universityNoLabel, universityNameLabel;
	JTextField universityNoField, universityNameField;
	JButton universityAddBtn, universityUpdateBtn, universityRemoveBtn;
	
	JLabel studentUniversityNoLabel, studentPositionNoLabel;
	JLabel studentNameLabel, studentIdLabel, studentCgpaLabel;
	JTextField studentUniversityNoField, studentPositionNoField;
	JTextField studentNameField, studentIdField, studentCgpaField;
	JButton studentAddBtn, studentUpdateBtn, studentRemoveBtn;
	
	JTextArea screen;
	
	University universities[] = new University[100];
	
	public UniversityManagerPage(){
		super("University Manager Page");
		this.setSize(800,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		this.setIconImage(new ImageIcon("./image/icon.jpg").getImage());

		FileIO.loadFromFile(universities);
		

		int x=10,y=10,w=150,h=30,vGap=h+10;
		
		title = createLabel("University Manager",x,y,2*w,h);
		universitySubTitle = createLabel("Set University Name",x,y+=vGap,2*w,h);	
		universityNoLabel = createLabel("University No",x,y+=vGap,w,h);
		universityNoField = createTextField("",x+w,y,w,h);
		universityNameLabel = createLabel("University Name",x,y+=vGap,w+20,h);
		universityNameField = createTextField("",x+w,y,w,h);
		universityAddBtn = createButton("Add University",x,y+=vGap,2*w,h);
		universityAddBtn.setBackground(Color.ORANGE);
		universityAddBtn.setForeground(Color.BLACK);
		universityUpdateBtn = createButton("Update",x,y+=vGap,w-5,h);
		universityRemoveBtn = createButton("Remove",x+w+5,y,w-5,h);
		universityRemoveBtn.setBackground(Color.RED);
		
		studentSubTitle = createLabel("Student Details",x,y+=vGap,w,h);
		studentUniversityNoLabel = createLabel("University No",x,y+=vGap,w,h);
		studentUniversityNoField = createTextField("",x+w,y,w,h);
		
		studentPositionNoLabel = createLabel("Position No",x,y+=vGap,w,h);
		studentPositionNoField = createTextField("",x+w,y,w,h);
		studentNameLabel= createLabel("Student Name",x,y+=vGap,w,h);
		studentNameField= createTextField("",x+w,y,w,h);
		studentIdLabel = createLabel("Student Id ",x,y+=vGap,w,h);
		studentIdField = createTextField("",x+w,y,w,h);
		studentCgpaLabel = createLabel("Cgpa",x,y+=vGap,w,h);
		studentCgpaField = createTextField("",x+w,y,w,h);
		
		studentAddBtn = createButton("Add Student",x,y+=vGap,w*2,h);
		studentAddBtn.setBackground(Color.ORANGE);
		studentAddBtn.setForeground(Color.BLACK);
		studentUpdateBtn = createButton("Update",x,y+=vGap,w-5,h);
		studentRemoveBtn = createButton("Remove",x+w+5,y,w-5,h);
		studentRemoveBtn.setBackground(Color.RED);
		
		
		screen = new JTextArea();
		screen.setFont(font20);
		screen.setEditable(false);
		updateScreen();
		JScrollPane jsp = new JScrollPane(screen);
		jsp.setBounds(350,50,400,500);
		this.add(jsp);

		JLabel background = new JLabel( new ImageIcon("./image/bg.jpg") );
		background.setBounds(0,0,800,700);
		this.add(background);
		
		this.setVisible(true);
	}
	
	public JLabel createLabel(String text,int x,int y,int w,int h){
		JLabel component = new JLabel(text);
		component.setBounds(x,y,w,h);
		component.setFont(font20);
		component.setOpaque(true);
		component.setBackground(Color.PINK);
		component.setForeground(Color.BLACK);
		this.add(component);
		return component;
	}
	
	public JTextField createTextField(String text,int x,int y,int w,int h){
		JTextField component = new JTextField(text);
		component.setBounds(x,y,w,h);
		component.setFont(font20);
		component.setBackground(Color.WHITE);
		component.setForeground(Color.BLACK);
		this.add(component);
		return component;
	}
	
	public JButton createButton(String text,int x,int y,int w,int h){
		JButton component = new JButton(text);
		component.setBounds(x,y,w,h);
		component.setFont(font20);
		component.setBackground(Color.BLUE);
		component.setForeground(Color.WHITE);
		component.addActionListener(this);
		this.add(component);
		return component;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == universityAddBtn){
			int universityNo = Integer.parseInt( universityNoField.getText());
			String universityName = universityNameField.getText();
			if(universities[universityNo]==null){
				universities[universityNo] = new University(universityName,14);
				updateScreen();
			}
			else{
				JOptionPane.showMessageDialog(this,"University No Already Taken.");
			}
		}
		else if(e.getSource() == universityUpdateBtn){
			
		}
		else if(e.getSource() == universityRemoveBtn){
			
		}
		else if(e.getSource() == studentAddBtn){
			int universityNo = Integer.parseInt(studentUniversityNoField.getText());
			int positionNo = Integer.parseInt(studentPositionNoField.getText());
			String name = studentNameField.getText();
			int id = Integer.parseInt(studentIdField.getText());
			double cgpa = Double.parseDouble(studentCgpaField.getText());
			
			Student s = new Student(name,id,cgpa);
			universities[universityNo].addStudent(positionNo,s);
			FileIO.writeInFile(universityNo,positionNo,s);
			updateScreen();
		}
		else if(e.getSource() == studentUpdateBtn){
			
		}
		else if(e.getSource() == studentRemoveBtn){
			
		}
	}
	
	public void updateScreen(){
		String allUniversityData = "";
		for(int i=0;i<universities.length;i++){
			if(universities[i]!=null){
				allUniversityData+= i+". "+universities[i].getUniversityAsString();
			}
		}
		screen.setText(allUniversityData);
	}
	
}