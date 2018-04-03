package extensionit.retrofitapimanager.interfaces;

import retrofit2.Response;

/**
 * Created by rifatullah on 3/22/18.
 */

public interface OnResponse<T> {

    void onSuccess(Response<T> response);
    void onFailure(Response<T> response);
}

