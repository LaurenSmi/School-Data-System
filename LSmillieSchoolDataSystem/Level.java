public enum Level
{
	O,
	M,
	C,
	U;
	
	public static Level fromInt(int num)
	{
		if (num == 1) 
		{
			return  O;
		}
		else if (num == 2) 
		{
			return M;
		}
		else if (num == 3) 
		{
			return C;
		}
		return U;
	}
	
	public String getFullName()
	{
		if (this == M)
		{
			return "Mixed";
		}
		else if (this == C)
		{
			return "College";
		}
		else if (this == O)
		{
			return "Open";
		}
		return "University";
	}
	
	
	@Override
	public String toString()
	{
		if (this == M)
		{
			return "M";
		}
		else if (this == C)
		{
			return "C";
		}
		else if (this == O)
		{
			return "O";
		}
		return "U";
	}
}
