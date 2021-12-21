package figuras.dosdimensiones;

public class Circulo {

	double radio;
	public Circulo(double radio) {
		this.radio=radio;
	}
	public double area() {
		return Math.PI*Math.pow(radio, 2);
	}
	public double perimetro() {
		return 2*Math.PI*radio;
	}

}
