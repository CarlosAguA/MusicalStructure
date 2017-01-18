package carlosdeveloper.com.musicalstructure;


/* This project uses the aweseome library MusicPlayerView from iammert
   Thanks for sharing this project that you can compile and use for personal projects :
   https://github.com/iammert/MusicPlayerView
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import co.mobiwise.library.MusicPlayerView;


public class nowPlaying extends AppCompatActivity {

    MusicPlayerView mpv ;
    boolean started = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        mpv = (MusicPlayerView) findViewById(R.id.mpv);
        getArtistInfo();
        mpv.start();
        mpv.setVelocity(1);


        /*Set False or True the MusicPlayerView Rotation */
        mpv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (started){
                    started = false;
                    mpv.stop();

                }else{
                    started = true;
                    mpv.start();

                }

            }
        });
    }


    /*
    This method gets the Info sent from any previous Top10 activity with the name of the song and
    artist.
    It also separates the gotten string in two parts and then show them on two different textViews
    @param String "songData" from intent Object
     */
    public void getArtistInfo() {
        /*Cast textViews */
        TextView songData1 = (TextView)findViewById(R.id.now_playing_tv1);
        TextView songData2 = (TextView)findViewById(R.id.now_playing_tv2);
        /* Get data from intent */
        Intent intent = getIntent();
        String songAndArtist = intent.getStringExtra("songData");
        int albumId = intent.getIntExtra("imId",0) ;
        setAlbum(albumId);
        /*Divide String*/
        String[] parts = songAndArtist.split("-");
        String first = parts[0].trim();
        String second = parts[1].trim();
        /* Set Text */
        songData1.setText(first);
        songData2.setText(second);
    }

    /*
    This method sets The Image of the MusicPlayerView widget depending on the Id  integer value
    sent from a previous intent.
    @param albumId  : The albumId from Top10 Activities
     */
    private void setAlbum(int albumId){

        Log.d("ALBUM ID  ",  String.valueOf(albumId)  ) ;

        if (albumId == 1){
            mpv.setCoverDrawable(R.drawable.latin);
        }
        if (albumId == 2){
            mpv.setCoverDrawable(R.drawable.indies);
        }
        if (albumId == 3){
            mpv.setCoverDrawable(R.drawable.pop);
        }
        if (albumId == 4){
            mpv.setCoverDrawable(R.drawable.house);
        }
        if (albumId == 5){
            mpv.setCoverDrawable(R.drawable.hip);
        }

    }
}
