package com.currency.exchange.Service;

//import com.currency.exchange.Model.Rate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface RateService {

     void getRates(String date,String str,int i);
   // void getApi(String date);
     void FetchApi(String st,int i)throws IOException;
}
