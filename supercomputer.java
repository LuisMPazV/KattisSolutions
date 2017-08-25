import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class supercomputer {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer skt=new StringTokenizer(in.readLine());
		
		int n=Integer.parseInt(skt.nextToken());
		int[] N=new int[n];
		SegmentTree tree=new SegmentTree(N);
		int querys=Integer.parseInt(skt.nextToken());
		for (int i = 0; i < querys; i++) {
			String[] query=in.readLine().split(" ");
			
			if(query[0].equals("F")){
				tree.update_point(Integer.parseInt(query[1])-1);
			}else{
				out.write(tree.querySum(Integer.parseInt(query[1])-1,Integer.parseInt(query[2])-1)+"\n");
			}
		}
		
		out.close();
		in.close();
		

	}

	static class SegmentTree { // the segment tree is stored like a heap array
		private int[] st, A;
		private int n;

		// same as binary heap operations
		private int left(int p) {
			return p << 1;
		}

		private int right(int p) {
			return (p << 1) + 1;
		}

		private void build(int p, int L, int R) {
			if (L == R) // as L == R, either one is fine
				st[p] = A[L];
			else { // recursively compute the values
				build(left(p), L, (L + R) / 2);
				build(right(p), (L + R) / 2 + 1, R);
				int p1 = st[left(p)], p2 = st[right(p)];
				st[p] = p1+p2;
			}
		}

		
		
		private int querySum(int p, int L, int R, int i, int j){
			if (i > R || j < L)
				return 0;
			if (L >= i && R <= j)
				return st[p];
			return querySum(left(p), L, (L + R) / 2, i, j)+ querySum(right(p), (L + R) / 2 + 1, R, i, j);
			
			
			
		}
		private int rmq(int p, int L, int R, int i, int j) { // O(log n)
			if (i > R || j < L)
				return -1; // current segment outside query range
			if (L >= i && R <= j)
				return st[p]; // inside query range

			// compute the min position in the left and right part of the
			// interval
			int p1 = rmq(left(p), L, (L + R) / 2, i, j);
			int p2 = rmq(right(p), (L + R) / 2 + 1, R, i, j);

			if (p1 == -1)
				return p2; // if we try to access segment outside query
			if (p2 == -1)
				return p1; // same as above
			return (A[p1] <= A[p2]) ? p1 : p2;
		} // as as in build routine

		private int update_point(int p, int L, int R, int idx) {
			// this update code is still preliminary, i == j
			// must be able to update range in the future!
			int i = idx, j = idx;

			// if the current interval does not intersect
			// the update interval, return this st node value!
			if (i > R || j < L)
				return st[p];

			// if the current interval is included in the update range,
			// update that st[node]
			if (L == i && R == j) {
				if(A[i]==0){
					A[i]=1;
				}else{
					A[i]=0;
				}
				 // update the underlying array
				return st[p] = A[i]; // this index
			}

			// compute the minimum position in the
			// left and right part of the interval
			int p1, p2;
			p1 = update_point(left(p), L, (L + R) / 2, idx);
			p2 = update_point(right(p), (L + R) / 2 + 1, R, idx);

			// return the position where the overall minimum is
			return st[p] = p1+p2;
		}

		public SegmentTree(int[] _A) {
			A = _A;
			n = A.length; // copy content for local usage
			st = new int[4 * n];
			for (int i = 0; i < 4 * n; i++)
				st[i] = 0; // create vector with length `len' and fill it with
							// zeroes
			build(1, 0, n - 1); // recursive build
		}

		public int rmq(int i, int j) {
			return rmq(1, 0, n - 1, i, j);
		} // overloading
		public int querySum(int i, int j) {
			return querySum(1, 0, n - 1, i, j);
		} // overloading

		public int update_point(int idx) {
			return update_point(1, 0, n - 1, idx);
		}
	}

}
