public class Course implements Comparable<Course>
{
	private String name;
	private Subject subject;
	private String code;
	private Grade grade;
	private Level level;
	private String description;

	public Course()
	{
		name = "Unknown";
		subject = Subject.MATH;
		grade = Grade.NINE;
		level = Level.O;
		description = "Unknown";
	}
	
	public Course(String name, Subject subject, String code, Grade grade, Level level, String description)
	{
		this();
		this.subject = subject;
		this.grade = grade;
		this.level = level;
		if (name.length()>0 && name!=null)
		{
			this.name = name;
		}
		if (description.length()>0 && description!=null)
		{
			this.description = description;
		}	
		if (code.length()>0 && code!=null)
		{
			this.code = code;
		}
		else
		{
			this.code = codeMaker();
		}
	}
	
	public void setName(String name)
	{
		if (name.length()>0 && name!=null)
		{
			this.name = name;
		}
	}
	
	public void setDescription(String description)
	{
		if (description.length()>0 && description!=null)
		{
			this.description = description;
		}
	}
	
	public void setSubject(Subject subject)
	{
		this.subject = subject;
	}
	
	public Subject getSubject()
	{
		return subject;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCode()
	{
		return this.code;
	}
	
	public Grade getGrade()
	{
		return grade;
	}
	
	public Level getLevel()
	{
		return level;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	private String codeMaker()
	{
		String code = subject.getPrefix() + grade.toString() + level.toString();
		return code;
	}
	
	@Override
	public String toString()
	{
		return name +" "+ subject.getFullName() +" "+ grade.realToString() +" "+ level.getFullName()+" "+" "+code +" \n";
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(this == other)
		{ 
			return true;
		}
		
		if (!(other instanceof Course))
		{
			return false;
		}
		
		Course c = (Course) other;
		
		if(c.code.equals(this.code))
		{
			return true;
		}
		return false;
	}
	
	public int compareTo(Course other)
	{
		if(this.code.equals(other.code))
		{
			return 0;
		}
		
		else if (this.name.equals(other.name))
		{
			return this.code.compareTo(other.code);
		}
		return this.name.compareTo(other.name);
	}	
}
