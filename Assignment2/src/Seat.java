public class Seat 
{
	private SeatType seatType;
	private boolean firstClass;
	private boolean reserved;
	private SeatPosition seatPosition;
	
	public Seat()
	{
		this.seatType = SeatType.WINDOW;
		this.firstClass = false;
		this.reserved = false;
		this.seatPosition = null; 
	}
	
	public Seat(SeatPosition sp, SeatType sType, boolean f)
	{
		this.seatPosition = sp;
		this.seatType = sType;
		this.firstClass = f;
	}
	
	public SeatType getSeatType()
	{
		return seatType;
	}
	
	public boolean getFirstClass()
	{
		return firstClass;
	}
	
	public boolean getReserved()
	{
		return reserved;
	}
	
	public void setReserved(boolean r)
	{
		this.reserved = r;
	}
	
	public SeatPosition getSeatposition()
	{
		return seatPosition;
	}
	
	public String toDescription()
	{
		if (firstClass == true)
		{
			if (reserved == false)
			{
				return ("First class "+seatType+" seat at: "+seatPosition+" is not booked");
			}
			else
			{
				return ("First class "+seatType+" seat at: "+seatPosition);
			}
		}
		else
		{
			if (reserved == false)
			{
				return ("Economy class "+seatType+" seat at: "+seatPosition+" is not booked");
			}
			else
			{
				return ("Economy class "+seatType+" seat at: "+seatPosition);
			}
		}	
	}
	
	public String toString()
	{
		return (seatPosition.toString());
	}
}
