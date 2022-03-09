public abstract class FloorGrid 
{
	protected int nRows;
	protected int nColumns;
	protected Seat[][] seats;
	protected int nFirstClassRows;
	
	abstract protected void initialiseFloorGrid();
	
	public char lastSeatPosition()
	{
		if(nColumns == 12)
		{
			return 'L';
		}
		else
		{
			return 'G';
		}
	}
	
	public int lastSeatRow()
	{
		return nRows;
	}
	//gets seat to the left
	public Seat getLeft(Seat aSeat)
	{	
		char let = aSeat.getSeatposition().getColumn();
		let -= 1;
		
		if (let == 'A')
		{
			return null;
		}
		else
		{
			return seats[aSeat.getSeatposition().getRow()][(int)let-65];
		}
	}
	//gets seat to the right
	public Seat getRight(Seat aSeat)
	{
		char let = aSeat.getSeatposition().getColumn();
		let += 1;
		
		if (let == lastSeatPosition())
		{
			return null;
		}
		else
		{
			return seats[aSeat.getSeatposition().getRow()][(int)let-65];
		}
	}
	//checks economy if there is a seat available using trainsmart method
	public Seat querysAvaliableEconomySeat(SeatType aType)
	{
		for(int r = nFirstClassRows; r < nRows; ++r)
		{
			for(int c = 0; c < nColumns; ++c)
			{
				if(seats[r][c].getSeatType() == aType && seats[r][c].getReserved() == false)
				{
					seats[r][c].setReserved(true);
					System.out.println(seats[r][c].toDescription());
					return seats[r][c];
				}
			}
		}
		
		return null;
	}
	
	//checks first class if there is a seat available using trainsmart method
	public Seat querysAvaliableFirstClassSeat(SeatType aType)
	{
		for(int r = 0; r < nFirstClassRows; ++r)
		{
			for(int c = 0; c < nColumns; ++c)
			{
				if(seats[r][c].getSeatType() == aType && seats[r][c].getReserved() == false)
				{
					seats[r][c].setReserved(true);
					System.out.println(seats[r][c].toDescription());
					return seats[r][c];
				}
			}
		}
		
		for(int r = nFirstClassRows; r < nRows; ++r)
		{
			for(int c = 0; c < nColumns; ++c)
			{
				if(seats[r][c].getReserved() == false && seats[r][c].getSeatType() == SeatType.AISLE || seats[r][c].getSeatType() == SeatType.WINDOW)
				{
					seats[r][c].setReserved(true);
					
					if(getRight(seats[r][c]) == null)
					{
						getLeft(seats[r][c]).setReserved(true);
						System.out.println(seats[r][c].toDescription());
						return getLeft(seats[r][c]);
					}
					else
					{
						getRight(seats[r][c]).setReserved(true);
						System.out.println(seats[r][c].toDescription());
						return getRight(seats[r][c]);
					}
				}
			}
		}
		
		return null;
	}
	//checks economy for available seat using trainway method
	public Seat querywAvaliableEconomySeat(SeatType aType)
	{
		for(int r = nFirstClassRows; r < nRows; ++r)
		{
			for(int c = 0; c < nColumns; ++c)
			{
				if(seats[r][c].getSeatType() == aType && seats[r][c].getReserved() == false)
				{
					seats[r][c].setReserved(true);
					System.out.println(seats[r][c].toDescription());
					return seats[r][c];
				}
			}
		}
		
		for(int r = 0; r < nFirstClassRows; ++r)
		{
			for(int c = 0; c < nColumns; ++c)
			{
				if(seats[r][c].getSeatType() == SeatType.WINDOW && seats[r][c].getReserved() == false)
				{
					seats[r][c].setReserved(true);
					System.out.println(seats[r][c].toDescription());
					return seats[r][c];
				}
			}
		}
	
		return null;
	}
	//checks first class for available seat using trainway method
	public Seat querywAvailableFirstClassSeat(SeatType aType)
	{
		for(int r = 0; r < nFirstClassRows; ++r)
		{
			for(int c = 0; c < nColumns; ++c)
			{
				if(seats[r][c].getSeatType() == aType && seats[r][c].getReserved() == false)
				{
					seats[r][c].setReserved(true);
					System.out.println(seats[r][c].toDescription());
					return seats[r][c];
				}
			}
		}
		
		for(int r = 0; r < nFirstClassRows; ++r)
		{
			for(int c = 0; c < nColumns; ++c)
			{
				if(seats[r][c].getReserved() == false)
				{
					seats[r][c].setReserved(true);
					System.out.println(seats[r][c].toDescription());
					return seats[r][c];
				}
			}
		}
		
		for(int r = nFirstClassRows; r < nRows; ++r)
		{
			for(int c = 0; c < nColumns; ++c)
			{
				if(seats[r][c].getSeatType() == SeatType.WINDOW && seats[r][c].getReserved() == false)
				{
					seats[r][c].setReserved(true);
					System.out.println(seats[r][c].toDescription());
					return seats[r][c];
				}
			}
		}
	
		return null;
	}
	
	public Seat getSeat(int row, char column)
	{
		return seats[row][column];
	}
	//prints seating grid
	public String toString()
	{	
		String grid = "\n";
		char letter = 'A';
		
		for (int let = 0; let < nColumns; ++let)
		{
			grid += ("     "+letter+"  ");
			++letter;
		}
		
		for (int r = 0; r < nRows; ++r)
		{
			grid += String.format("\n%2d ", r+1);
			for (int c = 0; c < nColumns; ++c)
			{
				grid += (" [");
				if(seats[r][c].getSeatType() == SeatType.WINDOW)
				{
					if (seats[r][c].getFirstClass() == true)
					{
						grid += "W";
						if(seats[r][c].getReserved() == false)
						{
							grid += (" _ ] ");
						}
						else
						{
							grid += (" X ] ");
						}
					}
					else
					{
						grid += ("w");
						
						if(seats[r][c].getReserved() == false)
						{
							grid += (" _ ] ");
						}
						else
						{
							grid += (" X ] ");
						}
					}
				}    
				else if(seats[r][c].getSeatType() == SeatType.MIDDLE)
				{
					if(seats[r][c].getFirstClass() == true)
					{
						grid += ("M");
						
						if(seats[r][c].getReserved() == false)
						{
							grid += (" _ ] ");
						}
						else
						{
							grid += (" X ] ");
						}
					}
					else
					{
						grid += ("m");
						
						if(seats[r][c].getReserved() == false)
						{
							grid += (" _ ] ");
						}
						else
						{
							grid += (" X ] ");
						}
					}
				}
				else
				{
					if(seats[r][c].getFirstClass() == true)
					{
						grid += ("A");
						
						if(seats[r][c].getReserved() == false)
						{
							grid += (" _ ] ");
						}
						else
						{
							grid += (" X ] ");
						}
					}
					else
					{
						grid += ("a");
						
						if(seats[r][c].getReserved() == false)
						{
							grid += (" _ ] ");
						}
						else
						{
							grid += (" X ] ");
						}
					}
				}
			}
		}
		return grid;
	}
}
