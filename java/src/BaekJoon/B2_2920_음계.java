import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2_2920음계 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[9];
		boolean asc = false;
		boolean des = false;
		
		for (int i=1; i<9; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (arr[1] == 1) {			
			for (int i=1; i<9; i++) {
				if (arr[i] != i) {
					asc = false;
					break;
				}
				else asc = true;
			}
		}
		
		if (arr[1] == 8) {			
			for (int i=1; i<9; i++) {
				if (arr[i] != 9-i) {
					des = false;
					break;
				}
				else des = true;
			}
		}
		
		if (asc == true) System.out.println("ascending");
		else if (des == true) System.out.println("descending");
		else System.out.println("mixed");
	}

}