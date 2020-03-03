public class offByN implements CharacterComparator{
    int n;
    public offByN(int N){
        n = N;
    }
    public boolean equalChars(char a,char b){
        return a - b == n || a - b == -n;
    }
}
