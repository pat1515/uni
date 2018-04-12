package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SSS {

	List<Segment> segmente = new ArrayList<Segment>();
	
	
	
	public void Einfuegen(Segment seg, double X) {
		
		if (segmente.size() == 0) {
			segmente.add(seg);
			return;
		}
		
		// Vorne  einfügen
		if (seg.GetY(X) < segmente.get(0).GetY(X)) {
			segmente.add(0, seg);
			return;
		}
		
		// Hinten einfügen
		if (seg.GetY(X) > segmente.get(segmente.size() - 1).GetY(X)) {
			segmente.add(seg);
			return;
		}		
		
		// Irgendwo in der Mitte einfügen
		for (int i = 1; i < segmente.size(); i++) {
			
			if (seg.GetY(X) > segmente.get(i-1).GetY(X) && seg.GetY(X) < segmente.get(i).GetY(X)) {
				segmente.add(i, seg);
				return;
			}			
		}
	}
	
	
	public void Entfernen(Segment seg) {
		
		segmente.remove(seg);
	}
	
	
	public void Vertausche (Segment seg1, Segment seg2) {
		
		int i = segmente.indexOf(seg1);
		int j = segmente.indexOf(seg2);
		Collections.swap(segmente, i, j);
	}
	
	
	
	public Segment GetVorg(Segment seg) {
		
		int i = segmente.indexOf(seg);
		i--;
		if (i >= 0 && i < segmente.size())
			return segmente.get(i);		
		
		return null;
	}
	
	
	public Segment GetNach(Segment seg) {
		
		int i = segmente.indexOf(seg);
		i++;
		if (i >= 0 && i < segmente.size())
			return segmente.get(i);		
		
		return null;
	}
	
	
	void TesteSchnittErzeugeEreignis(ES es, Segment a, Segment b, int i) {
		
		Punkt p = a.Schnittpunkt(b);
		
		if (p != null) {
			
			boolean vorhanden = false;
			
			for (int j = 0; j < es.ereignisse.size(); j++) {
				
				if (p.distanceTo(es.ereignisse.get(j).punkt) < 1e-8) {
					vorhanden = true;
					break;
				}
			}
			
			
			if (!vorhanden) {
				Ereignis ereignis = new Ereignis();
				ereignis.USeg = a;
				ereignis.OSeg = b;
				ereignis.punkt = new Punkt(p.X, p.Y, PunktTyp.Schnitt);
				
				es.ereignisse.add(i + 1, ereignis);
			}
		}
		
	}
	
}
