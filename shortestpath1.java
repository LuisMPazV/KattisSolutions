import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class shortestpath1 {

	public static void main(String[] args) throws IOException{
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line=in.readLine().trim();
		while(!line.equals("0 0 0 0")){
			StringTokenizer skt=new StringTokenizer(line);
			int n=Integer.parseInt(skt.nextToken());
			int m=Integer.parseInt(skt.nextToken());
			int q=Integer.parseInt(skt.nextToken());
			int s=Integer.parseInt(skt.nextToken());
			Node[] nodes=new Node[n];
			for (int i = 0; i < nodes.length; i++) {
				nodes[i]=new Node(i);
			}
			for (int i = 0; i < m; i++) {
				String[] edge=in.readLine().trim().split(" ");
				int inicio=Integer.parseInt(edge[0]);
				int fin=Integer.parseInt(edge[1]);
				int peso=Integer.parseInt(edge[2]);
				nodes[inicio].adjacent.add(new Edge(peso, nodes[fin]));
			}
			
			HashSet<Node> visitados=new HashSet<>();
			long[] dist=new long[n];
			for (int i = 0; i < dist.length; i++) {
				dist[i]=Integer.MAX_VALUE;
			}
			PriorityQueue<Edge> cola=new PriorityQueue<>();
			Node inicio=nodes[s];
			dist[s]=0;
			cola.add(new Edge(0, inicio));
			
			while(!cola.isEmpty()&&visitados.size()!=n){
				Edge actual=cola.poll();
				inicio=actual.target;
				if(!inicio.visitado){
					inicio.visitado=true;
					dist[inicio.value]=actual.weight;
					visitados.add(inicio);
					for (int i = 0; i < inicio.adjacent.size(); i++) {
						if(!inicio.adjacent.get(i).target.visitado){
							cola.add(new Edge(actual.weight+inicio.adjacent.get(i).weight,inicio.adjacent.get(i).target ));
						}
					}
				}
				
			}
			for (int i = 0; i < q; i++) {
				int destino=Integer.parseInt(in.readLine());
				if(dist[destino]==Integer.MAX_VALUE){
					out.write("Impossible\n");
				}else
					out.write(dist[destino]+"\n");
			}
			line=in.readLine();
			if(!line.equals("0 0 0 0")){
				out.write("\n");
			}
			
		}
		out.close();
		in.close();
	}
	
	
	static class Node{
	    ArrayList<Edge> adjacent;
	    int value;
	    boolean visitado;
	    public Node(int value){
	    	adjacent=new ArrayList<>();
	    	this.value=value;
	    	visitado=false;
	    }
	    public String toString(){
	    	return "["+value+"]";
	    }
	}
	
	
	static class Edge implements Comparable<Edge>{
	    Node target;
	    int weight;
	    public Edge(int weight,Node target){
	    	this.weight=weight;
	    	this.target=target;
	    }
		@Override
		public int compareTo(Edge o) {
			
			return weight-o.weight;
		}
		public String toString(){
	    	return "["+target+", "+weight+"]";
	    }
	}
}
