package main;

import java.util.Comparator;

public class PunktComparator implements Comparator<Ereignis> {

	@Override
	public int compare(Ereignis arg0, Ereignis arg1) {

		if (arg0.punkt.X < arg1.punkt.X)
			return -1;
		else if (arg0.punkt.X > arg1.punkt.X)
			return 1;
		else
			return 0;
		
	}

}
