package by.natashkinsasha.springtemplateannotation.service;


import by.natashkinsasha.springtemplateannotation.entity.Waybill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaybillServiceImpl implements WaybillService {
    @Autowired
    @Qualifier("hibernateWaybillRepository")
    JpaRepository<Waybill, Long> repository;

    @Override
    public List<Waybill> getAll() {
        List<Waybill> all = repository.findAll();
        return all;
    }

    @Override
    public Waybill getByID(long id) {
        return repository.findOne(id);
    }

    @Override
    public Waybill save(Waybill waybill) {
        return repository.save(waybill);
    }

    @Override
    public void remove(long id) {
        repository.delete(id);
    }
}
