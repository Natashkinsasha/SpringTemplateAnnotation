package by.natashkinsasha.springtemplateannotation.controller;


import by.natashkinsasha.springtemplateannotation.entity.User;
import by.natashkinsasha.springtemplateannotation.entity.Waybill;
import by.natashkinsasha.springtemplateannotation.service.UserService;
import by.natashkinsasha.springtemplateannotation.service.WaybillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class WaybillController {


    @Autowired
    @Qualifier("waybillServiceImpl")
    WaybillService waybillService;
    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    @RequestMapping(value = "/waybillers", method = RequestMethod.GET)
    @ResponseBody
    public List<Waybill> getAllWaybillers() {
        return waybillService.getAll();
    }

    @RequestMapping(value = "/waybillers/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Waybill getWaybill(@PathVariable("id") long WaybillID) {
        return waybillService.getByID(WaybillID);
    }

    @RequestMapping(value = "/waybillers", method = RequestMethod.POST)
    @ResponseBody
    public Waybill saveWaybill(@RequestBody Waybill Waybill) {
        return waybillService.save(Waybill);
    }

    @RequestMapping(value = "/waybillers/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        waybillService.remove(id);
    }

    @RequestMapping(value = "/waybillers_test", method = RequestMethod.GET)
    @ResponseBody
    public void test(){
        Waybill firstWaybill = new Waybill();
        firstWaybill.setResponsiblePerson(userService.getByID(1));
        firstWaybill.setCheckedBy(userService.getByID(2));
        waybillService.save(firstWaybill);
    }



}
