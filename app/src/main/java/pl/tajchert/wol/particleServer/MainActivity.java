package pl.tajchert.wol.particleServer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getCanonicalName();
    @Bind(R.id.editAddress)
    EditText editAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        editAddress.setText("192.168.2.143;90:2B:34:A3:9F:65");
    }

    @OnClick(R.id.buttonWOL)
    public void pressButtonWOL() {
        if(editAddress != null && editAddress.getText().toString().contains(";")) {
            sendWOL(editAddress.getText().toString());
        }
    }


    public void sendWOL(String address) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.particle.io/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ParticleApiService particleApiService = retrofit.create(ParticleApiService.class);
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), address);
        Call<ParticleResponse> wakeOnLanHost = particleApiService.wakeOnLanHost("", "", requestBody);
        wakeOnLanHost.enqueue(new Callback<ParticleResponse>() {
            @Override
            public void onResponse(Response<ParticleResponse> response, Retrofit retrofit) {
                Log.d(TAG, "onResponse: ");
                Toast.makeText(MainActivity.this, "Response: " + response.code() +", val: " + response.body().returnValue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, "onFailure: ");
                Toast.makeText(MainActivity.this, "Failure: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
