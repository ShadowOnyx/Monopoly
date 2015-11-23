
public abstract class Players
	{
	protected int currentLocation;
	public static int rollDice()
		{
		int die1 = (int)(Math.random()*5)+1;	
		int die2 = (int)(Math.random()*5)+1;
		int dieRoll = die1+die2;
		return dieRoll;
		}
	public static int doTurn(int r, int p)
		{
		int newPosition = r+p%40;
		return newPosition;
		}
	}
