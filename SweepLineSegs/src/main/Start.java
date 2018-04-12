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
		segmente.add(new Segment(new Punkt(3, 4, PunktTyp.Start), new Punkt(5, 5, PunktTyp.Ende)));
		segmente.add(new Segment(new Punkt(4.5, 6, PunktTyp.Start), new Punkt(5.5, 1, PunktTyp.Ende)));
		
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
				
				sss.Einfuegen(ereignis.Seg, ereignis.Seg.Start.X);
				Segment Vseg = sss.GetVorg(ereignis.Seg);
				if (Vseg != null) {
					sss.TesteSchnittErzeugeEreignis(es, Vseg, ereignis.Seg, i);
				}
				
				Segment Nseg = sss.GetNach(ereignis.Seg);
				if (Nseg != null) {
					sss.TesteSchnittErzeugeEreignis(es, ereignis.Seg, Nseg, i);
				}
				
			}
			// Endpunkt
			else if (ereignis.getTyp() == PunktTyp.Ende) {
				
				Segment Vseg = sss.GetVorg(ereignis.Seg);
				Segment Nseg = sss.GetNach(ereignis.Seg);
				
				sss.Entfernen(ereignis.Seg);
				if (Vseg != null && Nseg != null)
					sss.TesteSchnittErzeugeEreignis(es, Vseg, Nseg, i);
			}
			// Schnittpunkt
			else {
				
				System.out.println(ereignis.punkt.X + "/" + ereignis.punkt.Y);
			
				sss.Vertausche(ereignis.USeg, ereignis.OSeg);
				
				Segment Vseg = sss.GetVorg(ereignis.OSeg);
				if (Vseg != null) {
					sss.TesteSchnittErzeugeEreignis(es, Vseg, ereignis.OSeg, i);
				}
								
				Segment Nseg = sss.GetNach(ereignis.USeg);
				if (Nseg != null) {
					sss.TesteSchnittErzeugeEreignis(es, ereignis.USeg, Nseg, i);
				}
			}
			
			
			
			
			
			i++;
		}
		
		
		

	}

}
