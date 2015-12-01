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
			board.add(new Colored(1,"Dagobah - Swamp", "Purple",60,false,true));
			board.add(new NonBuyable(2,"Rebel Scum",false));
			board.add(new Colored(3,"Dagobah  - Yodas Hut", "Purple",60,false,true));
			board.add(new NonBuyable(4,"Docking Tax",false));
			board.add(new NonColored(5,"Tie Fighter",200,false,true));
			board.add(new Colored(6,"Hoth - Echo Base", "Blue",100,false,true));
			board.add(new NonBuyable(7,"Imperial Chance",false));
			board.add(new Colored(8,"Hoth - Frozen Plains", "Blue",100,false,true));
			board.add(new Colored(9,"Hoth - North Ridge", "Blue",120,false,true));
			board.add(new NonBuyable(10,"CARBON JAIL",false));
			board.add(new Colored(11,"Tatooine - Lars Homestead", "Pink",140,false,true));
			board.add(new NonColored(12,"Reactor Core",150,false,true));
			board.add(new Colored(13,"Tatooine - Mos Eisly ", "Pink",140,false,true));
			board.add(new Colored(14,"Tatooine - Yodas Second Swamp", "Pink",160,false,true));
			board.add(new NonColored(15,"Millennium Falcon",200,false,true));
			board.add(new Colored(16,"Yavin Four - War Room", "Orange",180,false,true));
			board.add(new NonBuyable(17,"Rebel Scum",false));
			board.add(new Colored(18,"Yavin Four - Massassi Temple", "Orange",180,false,true));
			board.add(new Colored(19,"Yavin Temple - Temple Throne Room", "Orange",200,false,true));
			board.add(new NonBuyable(20,"Free Fighter Parking",false));
			board.add(new Colored(21,"Cloud City - Landos Platform", "Red",220,false,true));
			board.add(new NonBuyable(22,"Imperial Chance",false));
			board.add(new Colored(23,"Cloud City - Carbon Freezing Chamber", "Red",220,false,true));
			board.add(new Colored(24,"Cloud City - Reactor Control Room", "Red",240,false,true));		
			board.add(new NonColored(25,"X-Wing Fighter",200,false,true));		
			board.add(new Colored(26,"Death Star - Landing Bay", "Yellow",260,false,true));		
			board.add(new Colored(27,"Death Star - Throne Room", "Yellow",260,false,true));		
			board.add(new NonColored(28,"Moisture Farm",150,false,true));		
			board.add(new Colored(29,"Death Star - Central Core", "Yellow",280,false,true));		
			board.add(new NonBuyable(30,"IT'S A TRAP",false));		
			board.add(new Colored(31,"Endor - Forest", "Green",300,false,true));		
			board.add(new Colored(32,"Endor - Shield Generator", "Green",300,false,true));
			board.add(new NonBuyable(33,"Rebel Scum",false));
			board.add(new Colored(34,"Endor - Ewok Village", "Green",320,false,true));
			board.add(new NonColored(35,"Star Destroyer",200,false,true));
			board.add(new NonBuyable(36,"Imperial Chance",false));
			board.add(new Colored(37,"Coruscant - Monument Square", "Blue",350,false,true));
			board.add(new NonBuyable(38,"Bounty",false));
			board.add(new Colored(39,"Coruscant - Imperial Palace", "Blue",400,false,true));
			
			
			
			
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
