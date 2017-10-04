package com.taskcar.retrofit;

import com.taskcar.model.CitaPost;
import com.taskcar.model.LoginPost;
import com.taskcar.model.RegistroPost;
import com.taskcar.model.VehiculoPost;
import com.taskcar.retrofit.Response.CitaResponse;
import com.taskcar.retrofit.Response.LoginResponse;
import com.taskcar.retrofit.Response.RegistroResponse;
import com.taskcar.retrofit.Response.ServiciosResponse;
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

    @GET("listarServicios")
    Call<ServiciosResponse> getServicios();

    @POST("registrarCita")
    Call<CitaResponse> postRegistrarCita(  @Body CitaPost citaPost);

   @POST("registrarVehiculo")
   Call<VehiculoResponse> postRegistrarVehiculo( @Body VehiculoPost vehiculoPost);

    @POST("registrarPersona")
    Call<RegistroResponse> postRegistrarPersona(@Body RegistroPost registroPost);

    @POST("loginPersona")
    Call<LoginResponse> postLoginPersona(@Body LoginPost loginPost);




}
