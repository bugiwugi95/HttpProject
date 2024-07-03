package lesson.java;

import lesson.java.data_source.ReceiverApiDataSource;
import lesson.java.domain.ReceiveService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

//https://receviers.api.ecohub.eco/inRadius
public class Main {
    public static void main(String[] args)  {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://receviers.api.ecohub.eco/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ReceiverApiDataSource receiverApiDataSource = retrofit.create(ReceiverApiDataSource.class);
        ReceiveService service = new ReceiveService(receiverApiDataSource);
        try {
            service.fetch(0,0,10000);
        } catch (IOException e) {
            e.getStackTrace();
        }

    }




}

