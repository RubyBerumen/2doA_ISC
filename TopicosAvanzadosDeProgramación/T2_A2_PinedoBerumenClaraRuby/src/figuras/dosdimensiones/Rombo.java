package figuras.dosdimensiones;

public class Rombo {
	protected double diagonalMayor,diagonalMenor,lado;

	public Rombo(double diagonalMayor, double diagonalMenor, double lado) {
		super();
		this.diagonalMayor = diagonalMayor;
		this.diagonalMenor = diagonalMenor;
		this.lado = lado;
	}
	public double area() {
		return (diagonalMenor*diagonalMayor)/2;
	}
	public double perimetro() {
		return 4*lado;
	}

}
