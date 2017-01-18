package carlosdeveloper.com.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class houseActivity extends AppCompatActivity {

    int count = 10 ; //Number of TextViews within the category
    TextView[] houseSongArray = new TextView[count];
    String [] idTvHouse ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        assignID();
    }

    /*
    This method casts the id to a set of TextViews from the activity_house.xml with a loop
    Then the same method assigns an onClickListener for the casted textViews with a loop
    When a textView is clicked, the index will be identified and pass its text to nowPlaying activity
    through an intent.
    @extra key value pair : "songData" , text
     */
    private void assignID() {

        idTvHouse = new String[]{"tv_house_pos1", "tv_house_pos2", "tv_house_pos3", "tv_house_pos4", "tv_house_pos5",
                "tv_house_pos6", "tv_house_pos7", "tv_house_pos8", "tv_house_pos9", "tv_house_pos10"};
        int temp;

        for (int i = 0;i< idTvHouse.length ; i++ ){
            //(sourceString, resource, package)
            temp = getResources().getIdentifier(idTvHouse[i], "id", getPackageName());
            houseSongArray[i] = (TextView)findViewById(temp) ;
        }

        for ( int j = 0 ; j <  houseSongArray.length ; j++ ) {
            final int index = j;
            houseSongArray[j].setOnClickListener(new TextView.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(houseActivity.this, nowPlaying.class);
                    intent.putExtra("songData", houseSongArray[index].getText().toString());
                    intent.putExtra("imId", 4 );
                    startActivity(intent);

                }
            });
        }

    }
}

