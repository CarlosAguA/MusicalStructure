package carlosdeveloper.com.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

   TextView latinTopTen, indieTopTen, popTopTen, houseTopTen , hipTopTen ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife.bind(this);
        latinTopTen = (TextView) findViewById(R.id.tv_latin) ;
        indieTopTen = (TextView) findViewById(R.id.tv_rock_indie) ;
        popTopTen =  (TextView) findViewById(R.id.tv_pop) ;
        houseTopTen = (TextView) findViewById(R.id.tv_deep_house) ;
        hipTopTen = (TextView) findViewById(R.id.tv_hiphop) ;


       latinTopTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent latinTopIntent = new Intent(MainActivity.this, latinActivity.class);

                // Start the new activity
                startActivity(latinTopIntent);

            }
        });



        indieTopTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link indieActivity}
                Intent indieTopIntent = new Intent(MainActivity.this, indieActivity.class);
                // Start the new activity
                startActivity(indieTopIntent);

            }
        });

        popTopTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link popActivity}
                Intent popTopIntent = new Intent(MainActivity.this, popActivity.class);
                // Start the new activity
                startActivity(popTopIntent);
            }
        });


        hipTopTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link hiphopActivity}
                Intent hiphopTopIntent = new Intent(MainActivity.this, hiphopActivity.class);
                // Start the new activity
                startActivity(hiphopTopIntent);

            }
        });

        houseTopTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link houseActivity}
                Intent houseIntent = new Intent(MainActivity.this, houseActivity.class);
                // Start the new activity
                startActivity(houseIntent);

            }
        });

    }
}
