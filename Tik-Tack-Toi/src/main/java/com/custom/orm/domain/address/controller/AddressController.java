package com.custom.orm.domain.address.controller;

import com.custom.orm.domain.address.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    /** demo API using custom ORM **/

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<?> findAll()throws Exception{

        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }
}
