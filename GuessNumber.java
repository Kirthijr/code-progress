/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.
Input: n = 10, pick = 6
Output: 6
*/

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1, mid , end = n;
        while(start>=1 && end <=n && start <= end){
            mid = (end-start)/2 + start;
            if(guess(mid) == 0){
                return mid;
            }else if(guess(start) == 0)
                return start;
            else if(guess(end)== 0)
                return end;
            else if(guess(mid) == -1){
                end = mid-1;
            }else
                start = mid+1;
        }
        return -1;
    }
}
