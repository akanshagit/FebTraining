package com.exchange.money_exchange.Service;

import com.exchange.money_exchange.Entity.Audit;
import com.exchange.money_exchange.Entity.RatesData;
import com.exchange.money_exchange.ExcelWrite.CSVUpdation;
import com.exchange.money_exchange.Repository.AuditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@Service
public class DataFetchService {
    @Autowired
    private AuditRepo repo;
    String currency_choice[]= {"AED","CAD","EUR","INR","JPY"};
    public void getApiData(String date) {
        FutureTask<RatesData>[] tasks = new FutureTask[6];
        Audit[] infos=new Audit[6];
        try {

            for(int i = 0; i< currency_choice.length; i++) {
                String st="https://api.apilayer.com/exchangerates_data/"+date+"?symbols=USD&base="+ currency_choice[i];

                Callable<RatesData> clble = new DataFetchApi(st);
                tasks[i] = new FutureTask<RatesData>(clble);

                Audit info=new Audit();
                info.setRequest(st);
                info.setCreate_ts(new Timestamp(new Date().getTime()));
                info.setStatus("SENT_THE_REQ");
                infos[i]=repo.save(info);

                Thread th = new Thread(tasks[i]);
                th.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int j = 0; j < currency_choice.length; j++)
        {

            try {
                Audit info=infos[j];
                info.setReponse(tasks[j].get().toString());
                info.setUpdate_ts(tasks[j].get().getTimestamp());
                info.setStatus("RECEIVED_RESPONSE");
                new CSVUpdation(tasks[j].get());
                repo.save(info);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
