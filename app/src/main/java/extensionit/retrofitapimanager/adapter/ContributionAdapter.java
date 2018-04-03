package extensionit.retrofitapimanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import extensionit.retrofitapimanager.R;
import extensionit.retrofitapimanager.model.Contributor;

/**
 * Created by rifatullah on 3/22/18.
 */

public class ContributionAdapter extends RecyclerView.Adapter<ContributionAdapter.ContributionViewHolder> {

    List<Contributor> contributorList;
    Context context;

    public ContributionAdapter(Context context,List<Contributor> contributorList) {
        this.context = context;
        this.contributorList = contributorList;
    }

    @Override
    public ContributionAdapter.ContributionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contributor_row, null);
        return new ContributionAdapter.ContributionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContributionAdapter.ContributionViewHolder viewHolder, final int position) {



            Contributor contributor = contributorList.get(position);
            viewHolder.textViewUserName.setText(contributor.getLogin());
            viewHolder.textViewContributions.setText(String.format("Total contributions: %d",contributor.getContributions()));


        Picasso.get()
                .load(contributor.getAvatar_url())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .resizeDimen(R.dimen.contribution_item_icon_width, R.dimen.contribution_item_icon_height)
                .centerInside()
                .into(viewHolder.imageViewUser);


    }

    @Override
    public int getItemCount() {
        return contributorList.size();
    }

    public class ContributionViewHolder extends RecyclerView.ViewHolder {


        TextView textViewUserName;
        TextView textViewContributions;
        ImageView imageViewUser;

        public ContributionViewHolder(View itemView) {
            super(itemView);
            textViewUserName = itemView.findViewById(R.id.textViewUserName);
            textViewContributions = itemView.findViewById(R.id.textViewUserContribution);
            imageViewUser = itemView.findViewById(R.id.imageViewUser);

        }
    }

}
