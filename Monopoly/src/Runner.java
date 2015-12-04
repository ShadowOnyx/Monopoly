import java.util.*;
public class Runner
	{
		static ArrayList <Squares> board = new ArrayList <Squares>();
		static ArrayList <Players> players = new ArrayList<Players>();
		static ArrayList <String> ownedByPlayer = new ArrayList<String>();
		
		public static void main(String[] args)
			{
			createArray(chooseBoard());
			int currentPosition = players.get(0).getCurrentLocation();
			boolean stillPlaying = true;
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
				if(board.get(currentPosition) instanceof Buyable)
					{
					if((players.get(0).getMoney()>((Buyable)board.get(currentPosition)).getPrice())&&(((Buyable) board.get(currentPosition)).isOwned()==false))
						{
						System.out.println(board.get(currentPosition).getName()+" costs "+(((Buyable) board.get(currentPosition)).getPrice())+" credits");
						System.out.println("You have: "+players.get(0).getMoney()+" credits, would you like to purchase it? (Y/N)");
						Scanner userInput1 = new Scanner(System.in);
						String answerToBuy = userInput1.nextLine();
						if(answerToBuy.equals("Y")||answerToBuy.equals("y"))
							{
							players.get(0).setMoney(players.get(0).getMoney()-((Buyable)board.get(currentPosition)).getPrice());
							((Buyable) board.get(currentPosition)).setOwned(true);
							ownedByPlayer.add(new String(board.get(currentPosition).getName()));
							System.out.println("Property purchased, you now have "+players.get(0).getMoney()+" credits");	
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
							System.out.println(board.get(currentPosition).getName()+" costs "+(((Buyable) board.get(currentPosition)).getPrice())+" credits");
							System.out.println("You have: "+players.get(0).getMoney()+" credits, and cannot purchase :(");
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
		public static int chooseBoard()
			{
			System.out.println("Welcome to Star Wars Monopoly");
			System.out.println("What version would you like to play? 1) Original 2) Star Wars 3)Random");	
			Scanner userInput3 = new Scanner(System.in);
			int answer = userInput3.nextInt();
			if(answer==3)
				{
				answer=(int)(Math.random()*2)+1;
				}
			if(answer>3||answer<1)
				{
				System.out.println("Choice not recognized, random board chosen");	
				answer=(int)(Math.random()*2)+1;
				}
			return answer;
			}
		public static void createArray(int answer)
			{
			if(answer==2)
				{
				players.add(new Human(0,1500));
				board.add(new NonBuyable(0,"GO"));
				board.add(new Colored(1,"Dagobah - Swamp", "Purple",60,false));
				board.add(new NonBuyable(2,"Rebel Scum"));
				board.add(new Colored(3,"Dagobah  - Yodas Hut", "Purple",60,false));
				board.add(new NonBuyable(4,"Docking Tax"));
				board.add(new NonColored(5,"Tie Fighter",200,false));
				board.add(new Colored(6,"Hoth - Echo Base", "Blue",100,false));
				board.add(new NonBuyable(7,"Imperial Chance"));
				board.add(new Colored(8,"Hoth - Frozen Plains", "Blue",100,false));
				board.add(new Colored(9,"Hoth - North Ridge", "Blue",120,false));
				board.add(new NonBuyable(10,"CARBON JAIL"));
				board.add(new Colored(11,"Tatooine - Lars Homestead", "Pink",140,false));
				board.add(new NonColored(12,"Reactor Core",150,false));
				board.add(new Colored(13,"Tatooine - Mos Eisly ", "Pink",140,false));
				board.add(new Colored(14,"Tatooine - Yodas Second Swamp", "Pink",160,false));
				board.add(new NonColored(15,"Millennium Falcon",200,false));
				board.add(new Colored(16,"Yavin Four - War Room", "Orange",180,false));
				board.add(new NonBuyable(17,"Rebel Scum"));
				board.add(new Colored(18,"Yavin Four - Massassi Temple", "Orange",180,false));
				board.add(new Colored(19,"Yavin Temple - Temple Throne Room", "Orange",200,false));
				board.add(new NonBuyable(20,"Free Fighter Parking"));
				board.add(new Colored(21,"Cloud City - Landos Platform", "Red",220,false));
				board.add(new NonBuyable(22,"Imperial Chance"));
				board.add(new Colored(23,"Cloud City - Carbon Freezing Chamber", "Red",220,false));
				board.add(new Colored(24,"Cloud City - Reactor Control Room", "Red",240,false));		
				board.add(new NonColored(25,"X-Wing Fighter",200,false));		
				board.add(new Colored(26,"Death Star - Landing Bay", "Yellow",260,false));		
				board.add(new Colored(27,"Death Star - Throne Room", "Yellow",260,false));		
				board.add(new NonColored(28,"Moisture Farm",150,false));		
				board.add(new Colored(29,"Death Star - Central Core", "Yellow",280,false));		
				board.add(new NonBuyable(30,"IT'S A TRAP"));		
				board.add(new Colored(31,"Endor - Forest", "Green",300,false));		
				board.add(new Colored(32,"Endor - Shield Generator", "Green",300,false));
				board.add(new NonBuyable(33,"Rebel Scum"));
				board.add(new Colored(34,"Endor - Ewok Village", "Green",320,false));
				board.add(new NonColored(35,"Star Destroyer",200,false));
				board.add(new NonBuyable(36,"Imperial Chance"));
				board.add(new Colored(37,"Coruscant - Monument Square", "Blue",350,false));
				board.add(new NonBuyable(38,"Bounty"));
				board.add(new Colored(39,"Coruscant - Imperial Palace", "Blue",400,false));
				}
			if(answer==1)
				{
				players.add(new Human(0,1500));
				board.add(new NonBuyable(0,"GO"));
				board.add(new Colored(1,"Medditerranean Avenue", "Brown",60,false));
				board.add(new NonBuyable(2,"Community Chest"));
				board.add(new Colored(3,"Baltic Avenue", "Brown",60,false));
				board.add(new NonBuyable(4,"Income Tax"));
				board.add(new NonColored(5,"Reading Railroad",200,false));
				board.add(new Colored(6,"Oriental Avenue", "Blue",100,false));
				board.add(new NonBuyable(7,"Chance"));
				board.add(new Colored(8,"Vermont Avenue", "Blue",100,false));
				board.add(new Colored(9,"Connecticut Avenue", "Blue",120,false));
				board.add(new NonBuyable(10,"Jail"));
				board.add(new Colored(11,"St. Charles Place", "Pink",140,false));
				board.add(new NonColored(12,"Electric Company",150,false));
				board.add(new Colored(13,"States Avenue", "Pink",140,false));
				board.add(new Colored(14,"Virginia Avenue", "Pink",160,false));
				board.add(new NonColored(15,"Pennsylvania Railroad",200,false));
				board.add(new Colored(16,"St. James Place", "Orange",180,false));
				board.add(new NonBuyable(17,"Community Chest"));
				board.add(new Colored(18,"Tennessee Avenue", "Orange",180,false));
				board.add(new Colored(19,"New York Avenue", "Orange",200,false));
				board.add(new NonBuyable(20,"Free Parking"));
				board.add(new Colored(21,"Kentucky Avenue", "Red",220,false));
				board.add(new NonBuyable(22,"Chance"));
				board.add(new Colored(23,"Indiana Avenue", "Red",220,false));
				board.add(new Colored(24,"Illinois Avenue", "Red",240,false));		
				board.add(new NonColored(25,"B & O Railroad",200,false));		
				board.add(new Colored(26,"Atlantic Avenue", "Yellow",260,false));		
				board.add(new Colored(27,"Ventnor Avenue", "Yellow",260,false));		
				board.add(new NonColored(28,"Water Works",150,false));		
				board.add(new Colored(29,"Marian Gardens", "Yellow",280,false));		
				board.add(new NonBuyable(30,"Go To Jail"));		
				board.add(new Colored(31,"Pacific Avenue", "Green",300,false));		
				board.add(new Colored(32,"North Carolina Avenue", "Green",300,false));
				board.add(new NonBuyable(33,"Community Chest"));
				board.add(new Colored(34,"Pennsylvania Avenue", "Green",320,false));
				board.add(new NonColored(35,"Short Line",200,false));
				board.add(new NonBuyable(36,"Chance"));
				board.add(new Colored(37,"Park Place", "Blue",350,false));
				board.add(new NonBuyable(38,"Luxury Tax"));
				board.add(new Colored(39,"Boardwalk", "Blue",400,false));	
				}
			
			
			
			}
		public static void displayInventory()
			{
			for(String i:ownedByPlayer)
				{
				System.out.println("\t"+"|"+i+"|");	
				}
			System.out.println();
			}

	}
