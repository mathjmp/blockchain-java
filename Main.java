public class Main {
    
    public static void main(String[] args) {
        
        
        final Block a = new Block("ABC", null, System.currentTimeMillis());
        final Block b = new Block("DEF", a.getHash(), System.currentTimeMillis());


        System.out.println("B1 HASH: "+ a.getHash());
        System.out.println("B2 HASH: "+ b.getHash());
    }
}
