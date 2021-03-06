import java.util.Scanner;

class Biseccion {
	private double xi;
	private double xu;
	
	public Biseccion(double xi, double xu) {	
		this.xi = xi;
		this.xu = xu;	
	}
	
	
	public void calcular() {
		int cont = 0;
		double xr = 0;
		double fxi = 0;
		double fxr = 0;
		double xrant = 0;
		double fxrfxi = 0;

		do {
			System.out.println("-----------------------------------------\n");
			System.out.println("Iteracion: " + (cont+1));

			xr = (xi+xu)/2;//Calculos
			fxi = 2.5+xi;
			fxr = 2.5+xr;
			fxrfxi = fxi*fxr;
			
			if(cont!=0) {
				double res = xr-xrant;
				String caracter = String.valueOf(res);
				
				System.out.println("Error: " + (res*100/xr));
			}

			if(fxrfxi<0) {// Calculo de fxr y fxi
				xu=xr;
			}else if(fxrfxi>0) {
				xi=xr;
			}else {
				System.out.println("Raiz aproximada: " + xr);
				break;
			}

			System.out.println("f(xr)="+fxr);
			System.out.println("f(xl)="+fxi);
			System.out.println("xr: "+xr);
			System.out.println("f(xl)f(xr)="+fxrfxi);
			System.out.println("xu: "+xu);
			System.out.println("xi: "+xi);

			System.out.println();
			System.out.println();
			
			cont++;//Contador para aumentar el valor de las iteraciones
			
			xrant=xr;
			
		}while(cont<10);

	}
	
}



class ReglaFalsa {
	private double a;
	private double b;
	
	public ReglaFalsa(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
    public void calcular() {
		int cont = 0;
		double xi;
		double fa = 0;
		double fb = 0;
		double fxi = 0;
		
		do {
			System.out.println("-----------------------------------------");
			System.out.println("Iteracion: " + (cont+1));
			
			fa = 2.5+a;//Calculos
			fb = 2.5+b;
			xi = (a*fb-b*fa)/(fb-fa);

			fxi = 2.5+xi;
			
			if(fa*fxi>0) {// Calculo de fxr y fxi
				a=xi;
			}else if(fa*fxi<0){
				b=xi;
			}else {
				System.out.println("Resultados= Xi: " + xi + ", fxi: " + fxi);
				break;
			}
			
			
			System.out.println("f(a): "+fa);
			System.out.println("f(b): "+fb);
			System.out.println("xi: "+xi);
			System.out.print("f(xi): "+fxi);

			System.out.println();
			System.out.println();
			
			cont++;

		}while(cont<10);

	}
    
	
}


public class Prueba {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		String op="";
		System.out.println("Funcion: f(x)=2.5+x");
		
		do {
			System.out.println("Elije un m?todo");
			System.out.println("1->Metodo de biseccion ");
			System.out.println("2->Regla Falsa");
			System.out.println("3->Salir");
			op=entrada.nextLine();
			switch (op) {
			case "1":
				System.out.println("Ingresa el primer valor");
				double n1=entrada.nextDouble();
				System.out.println("Ingresa el segundo valor");
				double n2=entrada.nextDouble();
				Biseccion bi = new Biseccion(n1,n2);
				bi.calcular();
				entrada.nextLine();
				break;
			case "2":
				System.out.println("Ingresa el primer valor");
				double num1=entrada.nextDouble();
				System.out.println("Ingresa el segundo valor");
				double num2=entrada.nextDouble();
				ReglaFalsa rf =new ReglaFalsa(num1, num2);
				rf.calcular();
				entrada.nextLine();
				break;
			case "3":
				System.out.println("Saliendo.....");
				break;
			default:
				System.out.println("Opci?n incorrecta");
				break;
			}
		}while(!op.equals("3"));
	
		

	}

}
