package semana_05;

public class ArregloPrecios {

	private double[] precio = {240.5, 350.2, 80.4, 100.3, 470.1, 60.0, 330.8, 260.6, 510.9, 200.7};

	public ArregloPrecios() {
		
	}
	
	public int tamanio() {
		return precio.length;
	}
	
	public double obtener(int pos ) {
		return precio[pos];
	}
	
	public double precioPromedio() {
		double sumaprecio = 0.0;
		for(int i=0;i<precio.length;i++) {
			sumaprecio+=obtener(i);
		}
		return sumaprecio/tamanio();
	}
	
	public double precioMayor() {
		double precioMayor = obtener(0);
		for(int i=0;i<precio.length;i++) {
			if(obtener(i)>precioMayor) {
				precioMayor = obtener(i);
			}
		}
		return precioMayor;
	}
	
	public double precioMenor() {
		double precioMenor = obtener(0);
		for(int i=0;i<precio.length;i++) {
			if(obtener(i)<precioMenor) {
				precioMenor = obtener(i);
			}
		}
		return precioMenor;
	}
	
	public int cantMayoresprecioPromedio () {
		int contMayorPromedio =0;
		for ( int i=0;i<precio.length;i++) {
			if(obtener(i)>=precioPromedio()) {
				contMayorPromedio++;
			}
		}
		return contMayorPromedio;
	}
	
	public int cantMenoresprecioPromedio () {
		int contMenorPromedio =0;
		for ( int i=0;i<precio.length;i++) {
			if(obtener(i)<precioPromedio()) {
				contMenorPromedio++;
			}
		}
		return contMenorPromedio;
	}

	public int posPrimerPrecioMayorAlSegundo() {
		
		for(int i=0;i<precio.length;i++) {
			if(obtener(i)>obtener(1)) {
				return i;
			}
		}
		return -1;
	}
	
	public int posUltimoPrecioMenorAlPenultimo(){
		 for (int i = precio.length - 1; i >= 0; i--) {
		        if (precio[i] < obtener(precio.length-2)) {
		            return i; 
		        }
		    }
		 return -1;
	}
	
	public void generarPrecios() {
		for(int i=0;i<precio.length;i++) {
			precio[i] = aleatorio(99.9, 999.9);
		}
	}
	
	private double aleatorio(double min, double max) {
		return (int)((max - min + 1) * Math.random()) + min;
		}
}



