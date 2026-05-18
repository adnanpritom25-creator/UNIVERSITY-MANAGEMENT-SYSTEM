package Entity;
public class University{
	private String universityName;
	private Student[] students;
	
	public University(){
		universityName = "No Name";
		students = new Student[500];
	}
	public University(String universityName, int size){
		this.universityName = universityName;
		students = new Student[size];
	}
	public void setUniversityName(String universityName){
		this.universityName = universityName;
	}
	public String getUniversityName(){
		return universityName;
	}
	
	public void addStudent(int sNo, Student s){
		if(sNo>=0 && sNo<students.length){
			students[sNo] = s;
		}
	}
	public void removeStudent(int sNo){
		if(sNo>=0 && sNo<students.length){
			students[sNo] = null;
		}
	}
	public Student getStudent(int sNo){
		if(sNo>=0 && sNo<students.length){
			return students[sNo];
		}
		
		return null;
	}
	
	public void showUniversity(){
		System.out.println("=========== "+universityName+" ==============");
		for(int i=0;i<students.length;i++){
			if(students[i]!=null){
				students[i].showStudent();
				System.out.println("---------------------");
			}
		}
		System.out.println("---------------------");
		System.out.println("---------------------\n\n");
	}
	
	public String getUniversityAsString(){
		String data = "";
		data+= "=========== "+universityName+" ==============\n";
		int studentCount = 0;
		for(int i=0;i<students.length;i++){
			if(students[i]!=null){
				studentCount++;
				data+= students[i].toString();
				data+= "---------------------\n";
			}
		}
		data+="---------------------\n";
		data+="Total Number of Student: "+studentCount+"\n";
		data+="---------------------\n\n";
		return data;
	}
	
	
}