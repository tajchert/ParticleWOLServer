package pl.tajchert.wol.particleServer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Michał Tajchert on 26.12.2015.
 */
public class ParticleResponse {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("last_app")
    @Expose
    public String lastApp;
    @SerializedName("connected")
    @Expose
    public Boolean connected;
    @SerializedName("return_value")
    @Expose
    public Long returnValue;

}
