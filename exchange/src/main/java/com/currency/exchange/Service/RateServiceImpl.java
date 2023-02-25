package com.currency.exchange.Service;


import com.currency.exchange.Model.Audit;
import com.currency.exchange.Model.ExcelDto;
//import com.currency.exchange.Model.Rate;
import com.currency.exchange.Repository.AuditRepo;
//import com.currency.exchange.writer.Csvfilewriter;
import com.currency.exchange.Repository.ExcelDtoRepo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import jakarta.transaction.Transactional;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
@Service
@Slf4j
@Transactional
public class RateServiceImpl implements RateService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ExcelDtoRepo excelDtoRepo;

    @Autowired
    private AuditRepo auditRepo;
    private static final String apikey = "ILfxmWLoFifzwpuQSopkRyuuUMlg9q49";

    String arr[] = {"AED", "CAD", "EUR", "INR", "JPY"};

    Audit[] infos = new Audit[6];




    @Override
    public void getRates(String date, String str, int i) {
        ExcelDto[] excelDtos = new ExcelDto[6];


        String url = "https://api.apilayer.com/exchangerates_data/" + date + "?symbols=USD&base=" + str;



        Audit info = new Audit();
        info.setRequest(url);
        info.setCreate_ts(new Timestamp(new Date().getTime()));
        info.setStatus("SENT_THE_REQ");
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("apikey", apikey);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class);
//            log.info("Output :{}", response.getBody());
            info.setResponse(response.getBody());
            ExcelDto excelDto = new ExcelDto();
            excelDto.setConversionCurrency("USD");
            excelDto.setBaseCurrency(arr[i]);
            JSONObject jsonObj = new JSONObject(response.getBody());
            Double rates = jsonObj.getJSONObject("rates").getDouble("USD");
            excelDto.setRate(rates);
            excelDto.setCreateTs(new Timestamp(new Date().getTime()));
//            excelDto.setCreateTs(new LocalDateTime(new Date()));
            excelDtos[i] = excelDtoRepo.save(excelDto);
            FetchApi(url,i);

        } catch (Exception e) {
            log.error("something went wrong", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "exception while catching endpoint",
                    e);

        }
        infos[i] = auditRepo.save(info);
    }

    @Override
    public void FetchApi(String url,int i) throws IOException {
        for (int j = 0; j < arr.length; j++)
        {
            try {
                Audit info=infos[j];
                info.setStatus("RECEIVED_RESPONSE");
                auditRepo.save(info);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
    

