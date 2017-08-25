import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class acm {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line=in.readLine();
		HashMap<String, Integer> map=new HashMap<>();
		int count=0;
		int solved=0;
		while(!line.equals("-1")) {
			String[] array=line.split(" ");
			if(array[2].equals("right")) {
				if(map.get(array[1])!=null) {
					count+=Integer.parseInt(array[0]);
					count+=20*map.get(array[1]);
					solved+=1;
				}else {
					count+=Integer.parseInt(array[0]);
					solved+=1;
				}
			}else {
				if(map.get(array[1])!=null) {
					map.replace(array[1], map.get(array[1]).intValue()+1);
				}else {
					map.put(array[1], 1);
				}
			}
			line=in.readLine();
		}

		out.write(solved+" "+count);
		out.close();
	}

}
