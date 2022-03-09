public class TrainSmart extends TrainOperator
{
	public TrainSmart(String oName)
	{
		super.setOperatorName(oName);
	}
	
	public Seat reserveFirstClass(TrainJourney tJourney, SeatType sType)
	{
		return tJourney.getSeating().querysAvaliableFirstClassSeat(sType);
	}
	
	public Seat reserveEconomy(TrainJourney tJourney, SeatType sType)
	{
		return tJourney.getSeating().querysAvaliableEconomySeat(sType);
	}
}
