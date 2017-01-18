package carlosdeveloper.com.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class indieActivity extends AppCompatActivity {

    int count = 10 ; //Number of TextViews within the category
    TextView[] indieSongArray = new TextView[count];
    String [] idTvIndie ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indie);

        assignID();

    }

    /*
   This method casts the id to a set of TextViews from the activity_indie.xml with a loop
   Then the same method assigns an onClickListener for the casted textViews with a loop
   When a textView is clicked, the index will be identified and pass its text to nowPlaying activity
   through an intent.
   @extra key value pair : "songData" , text
    */
    private void assignID() {

        idTvIndie = new String[]{"tv_indie_pos1", "tv_indie_pos2", "tv_indie_pos3", "tv_indie_pos4", "tv_indie_pos5",
                "tv_indie_pos6", "tv_indie_pos7", "tv_indie_pos8", "tv_indie_pos9", "tv_indie_pos10"};
        int temp;

        for (int i = 0;i< idTvIndie.length ; i++ ){
            //(sourceString, resource, package)
            temp = getResources().getIdentifier(idTvIndie[i], "id", getPackageName());
            indieSongArray[i] = (TextView)findViewById(temp) ;
        }

        for ( int j = 0 ; j <  indieSongArray.length ; j++ ) {
            final int index = j;
            indieSongArray[j].setOnClickListener(new TextView.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(indieActivity.this, nowPlaying.class);
                    intent.putExtra("songData", indieSongArray[index].getText().toString());
                    intent.putExtra("imId", 2 );
                    startActivity(intent);

                }
            });
        }

    }
}
