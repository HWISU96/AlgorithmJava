package 백주니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class FizzBuzz {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int target = 0;
		
		for(int i=3; i>=1; i--) {
			
			try {
				int num = Integer.parseInt(br.readLine());
					target = num + i;
			}
			catch (NumberFormatException e){
				continue;
			}
		}
		
		if (target % 3 == 0 && target % 5 == 0) {
			System.out.println("FizzBuzz");
		}
		else if (target % 3 == 0 && target % 5 != 0) {
			System.out.println("Fizz");
		}
		else if (target % 3 != 0 && target % 5 == 0) {
			System.out.println("Buzz");
		}
		else {
			System.out.println(target);
		}
		
	} // main
}