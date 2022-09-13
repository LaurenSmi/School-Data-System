import java.util.TreeSet;
import java.util.ArrayList;
public class CourseSectionGroup
{
	private TreeSet<CourseSection> courses;
	
	public CourseSectionGroup()
	{
		courses = new TreeSet<>();
	}
	
	public boolean add(CourseSection c)
	{
		return courses.add(c);
	}	
	
	public void remove(CourseSection c)
	{
		courses.remove(c);
	}
	
	public boolean remove(int index)
	{
		if(index<courses.size() && index>=0)
		{
			ArrayList<CourseSection> temp = new ArrayList<>(courses);
			temp.remove(index);
			courses = new TreeSet<>(temp);
			return true;
		}
		return false;
	}
	
	public CourseSection get(int index)
	{
		ArrayList<CourseSection> temp = new ArrayList<>(courses);
		return temp.get(index);
	}
	
	public int get(CourseSection c)
	{
		ArrayList<CourseSection> temp = new ArrayList<>(courses);
		return temp.indexOf(c);
	}
	
	@Override
	public String toString()
	{
		int counter=1;
		String big = "";
		for(CourseSection c: courses)
		{
			big= big+counter+"\t";
			big = big+c+"\n\n";
			counter++;
		}
		return big;
	}
	
	public int size()
	{
		return courses.size();
	}
}
