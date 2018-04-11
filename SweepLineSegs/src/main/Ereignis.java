package main;

public class Ereignis {

	public Punkt punkt = null;
	public Segment Seg = null;
	
	public Segment USeg = null;
	public Segment OSeg = null;
	
	
	public PunktTyp getTyp() {
		return punkt.Typ;
	}
}
