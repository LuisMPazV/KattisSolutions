import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class flexible {

	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] entrada=in.readLine().split(" ");
		int room=Integer.parseInt(entrada[0]);
		int numberOfPartitions=Integer.parseInt(entrada[1]);
		LinkedList<Integer> espacios=new LinkedList<>();
		LinkedList<Integer> especiales=new LinkedList<>();
		espacios.add(room);
		StringTokenizer skt=new StringTokenizer(in.readLine());
		for (int i = 0; i < numberOfPartitions; i++) {
			int partition=Integer.parseInt(skt.nextToken());
			for (Iterator iterator = espacios.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				especiales.add(Math.abs(integer.intValue()-partition));
			}
			espacios.add(partition);
		}
		espacios.addAll(especiales);
		HashSet<Integer> agregados=new HashSet<>();
		Collections.sort(espacios);
		StringBuilder respuesta=new StringBuilder();
		for (Iterator iterator = espacios.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if(!agregados.contains(integer)){
				agregados.add(integer);
				respuesta.append(integer+" ");
			}
		}
		out.write(respuesta.toString().trim());

		out.close();
		in.close();
	}

}
