public enum Grade
{
	NINE,
	TEN,
	ELEVEN,
	TWELVE;
	 
	public static Grade fromInt(int num)
	{
		if (num == 9) 
		{
			return  NINE;
		}
		else if (num == 10) 
		{
			return TEN;
		}
		else if (num == 11) 
		{
			return ELEVEN;
		}
		return TWELVE;
	}
	
	public String realToString()
	{
		if (this == NINE)
		{
			return "9";
		}
		else if (this == TEN)
		{
			return "10";
		}
		else if (this == ELEVEN)
		{
			return "11";
		}
		return "12";
	}
	
	@Override
	public String toString()
	{
		if (this == NINE)
		{
			return "1";
		}
		else if (this == TEN)
		{
			return "2";
		}
		else if (this == ELEVEN)
		{
			return "3";
		}
		return "4";
	}
}
