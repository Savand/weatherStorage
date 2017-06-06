package mteo.savand.abstractdao;

import java.io.IOException;
import java.util.List;

public interface GenericDao<T> {

    void store(T object) throws IOException;

    List<T> read();


}
