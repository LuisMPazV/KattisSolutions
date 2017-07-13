import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class secretmessage {

	public static void main(String[] args)  throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));

		int numberOfCases=Integer.parseInt(in.readLine());
		for (int i = 0; i < numberOfCases; i++) {
			char[] word=in.readLine().trim().toCharArray();
			int dimension=(int)Math.ceil(Math.sqrt(word.length));
			char[][] matriz=new char[dimension][dimension];
			int index=0;
			for (int j = matriz.length-1; j >= 0; j--) {
				for (int k = 0; k < matriz.length; k++) {
					if(index<word.length)
						matriz[k][j]=word[index];
					else
						matriz[k][j]='*';
					
					index++;
				}
			}
			StringBuilder respuesta=new StringBuilder();
			for (int j = 0; j < matriz.length; j++) {
				for (int k = 0; k < matriz.length; k++) {
					if(matriz[j][k]!='*'){
						respuesta.append(matriz[j][k]+"");
					}
				}
			}
			
			out.write(respuesta.toString()+"\n");
			
		}
		out.close();
		in.close();
		
	}

}
