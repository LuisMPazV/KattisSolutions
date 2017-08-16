import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class backspace {

	public static void main(String[] args) throws IOException{
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		
		char[] array=in.readLine().toCharArray();
		int cuenta=0;
		StringBuilder respuesta=new StringBuilder();
		for (int i = array.length-1; i >=0; i--) {
			if(array[i]=='<'){
				cuenta++;
			}else{
				if(cuenta==0){
					respuesta.append(array[i]);
				}else{
					cuenta--;
				}
			}
		}
		
		System.out.println(respuesta.reverse().toString());

	}

}
