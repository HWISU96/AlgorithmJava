import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 웰컴키트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int tCount = 0;
		for (int i=0; i<arr.length; i++) {
			
			// tCount += (int) Math.ceil((double) arr[i]/T) ;
			tCount += (arr[i]-1)/T +1 ;
				
			}
		System.out.println(tCount);
		System.out.print(N/P + " ");
		System.out.print(N%P);
	}
}

