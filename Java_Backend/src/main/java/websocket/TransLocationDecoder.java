package websocket;

import com.google.gson.Gson;
import dto.TransLocationDTO;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Teun
 */
public class TransLocationDecoder implements Decoder.Text<TransLocationDTO> {

    private final Gson gson = new Gson();

    @Override
    public TransLocationDTO decode(String s) throws DecodeException {
        return gson.fromJson(s, TransLocationDTO.class);
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }
}
