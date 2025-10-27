package 백주니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 초기 위치

            Queue<Document> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            // 큐에 초기 위치와 중요도를 함께 저장
            for (int j = 0; j < N; j++) {
                queue.add(new Document(j, Integer.parseInt(st.nextToken())));
            }

            int count = 0; // 인쇄 순서

            while (!queue.isEmpty()) {
                // 1. 큐에서 가장 앞에 있는 문서를 꺼낸다.
                Document currentDoc = queue.poll();
                boolean isPrintable = true;

                // 2. 나머지 문서들과 중요도를 비교한다.
                for (Document doc : queue) {
                    if (doc.priority > currentDoc.priority) {
                        isPrintable = false;
                        break;
                    }
                }

                // 3. 중요도가 더 높은 문서가 있다면, 큐의 가장 뒤로 보낸다.
                if (!isPrintable) {
                    queue.add(currentDoc);
                } else {
                    // 4. 현재 문서가 가장 중요하다면 인쇄한다.
                    count++;
                    // 5. 인쇄한 문서가 내가 찾던 문서인지 확인한다.
                    if (currentDoc.index == M) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
	} // main
	
	static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    } // Document
}