package figuras.dosdimensiones;

public class Triangulo {
	protected double  lado1,lado2,lado3;

	public Triangulo(double lado1, double lado2, double lado3) {
		super();
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}
	public double area() {
		double semiPerimetro=(lado1+lado2+lado3)/2;
		return Math.sqrt(semiPerimetro*(semiPerimetro-lado1)*(semiPerimetro-lado2)*(semiPerimetro-lado3));
	}
	public double perimetro() {
		return (lado1+lado2+lado3);
	}

}
