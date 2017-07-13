import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class coast {

	public static void main(String[] args) throws IOException{
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] medidas=in.readLine().split(" ");
		int n=Integer.parseInt(medidas[0]);
		int m=Integer.parseInt(medidas[1]);
		char[][] matrix=new char[n][m];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i]=in.readLine().toCharArray();
		}
		int coastLength=0;
		boolean[][] coast=new boolean[n][m];
		for (int i = 0; i < coast.length; i++) {
			if(!coast[i][0]){
				if(matrix[i][0]=='0'){
					coast=dfs(i, 0, matrix, coast);
				}
			}
			if(!coast[i][coast[0].length-1]){
				if(matrix[i][coast[0].length-1]=='0'){
					coast=dfs(i, coast[0].length-1, matrix, coast);
				}
			}
		}
		for (int i = 0; i < coast[0].length; i++) {
			if(!coast[0][i]){
				if(matrix[0][i]=='0'){
					coast=dfs(0, i, matrix, coast);
				}
			}
			if(!coast[coast.length-1][i]){
				if(matrix[coast.length-1][i]=='0'){
					coast=dfs(coast.length-1, i, matrix, coast);
				}
			}
		}
		for (int i = 0; i < coast.length; i++) {
			for (int j = 0; j < coast[0].length; j++) {
				if(!coast[i][j]){
					matrix[i][j]='1';
				}
			}
		}
		
		
		
		for (int i = 0; i < matrix.length; i++) {
			boolean inicio=false;
			for (int j = 0; j < matrix[0].length; j++) {
				if(i==0&&i+1==matrix.length){
					if(matrix[i][j]=='1'){
						if(!inicio){
							inicio=true;
							coastLength+=3;
						}else{
							coastLength+=2;
						}
					}else{
						if(inicio){
							coastLength+=1;
							inicio=false;
						}
					}
				}
				else if(i==0){
					if(matrix[i][j]=='1'){
						if(!inicio){
							inicio=true;
							coastLength+=2;
						}else{
							coastLength+=1;
						}
						if(i+1<matrix.length){
							if(matrix[i+1][j]=='0'){
								coastLength+=1;
							}
						}
					}else{
						if(inicio){
							coastLength+=1;
							inicio=false;
						}
					}
				}else if(i+1==matrix.length){
					if(matrix[i][j]=='1'){
						if(!inicio){
							inicio=true;
							coastLength+=2;
						}else{
							coastLength+=1;
						}
						if(i-1<matrix.length){
							if(matrix[i-1][j]=='0'){
								coastLength+=1;
							}
						}
					}else{
						if(inicio){
							coastLength+=1;
							inicio=false;
						}
					}
				}else{
					if(matrix[i][j]=='1'){
						if(!inicio){
							inicio=true;
							coastLength+=1;
						}
						if(i+1<matrix.length){
							if(matrix[i+1][j]=='0'){
								coastLength+=1;
							}
						}
						if(i-1<matrix.length){
							if(matrix[i-1][j]=='0'){
								coastLength+=1;
							}
						}
					}else{
						if(inicio){
							coastLength+=1;
							inicio=false;
						}
					}
				}
			}
			if(inicio){
				coastLength+=1;
			}
		}
		out.write(coastLength+"\n");
		out.close();
		in.close();
	}

	static boolean[][] dfs(int i, int j, char[][] matriz, boolean[][] visitados){
		if(i>=0&&i<matriz.length&&j>=0&&j<matriz[0].length&&matriz[i][j]=='0'&&!visitados[i][j]){
			visitados[i][j]=true;
			visitados=dfs(i+1, j, matriz, visitados);
			visitados=dfs(i-1, j, matriz, visitados);
			visitados=dfs(i, j+1, matriz, visitados);
			visitados=dfs(i, j-1, matriz, visitados);
			return visitados;
		}else{
			return visitados;
		}
		
	}
}
