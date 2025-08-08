import java.io.UnsupportedEncodingException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
    private String hash;
    private String previousHash;
    private String data;
    private long timestamp;
    private int nonce;

    public Block(String data, String previousHash, long timestamp) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.hash = calculateBlockHash();
    }

    public String calculateBlockHash() {

        String dataToHash = String.format("%s%s%s%s",
        previousHash,
        Long.toString(timestamp),
        Integer.toString(nonce),
        data);

        MessageDigest digest = null;
        byte[] bytes = null;

        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes("UTF-8"));
        }
        catch(NoSuchAlgorithmException | UnsupportedEncodingException exception) {
            
        }

        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }

        return buffer.toString();
    }

    public String getHash() {

        return hash;
    }
}