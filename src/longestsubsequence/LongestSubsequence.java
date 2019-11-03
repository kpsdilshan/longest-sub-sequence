
package longestsubsequence;

/**
 *
 * @author kpsdiilshan
 */
public class LongestSubsequence {

    public  int max(int a,int b){ return (a>b)?a:b;}
    
    public int longestSub(int list[],int n){
        int table[][]= new int[n][2];
        
        for(int i=0;i<n;i++){
            table[i][0]=1;
            table[i][1]=1;
        }
        
        int result=1;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                //If list[i] is greater than last element in subsequence
                //then check with table[j][1]
                if(list[j]<list[i] && table[i][0]<table[j][1]+1){
                    table[i][0]=table[j][1]+1;
                    //if list[j]>list[i] then last element in subsequence
                    //then check with table[j][0]
                    if(list[j] > list[i] && table[i][1] < table[j][0]+1){
                        table[i][1]=table[j][0]+1;
                    }
                    
                }
            }
            //pick maximum of both vlues at index i
            if(result < max(table[i][0],table[i][1])){
                result=max(table[i][0],table[i][1]);
            }
            System.out.println(result);
        }
        return result;
    }
    public static void main(String[] args) {
        LongestSubsequence ls = new LongestSubsequence();
        
        int list[]={3,7,4,9,2,5,4};
        int length=list.length;
        
        System.out.println(ls.longestSub(list, length));
    }
    
}
