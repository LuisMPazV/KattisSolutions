import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class addingwords {

	public static void main(String[] args) throws IOException{
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Integer> map=new HashMap<>();
		HashMap<Integer, String> map2=new HashMap<>();
		String line=in.readLine();
		while(line!=null){
			String[] array=line.split(" ");
			if(array[0].equals("def")){
				if(map.get(array[1])==null){
				map2.put(Integer.parseInt(array[2]), array[1]);
				map.put(array[1], Integer.parseInt(array[2]));
				}
				else{
					map2.remove(map.get(array[1]));
					map.replace(array[1], Integer.parseInt(array[2]));
					map2.put(Integer.parseInt(array[2]), array[1]);
				}
			}else if(array[0].equals("calc")){
				boolean unknown=false;
				int resultado=0;
				if(map.get(array[1])!=null)
					resultado=map.get(array[1]);
				else
					unknown=true;
				int num=2;
				while(!array[num].equals("=")&&!unknown){
					if(array[num].equals("+")){
						num++;
						if(map.get(array[num])!=null){
							resultado+=map.get(array[num]).intValue();
						}else{
							unknown=true;
						}
					}else{
						num++;
						if(map.get(array[num])!=null){
							resultado-=map.get(array[num]).intValue();
						}else{
							unknown=true;
						}
					}
					num++;
				}
				if(map2.get(resultado)!=null&&!unknown){
					out.write(line.substring(5).trim()+" "+map2.get(resultado)+"\n");
				}else{
					out.write(line.substring(5).trim()+" unknown\n");
				}
			}
			else{
				map=new HashMap<>();
				map2=new HashMap<>();
			}
			line=in.readLine();
		}
		
		out.close();
		in.close();

	}

}
