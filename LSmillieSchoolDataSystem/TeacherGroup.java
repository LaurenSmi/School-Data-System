import java.util.TreeSet;
import java.util.ArrayList;
public class TeacherGroup
{
	private TreeSet<Teacher> teachers;
	
	public TeacherGroup()
	{
		teachers = new TreeSet<>();
	}
	
	public boolean add(Teacher s)
	{
		return(teachers.add(s));
	}	
	
	public boolean remove(Teacher s)
	{
		return(teachers.remove(s));
	}
	
	public boolean remove(int index)
	{
		if(index<teachers.size() && index>=0)
		{
			ArrayList<Teacher> temp = new ArrayList<>(teachers);
			temp.remove(index);
			teachers = new TreeSet<>(temp);
			return true;
		}
		return false;
	}
	
	public Teacher get(int index)
	{
		ArrayList<Teacher> temp = new ArrayList<>(teachers);
		return temp.get(index);
	}
	
	public int get(Teacher s)
	{
		ArrayList<Teacher> temp = new ArrayList<>(teachers);
		return temp.indexOf(s);
	}
	
	@Override
	public String toString()
	{
		int counter = 1;
		String big = "";
		for(Teacher s: teachers)
		{
			big = big+counter + "\t";
			big = big+s+"\n";
			counter++;
		}
		return big;
	}
	
	public int size()
	{
		return teachers.size();
	}
	
	public boolean contains(int iD)
	{
		for(Teacher s: teachers)
		{
			if(iD == s.getID())
			{
				return true;
			}
		}
		return false;
	}
}
