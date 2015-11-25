import java.util.*;
public class Runner
	{
		static ArrayList <Squares> board = new ArrayList <Squares>();
		static ArrayList <Players> players = new ArrayList<Players>();
		static ArrayList <String> ownedByPlayer = new ArrayList<String>();
		public static void main(String[] args)
			{
			createArray();
			int currentPosition = players.get(0).getCurrentLocation();
			boolean stillPlaying = true;
			System.out.println("Welcome to Monopoly");
			System.out.println();
			System.out.println("You're on "+board.get(currentPosition).getName());
			Scanner userInput = new Scanner(System.in);
			String idunknow = userInput.nextLine();
			while(stillPlaying)
				{	
				int dieRoll = Human.rollDice();	
				players.get(0).setCurrentLocation(Players.doTurn(dieRoll, currentPosition));
				currentPosition = players.get(0).getCurrentLocation();
				System.out.println("You rolled a "+dieRoll);
				System.out.println("You landed on "+board.get(currentPosition).getName());
				if(ownedByPlayer.size()>0)
					{
					System.out.println("Inventory:");
					displayInventory();
					}
				if(board.get(currentPosition).isCanBeOwned()==true)
					{
					if((players.get(0).getMoney()>((Buyable)board.get(currentPosition)).getPrice())&&(((Buyable) board.get(currentPosition)).isOwned()==false))
						{
						System.out.println(board.get(currentPosition).getName()+" costs $"+(((Buyable) board.get(currentPosition)).getPrice()));
						System.out.println("You have: $"+players.get(0).getMoney()+" Would you like to purchase it? (Y/N)");
						Scanner userInput1 = new Scanner(System.in);
						String answer = userInput1.nextLine();
						if(answer.equals("Y")||answer.equals("y"))
							{
							players.get(0).setMoney(players.get(0).getMoney()-((Buyable)board.get(currentPosition)).getPrice());
							((Buyable) board.get(currentPosition)).setOwned(true);
							ownedByPlayer.add(new String(board.get(currentPosition).getName()));
							System.out.println("Property purchased, you now have $"+players.get(0).getMoney());	
							}
						else
							{
							System.out.println("Property not purchased");	
							}
						}
					else
						{
						if(((Buyable) board.get(currentPosition)).isOwned()==false&&players.get(0).getMoney()<((Buyable)board.get(currentPosition)).getPrice())
							{
							System.out.println(board.get(currentPosition).getName()+" costs $"+(((Buyable) board.get(currentPosition)).getPrice()));
							System.out.println("You have: $"+players.get(0).getMoney()+", and cannot purchase :(");
							}
						else if(((Buyable) board.get(currentPosition)).isOwned()==true)
							{
							System.out.println("Property is already owned");
							}
						}
					}
				Scanner userInput2 = new Scanner(System.in);
				String idunknow1 = userInput2.nextLine();
				}
			}
		public static void createArray()
			{
			players.add(new Human(0,1500));
			board.add(new NonBuyable(0,"GO",false));
			board.add(new Colored(1,"Medditerranean Avenue", "Brown",60,false,true));
			board.add(new NonBuyable(2,"Community Chest",false));
			board.add(new Colored(3,"Baltic Avenue", "Brown",60,false,true));
			board.add(new NonBuyable(4,"Income Tax",false));
			board.add(new NonColored(5,"Reading Railroad",200,false,true));
			board.add(new Colored(6,"Oriental Avenue", "Blue",100,false,true));
			board.add(new NonBuyable(7,"Chance",false));
			board.add(new Colored(8,"Vermont Avenue", "Blue",100,false,true));
			board.add(new Colored(9,"Connecticut Avenue", "Blue",120,false,true));
			board.add(new NonBuyable(10,"Jail",false));
			board.add(new Colored(11,"St. Charles Place", "Pink",140,false,true));
			board.add(new NonColored(12,"Electric Company",150,false,true));
			board.add(new Colored(13,"States Avenue", "Pink",140,false,true));
			board.add(new Colored(14,"Virginia Avenue", "Pink",160,false,true));
			board.add(new NonColored(15,"Pennsylvania Railroad",200,false,true));
			board.add(new Colored(16,"St. James Place", "Orange",180,false,true));
			board.add(new NonBuyable(17,"Community Chest",false));
			board.add(new Colored(18,"Tennessee Avenue", "Orange",180,false,true));
			board.add(new Colored(19,"New York Avenue", "Orange",200,false,true));
			board.add(new NonBuyable(20,"Free Parking",false));
			board.add(new Colored(21,"Kentucky Avenue", "Red",220,false,true));
			board.add(new NonBuyable(22,"Chance",false));
			board.add(new Colored(23,"Indiana Avenue", "Red",220,false,true));
			board.add(new Colored(24,"Illinois Avenue", "Red",240,false,true));		
			board.add(new NonColored(25,"B & O Railroad",200,false,true));		
			board.add(new Colored(26,"Atlantic Avenue", "Yellow",260,false,true));		
			board.add(new Colored(27,"Ventnor Avenue", "Yellow",260,false,true));		
			board.add(new NonColored(28,"Water Works",150,false,true));		
			board.add(new Colored(29,"Marian Gardens", "Yellow",280,false,true));		
			board.add(new NonBuyable(30,"Go To Jail",false));		
			board.add(new Colored(31,"Pacific Avenue", "Green",300,false,true));		
			board.add(new Colored(32,"North Carolina Avenue", "Green",300,false,true));
			board.add(new NonBuyable(33,"Community Chest",false));
			board.add(new Colored(34,"Pennsylvania Avenue", "Green",320,false,true));
			board.add(new NonColored(35,"Short Line",200,false,true));
			board.add(new NonBuyable(36,"Chance",false));
			board.add(new Colored(37,"Park Place", "Blue",350,false,true));
			board.add(new NonBuyable(38,"Luxury Tax",false));
			board.add(new Colored(39,"Boardwalk", "Blue",400,false,true));
			
			
			
			
			}
		public static void displayInventory()
			{
			for(String i:ownedByPlayer)
				{
				System.out.println("\t"+i );	
				}
			System.out.println();
			}

	}
