import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class permutationencryption {

	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		String line=in.readLine().trim();
		while(!line.equals("0")){
			StringTokenizer skt=new StringTokenizer(line);
			int lenghtOfKey=Integer.parseInt(skt.nextToken());
			int[] key=new int[lenghtOfKey];
			for (int i = 0; i < key.length; i++) {
				key[i]=Integer.parseInt(skt.nextToken());
			}
			char[] original=in.readLine().toCharArray();
			int lenghtNewMessage=(int)Math.ceil(((double)original.length)/((double)lenghtOfKey));
			char[] newMessage=new char[lenghtNewMessage*lenghtOfKey];
			int index=0;
			for (int i = 0; i < lenghtNewMessage; i++) {
				for (int j = 0; j < key.length; j++) {
					int control=(key[j]*i)-1;
					if((key[j]+(lenghtOfKey*i))-1<original.length){
						newMessage[index]=original[(key[j]+(lenghtOfKey*i))-1];
					}else{
						newMessage[index]=' ';
					}
					index++;
				}
			}
			StringBuilder answer=new StringBuilder();
			for (int i = 0; i < newMessage.length; i++) {
				answer.append(newMessage[i]+"");
			}
			out.write("'"+answer.toString()+"'\n");
			line=in.readLine();
		}
		out.close();
		in.close();
	}

}
