import java.util.*;
public class Runner
	{
		static ArrayList <Squares> squares = new ArrayList <Squares>();
		static ArrayList <Players> players = new ArrayList<Players>();
		public static void main(String[] args)
			{
			createArray();
			int currentPosition = players.get(0).getCurrentLocation();
			boolean stillPlaying = true;
			while(stillPlaying)
				{	
				int dieRoll = Human.rollDice();	
				players.get(0).setCurrentLocation(Players.doTurn(dieRoll, currentPosition));
				currentPosition = players.get(0).getCurrentLocation();
				System.out.println("You rolled a "+dieRoll);
				System.out.println("You landed on "+squares.get(currentPosition).getName());
				Scanner userInput = new Scanner(System.in);
				String idunknow = userInput.nextLine();
				}
			}
		public static void createArray()
			{
			players.add(new Human(0));
			squares.add(new NonBuyable(0,"GO"));
			squares.add(new Colored(1,"Medditerranean Avenue", "Brown"));
			squares.add(new NonBuyable(2,"Community Chest"));
			squares.add(new Colored(3,"Baltic Avenue", "Brown"));
			squares.add(new NonBuyable(4,"Income Tax"));
			squares.add(new NonColored(5,"Reading Railroad"));
			squares.add(new Colored(6,"Oriental Avenue", "Blue"));
			squares.add(new NonBuyable(7,"Chance"));
			squares.add(new Colored(8,"Vermont Avenue", "Blue"));
			squares.add(new Colored(9,"Connecticut Avenue", "Blue"));
			squares.add(new NonBuyable(10,"Jail"));
			squares.add(new Colored(11,"St. Charles Place", "Pink"));
			squares.add(new NonColored(12,"Electric Company"));
			squares.add(new Colored(13,"States Avenue", "Pink"));
			squares.add(new Colored(14,"Virginia Avenue", "Pink"));
			squares.add(new NonColored(15,"Pennsylvania Railroad"));
			squares.add(new Colored(16,"St. James Place", "Orange"));
			squares.add(new NonBuyable(17,"Community Chest"));
			squares.add(new Colored(18,"Tennessee Avenue", "Orange"));
			squares.add(new Colored(19,"New York Avenue", "Orange"));
			squares.add(new NonBuyable(20,"Free Parking"));
			squares.add(new Colored(21,"Kentucky Avenue", "Red"));
			squares.add(new NonBuyable(22,"Chance"));
			squares.add(new Colored(23,"Indiana Avenue", "Red"));
			squares.add(new Colored(24,"Illinois Avenue", "Red"));		
			squares.add(new NonColored(25,"B & O Railroad"));		
			squares.add(new Colored(26,"Atlantic Avenue", "Yellow"));		
			squares.add(new Colored(27,"Ventnor Avenue", "Yellow"));		
			squares.add(new NonColored(28,"Water Works"));		
			squares.add(new Colored(29,"Marian Gardens", "Yellow"));		
			squares.add(new NonBuyable(30,"Go To Jail"));		
			squares.add(new Colored(31,"Pacific Avenue", "Green"));		
			squares.add(new Colored(32,"North Carolina Avenue", "Green"));
			squares.add(new NonBuyable(33,"Community Chest"));
			squares.add(new Colored(34,"Pennsylvania Avenue", "Green"));
			squares.add(new NonColored(35,"Short Line"));
			squares.add(new NonBuyable(36,"Chance"));
			squares.add(new Colored(37,"Park Place", "Blue"));
			squares.add(new NonBuyable(38,"Luxury Tax"));
			squares.add(new Colored(39,"Boardwalk", "Blue"));
			
			
			
			
			}

	}
