package extensionit.retrofitapimanager.activity;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import extensionit.retrofitapimanager.R;
import extensionit.retrofitapimanager.adapter.ContributionAdapter;
import extensionit.retrofitapimanager.api.ApiClient;
import extensionit.retrofitapimanager.api.ApiManager;
import extensionit.retrofitapimanager.interfaces.ApiService;
import extensionit.retrofitapimanager.interfaces.OnResponse;
import extensionit.retrofitapimanager.model.Contributor;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView = findViewById(R.id.recycleView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(manager);
        final int gridMargin = getResources().getDimensionPixelOffset(R.dimen.recycleView_padding);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                       RecyclerView.State state) {
                outRect.set(gridMargin, gridMargin, gridMargin, gridMargin);
            }
        });



        Call<List<Contributor>> call = ApiClient.getClient().create(ApiService.class).contributors("square","retrofit");

        ApiManager.requestToServer(this, call, "Fetching data", new OnResponse() {
            @Override
            public void onSuccess(Response response) {

                System.out.println("response "+response.body());
                List<Contributor> contributorList = (List<Contributor>) response.body();
                if(contributorList.size() > 0){

                    ContributionAdapter adapter = new ContributionAdapter(MainActivity.this,contributorList);
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Response response) {

                progressBar.setVisibility(View.GONE);
                // Do something
            }
        });
    }
}
