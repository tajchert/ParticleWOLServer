package pl.tajchert.wol.particleServer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String strRequestBody = "192.168.100.100;00:0a:95:9d:68:16";
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"),strRequestBody);
        Call<ParticleResponse> wakeOnLanHost = AppParticle.particleApiService.wakeOnLanHost("", "", requestBody);
        wakeOnLanHost.enqueue(new Callback<ParticleResponse>() {
            @Override
            public void onResponse(Response<ParticleResponse> response, Retrofit retrofit) {
                Log.d(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }
}
