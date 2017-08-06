import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class battle {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] array=in.readLine().toCharArray();
		StringBuilder respuesta=new StringBuilder();
		if(array.length<3){
			for (int i = 0; i < array.length; i++) {
				if(array[i]=='R'){
					respuesta.append("S");
				}else if(array[i]=='B'){
					respuesta.append("K");
				}else{
					respuesta.append("H");
				}
			}
		}else{
			for (int i = 0; i < array.length; i++) {
				if(i==array.length-3){
					if(array[i]!=array[i+1]&&array[i+2]!=array[i+1]&&array[i]!=array[i+2]){
						respuesta.append("C");
						i+=2;
					}else{
						if(array[i]=='R'){
							respuesta.append("S");
						}else if(array[i]=='B'){
							respuesta.append("K");
						}else{
							respuesta.append("H");
						}
						if(array[i+1]=='R'){
							respuesta.append("S");
						}else if(array[i+1]=='B'){
							respuesta.append("K");
						}else{
							respuesta.append("H");
						}
						if(array[i+2]=='R'){
							respuesta.append("S");
						}else if(array[i+2]=='B'){
							respuesta.append("K");
						}else{
							respuesta.append("H");
						}
					}	
					
					i+=3;
				}else if(i==array.length-2){
					if(array[i]=='R'){
						respuesta.append("S");
					}else if(array[i]=='B'){
						respuesta.append("K");
					}else{
						respuesta.append("H");
					}
					if(array[i+1]=='R'){
						respuesta.append("S");
					}else if(array[i+1]=='B'){
						respuesta.append("K");
					}else{
						respuesta.append("H");
					}
					i+=3;
				}else if(i==array.length-1){
					if(array[i]=='R'){
						respuesta.append("S");
					}else if(array[i]=='B'){
						respuesta.append("K");
					}else{
						respuesta.append("H");
					}
					i+=3;
				}
				else{
					if(array[i]!=array[i+1]&&array[i+2]!=array[i+1]&&array[i]!=array[i+2]){
						respuesta.append("C");
						i+=2;
					}else{
						if(array[i]=='R'){
							respuesta.append("S");
						}else if(array[i]=='B'){
							respuesta.append("K");
						}else{
							respuesta.append("H");
						}
					}	
				}
				
				
				
			}
		}
		out.write(respuesta.toString());
		out.close();
		in.close();
	
	}

}
