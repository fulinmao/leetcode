public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word1.length() == 0){
            return word2 == null ? 0 : word2.length();
        }
        
        if(word2 == null || word2.length() == 0){
            return word1 == null ? 0 : word1.length();
        }
        
        int m = word1.length();
        int n = word2.length();
        int[][] distance = new int[m + 1][n + 1];
        distance[0][0] = 0;
        //
        for(int i=1; i <= m ; i++){
            distance[i][0] = i;
        }
        
        for(int i = 1;i <= n;i ++){
            distance[0][i] = i;
        }
        
        
                       
        for(int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                //两个元素值相同
                int temp = 0;
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    temp = distance[i - 1][j-1];
                }else{
                    temp = distance[i - 1][j - 1] + 1;
                }
                
                distance[i][j] = Math.min( Math.min(distance[i-1][j] + 1,distance[i][j-1] + 1) ,temp);
            }
        }
        
        return distance[m][n];
    }
}
