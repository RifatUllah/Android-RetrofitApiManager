package extensionit.retrofitapimanager.api;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import extensionit.retrofitapimanager.interfaces.OnResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rifatullah on 3/22/18.
 */

public class ApiManager {

    private static final String TAG = ApiManager.class.getName();


    public static <T> void requestToServer(final Activity activity, Call<T> call, String progressMessage, final OnResponse serverResponse) {

//        final ProgressDialog dialog = new ProgressDialog(activity);
//        dialog.setMessage(progressMessage);
//        dialog.show();
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {

//                if (dialog.isShowing()) {
//                    dialog.dismiss();
//                }

                if (response.isSuccessful()) {
                    serverResponse.onSuccess(response);

                } else {

                    serverResponse.onFailure(response);
                }

            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
//                if (dialog.isShowing()) {
//                    dialog.dismiss();
//                }
                Toast.makeText(activity.getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
