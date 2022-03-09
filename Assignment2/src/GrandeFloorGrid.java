public class GrandeFloorGrid extends FloorGrid
{
	public GrandeFloorGrid()
	{
		//rows to 12, columns to 9, first class till 6
		super.nRows = 12;
		super.nColumns = 9;
		super.nFirstClassRows = 6;
		
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
					else if(c == 1 || c == 2 || c == 3 || c == 5 || c == 6 || c == 7)
					{
						aSeatP = new SeatPosition(row, column);
						seats[r][c] = aSeat = new Seat(aSeatP, SeatType.AISLE, true);
					}
					else if(c == 4)
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
					else if(c == 1 || c == 2 || c == 3 || c == 5 || c == 6 || c == 7)
					{
						aSeatP = new SeatPosition(row, column);
						seats[r][c] = aSeat = new Seat(aSeatP, SeatType.AISLE, false);
					}
					else if(c == 4)
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