package com.devf.spotifyplayer.ui;

import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.devf.spotifyplayer.R;
import com.devf.spotifyplayer.models.Item;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ken on 11/05/17.
 */

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.TrackViewHolder> {

    private List<Item> items;
    private MediaPlayer mediaPlayer;


    public TracksAdapter(List<Item> items, MediaPlayer mediaPlayer) {
        this.items = items;
        this.mediaPlayer = mediaPlayer;

    }

    @Override
    public TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_track, parent, false);
        TrackViewHolder trackViewHolder = new TrackViewHolder(view);
        return trackViewHolder;
    }

    @Override
    public void onBindViewHolder(TrackViewHolder holder, int position) {
        holder.bindItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class TrackViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_track_name)
        TextView tvTrackName;

        @BindView(R.id.tv_album_name)
        TextView tvAlbumName;

        @BindView(R.id.img_track)
        ImageView imgTrack;

        private View rootView;


        public TrackViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(final Item item) {
            tvTrackName.setText(item.getName());
            tvAlbumName.setText(item.getAlbum().getName());
            if (!item.getAlbum().getImages().isEmpty()) {
                Picasso.with(rootView.getContext())
                        .load(item.getAlbum().getImages().get(0).getUrl())
                        .into(imgTrack);
            } else {
                Log.e("myLog", item.getName() + " No tiene imagen");
            }

            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (item.getPreviewUrl() != null) {
                        play(item.getPreviewUrl());
                    } else {
                        Toast.makeText(view.getContext(), "No es posible reproducir este track",
                                Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }


    }


    public void play(String url) {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }

        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }


        try {

            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
