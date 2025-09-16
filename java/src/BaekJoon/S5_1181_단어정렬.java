package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int n=0; n<N; n++) {
            list.add(br.readLine());
        } // for

        Collections.sort(list);
        int len = 1;
        while (list2.size() < N) {
            for (int i=0; i<list.size(); i++) {
                if (list.get(i).length() == len) {
                    list2.add(list.get(i));
                }
            }
            len++;
        } // while

        List<String> list3 = list2.stream().distinct().collect(Collectors.toList());

        for (int i=0; i<list3.size(); i++) {
            System.out.println(list3.get(i));
        }
    }
}