import java.util.ArrayList;
import java.util.Arrays;

public class Leetcode3372 {
   public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
          int[] ans=new int[edges1.length+1];
        if(k==0) {
            Arrays.fill(ans,1);
            return ans;
        }
        ArrayList<Integer>[] adj=new ArrayList[edges1.length+1];
        for(int i=0;i<edges1.length+1;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges1){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
//        System.out.println(adj[2]);
        boolean isVisited[]=new boolean[edges1.length+1];
        for(int i=0;i<edges1.length+1;i++) ans[i]=helper(i,k,adj,isVisited);
//        System.out.println(Arrays.toString(ans));
        adj=new ArrayList[edges2.length+1];
        for(int i=0;i<edges2.length+1;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges2){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        isVisited=new boolean[edges2.length+1];
        int max=0;
        for(int i=0;i<edges2.length+1;i++) max=Math.max(helper(i,k-1,adj,isVisited),max);
        for(int i=0;i<edges1.length+1;i++) ans[i]+=max;
        return ans;

    }
    private static int helper(int i, int k, ArrayList<Integer>[] adj, boolean[] isVisited){
        if(isVisited[i]) return 0;
        if(k==0) return 1;
        isVisited[i]=true;
        int ans=0;
        for(Integer neighbor: adj[i]) ans+=helper(neighbor,k-1,adj,isVisited);
        isVisited[i]=false;
//        System.out.println(ans);
        return ans+1;
    }
  
}
