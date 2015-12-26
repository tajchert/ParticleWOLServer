package pl.tajchert.wol.particleServer;

import android.app.Application;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by mtajc on 26.12.2015.
 */
public class AppParticle extends Application {
    public static Retrofit retrofit;
    public static ParticleApiService particleApiService;
    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.particle.io/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        particleApiService = retrofit.create(ParticleApiService.class);

    }
}
