package com.devf.spotifyplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.devf.spotifyplayer.data.ServiceGenerator;
import com.devf.spotifyplayer.data.SpotifyApi;
import com.devf.spotifyplayer.models.Item;
import com.devf.spotifyplayer.models.TrackObject;
import com.devf.spotifyplayer.models.Tracks;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @BindView(R.id.input_track)
    EditText inputTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn_search)
    public void onClick() {
        String query = inputTrack.getText().toString();
        searchTracks(query);
    }


    public void searchTracks(String query) {
        SpotifyApi spotifyApi = ServiceGenerator.createService();

        spotifyApi.searchTracks(query, "track").enqueue(new Callback<TrackObject>() {
            @Override
            public void onResponse(Call<TrackObject> call, Response<TrackObject> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        TrackObject trackObject = response.body();
                        Tracks tracks = trackObject.getTracks();
                        if (tracks.getItems().size() > 0) {
                            Item item = tracks.getItems().get(0);
                            play(item.getPreviewUrl());
                            Log.e("myLog", trackObject.toString());
                        } else {
                            Toast.makeText(MainActivity.this, "NO ENCONTRE CANCIONES", Toast.LENGTH_SHORT).show();
                        }


                    }
                }
            }

            @Override
            public void onFailure(Call<TrackObject> call, Throwable t) {

            }
        });
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
