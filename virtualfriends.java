import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class virtualfriends {

	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int numberOfCases=Integer.parseInt(in.readLine());
        for (int i = 0; i < numberOfCases; i++) {
			int numeroDeAmistades=Integer.parseInt(in.readLine());
			UnionFind union=new UnionFind(2*numeroDeAmistades);
			int indexActual=0;
			TreeMap<String, Integer> map=new TreeMap<>();
			for (int j = 0; j < numeroDeAmistades; j++) {
				String[] entrada=in.readLine().split(" ");
				if(map.get(entrada[0])==null&&map.get(entrada[1])==null) {
					int uno=indexActual;
					indexActual++;
					int dos=indexActual;
					indexActual++;
					map.put(entrada[0], uno);
					map.put(entrada[1], dos);
					union.unionSet(uno, dos);
					out.write(union.sizeOfSet(uno)+"\n");
				}else if(map.get(entrada[0])==null) {
					int uno=indexActual;
					indexActual++;
					int dos=map.get(entrada[1]);
					map.put(entrada[0], uno);
					union.unionSet(uno, dos);
					out.write(union.sizeOfSet(uno)+"\n");
				}else if(map.get(entrada[1])==null){
					int uno=map.get(entrada[0]);
					int dos=indexActual;
					indexActual++;
					map.put(entrada[1], dos);
					union.unionSet(uno, dos);
					out.write(union.sizeOfSet(uno)+"\n");
				}else {
					int uno=map.get(entrada[0]);
					int dos=map.get(entrada[1]);
					union.unionSet(uno, dos);
					out.write(union.sizeOfSet(uno)+"\n");
				}
			}
		}
        out.close();
        in.close();
		
		
		
		
	}
	
	
	
	
	
	static class UnionFind {                                              // OOP style
		  private Vector<Integer> p, rank, setSize;
		  private int numSets;

		  public UnionFind(int N) {
		    p = new Vector<Integer>(N);
		    rank = new Vector<Integer>(N);
		    setSize = new Vector<Integer>(N);
		    numSets = N;
		    for (int i = 0; i < N; i++) {
		      p.add(i);
		      rank.add(0);
		      setSize.add(1);
		    }
		  }

		  public int findSet(int i) { 
		    if (p.get(i) == i) return i;
		    else {
		      int ret = findSet(p.get(i)); p.set(i, ret);
		      return ret; } }

		  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

		  public void unionSet(int i, int j) { 
		    if (!isSameSet(i, j)) { numSets--; 
		    int x = findSet(i), y = findSet(j);
		    // rank is used to keep the tree short
		    if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
		    else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
		                                     if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }
		  public int numDisjointSets() { return numSets; }
		  public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
		}

}
