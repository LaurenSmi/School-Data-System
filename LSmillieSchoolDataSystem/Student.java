import java.util.TreeSet;
import java.time.LocalDate;
public class Student extends Person
{
	private LocalDate birthDate;
	
	public Student(String firstName, String lastName, int studentID, LocalDate birthDate)
	{
		super(firstName,lastName, studentID);
		if(birthDate!= null)
		{
			this.birthDate = birthDate;
		}
		else
		{
			this.birthDate = LocalDate.now();
		}
	}
	
	public Student(Student other)
	{
		super(other.getFirstName(),other.getLastName(), other.getID());
		this.birthDate = other.birthDate;
	}
	
	public LocalDate getBirthDate()
	{
		return this.birthDate;	
	}
	
	public void setBirthDate(LocalDate birthDate)
	{
		birthDate = this.birthDate;
	}
	
	@Override
	public String toString()
	{
		return super.toString() +" "+ birthDate;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(this == other)
		{ 
			return true;
		}
		
		if (!(other instanceof Student))
		{
			return false;
		}
		
		Student s = (Student) other;
		
		if(this.getID() == s.getID())
		{
			return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Person other)
	{
		if(this.getID() == other.getID())
		{
			return 0;
		}
		else if(this.getID()!= other.getID())
		{
			if (this.getLastName().equals(other.getLastName()))
			{
				if(this.getFirstName().equals(other.getFirstName()))
				{
					if (this.getID() > other.getID())
					{
						return 1;
					}
					else
					{
						return -1;
					}
				}
				return this.getFirstName().compareTo(other.getFirstName());
			}
			return this.getLastName().compareTo(other.getLastName());
		}
		return -1;
	}	
}
