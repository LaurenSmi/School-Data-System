public enum Location
{
	RM01,
	RM02,
	RM03;
	
	public static Location fromInt(int num)
	{
		if(num ==1)
		{
			return RM01;
		}
		
		else if(num==2)
		{
			return RM02;
		}
		return RM03;
	}
	
	
	@Override
	public String toString()
	{
		if (this == RM01)
		{
			return "RM01";
		}
		else if (this == RM02)
		{
			return "RM02";
		}
		return "RM03";
	}
}
