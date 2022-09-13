public class CourseSection implements Comparable<CourseSection>
{
	private Course course;
	private StudentGroup students;
	private Teacher teacher;
	private Location location;
	
	public CourseSection(Course course, StudentGroup students, Teacher teacher, Location location)
	{
		this.location = location;
		this.teacher = teacher;
		this.students = students;
		this.course = course;
	}
	
		public CourseSection(Course course, Teacher teacher, Location location)
	{
		this.location = location;
		this.teacher = teacher;
		students = new StudentGroup();
		this.course = course;
	}
	
	
	public Course getCourse()
	{
		return course;
	}
	
	public Teacher getTeacher()
	{
		return teacher;
	}
	
	public Location getLocation()
	{
		return location;
	}
	
	public StudentGroup getStudents()
	{
		return students;
	}
	
	public void setLocation(Location location)
	{
		this.location = location;
	}
	
	public void setCourse(Course course)
	{
		this.course = course;
	}
	
	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}
	
	public boolean addStudent(Student s)
	{
		return students.add(s);
	}
	
	public boolean removeStudent(Student s)
	{
		return students.remove(s);
	}
	
	public boolean removeStudent(int index)
	{
		return students.remove(index);
	}
	
	@Override
	public String toString()
	{
		return course.toString() + "\t"+teacher.toString() + "\t Students: "+ students.size() +"\t" +location.toString();
		// +"\nStudents:\n" + students.toString();
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(this==other)
		{
			return true;
		}
	
		if (!(other instanceof CourseSection))
		{
			return false;
		}
		
		CourseSection c = (CourseSection) other;
		if(c.course == this.course && this.teacher == c.teacher && this.location == c.location)
		{
			return true;
		}
		return false;
	}
	
	public int compareTo(CourseSection other)
	{
		if (this.course.equals(other.course))
		{
			if(this.teacher.equals(other.teacher))
			{
				if(this.location==other.location)
				{
					return 0;
				}
				return this.location.compareTo(other.location);
			}
			return this.teacher.compareTo(other.teacher);
		}
		return this.course.compareTo(other.course);
	}
}
