import java.io.IOException;

public interface IOService {
    String read() throws IOException;
    void write(String message);

    public int readInt();


}
