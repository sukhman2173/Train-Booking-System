public class TrainWay extends TrainOperator
{
	public TrainWay(String oName)
	{
		super.setOperatorName(oName);
	}
	
	public Seat reserveFirstClass(TrainJourney tJourney, SeatType sType)
	{
		return tJourney.getSeating().querywAvailableFirstClassSeat(sType);
	}
	
	public Seat reserveEconomy(TrainJourney tJourney, SeatType sType)
	{
		return tJourney.getSeating().querywAvaliableEconomySeat(sType);
	}
}
