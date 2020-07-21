package cn.supfox.redis;

import com.servyou.japter.Japter;
import org.springframework.data.redis.serializer.SerializationException;

import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class JsonSerializer implements Serializer {

    public static final Charset UTF8     = StandardCharsets.UTF_8;

    private Charset charset  = UTF8;

    private Type type;

    public JsonSerializer(Type type) {
        this.type = type;
    }

    @Override
    public byte[] serialize(Object t) {
        if (t == null) {
            return new byte[0];
        }

        try {
            String text = Japter.fromObject(t);
            return text.getBytes(charset);
        } catch (Exception ex) {
            throw new SerializationException("Could not write JSON: " + ex.getMessage(), ex);
        }

    }

    @Override
    public Object deserialize(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return Japter.toObject(new String(bytes, charset), type);
    }

}
