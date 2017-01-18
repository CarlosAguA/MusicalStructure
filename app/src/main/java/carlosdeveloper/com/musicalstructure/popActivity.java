package carlosdeveloper.com.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class popActivity extends AppCompatActivity {

    int count = 10 ; //Number of TextViews within the category
    TextView[] popSongArray = new TextView[count];
    String [] idTvPop ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        assignID();
    }

    /*
   This method casts the id to a set of TextViews from the activity_pop.xml with a loop
   Then the same method assigns an onClickListener for the casted textViews with a loop
   When a textView is clicked, the index will be identified and pass its text to nowPlaying activity
   through an intent.
   @extra key value pair : "songData" , text
    */
    private void assignID() {

        idTvPop = new String[]{"tv_pop_pos1", "tv_pop_pos2", "tv_pop_pos3", "tv_pop_pos4", "tv_pop_pos5",
                "tv_pop_pos6", "tv_pop_pos7", "tv_pop_pos8", "tv_pop_pos9", "tv_pop_pos10"};
        int temp;

        for (int i = 0;i<idTvPop.length ; i++ ){
            //(sourceString, resource, package)
            temp = getResources().getIdentifier(idTvPop[i], "id", getPackageName());
            popSongArray [i] = (TextView)findViewById(temp) ;
        }

        for ( int j = 0 ; j <  popSongArray .length ; j++ ) {
            final int index = j;
            popSongArray [j].setOnClickListener(new TextView.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(popActivity.this, nowPlaying.class);
                    intent.putExtra("songData", popSongArray [index].getText().toString());
                    intent.putExtra("imId", 3 );
                    startActivity(intent);

                }
            });
        }

    }
}
