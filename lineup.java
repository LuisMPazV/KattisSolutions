import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class lineup {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(in.readLine());
		boolean decreasing=true;
		boolean increasing=true;
		String anterior="";
		String actual=in.readLine();
		for (int i = 1; i < n&&(increasing||decreasing); i++) {
			anterior=actual;
			actual=in.readLine();
			if(actual.compareTo(anterior)>0) {
				decreasing=false;
			}else if(actual.compareTo(anterior)<0) {
				increasing=false;
			}
		}
		if(increasing) {
			out.write("INCREASING");
		}else if(decreasing) {
			out.write("DECREASING");
		}else {
			out.write("NEITHER");
		}
		out.close();

	}

}
