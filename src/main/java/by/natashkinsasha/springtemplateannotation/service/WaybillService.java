package by.natashkinsasha.springtemplateannotation.service;


import by.natashkinsasha.springtemplateannotation.entity.Waybill;

import java.util.List;

public interface WaybillService {
    List<Waybill> getAll();
    Waybill getByID(long id);
    Waybill save(Waybill waybill);
    void remove(long id);
}
