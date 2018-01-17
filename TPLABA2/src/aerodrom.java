import java.io.Serializable;
import java.util.Dictionary;
import java.util.Hashtable;


public class aerodrom <T extends Itechnica> implements Serializable{
	private Dictionary<Integer, T> places;
	int maxCount;
	private T defaultValue;

	public aerodrom(int size, T defVal)
	{
		places = new Hashtable<Integer, T>();
		maxCount = size;
	}
	
	public static <T extends Itechnica> int plus(aerodrom<T> p, T samolet) throws ParkingOverflowException
	{
		if (p.places.size() == p.maxCount) throw new ParkingOverflowException();
		for(int i = 0; i < p.places.size(); i++)
		{
			if (p.checkFree(i))
			{
				p.places.put(i, samolet);
				return i;
			}
		}
		p.places.put(p.places.size(), samolet);
		return p.places.size() - 1;
	}

	public static <T extends Itechnica> T minus(aerodrom<T> p, int index)throws ParkingIndexOutOfRangeException
	{
		if (p.places.get(index) != null)
		{
			T samolet = p.places.get(index);
			p.places.remove(index);
			return samolet;
		}
		throw new ParkingIndexOutOfRangeException();
	}

	public boolean checkFree(int index)
	{
		if(places.get(index)==null) return true;
		return false;
	}
	
	public T getSamolet(int ind) {
		if(places.get(ind)!=null) return places.get(ind);
		return defaultValue;
	}
}