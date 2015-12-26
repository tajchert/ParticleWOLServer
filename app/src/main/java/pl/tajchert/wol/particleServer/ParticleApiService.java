package pl.tajchert.wol.particleServer;

import com.squareup.okhttp.RequestBody;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Michał Tajchert on 26.12.2015.
 */
public interface ParticleApiService {

    @POST("devices/{device_id}/wakeHost")//TODO
    Call<ParticleResponse> wakeOnLanHost(@Path("device_id") String device_id, @Query("access_token") String access_token, @Body RequestBody hostAddressIpAndMac);
}
