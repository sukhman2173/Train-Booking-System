import java.util.Scanner;

public class TrainSeatBookingApplication 
{
	private static Scanner scan = new Scanner(System.in);
	
	//Method to get users input for Train Journey details and whether they want petite or grande
	private static TrainJourney journeyDetails(PetiteFloorGrid pGrid, GrandeFloorGrid gGrid)
	{
		String journeyNumber = "";
		String sourceCity = "";
		String destCity = "";
		String departureTime = "";
		String choice;
		
		System.out.println("******************************");
		System.out.println("Train Seat Booking Application");
		System.out.println("******************************");
		
		System.out.println("\nPlease enter journey number: ");
		scan = new Scanner(System.in);
		journeyNumber = scan.nextLine();
		
		System.out.println("Please enter source city: ");
		scan = new Scanner(System.in);
		sourceCity = scan.nextLine();
		
		System.out.println("Please enter destination city: ");
		scan = new Scanner(System.in);
		destCity = scan.nextLine();
		
		System.out.println("Please enter departure time: ");
		scan = new Scanner(System.in);
		departureTime = scan.nextLine();
		
		System.out.println("Would you like a seat on the Petite or Grande floor (P/G): ");
		scan = new Scanner(System.in);
		choice = scan.nextLine();
		
		if((choice).equalsIgnoreCase("p"))
		{
			TrainJourney aJourney = new TrainJourney(journeyNumber, sourceCity, destCity, departureTime, pGrid);
			System.out.println(pGrid);
			return aJourney;
		}
		else if(choice.equalsIgnoreCase("g"))
		{
			TrainJourney aJourney = new TrainJourney(journeyNumber, sourceCity, destCity, departureTime, gGrid);
			System.out.println(gGrid);
			return aJourney;
		}
		else
		{
			return null;
		}
	}
	//Gets users choice for the seatType they want
	private static SeatType querySeatType()
	{
		String type;
		
		System.out.println("\nWould you like a Window, Middle, or Aisle seat (W/M/A): ");
		scan = new Scanner(System.in);
		type = scan.nextLine();
		
		if (type.equalsIgnoreCase("w"))
		{ 
			
			
			return SeatType.WINDOW;
		}
		else if (type.equalsIgnoreCase("m"))
		{
			return SeatType.MIDDLE;
		}
		else if (type.equalsIgnoreCase("a"));
		{
			return SeatType.AISLE;
		}
	}
	
	//Method that results in the booking being made and displayed to the user.
	private static void showBooking(TrainJourney aJourney, SeatType aType)
	{
		String operatorName;
		String option;
		String seatClass;
		
		System.out.println("Please enter your name: ");
		scan = new Scanner(System.in);
		operatorName = scan.nextLine();
		
		System.out.println("Would you like TrainWay or TrainSmart (W/S): ");
		scan = new Scanner(System.in);
		option = scan.nextLine();
		
		System.out.println("Would you like to book a first or economy class (F/E): ");
		scan = new Scanner(System.in);
		seatClass = scan.nextLine();
		
		System.out.println("\n********Booking Details********");
		System.out.println("Name: "+operatorName);
		System.out.println(aJourney.getJourneyNumber()+".Route: "+aJourney.getSourceCity()+" - "+aJourney.getDestCity());
		System.out.println("Departure time: "+aJourney.getTime());
		if (option.equalsIgnoreCase("w"))
		{
			TrainWay aWay = new TrainWay(operatorName);
			
			if (seatClass.equalsIgnoreCase("f"))
			{
				aWay.reserveFirstClass(aJourney, aType);
			}
			else
			{
				aWay.reserveEconomy(aJourney, aType);
			}
		}
		else if (option.equalsIgnoreCase("s"))
		{
			TrainSmart aSmart = new TrainSmart(operatorName);
			
			if (seatClass.equalsIgnoreCase("f"))
			{
				aSmart.reserveFirstClass(aJourney, aType);
			}
			else
			{
				aSmart.reserveEconomy(aJourney, aType);
			}
		}
		System.out.println("*******************************");
		System.out.println(aJourney.getSeating());
	}
	
	public static void main(String[] args)
	{
		//Initialise new object for petite and grande
		PetiteFloorGrid pGrid = new PetiteFloorGrid();
		GrandeFloorGrid gGrid = new GrandeFloorGrid();
		
		//Variable used to loop through when user is asked for another booking
		String loop = "y";
		
		//While loop to check whether the user wants another booking
		while(loop.equalsIgnoreCase("y"))
		{
			//Calling methods
			showBooking(journeyDetails(pGrid, gGrid), querySeatType());
			
			System.out.println("\nWould you like to book another seat (Y/N): ");
			scan = new Scanner(System.in);
			loop = scan.nextLine();
		}
		//Closing scanner
		scan.close();
	}
}
