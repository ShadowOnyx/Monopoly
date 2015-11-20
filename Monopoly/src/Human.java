
public class Human extends Players
	{
	public int doTurn()
		{
		int die1 = (int)(Math.random()*5)+1;	
		int die2 = (int)(Math.random()*5)+1;
		return die1+die2;
		}
	}
