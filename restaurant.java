import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class restaurant {

    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N=Integer.parseInt(in.readLine());
        
        while(N!=0){
            int Y=0;
            int cantidadDePlatosPila1=0;
            int cantidadDePlatosPila2=0;
            boolean primerosArriba=false;
            int cantidadAMover=0;
            for (int i = 0; i < N; i++) {
                String[] entrada=in.readLine().split(" ");
                if(i==N-1){
                    Y=Integer.parseInt(in.readLine());
                    if(Y==0){
                    	if(entrada[0].equals("DROP")){
                            out.write("DROP 2 "+Integer.parseInt(entrada[1])+"");
                            cantidadDePlatosPila2+=Integer.parseInt(entrada[1]);
                            cantidadAMover+=Integer.parseInt(entrada[1]); 
                    }else{
                        if(!primerosArriba){
                            out.write("MOVE 2->1 "+cantidadAMover+"\n");
                            cantidadDePlatosPila2-=cantidadAMover;
                            cantidadDePlatosPila1+=cantidadAMover;
                            cantidadAMover=0;
                            primerosArriba=!primerosArriba;
                            out.write("TAKE 1 "+Integer.parseInt(entrada[1])+"");
                            cantidadDePlatosPila1-=Integer.parseInt(entrada[1]);
                        }else{
                        	int cantidadATomar=Integer.parseInt(entrada[1]);
                        	if(cantidadATomar>cantidadDePlatosPila1) {
                        		out.write("TAKE 1 "+cantidadDePlatosPila1+"\n");
                        		cantidadATomar-=cantidadDePlatosPila1;
                        		cantidadDePlatosPila1=0;
                        		out.write("MOVE 2->1 "+cantidadAMover+"\n");
                                cantidadDePlatosPila2-=cantidadAMover;
                                cantidadDePlatosPila1+=cantidadAMover;
                                cantidadAMover=0;
                                out.write("TAKE 1 "+cantidadATomar+"");
                                cantidadDePlatosPila1-=cantidadATomar;
                                if(cantidadDePlatosPila1==0) {
                        			primerosArriba=false;
                        		}
                        	}else {
                        		out.write("TAKE 1 "+cantidadATomar+"");
                        		cantidadDePlatosPila1-=cantidadATomar;
                        		if(cantidadDePlatosPila1==0) {
                        			primerosArriba=false;
                        		}
                        		
                        	}
                        }
                    }
                        
                    }else{
                    	if(entrada[0].equals("DROP")){
                            out.write("DROP 2 "+Integer.parseInt(entrada[1])+"\n");
                            cantidadDePlatosPila2+=Integer.parseInt(entrada[1]);
                            cantidadAMover+=Integer.parseInt(entrada[1]); 
                    }else{
                        if(!primerosArriba){
                            out.write("MOVE 2->1 "+cantidadAMover+"\n");
                            cantidadDePlatosPila2-=cantidadAMover;
                            cantidadDePlatosPila1+=cantidadAMover;
                            cantidadAMover=0;
                            primerosArriba=!primerosArriba;
                            out.write("TAKE 1 "+Integer.parseInt(entrada[1])+"\n");
                            cantidadDePlatosPila1-=Integer.parseInt(entrada[1]);
                        }else{
                        	int cantidadATomar=Integer.parseInt(entrada[1]);
                        	if(cantidadATomar>cantidadDePlatosPila1) {
                        		out.write("TAKE 1 "+cantidadDePlatosPila1+"\n");
                        		cantidadATomar-=cantidadDePlatosPila1;
                        		cantidadDePlatosPila1=0;
                        		out.write("MOVE 2->1 "+cantidadAMover+"\n");
                                cantidadDePlatosPila2-=cantidadAMover;
                                cantidadDePlatosPila1+=cantidadAMover;
                                cantidadAMover=0;
                                out.write("TAKE 1 "+cantidadATomar+"\n");
                                cantidadDePlatosPila1-=cantidadATomar;
                                if(cantidadDePlatosPila1==0) {
                        			primerosArriba=false;
                        		}
                        	}else {
                        		out.write("TAKE 1 "+cantidadATomar+"\n");
                        		cantidadDePlatosPila1-=cantidadATomar;
                        		if(cantidadDePlatosPila1==0) {
                        			primerosArriba=false;
                        		}
                        		
                        	}
                        }
                    }
                    }

                }else{
                    if(entrada[0].equals("DROP")){
                            out.write("DROP 2 "+Integer.parseInt(entrada[1])+"\n");
                            cantidadDePlatosPila2+=Integer.parseInt(entrada[1]);
                            cantidadAMover+=Integer.parseInt(entrada[1]); 
                    }else{
                        if(!primerosArriba){
                            out.write("MOVE 2->1 "+cantidadAMover+"\n");
                            cantidadDePlatosPila2-=cantidadAMover;
                            cantidadDePlatosPila1+=cantidadAMover;
                            cantidadAMover=0;
                            out.write("TAKE 1 "+Integer.parseInt(entrada[1])+"\n");
                            cantidadDePlatosPila1-=Integer.parseInt(entrada[1]);
                            if(cantidadDePlatosPila1>0) {
                            	primerosArriba=!primerosArriba;
                            }
                        }else{
                        	int cantidadATomar=Integer.parseInt(entrada[1]);
                        	if(cantidadATomar>cantidadDePlatosPila1) {
                        		out.write("TAKE 1 "+cantidadDePlatosPila1+"\n");
                        		cantidadATomar-=cantidadDePlatosPila1;
                        		cantidadDePlatosPila1=0;
                        		out.write("MOVE 2->1 "+cantidadAMover+"\n");
                                cantidadDePlatosPila2-=cantidadAMover;
                                cantidadDePlatosPila1+=cantidadAMover;
                                cantidadAMover=0;
                                out.write("TAKE 1 "+cantidadATomar+"\n");
                                cantidadDePlatosPila1-=cantidadATomar;
                                if(cantidadDePlatosPila1==0) {
                        			primerosArriba=false;
                        		}
                        	}else {
                        		out.write("TAKE 1 "+cantidadATomar+"\n");
                        		cantidadDePlatosPila1-=cantidadATomar;
                        		if(cantidadDePlatosPila1==0) {
                        			primerosArriba=false;
                        		}
                        		
                        	}
                        }
                    }
                    
                }
            }
            N=Y;
            if(N!=0){
                out.write("\n");
            }
        }
        
        out.close();
        in.close();
        

    }
}