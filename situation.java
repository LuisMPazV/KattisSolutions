import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class situation {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(in.readLine());
		StringTokenizer skt=new StringTokenizer(in.readLine());
		ArrayList<Long> cola=new ArrayList<>();
		while(skt.hasMoreTokens()){
			cola.add(Long.parseLong(skt.nextToken()));
		}
		Collections.sort(cola);
		
		boolean posible=false;
		
		while(!posible&&cola.size()>2){
			if(cola.get(cola.size()-1)<cola.get(cola.size()-2)+cola.get(cola.size()-3)){
				posible=true;
			}else{
				cola.remove(cola.size()-1);
			}
		}
		if(posible){
			out.write("possible");
		}else{
			out.write("impossible");
			
		}

		out.close();
		in.close();
	}
	
	

}
