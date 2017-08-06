import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;



public class brexit {

	public static void main(String[] args)	throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] entrada=in.readLine().trim().split(" ");
		
		Node[] nodes=new Node[Integer.parseInt(entrada[0])];
		
		for (int i = 0; i < nodes.length; i++) {
			nodes[i]=new Node(i+1);
		}
		
		int numberOfPairs=Integer.parseInt(entrada[1]);
		
		for (int i = 0; i < numberOfPairs; i++) {
			String[] pair=in.readLine().trim().split(" ");
			int a=Integer.parseInt(pair[0])-1;
			int b=Integer.parseInt(pair[1])-1;
			nodes[a].adyacent.add(nodes[b]);
			nodes[b].adyacent.add(nodes[a]);
			
		}
		
		LinkedList<Node> cola=new LinkedList<>();
		int origen=Integer.parseInt(entrada[3])-1;
		int fin=Integer.parseInt(entrada[2])-1;
		nodes[origen].out=true;
		nodes[origen].visitado=true;
		for (int i = 0; i < nodes[origen].adyacent.size(); i++) {
			cola.add(nodes[origen].adyacent.get(i));
		}
		
		boolean salio=false;
		while(!cola.isEmpty()&&!salio){
			Node actual=cola.remove();
			if(!actual.out&&!actual.visitado){
				double salieron=0;
				ArrayList<Node> posibles=new ArrayList<>();
				for (int i = 0; i < actual.adyacent.size(); i++) {
					if(actual.adyacent.get(i).out){
						salieron++;
					}else{
						posibles.add(actual.adyacent.get(i));
					}
					
					if(!actual.adyacent.get(i).visitado)
						cola.add(actual.adyacent.get(i));
				}
				double sal=(actual.adyacent.size()/2d);
				if(salieron>=sal){
					actual.out=true;
					if(actual.index-1==fin){
						salio=true;
					}
					for (int i = 0; i < posibles.size(); i++) {
						
							posibles.get(i).visitado=false;
							cola.add(posibles.get(i));
						
					}
				}
			}else{
				if(nodes[fin].out){
					salio=true;
				}
			}
			actual.visitado=true;
		}
		
		if(salio||nodes[fin].out){
			out.write("leave");
		}else{
			out.write("stay");
		}
		out.close();

	}
	static class Node implements Comparable<Node>{
		boolean out;
		boolean visitado;
		ArrayList<Node> adyacent;
		int index;
		public Node(int num){
			index=num;
			out=false;
			visitado=false;
			adyacent=new ArrayList<>();
		}
		public String toString(){
			return index+" "+out+"";
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return adyacent.size()-o.adyacent.size();
		}
	}

}
