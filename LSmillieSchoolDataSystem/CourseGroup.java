import java.util.TreeSet;
import java.util.ArrayList;
public class CourseGroup 
{
	private TreeSet<Course> courses;
	
	public CourseGroup()
	{
		courses = new TreeSet<>();
	}
	
	public boolean add(Course c)
	{
		return courses.add(c);
	}	
	
	public boolean remove(Course c)
	{
		return courses.remove(c);
	}
	
	public boolean remove(int index)
	{
		if(index<courses.size() && index>=0)
		{
			ArrayList<Course> temp = new ArrayList<>(courses);
			temp.remove(index);
			courses = new TreeSet<>(temp);
			return true;
		}
		return false;
	}
	
	public Course get(int index)
	{
		ArrayList<Course> temp = new ArrayList<>(courses);
		return temp.get(index);
	}
	
	public int get(Course c)
	{
		ArrayList<Course> temp = new ArrayList<>(courses);
		return temp.indexOf(c);
	}
	
	@Override
	public String toString()
	{
		int counter =1;
		String big = "";
		for(Course c: courses)
		{
			big = big+counter+"\t";
			big = big+c+"\n";
			counter++;
		}
		return big;
	}
	
	public int size()
	{
		return courses.size();
	}
	
	public boolean contains(String code)
	{
		for(Course s: courses)
		{
			if(code.equals(s.getCode()))
			{
				return true;
			}
		}
		return false;
	}
}
