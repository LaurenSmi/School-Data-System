import java.util.TreeSet;
import java.util.ArrayList;
public class StudentGroup
{
	private TreeSet<Student> students;
	
	public StudentGroup()
	{
		students = new TreeSet<>();
	}
	
	public boolean add(Student s)
	{
		return(students.add(s));
	}	
	
	public boolean remove(Student s)
	{
		return(students.remove(s));
	}
	
	public boolean remove(int index)
	{
		if(index<students.size() && index>=0)
		{
			ArrayList<Student> temp = new ArrayList<>(students);
			temp.remove(index);
			students = new TreeSet<>(temp);
			return true;
		}
		return false;
	}
	
	public Student get(int index)
	{
		ArrayList<Student> temp = new ArrayList<>(students);
		return temp.get(index);
	}
	
	public int get(Student s)
	{
		ArrayList<Student> temp = new ArrayList<>(students);
		return temp.indexOf(s);
	}
	
	public boolean contains(Student s)
	{
		if(students.contains(s))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		int counter = 1;
		String big = "";
		for(Student s: students)
		{
			big = big+counter+"\t";
			big = big+s+"\n";
			counter++;
		}
		return big;
	}
	
	public int size()
	{
		return students.size();
	}
	
	public boolean contains(int iD)
	{
		for(Student s: students)
		{
			if(iD == s.getID())
			{
				return true;
			}
		}
		return false;
	}
}
