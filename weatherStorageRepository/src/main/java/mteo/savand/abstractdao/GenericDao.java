package mteo.savand.abstractdao;

import java.io.IOException;
import java.util.List;

public interface GenericDao<T> {

    /**
     * Store single instance
     * 
     * @param object
     * @throws IOException
     */
    void store(T object) throws IOException;

    /**
     * Retrieve all data from the storage
     * 
     * @return
     */
    List<T> read();


}
