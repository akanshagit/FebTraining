package com.exchange.money_exchange.Controller;


import com.exchange.money_exchange.Service.DataFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
public class FetchData {

    @Autowired
    private DataFetchService dataFetchService;

    @GetMapping("/fetchrate")
    public void FetchApiData(@RequestParam Optional<String> date) {
        if(date.isPresent()){
            dataFetchService.getApiData(date.get());
        }else{
            String pat = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pat);
            dataFetchService.getApiData(simpleDateFormat.format(new Date()));
        }

    }
}
