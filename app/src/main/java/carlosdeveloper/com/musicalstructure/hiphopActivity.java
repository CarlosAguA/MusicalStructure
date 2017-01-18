package carlosdeveloper.com.musicalstructure;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import static carlosdeveloper.com.musicalstructure.R.id.tv_hip_pos1;
import static carlosdeveloper.com.musicalstructure.R.id.tv_hip_pos10;
import static carlosdeveloper.com.musicalstructure.R.id.tv_hip_pos2;
import static carlosdeveloper.com.musicalstructure.R.id.tv_hip_pos3;
import static carlosdeveloper.com.musicalstructure.R.id.tv_hip_pos4;
import static carlosdeveloper.com.musicalstructure.R.id.tv_hip_pos5;
import static carlosdeveloper.com.musicalstructure.R.id.tv_hip_pos6;
import static carlosdeveloper.com.musicalstructure.R.id.tv_hip_pos7;
import static carlosdeveloper.com.musicalstructure.R.id.tv_hip_pos8;
import static carlosdeveloper.com.musicalstructure.R.id.tv_hip_pos9;

public class hiphopActivity extends AppCompatActivity {

    int count = 10 ; //Number of TextViews within the category
    TextView[] hiphopSongArray = new TextView[count];
    String [] idTvHip ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiphop);

        assignID();

    }

    /*
    This method casts the id to a set of TextViews from the activity_hiphop.xml with a loop
    Then the same method assigns an onClickListener for the casted textViews with a loop
    When a textView is clicked, the index will be identified and pass its text to nowPlaying activity
    through an intent.
    @extra key value pair : "songData" , text
     */
    private void assignID() {

        idTvHip = new String[]{"tv_hip_pos1", "tv_hip_pos2", "tv_hip_pos3", "tv_hip_pos4", "tv_hip_pos5",
                "tv_hip_pos6", "tv_hip_pos7", "tv_hip_pos8", "tv_hip_pos9", "tv_hip_pos10"};
        int temp;

        for (int i = 0;i< idTvHip.length ; i++ ){
            //(sourceString, resource, package)
            temp = getResources().getIdentifier(idTvHip[i], "id", getPackageName());
            hiphopSongArray[i] = (TextView)findViewById(temp) ;
        }

        for ( int j = 0 ; j < hiphopSongArray.length ; j++ ) {
            final int index = j;
            hiphopSongArray[j].setOnClickListener(new TextView.OnClickListener() {
               @Override
               public void onClick(View view) {

                   Intent intent = new Intent(hiphopActivity.this, nowPlaying.class);
                   intent.putExtra("songData", hiphopSongArray[index].getText().toString());
                   intent.putExtra("imId", 5 );
                   startActivity(intent);

               }
           });
        }

    }

    }



