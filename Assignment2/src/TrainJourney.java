public class TrainJourney 
{
	private String journeyNumber;
	private String sourceCity;
	private String destCity;
	private String departureTime;
	private FloorGrid seating;
	
	public TrainJourney()
	{
		this.journeyNumber = "null";
		setSourceCity("null");
		setDestCity("null");
		setTime("null");
		setSeating(null);
	}
	public TrainJourney(String jn, String sc, String dc, String dt, FloorGrid s)
	{
		this.journeyNumber = jn;
		setSourceCity(sc);
		setDestCity(dc);
		setTime(dt);
		setSeating(s);
	}
	
	public String getJourneyNumber()
	{
		return journeyNumber;
	}
	
	public String getSourceCity()
	{
		return sourceCity;
	}
	
	public void setSourceCity(String sourCity)
	{
		this.sourceCity = sourCity;
	}
	
	public String getDestCity()
	{
		return destCity;
	}
	
	public void setDestCity(String dCity)
	{
		this.destCity = dCity;
	}
	
	public FloorGrid getSeating()
	{
		return seating;
	}
	
	public void setSeating(FloorGrid grid)
	{
		this.seating = grid;
	}
	
	public String getTime()
	{
		return departureTime;
	}
	
	public void setTime(String time)
	{
		this.departureTime = time;
	}
	
	public String toString()
	{
		return "String onzzz";
	}
	
}
