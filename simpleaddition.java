import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class simpleaddition {

	public static void main(String[] args) throws IOException{
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		BigInteger primero=new BigInteger(in.readLine());
		BigInteger segundo=new BigInteger(in.readLine());
		
		System.out.println(primero.add(segundo).toString());

	}

}
