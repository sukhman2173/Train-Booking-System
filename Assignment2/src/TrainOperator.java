public abstract class TrainOperator
{
	private String operatorName;	
	
	abstract public Seat reserveFirstClass(TrainJourney aJourney, SeatType aType);
	abstract public Seat reserveEconomy(TrainJourney tJourney, SeatType sType);
	
	public TrainOperator()
	{
		setOperatorName("null");
	}
	
	public TrainOperator(String oName)
	{
		setOperatorName(oName);
	}
	
	public String getOperatorName()
	{
		return operatorName;
	}
	
	public void setOperatorName(String oName)
	{
		operatorName = oName;
	}
	
	public String toString()
	{
		return "toString of TrainOperator";
	}
}
