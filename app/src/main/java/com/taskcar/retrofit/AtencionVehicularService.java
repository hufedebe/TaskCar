package com.taskcar.retrofit;

import com.taskcar.model.VehiculoPost;
import com.taskcar.retrofit.Response.TalleresResponse;
import com.taskcar.retrofit.Response.VehiculoResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Hudeya on 12/09/2017.
 */

public interface AtencionVehicularService {
    @GET("listarTalleres")
    Call<TalleresResponse> getTalleres();


    @POST("registrarVehiculo")
    Call<VehiculoResponse> postRegistrarVehiculo( @Body VehiculoPost vehiculoPost);

}
