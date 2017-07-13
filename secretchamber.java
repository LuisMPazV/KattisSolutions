import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class secretchamber {

	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] info=in.readLine().split(" ");
		int m=Integer.parseInt(info[0]);
		int n=Integer.parseInt(info[1]);
		HashMap<Character, Node> map=new HashMap<>();
		HashSet<String> posibles=new HashSet<>();
		ArrayList<Node> nodes=new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String entrada=in.readLine();
			String[] translation=entrada.split(" ");
			Node primero=map.get(translation[0].charAt(0));
			Node segundo=map.get(translation[1].charAt(0));
			if(primero==null){
				primero=new Node(translation[0].charAt(0));
				map.put(translation[0].charAt(0), primero);
				nodes.add(primero);
			}
			if(segundo==null){
				segundo=new Node(translation[1].charAt(0));
				map.put(translation[1].charAt(0), segundo);
				nodes.add(segundo);
			}
			posibles.add(entrada);
			primero.conexiones.add(segundo);
		}
		
		for (int i = 0; i < n; i++) {
			StringTokenizer skt=new StringTokenizer(in.readLine());
			String primera=skt.nextToken();
			String segunda=skt.nextToken();
			char[] firstWord=primera.toCharArray();
			char[] secondWord=segunda.toCharArray();
			if(primera.equals(segunda)){
				out.write("yes\n");
			}
			else if(firstWord.length==secondWord.length){
				boolean salir=false;
				for (int j = 0; j < secondWord.length&&!salir; j++) {
					if(firstWord[j]==secondWord[j]||posibles.contains(firstWord[j]+" "+secondWord[j])){
						

					}
					else{
					LinkedList<Node> cola=new LinkedList<>();
					for (int k = 0; k < nodes.size(); k++) {
						nodes.get(k).visitado=false;
					}
					
					Node inicio=map.get(firstWord[j]);
					boolean encontrado=false;
					if(inicio==null){
						salir=true;
					}else{
						inicio.visitado=true;
						cola.add(inicio);						
					}
					while(!cola.isEmpty()&&!encontrado&&!salir){
						inicio=cola.remove();
						if(inicio.id==secondWord[j]){
							encontrado=true;
							posibles.add(firstWord[j]+" "+secondWord[j]);
						}else{
							for (int k = 0; k < inicio.conexiones.size(); k++) {
								if(!inicio.conexiones.get(k).visitado){
									cola.add(inicio.conexiones.get(k));
									inicio.conexiones.get(k).visitado=true;
								}
							}
						}
					}
					if(!encontrado){
						salir=true;
					}
				}
				}
				if(!salir){
					out.write("yes\n");
				}else{
					out.write("no\n");
				}
			}else{
				out.write("no\n");
			}
		}
		out.close();

	}
	
	
	static class Node{
		char id;
		boolean visitado;
		ArrayList<Node> conexiones;
		
		public Node(char id){
			conexiones=new ArrayList<>();
			this.id=id;
			visitado=false;
		}
	}

}
