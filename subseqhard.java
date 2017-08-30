import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class subseqhard {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int numberOfCases=Integer.parseInt(in.readLine());
		for (int i = 0; i < numberOfCases; i++) {
			in.readLine();
			int numberOfNumbers=Integer.parseInt(in.readLine());
			StringTokenizer skt=new StringTokenizer(in.readLine());
			long[] numeros=new long[numberOfNumbers];
			numeros[0]=Long.parseLong(skt.nextToken());
			long [] sumas=new long[numberOfNumbers+1];
			sumas[1]=numeros[0];
			TreeMap<Long, Integer> map=new TreeMap<>();
			long cantidad=0;
			map.put(0l, 1);
			map.put(sumas[1], 1);
			if(sumas[1]==47) {
				cantidad++;
			}
			
			for (int j = 1; j < numeros.length; j++) {
				numeros[j]=Long.parseLong(skt.nextToken());
				sumas[j+1]=numeros[j]+sumas[j];
				if(map.get(sumas[j+1])==null) {
					map.put(sumas[j+1], 1);					
				}else {
					map.replace(sumas[j+1], map.get(sumas[j+1])+1);
				}
				long numeroAEncontrar=sumas[j+1]-47;
				Integer numero=map.get(numeroAEncontrar);
				if(numero!=null) {
					cantidad+=numero.intValue();
				}
			}
			out.write(cantidad+"");
			if(i!=numberOfCases-1) {
				out.write("\n");
			}
		}
		out.close();
		in.close();
	}
	
	

}
