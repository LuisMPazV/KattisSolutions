import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class cold {

	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(in.readLine());
		StringTokenizer skt=new StringTokenizer(in.readLine());

		int contador=0;
		while(skt.hasMoreTokens()){
			int actual=Integer.parseInt(skt.nextToken());
			if(actual<0){
				contador++;
			}
		}
		System.out.println(contador);
	}

}
