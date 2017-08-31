import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class closestsums {

	public static void main(String[] args) throws IOException{
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line=in.readLine();
		int cas=1;
		while(line!=null) {
			int numberOfItems=Integer.parseInt(line);
			int[][] matriz=new int[numberOfItems][numberOfItems];
			ArrayList<Integer> array=new ArrayList<>(((numberOfItems*numberOfItems-numberOfItems)/2));
			for (int i = 0; i < matriz.length; i++) {
				int entrada=Integer.parseInt(in.readLine());
				matriz[i][i]=entrada;
				if(i!=0)
				for (int j = i; j >0; j--) {
					matriz[j-1][i]=matriz[i][i]+matriz[j-1][j-1];
					array.add(matriz[j-1][i]);
				}
				
			}
			Collections.sort(array);
			int numberOfSearch=Integer.parseInt(in.readLine());
			
			out.write("Case "+cas+":\n");
			for (int i = 0; i < numberOfSearch; i++) {
				int numberToSearch=Integer.parseInt(in.readLine());
				int number=busquedaBinaria(array, 0, array.size()-1, numberToSearch);
				
				out.write("Closest sum to "+numberToSearch+" is "+number+".\n");
			}
			line=in.readLine();
			
			
			
			cas++;
		}

		out.close();
	}
	
	
	static int busquedaBinaria(ArrayList<Integer> array,int inf,int sup, int toSearch) {
		if(inf==sup) {
			if(inf>0&&inf<array.size()-1) {
				int superior=Math.abs(array.get(inf+1)-toSearch);
				int inferior=Math.abs(array.get(inf-1)-toSearch);
				int actual=Math.abs(array.get(inf)-toSearch);
				if(superior<inferior) {
					if(superior<actual) {
						return array.get(inf+1);
					}else {
						return array.get(inf);
					}
				}else {
					if(actual<inferior) {
						return array.get(inf);
					}else {
						return array.get(inf-1);
					}
				}
			}else if(inf>0) {
				int inferior=Math.abs(array.get(inf-1)-toSearch);
				int actual=Math.abs(array.get(inf)-toSearch);
					if(actual<inferior) {
						return array.get(inf);
					}else {
						return array.get(inf-1);
					}
			}else {
				int superior=Math.abs(array.get(inf+1)-toSearch);
				int actual=Math.abs(array.get(inf)-toSearch);
				if(superior<actual) {
					return array.get(inf+1);
				}else {
					return array.get(inf);
				}
			}
		}else {
			int mid=(inf+sup)/2;
			if(array.get(mid).intValue()==toSearch) {
				return toSearch;
			}else if(array.get(mid)>toSearch) {
				return busquedaBinaria(array, inf, mid, toSearch);
			}else {
				return busquedaBinaria(array, mid+1, sup, toSearch);
			}
		}
		
	}

}
