
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        sb.append("<");

        // 덱에 요소가 하나만 남을 때까지 반복
        while (deque.size() > 1) {
            // K-1번, 맨 앞의 원소를 뽑아서 맨 뒤로 보내기
            for (int i = 0; i < K - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
            // K번째 원소를 뽑아서 결과에 추가
            sb.append(deque.pollFirst()).append(", ");
        }

        // 마지막으로 남은 원소를 결과에 추가
        sb.append(deque.pollFirst()).append(">");

        System.out.println(sb);
    }
}