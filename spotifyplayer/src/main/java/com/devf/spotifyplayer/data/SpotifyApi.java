package com.devf.spotifyplayer.data;

import com.devf.spotifyplayer.models.TrackObject;
import com.devf.spotifyplayer.utils.NetworkConstants;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ken on 10/05/17.
 */

public interface SpotifyApi {

    @GET(NetworkConstants.PATH_SEARCH)
    public Call<TrackObject> searchTracks(
            @Query(NetworkConstants.PARAM_QUERY) String query,
            @Query(NetworkConstants.PARAM_TYPE) String type);

}
