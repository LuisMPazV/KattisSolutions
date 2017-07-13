import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Locale;

public class speed {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out= new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String[] initialValues=in.readLine().split(" ");
		int datos=Integer.parseInt(initialValues[0]);
		int tiempo=Integer.parseInt(initialValues[1]);
		Caso[] casos=new Caso[datos];
		double menor=1000000000;
		double velMenor=0;
		double mayor=10000000d;
		for (int i = 0; i < datos; i++) {
			String[] lectura=in.readLine().split(" ");
			int dist=Integer.parseInt(lectura[0]);
			int vel=Integer.parseInt(lectura[1]);
			casos[i]=new Caso(dist, vel);
			
			if(vel<menor){
				menor=vel;
			}
		}
		menor*=-1;
		boolean encontrado=false;
		double c=0;
		int contador=0;
		for(int j=0;j<300;j++) {
			contador++;
			double mitad=(menor+mayor)/2;
			double tiempoProbado=0;
			
			for (int i = 0; i < casos.length; i++) {
				tiempoProbado+=casos[i].dist/(casos[i].speed+mitad);
			}
			if(Math.abs(tiempoProbado-tiempo)<=0.000000001){
				c=mitad;
				encontrado=true;
			}else{
				if(tiempoProbado<0){
					menor=mitad;
				}else if(tiempo<tiempoProbado){
					menor=mitad;
				}
				else{
					mayor=mitad;
				}							
			}
		
		}
		c=(menor+mayor)/2;
		out.format(new Locale("*"),"%.9f%n", c);
		out.close();

	}

	static class Caso{
		double dist;
		double speed;
		
		public Caso(int dist, int speed){
			this.dist=dist;
			this.speed=speed;
		}
	}
}
