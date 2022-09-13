public enum Subject
{
	COMPUTER_STUDIES,
	BUSINESS,
	MATH,
	MUSIC,
	TECHNOLOGY;
	
	public static Subject fromInt(int num)
	{
		if (num == 1) 
		{
			return  COMPUTER_STUDIES;
		}
		else if (num == 2) 
		{
			return BUSINESS;
		}
		else if (num == 3) 
		{
			return MATH;
		}
		else if (num == 4) 
		{
			return MUSIC;
		}
		return TECHNOLOGY;
	}
	
	public String getFullName()
	{
		if (this == COMPUTER_STUDIES) 
		{
			return "Computer Studies";
		}
		else if (this == BUSINESS) 
		{
			return "Business";
		}
		else if (this == MATH) 
		{
			return "Math";
		}
		else if (this == MUSIC) 
		{
			return "Music";
		}
		return "Technology";
		
	}
	
	public String getPrefix()
	{
		if (this == MATH) 
		{
			return "MATH";
		}
		else if (this == BUSINESS) 
		{
			return "BUSI";
		}
		
		else if (this == TECHNOLOGY) 
		{
			return "TECH";
		}
		else if(this == MUSIC)
		{ 
			return "MUS";
		}
		
		return "COMP";
	}
}
