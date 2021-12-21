package figuras.tresdimensiones;

public class Piramide {
	private double altura,a,a2;

	public Piramide(double altura, double a, double a2) {
		super();
		this.altura = altura;
		this.a = a;
		this.a2 = a2;
	}
	public double area() {
		double resultado=4*a;
		return resultado*(a+a2)/2;
	}
	public double volumen() {
		return (Math.pow(a, 2)*altura)/3;
	}
}
