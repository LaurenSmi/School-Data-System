public class Teacher extends Person
{		
	public Teacher()
	{
		super();
	}
	public Teacher(String firstName, String lastName,int teacherID)
	{
		super(firstName,lastName,teacherID);
	}
	
	public Teacher(Teacher other)
	{
		super(other.getFirstName(),other.getLastName(),other.getID());
	}
	
	@Override
	public String toString()
	{
		return "Mx. " + super.toString();
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(this == other)
		{ 
			return true;
		}
		
		if (!(other instanceof Teacher))
		{
			return false;
		}
		
		Teacher t = (Teacher) other;
		
		if(this.getID() == t.getID())
		{
			return true;
		}
		return false;
	}
	
	public int compareTo(Person other)
	{
		if(this.getID() == other.getID())
		{
			return 0;
		}
		
		else
		{
			if (this.getLastName().equals(other.getLastName()))
			{
				if(this.getFirstName().equals(other.getFirstName()))
				{
					if (this.getID() > other.getID())
					{
						return 1;
					}
					else if (this.getID() == other.getID())
					{
						return 0;
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
	}
}
