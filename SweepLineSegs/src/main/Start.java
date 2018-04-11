package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Start {

	public static void main(String[] args) {
		
		List<Segment> segmente = new ArrayList<Segment>();
		
		// Segmente
		segmente.add(new Segment(new Punkt(1, 1, PunktTyp.Start), new Punkt(6, 4, PunktTyp.Ende)));		
		segmente.add(new Segment(new Punkt(2, 4, PunktTyp.Start), new Punkt(4, 1, PunktTyp.Ende)));		
		segmente.add(new Segment(new Punkt(3, 3, PunktTyp.Start), new Punkt(5, 5, PunktTyp.Ende)));
		
		// Strukturen erstellen
		ES es = new ES();
		SSS sss = new SSS();
		
		// Ereignisse der ES hinzufügen
		for (int i = 0; i < segmente.size(); i++) {
			
			Ereignis e1 = new Ereignis();
			e1.punkt = segmente.get(i).Start;
			e1.Seg = segmente.get(i);
			
			Ereignis e2 = new Ereignis();
			e2.punkt = segmente.get(i).Ende;
			e2.Seg = segmente.get(i);
			
			es.ereignisse.add(e1);
			es.ereignisse.add(e2);			
		}
		
		// Punkte sortieren nach aufsteigender X-Koordinate
		Collections.sort(es.ereignisse, new PunktComparator());
		
		// Sweep durchführen
		int i = 0;
		while (i < es.ereignisse.size()) {
			
			Ereignis ereignis = es.ereignisse.get(i);
			
			// Startpunkt
			if (ereignis.getTyp() == PunktTyp.Start) {
				
				
				
			}
			// Endpunkt
			else if (ereignis.getTyp() == PunktTyp.Ende) {
				
				
				
			}
			// Schnittpunkt
			else {
				
				
				
			}
			
			
			
			
			
			i++;
		}
		
		
		

	}

}
