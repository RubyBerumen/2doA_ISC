package figuras.dosdimensiones;

public class Elipse {
	double radioMa,radioMe;
	public Elipse(double radioMayor,double radioMenor) {
		radioMa=radioMayor;
		radioMe=radioMenor;
	}
	public double perimetro() {
		return 2*Math.PI*Math.sqrt((radioMa*radioMa+radioMe*radioMe)/2);
	}
	public double area() {
		return radioMa*radioMe*Math.PI;
	}
}
