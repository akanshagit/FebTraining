package com.currency.exchange.Controller;

import com.currency.exchange.Model.Audit;
//import com.currency.exchange.Model.Rate;
import com.currency.exchange.Service.RateService;
import com.currency.exchange.Service.excelImplementation;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Controller
public class RateController {

    String arr[] = {"AED", "CAD", "EUR", "INR", "JPY"};

    @Autowired
    private RateService rateService;

    @Autowired
    private excelImplementation excelImplementation;

    @GetMapping("/fetchAllExchangeRates")
    public void fetchAllExchangeRates(@RequestParam Optional<String> date) {
        for (int i = 0; i < arr.length; i++) {
            if(date.isPresent()){
           rateService.getRates(date.get(),arr[i],i);
        }else{
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            rateService.getRates(simpleDateFormat.format(new Date()),arr[i],i);
        }

        }
    }
    @GetMapping("/excel")
    public void generateExcelReport(HttpServletResponse response) throws Exception{

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
//        String headerValue = "attachment;filename=./rates.xls";

        String headerValue = "attachment;filename=C://Users//akansha.k//Desktop//exchange-temp - Copy";
        response.setHeader(headerKey, headerValue);

        excelImplementation.generateExcel(response);

        response.flushBuffer();
    }

}



