package comensales;

public class tenedor {
	int numero;
	boolean EnUso;
	
	public tenedor(int x) {
		numero=x;		
	}
	synchronized public void usar () {
	if(EnUso) 
	{
		System.out.println("tenedor"+numero+"Esta en uso,Espera");
		
	}else {
		EnUso =true;
		System.out.println("Se esta usando el tenedor"+numero);
	}
	}
	synchronized public void dejar() {
	EnUso = false ;
	System.out.println("Tenedor"+numero+" esta Ahora disponible");
	
	
	}

}

