package by.natashkinsasha.springtemplateannotation.service;

import by.natashkinsasha.springtemplateannotation.entity.User;
import by.natashkinsasha.springtemplateannotation.entity.Waybill;
import by.natashkinsasha.springtemplateannotation.entity.WaybillStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MockWaybillService implements WaybillService {
    private Map<Long, Waybill> waybills;
    private Long userID =0L;
    private Long waybillID =0L;




    @Override
    public List<Waybill> getAll() {
        return new ArrayList<Waybill>(waybills.values());
    }

    @Override
    public Waybill getByID(long id) {
        return waybills.get(id);
    }

    @Override
    public Waybill save(Waybill waybill) {
        waybills.put(++waybillID,waybill);
        return waybill;
    }

    @Override
    public void remove(long id) {
        waybills.remove(id);
    }
}
