package File;
import java.io.*;
import java.util.Scanner;
import Entity.*;
public class FileIO{
	public static void loadFromFile(University universities[]){
		
		try{
			File universityFile = new File("./File/FileIO.txt");
			Scanner universitySc = new Scanner(universityFile);
			
			while(universitySc.hasNextLine()){
				String line = universitySc.nextLine();
				
				String data[] = line.split(";");
				int universityNo = Integer.parseInt(data[0]);
				String universityName = data[1];
				universities[universityNo] = new University(universityName,15);
			}
			universitySc.close();
			
			File studentFile = new File("./File/FileIO.txt");
			Scanner studentSc = new Scanner(studentFile);
			
			while(studentSc.hasNextLine()){
				String line = studentSc.nextLine();
				String data[] = line.split(";");
				int universityNo = Integer.parseInt(data[0]);
				int universityName = Integer.parseInt(data[1]);
				String name = data[2];
				int id = Integer.parseInt(data[3]);
				double cgpa = Double.parseDouble(data[4]);
				
				Student s = new Student(name,id,cgpa);
				universities[universityNo].addStudent(posNo,s);
			}
			studentSc.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("Cannot Find University File.");
		}
	}
	
	public static void writeInFile(int universityNo,int posNo, Student s){
		try{
			File studentFile = new File("./File/FileIO.txt");
			FileWriter writer = new FileWriter(studentFile,true);
			String line = universityNo+";"+posNo+";"+s.getStudentName()+";"+s.getId()+";"+s.getCgpa()+"\n";
			writer.write(line);
			writer.flush();
			writer.close();
		}
		catch(IOException ex){
			System.out.println("Cannot Write into the Student File.");
		}
	}
}