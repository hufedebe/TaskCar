package com.taskcar.retrofit;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hudeya on 12/09/2017.
 */

public class AtencionVehicularAdapter {
    private static AtencionVehicularService API_SERVICE;


    public static AtencionVehicularService getApiService(){
        //Creating the interceptor, and setting the log level
        //HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        //logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        //add logging as last interceptor
       // httpClient.addInterceptor(logging);
        // Creating the interceptor, and setting the log level
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …

// add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!


        String baseUrl = "http://10.0.2.2:8084/AtencionVehicular/";
        //String baseUrl = "http://10.0.2.2:9090/AtencionVehicular/";
        if (API_SERVICE==null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            //.client(httpClient.build())
            Log.d("getTasksListHTTP", "Se añadio bien:"+baseUrl);
            API_SERVICE = retrofit.create(AtencionVehicularService.class);


        }
        return API_SERVICE;

    }

}
