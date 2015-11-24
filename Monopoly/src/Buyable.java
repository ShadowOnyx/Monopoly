
public class Buyable extends Squares
	{
	
	protected int houseNum;
	protected int price;
	protected boolean owned;
	
	public boolean isOwned()
		{
			return owned;
		}
	public void setOwned(boolean owned)
		{
			this.owned = owned;
		}
	public int getPrice()
		{
			return price;
		}
	public void setPrice(int price)
		{
			this.price = price;
		}
	
	}
