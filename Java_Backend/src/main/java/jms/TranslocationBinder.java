package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.TransLocationDTO;
import net.reini.rabbitmq.cdi.DecodeException;
import net.reini.rabbitmq.cdi.Decoder;
import net.reini.rabbitmq.cdi.EventBinder;

import javax.enterprise.context.Dependent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Dependent
public class TranslocationBinder extends EventBinder {
    private final String queName = "rekeningrijden.police.translocation";
    private static final Logger LOGGER = Logger.getLogger(TransLocationDTO.class.getName());


    @Override
    protected void bindEvents() {
        bind(TransLocationDTO.class)
                .toExchange(queName);
        bind(TransLocationDTO.class)
                .toQueue(this.queName)
                .withDecoder(new Decoder<TransLocationDTO>() {
            @Override
            public TransLocationDTO decode(byte[] bytes) throws DecodeException {
                String data = new String(bytes);
                ObjectMapper mapper = new ObjectMapper();

                try {
                    return mapper.readValue(data, TransLocationDTO.class);
                } catch (IOException e) {

                    LOGGER.log(Level.FINE, "ERROR while performing messagequeququques method; {0}", e.getMessage());
                }

                return null;
            }

            @Override
            public boolean willDecode(String s) {
                return s.equals("text/plain");
            }
        }).autoAck();
    }
}