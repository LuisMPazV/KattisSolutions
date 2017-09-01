import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class batmanacci {

	static HashMap<Integer, StringBuilder> map=new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		StringTokenizer skt=new StringTokenizer(in.readLine());
		int numberOfSucesion=Integer.parseInt(skt.nextToken());
		long index=Long.parseLong(skt.nextToken());
		
		BigInteger[] fib=new BigInteger[numberOfSucesion];
		fib[0]=BigInteger.valueOf(1);
		fib[1]=BigInteger.valueOf(1);
		
		for (int i = 2; i < fib.length; i++) {
			fib[i]=fib[i-1].add(fib[i-2]);
		}
		int posOfArray=numberOfSucesion-1;
		while(posOfArray>1) {
			if(fib[posOfArray-2].compareTo(BigInteger.valueOf(index))<0) {
				index-=fib[posOfArray-2].longValueExact();
				posOfArray-=1;
			}else {
				posOfArray-=2;
			}
		}
		
		String resultado= posOfArray==0? "N":"A";
		out.write(resultado+"\n");
		out.close();
	}

	
	
}
