import java.time.LocalDate;
abstract class Person implements Comparable<Person>
{
	private String firstName;
	private String lastName;
	private int iD;
	
	public Person()
	{
		firstName = "unknown";
		lastName = "unknown";
		iD = 0;
	}
	
	public Person(String firstName, String lastName,int iD)
	{
		this();
		if(firstName!=null && firstName.length()>0)
		{
			this.firstName = firstName;
		}
		if(lastName!=null && lastName.length()>0)
		{
			this.lastName = lastName;
		}
		if(iD>=1)
		{
			this.iD = iD;
		}
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public int getID()
	{
		return iD;
	}
	
	public void setFirstName(String firstName)
	{
		if(firstName!=null && firstName.length()>0)
		{
			this.firstName = firstName;
		}
	}
	
	public void setLastName(String lastName)
	{
		if(lastName!=null && lastName.length()>0)
		{
			this.lastName = lastName;
		}
	}

	public void setID(int iD)
	{
		if (iD>=1)
		{
			this.iD = iD;
		}
	}
	
	@Override
	public String toString()
	{
		return lastName+", " + firstName+" " + iD;
	}
	
	@Override
	public abstract boolean equals(Object other);
	public abstract int compareTo(Person other);
}
