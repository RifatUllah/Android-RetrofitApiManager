package extensionit.retrofitapimanager.interfaces;

import java.util.List;

import extensionit.retrofitapimanager.model.Contributor;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rifatullah on 3/22/18.
 */

public interface ApiService {

    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(
            @Path("owner") String owner,
            @Path("repo") String repo);
}
