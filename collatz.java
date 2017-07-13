import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class collatz {

	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		String line=in.readLine();
		while(!line.equals("0 0")){
			StringTokenizer skt=new StringTokenizer(line);
			int initialFirst=Integer.parseInt(skt.nextToken());
			long firstNumber=initialFirst;
			int initialSecond=Integer.parseInt(skt.nextToken());
			long secondNumber=initialSecond;
			HashSet<Long> firstNumberSet=new HashSet<>();
			HashMap<Long, Integer> firstNumberSetPosition=new HashMap<>();
			firstNumberSet.add(firstNumber);
			firstNumberSetPosition.put((long)firstNumber, 0);
			int index=1;
			while(firstNumber!=1){
				if(firstNumber%2==0){
					firstNumber=firstNumber/2;
				}else{
					firstNumber=firstNumber*3+1;
				}
				firstNumberSet.add(firstNumber);
				firstNumberSetPosition.put(firstNumber, index);
				index++;
			}
			boolean encontrado=false;
			index=0;
			while(!encontrado){
				if(firstNumberSet.contains(secondNumber)){
					out.write(initialFirst+" needs "+firstNumberSetPosition.get(secondNumber)+" steps, "+initialSecond+" needs "+index+" steps, they meet at "+secondNumber+"\n");
					encontrado=true;
				}else{
					if(secondNumber%2==0){
						secondNumber/=2;
					}else{
						secondNumber=secondNumber*3+1;
					}
				}
				index++;
			}
			line=in.readLine();
		}
		out.close();
		in.close();

	}

}
