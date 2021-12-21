package figuras.tresdimensiones;

public class Cono {
	double radio,altura, generatriz;

	public Cono(double radio, double altura, double generatriz) {
		super();
		this.radio = radio;
		this.altura = altura;
		this.generatriz = generatriz;
	}
	public double volumen() {
		return Math.PI*Math.pow(radio, 2)*altura/3;
	}
	public double area() {
		return (radio+generatriz)*(Math.PI*radio);
	}
	
}
