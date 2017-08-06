import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Vector;

public class brother {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int number = Integer.parseInt(in.readLine());
		int root = (int) Math.sqrt(number) + 3;
		ArrayList<Integer> criba = a(root);
		boolean salir = false;
		for (int i = 0; i < criba.size() && !salir; i++) {
			double value = Math.log(number) / Math.log(criba.get(i));
			int integer = (int) value;
			if (value - integer <= 0.0000000001) {
				salir = true;
			}
		}
		if(number==1){
			out.write("no");
		}
		else if (salir) {
			out.write("yes");
		} else if (esPrimo(number)){
			out.write("yes");
		} else {
			out.write("no");
		}
		out.close();
		in.close();

	}

	public static boolean esPrimo(int num){
		int c = 0;
		for (int i = 1; i*i < num; i++) {
			if (num%i==0){
				c+=2;
			}
			if (c>2){
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<Integer> a(int b) {

		int x[] = new int[b];
		x[0] = 1;
		x[1] = 1;
		x[2] = 0;
		ArrayList<Integer> criba = new ArrayList<>();
		for (int y = 0; y * y < b; y++) {
			if (x[y] != 1) {
				for (int z = y * y; z < x.length; z += y) {
					x[z] = 1;
				}
			}
		}
		for (int i = 0; i < x.length; i++) {
			if (x[i] == 0) {
				criba.add(i);
			}
		}
		return criba;
	}

}
