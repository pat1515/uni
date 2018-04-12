package main;

public class Punkt {
	public double X;
	public double Y;
	
	public PunktTyp Typ;
	
	public Punkt(double X, double Y, PunktTyp Typ) {
		this.X = X;
		this.Y = Y;
		this.Typ = Typ;
	}
	
	
	public double distanceTo(Punkt other) {
		
		return Math.sqrt(Math.pow(other.X - this.X, 2) + Math.pow(other.Y - this.Y, 2));
	}
	
	public boolean AufSegment(Segment seg) {
		
		Punkt a = seg.Start;
		Punkt b = seg.Ende;
		
		double crossproduct = (this.Y - a.Y)* (b.X - a.X)- (this.X - a.X)* (b.Y - a.Y);
		if (Math.abs(crossproduct) > 1e-8)
			return false;
		
		double dotproduct = (this.X - a.X) * (b.X - a.X) + (this.Y - a.Y)* (b.Y - a.Y);
		if (dotproduct < 0.0)
			return false;
		
		double squaredlengthba = (b.X - a.X) * (b.X - a.X) + (b.Y - a.Y) * (b.Y - a.Y);   
		if (dotproduct > squaredlengthba)
			return false;
		
		return true;
	}
}
