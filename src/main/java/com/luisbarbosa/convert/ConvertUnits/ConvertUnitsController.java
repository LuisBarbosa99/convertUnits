package com.luisbarbosa.convert.ConvertUnits;

import com.luisbarbosa.convert.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/units")
public class ConvertUnitsController {
    private final ConvertUnitsService convertUnitsService;

    @Autowired
    public ConvertUnitsController(ConvertUnitsService convertUnitsService) {
        this.convertUnitsService = convertUnitsService;
    }

    @GetMapping
    public Response convert(@RequestParam String units){
        return convertUnitsService.getConversion(units);
    }
}
