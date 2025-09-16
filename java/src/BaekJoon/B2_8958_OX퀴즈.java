import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj8958_ox퀴즈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			String str = br.readLine();
			int count = 0;
			int conti = 0;
			
			for (int i=0; i<str.length(); i++) {
				if (str.charAt(i) == 'O') {
					conti += 1;
					count += conti;
				}
				else {
					conti = 0;
				}
			}
			System.out.println(count);
		} // test
		
	}

}