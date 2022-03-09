public class PetiteFloorGrid extends FloorGrid
{
	public PetiteFloorGrid()
	{
		//rows to 10, columns to 7, first class till 4
		super.nRows = 10;
		super.nColumns = 7;
		super.nFirstClassRows = 4;
		
		initialiseFloorGrid();
	}
	
	public void initialiseFloorGrid()
	{
		super.seats = new Seat[nRows][nColumns];
		
		int row = 0;
		char column = 'A';
		
		SeatPosition aSeatP = new SeatPosition(row, column);
		
		Seat aSeat = new Seat();
		
		for (int r = 0; r < nRows; ++r)
		{
			column = 'A';
			for(int c = 0; c < nColumns; ++c)
			{
				if (r < nFirstClassRows)
				{
					if(c == 0 || c == nColumns-1)
					{
						aSeatP = new SeatPosition(row, column);
						seats[r][c] = aSeat = new Seat(aSeatP, SeatType.WINDOW, true);
					}
					else if(c == 1 || c == 2 || c == 4 || c == 5)
					{
						aSeatP = new SeatPosition(row, column);
						seats[r][c] = aSeat = new Seat(aSeatP, SeatType.AISLE, true);
					}
					else if(c == 3)
					{
						aSeatP = new SeatPosition(row, column);
						seats[r][c] = aSeat = new Seat(aSeatP, SeatType.MIDDLE, true);
					}
					++column;
				}
				else
				{
					if(c == 0 || c == nColumns-1)
					{
						aSeatP = new SeatPosition(row, column);
						seats[r][c] = aSeat = new Seat(aSeatP, SeatType.WINDOW, false);
					}
					else if(c == 1 || c == 2 || c == 4 || c == 5)
					{
						aSeatP = new SeatPosition(row, column);
						seats[r][c] = aSeat = new Seat(aSeatP, SeatType.AISLE, false);
					}
					else if(c == 3)
					{
						aSeatP = new SeatPosition(row, column);
						seats[r][c] = aSeat = new Seat(aSeatP, SeatType.MIDDLE, false);
					}
					++column;
				}
			}
			++row;
		}	
	}
}
