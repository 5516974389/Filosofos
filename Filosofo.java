package comensales;
import java.util.Random;
public class Filosofo implements  Runnable{
   private Thread hilo;
   protected Cena cena;
   protected int tizq , tder;
   protected int numero;
	

   public Filosofo(int x, Cena cena) {
	  this.numero= x;
	  this.cena =cena;
	  tizq =cena.getTenedorIzq(numero);
	  tder= cena.getTenedorDer(numero);
	  hilo = new Thread(this);
	  hilo.start(); 
   }
   public void pensar(){
	try {
		System.out.println("filosofo"+numero+"pensando");
	    int espera =  (int)(Math.random()*1000);
        hilo.sleep(espera);
        System.out.println("filosofo"+numero+"tiene Hambre");
        
	}  catch(InterruptedException e) 
	{
		e.printStackTrace();	
	} 	   
   
   }
   public void TomarTenedores()
   {
	System.out.println("Tomando Tenedores");
	tenedor t1= cena.getTenedor (tizq);
	tenedor t2= cena.getTenedor(tder);
	t1.usar();
	t2.usar();
   
   }
   public void comer () 
   {
	try {
		System.out.println("filosgo"+numero+"Esta comiendo");
		int espera = (int)(Math.random()*700);
		hilo.sleep(espera);
		System.out.println("filosofo"+numero+"Esta satisfecho");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}   	
	}
  protected void dejarTenedores() 
  {
	 System.out.println("Soltando Tenedores");
	 tenedor t1 = 	cena.getTenedor(tizq);
	 tenedor t2 =  cena.getTenedor(tder);
	 t1.dejar();
	 t2.dejar();
  } 
public void  run() {
	while(true) 
	{
	pensar();
	TomarTenedores();
	comer();
	dejarTenedores();
	}
	
}

}


