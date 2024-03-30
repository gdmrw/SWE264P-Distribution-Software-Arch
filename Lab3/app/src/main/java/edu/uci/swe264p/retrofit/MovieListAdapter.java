package edu.uci.swe264p.retrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private final List<Movie> mData;

    MovieListAdapter(List<Movie> data) {
        this.mData = data;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImage;
        TextView mTitle;
        TextView mReleaseDate;

        TextView mVote;

        TextView mOverview;

        ViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.ivMovie);
            mTitle = itemView.findViewById(R.id.tvTitle);
            mReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
            mVote = itemView.findViewById(R.id.tvVote);
            mOverview =itemView.findViewById(R.id.tvOverview);
        }
    }


    @NonNull
    @Override
    public MovieListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_row, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.ViewHolder viewHolder, int position) {

        Movie movie = mData.get(position);
        String posterPath = movie.getPosterPath();
        Picasso.get().load("https://image.tmdb.org/t/p/w500" + posterPath).into(viewHolder.mImage);

        viewHolder.mTitle.setText(movie.getTitle());
        viewHolder.mReleaseDate.setText(movie.getReleaseDate());
        viewHolder.mVote.setText(String.format(movie.getVoteAverage().toString()));
        viewHolder.mOverview.setText(movie.getOverview());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
