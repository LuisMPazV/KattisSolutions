import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class cd {

	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		String linea=in.readLine();
		while(!linea.equals("0 0")){
			HashMap<String, String> map=new HashMap<>();
			String[] arreglo=linea.split(" ");
			int numeroPrimero=Integer.parseInt(arreglo[0]);
			int numeroSegundo=Integer.parseInt(arreglo[1]);
			for (int i = 0; i < numeroPrimero; i++) {
				String aAgregar=in.readLine();
				map.put(aAgregar, aAgregar);
			}
			int cuenta=0;
			for (int i = 0; i < numeroSegundo; i++) {
				if(map.get(in.readLine())!=null){
					cuenta++;
				}
			}
			out.write(cuenta+"\n");
			linea=in.readLine();
		}
		out.close();
		in.close();

	}

}
