package websocket;

import com.google.gson.Gson;
import dto.TransLocationDTO;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Teun
 */
public class TransLocationEncoder implements Encoder.Text<TransLocationDTO> {

    private final Gson gson = new Gson();

    @Override
    public String encode(TransLocationDTO object) throws EncodeException {
        return gson.toJson(gson);
    }

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }
}