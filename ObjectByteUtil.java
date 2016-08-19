import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象与byte[]的相互转化
 * Created by cliffyan on 2016/8/2.
 */
public class ObjectByteUtil {
    /**
     * byte[]转化为对象
     * @param bytes
     * @return
     */
    public static Object byteToObject(byte[] bytes) throws Exception {
        Object obj=null;
        ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
        ObjectInputStream oi = new ObjectInputStream(bi);
        try {
            obj = oi.readObject();
        }finally {
            bi.close();
            oi.close();
        }
        return obj;
    }

    /**
     * 对象转化为byte[]
     * @param obj
     * @return
     */
    public static byte[] objectToByte(Object obj) throws Exception {
        byte[] bytes;
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        try{
            oo.writeObject(obj);
            bytes = bo.toByteArray();

        }finally {
            bo.close();
            oo.close();
        }
        return(bytes);
    }


}
