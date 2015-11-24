
public abstract class Players
	{
	protected int currentLocation;
	protected int money;
	public static int rollDice()
		{
		int die1 = (int)(Math.random()*5)+1;	
		int die2 = (int)(Math.random()*5)+1;
		int dieRoll = die1+die2;
		return dieRoll;
		}

	public static int doTurn(int r, int p)
		{
		int newPosition = (r+p)%40;
		return newPosition;
		}
	public int getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(int currentLocation) {
		this.currentLocation = currentLocation;
	}
	public int getMoney()
		{
			return money;
		}
	public void setMoney(int money)
		{
			this.money = money;
		}
	}
