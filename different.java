import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class different {

	public static void main(String[] args)throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line=in.readLine();
		while(line!=null){
			StringTokenizer skt=new StringTokenizer(line);
			long first=Long.parseLong(skt.nextToken());
			long second=Long.parseLong(skt.nextToken());
			long dif=Math.abs(first-second);
			out.write(dif+"\n");
			line=in.readLine();
			
		}
		out.close();
		in.close();

	}

}
