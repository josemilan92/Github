package mx.utng.edu.laeraningpatrones.videoyoutube;


import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import mx.utng.edu.laeraningpatrones.R;

/**
 * Created by a on 22/03/2016.
 */
public class VideoSeisActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String API_KEY="AIzaSyDgglxa8rlJ26-nz4oxrmcldzihVte3Rf4";
    private String ID_VIDEO="9ZaEPeaucIU";
    private YouTubePlayerView youTubePlayerView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.video_youtube);
        youTubePlayerView.initialize(API_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b){
            youTubePlayer.cueVideo(ID_VIDEO);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "onInitializationFailure()", Toast.LENGTH_SHORT).show();
    }
}
