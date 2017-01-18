package carlosdeveloper.com.musicalstructure;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class latinActivity extends AppCompatActivity {

    int count = 10 ; //Number of TextViews within the category
    TextView[] latinSongArray = new TextView[count];
    String [] idTvLatin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latin);

        assignID();

    }

    /*
   This method casts the id to a set of TextViews from the activity_latin.xml with a loop
   Then the same method assigns an onClickListener for the casted textViews with a loop
   When a textView is clicked, the index will be identified and pass its text to nowPlaying activity
   through an intent.
   @extra key value pair : "songData" , text
    */
    private void assignID() {

        idTvLatin = new String[]{"tv_latin_pos1", "tv_latin_pos2", "tv_latin_pos3", "tv_latin_pos4", "tv_latin_pos5",
                "tv_latin_pos6", "tv_latin_pos7", "tv_latin_pos8", "tv_latin_pos9", "tv_latin_pos10"};
        int temp;

        for (int i = 0;i< idTvLatin.length ; i++ ){
            //(sourceString, resource, package)
            temp = getResources().getIdentifier(idTvLatin[i], "id", getPackageName());
            latinSongArray[i] = (TextView)findViewById(temp) ;
        }

        for ( int j = 0 ; j < latinSongArray.length ; j++ ) {
            final int index = j;
            latinSongArray[j].setOnClickListener(new TextView.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(latinActivity.this, nowPlaying.class);
                    intent.putExtra("songData", latinSongArray[index].getText().toString());
                    intent.putExtra("imId", 1 );
                    startActivity(intent);

                }
            });
        }

    }

    }



