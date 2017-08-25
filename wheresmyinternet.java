import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class wheresmyinternet {
	

	public static void main(String[] args) throws IOException{
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] line=in.readLine().split(" ");
		int n=Integer.parseInt(line[0]);
		int m=Integer.parseInt(line[1]);
		UnionFind union=new UnionFind(n);
		for (int i = 0; i < m; i++) {
			StringTokenizer skt=new StringTokenizer(in.readLine());
			int a=Integer.parseInt(skt.nextToken())-1;
			int b=Integer.parseInt(skt.nextToken())-1;
			union.unionSet(a, b);
		}
		int comp=union.findSet(0);
		boolean alguno=false;
		for (int i = 0; i < n; i++) {
			if(union.findSet(i)!=comp){
				out.write((i+1)+"\n");
				alguno=true;
			}
		}
		if(!alguno){
			out.write("Connected");
		}

		out.close();
	}
	static class UnionFind{
		int[] p,rank;
		public UnionFind(int N){
			p=new int[N];
			rank=new int[N];
			for (int i = 0; i < p.length; i++) {
				p[i]=i;
			}
		}
		public int findSet(int i){
			return (p[i]==i)? i: (p[i]=findSet(p[i]));
		}
		public boolean isSameSet(int i, int j){
			return findSet(i)==findSet(j);
		}
		void unionSet(int i, int j){
			if(!isSameSet(i, j)){
				int x=findSet(i);
				int y=findSet(j);
				if(rank[x]>rank[y])
					p[y]=x;
				else
					p[x]=p[y];
				if(rank[x]==rank[y])
					rank[y]++;
				
			}
		}
	}

}
