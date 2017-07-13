import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class busnumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N=Integer.parseInt(in.readLine());
		int[] array=new int[N];
		StringTokenizer skt=new StringTokenizer(in.readLine());
		for (int i = 0; i < array.length; i++) {
			array[i]=Integer.parseInt(skt.nextToken());
		}
		Arrays.sort(array);
		out.write(array[0]+"");
		for (int i = 1; i < array.length; i++) {
			int j=0;
			while((i+j)<array.length&&array[(i+j)-1]+1==array[(i+j)]){
				j++;
			}
			j--;
			if(j<1){
				out.write(" "+array[i]+"");
			}else{
				out.write("-"+array[i+j]+"");
				i=i+j;
			}
		}

		out.close();
		in.close();
	}

}
