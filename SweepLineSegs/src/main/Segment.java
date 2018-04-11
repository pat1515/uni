package main;

public class Segment {
	public Punkt Start;
	public Punkt Ende;
	
	public Segment(Punkt Start, Punkt Ende) {
		this.Start = Start;
		this.Ende = Ende;
	}
	
	
	public double GetY(double X) {
		
		double m = (Ende.Y - Start.Y) / (Ende.X - Start.X);
		double t = (Ende.X * Start.Y - Start.X * Ende.Y) / (Ende.X - Start.X);
		
		return m * X + t;
	}
	
	
	
	public Punkt Schnittpunkt(Segment other) {
		
		double x1 = this.Start.X;
		double y1 = this.Start.Y;
		double x2 = this.Ende.X;
		double y2 = this.Ende.Y;
		
		double x3 = other.Start.X;
		double y3 = other.Start.Y;
		double x4 = other.Ende.X;
		double y4 = other.Ende.Y;
		
		double Nenner = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
		
		if (Math.abs(Nenner) < 1e-8)
			return null;
		
		double Px = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / Nenner;
		double Py = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / Nenner;
		
		Punkt P = new Punkt(Px, Py, PunktTyp.Schnitt);
		
		if (P.AufSegment(this) && P.AufSegment(other))
			return P;
		else		
			return null;		
	}
}
