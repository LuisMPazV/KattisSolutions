import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class deduplicatingfiles {

	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line=in.readLine();
		while(!line.equals("0")){
			HashMap<String, Integer> set=new HashMap<>();
			HashSet<String> set1=new HashSet<>();
			int numberOfTimes=Integer.parseInt(line);
			for (int i = 0; i < numberOfTimes; i++) {
				String file=in.readLine();
				if(!set.containsKey(file)){
					set.put(file,1);
					set1.add(file);
				}else{
					set.replace(file, set.get(file)+1);
				}
			}
			int counter=0;
			for (Iterator iterator = set1.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				for (Iterator iterator2 = set1.iterator(); iterator2.hasNext();) {
					String string2 = (String) iterator2.next();
					if(!string.equals(string2)){
						char hash1=hash(string);
						char hash2=hash(string2);
						if(hash1==hash2){
							
							int actual=1;
							actual*=set.get(string);
							actual*=set.get(string2);
							counter+=actual;
						}
					}
				}
			}
			counter/=2;
			out.write(set.size()+" "+counter+"\n");
			line=in.readLine();
		}
		out.close();
		in.close();

	}
	
	static char hash (String file){
		char hash=(char)0;
		for (int i = 0; i < file.length(); i++) {
			hash^=file.charAt(i);
		}
		return hash;
	}

}
