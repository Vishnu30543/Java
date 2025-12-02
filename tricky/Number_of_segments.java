public class Number_of_segments {
    public static void main(String[] args) {
        String s = "   , , , , abcd aa ";
        System.out.println("Total segments : "+find(s));
    }
    static int find(String s){
        s = s.trim();
        if(s.length() == 0) return 0;
        String a[] = s.split("\\s+");
        return a.length;
    }
}
