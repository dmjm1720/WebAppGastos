package mx.dao;

import java.util.List;
import mx.model.xml;

public interface xmlDao {

    public void newViaje(xml paramViaje);

    public List<xml> selectviaje(String paramusu, String paramnom);

    public void updatexml(String uuid, String param1, int estatu, String param3, String param4);

}
