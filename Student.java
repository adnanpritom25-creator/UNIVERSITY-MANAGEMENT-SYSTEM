package Entity;
public class Student{
	private String studentName;
	private int id;
	private double cgpa;
	
	public Student(){
		System.out.println("E-Student Created.");
	}
	public Student(String studentName, int id, double cgpa){
		System.out.println("P-Student Created.");
		setStudentName(studentName);
		setId(id);
		setCgpa(cgpa);
	}
	
	public void setStudentName(String studentName){
		this.studentName = studentName;
	}
	public String getStudentName(){
		return studentName;
	}
	
	public void setId(int id){
		this.id = id;
	}
	public int getId(){ return id; }
	
	public void setCgpa(double cgpa){
		this.cgpa = cgpa;
	}
	public double getCgpa(){
		return cgpa;
	}
	
	public void showStudent(){
		System.out.println("Student Name: "+studentName);
		System.out.println("Student Id: "+id);
		System.out.println("CGPA: "+cgpa);
	}
	
	public String toString(){
		return "Student Name: "+studentName+"\n"+
				"Student Id: "+id+"\n"+
				"CGPA: "+cgpa+"\n";
	}
}