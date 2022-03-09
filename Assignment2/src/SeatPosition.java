public class SeatPosition 
{
	private int row;
	private char column;
	
	public SeatPosition()
	{
		this.row = 0;
		this.column = 'Z';
	}
	
	public SeatPosition(int r, char c)
	{
		this.row = r;
		this.column = c;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public char getColumn()
	{
		return column;
	}
	
	public String toString()
	{
		int arow = row + 1;
		return (""+arow+column);
	}
}
