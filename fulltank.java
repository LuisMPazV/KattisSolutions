import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class fulltank {
	public static final int MAX_CITY=1000;
	public static final int MAX_GAS=100;
	static int[][] consumoGalonesporNodo;
	static int n;
	static Node[] cityes=new Node[MAX_CITY];
	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] datos=in.readLine().split(" ");
		n=Integer.parseInt(datos[0]);
		int m=Integer.parseInt(datos[1]);
		StringTokenizer skt=new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			cityes[i]=new Node(Integer.parseInt(skt.nextToken()));
		}
		
		for (int i = 0; i < m; i++) {
			datos=in.readLine().split(" ");
			int u=Integer.parseInt(datos[0]);
			int v=Integer.parseInt(datos[1]);
			int d=Integer.parseInt(datos[2]);
			cityes[u].edges.add(new Edge(v, 0, d));
			cityes[v].edges.add(new Edge(u, 0, d));
			
		}
		int numberOfTimes=Integer.parseInt(in.readLine());
		for (int i = 0; i < numberOfTimes; i++) {
			datos=in.readLine().split(" ");
			int capacidad=Integer.parseInt(datos[0]);
			int start=Integer.parseInt(datos[1]);
			int end=Integer.parseInt(datos[2]);
			int price=dijkstra(start, end, capacidad);
			if(price<Integer.MAX_VALUE){
				out.write(price+"\n");
			}else{
				out.write("impossible\n");
			}
		}
		out.close();
		in.close();
		

	}
	
	
	static class Edge implements Comparable<Edge>{
		int id;
		int galones;
		int consumoActual;
		public Edge(int id, int galons, int weight) {
			this.id = id;
			this.galones = galons;
			this.consumoActual = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return consumoActual-o.consumoActual;
		}
		public String toString(){
			return "[ Final= "+id+", galones= "+galones+", weigth= "+consumoActual+"]";
		}
		
	}
	static class Node{
		int numeroNodo;
		int precioGasolina;
		ArrayList<Edge> edges;
		public Node(int pri){
			precioGasolina=pri;
			edges=new ArrayList<>();
		}
		public String toString(){
			return "[ Nodo= "+numeroNodo+", precio= "+precioGasolina+"]";
		}
	}
	
	static int dijkstra(int start, int end, int capacidad){
		consumoGalonesporNodo=new int[n][capacidad+1];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j <= capacidad; ++j) {
				consumoGalonesporNodo[i][j]=Integer.MAX_VALUE;
			}
		}
		
		PriorityQueue<Edge> queue=new PriorityQueue<>();
		queue.add(new Edge(start, 0, 0));
		consumoGalonesporNodo[start][0]=0;
		while(!queue.isEmpty()){
			Edge actual=queue.poll();
			if(actual.id==end){
				return actual.consumoActual;
			}
			if(!(consumoGalonesporNodo[actual.id][actual.galones]<actual.consumoActual)){
			if(actual.galones<capacidad&&actual.consumoActual+cityes[actual.id].precioGasolina<consumoGalonesporNodo[actual.id][actual.galones+1]){
				consumoGalonesporNodo[actual.id][actual.galones+1]=actual.consumoActual+cityes[actual.id].precioGasolina;
				queue.add(new Edge(actual.id, actual.galones+1, actual.consumoActual+cityes[actual.id].precioGasolina));
			}
			
			ArrayList<Edge> adjacent=cityes[actual.id].edges;
			for (int i = 0; i < adjacent.size(); i++) {
				int siguiente=adjacent.get(i).id;
				int distancia=adjacent.get(i).consumoActual;
				if(actual.galones>=distancia){
					int nuevoConsumo=actual.galones-distancia;
					if(actual.consumoActual<consumoGalonesporNodo[siguiente][nuevoConsumo]){
						consumoGalonesporNodo[siguiente][nuevoConsumo]=actual.consumoActual;
						queue.add(new Edge(siguiente,nuevoConsumo,actual.consumoActual));
					}
				}
			}
			}
		}
		return Integer.MAX_VALUE;
		
	}

}
