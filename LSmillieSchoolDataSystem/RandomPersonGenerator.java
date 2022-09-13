import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class RandomPersonGenerator 
{
	private List<String> lastNames;
	private List<String> firstNames;
	private java.time.LocalDate birthDate;

	
	public static void main(String[] args) 
	{
		RandomPersonGenerator pg = new RandomPersonGenerator();
		System.out.println(pg.getRandomStudent());
	}
	
	public RandomPersonGenerator()
	{
		loadLastNames();
		loadFirstNames();
	}
	
	public Teacher getRandomTeacher()
	{
		int id = (int)(Math.random() * 100000000);
		return new Teacher(randomFirstName(),randomLastName(),id);
	}
	
	public Student getRandomStudent()
	{
		int id = (int)(Math.random() * 100000000);
		return new Student(randomFirstName(),randomLastName(),id,java.time.LocalDate.now());
	}
	
	private String randomFirstName()
	{
		return firstNames.get((int)(Math.random() * firstNames.size()));
	}
	
	private String randomLastName()
	{
		return lastNames.get((int)(Math.random() * lastNames.size()));
	}
	
	public void loadLastNames()
	{
		try{
				
			Scanner in = new Scanner(new File("surnames.txt"));
			lastNames = new ArrayList<String>();
			while(in.hasNext())
			{
				lastNames.add(in.next());
			}
			in.close();
			//System.out.println(lastNames);
		}
		catch(FileNotFoundException e){
			System.out.println("File not found");
		}
		
	}
	
	public void loadFirstNames()
	{
		try{
				
			Scanner in = new Scanner(new File("firstnames.txt"));
			firstNames = new ArrayList<String>();
			while(in.hasNext())
			{
				firstNames.add(in.next());
			}
			in.close();
			//System.out.println(firstNames);
		}
		catch(FileNotFoundException e){
			System.out.println("File not found");
		}
		
	}
}		
