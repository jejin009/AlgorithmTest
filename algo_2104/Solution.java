package algo_2104;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		int a[] = {2,1,2,2};
		int[][] b = {{1,2},{1,3},{2,4}};
		System.out.println(Arrays.toString(solution(4,a,b)));
		System.out.println("dd");
	}
    public static int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = {1,0};
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer>[] linkedTrain = new ArrayList[n+1];
        for(int i = 0; i <n+1; i++){
            linkedTrain[i]= new ArrayList<Integer>();
        }
        boolean visited[] = new boolean[n+1];
        for(int i = 0; i <n+1; i++){
            linkedTrain[i]= new ArrayList<Integer>();
        }
        for(int i = 0; i < train.length; i++){
            linkedTrain[train[i][0]].add(train[i][1]);
            linkedTrain[train[i][1]].add(train[i][0]);
        }
        
        q.offer(1);
        q.offer(passenger[0]);
        visited[1] = true;
        System.out.println(q.size());
        System.out.println(linkedTrain.length);
        while(!q.isEmpty()){
            int station = q.poll();
            int p = q.poll();
            
            if(answer[1] < p){
                answer[0] = station;
                answer[1] = p;
            }
            
            for(int next : linkedTrain[station]){
                if(!visited[next]){
                    q.offer(next);
                    q.offer(p + passenger[next-1]);
                }    
            }
            
        }
        
        return answer;
    }
}