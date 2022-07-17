package com.Language.ApplicationRelease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.Language.ApplicationRelease.ColorsActivity;
import com.Language.ApplicationRelease.FamilyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmainmainmain);

        // Find the View that shows the numbers category
        LinearLayout numbers = (LinearLayout) findViewById(R.id.numbers);

        // Set a click listener on that View
        numbers.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, com.Language.ApplicationRelease.NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });


        //open's Family Members Activity
        // Find the View that shows the numbers category
        LinearLayout familyMembers = (LinearLayout) findViewById(R.id.family);
        // Set a click listener on that View
        familyMembers.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View v) {
                Intent familyMembersIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(familyMembersIntent);
            }
        });

        //open's colors list Activity
        // Find the View that shows the numbers category
        LinearLayout colours = (LinearLayout) findViewById(R.id.colors);
        // Set a click listener on that View
        colours.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View v) {
                Intent coloursIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(coloursIntent);
            }
        });

        //open's phrases list Activity
        // Find the View that shows the numbers category
        LinearLayout phrases = (LinearLayout) findViewById(R.id.phrases);
        // Set a click listener on that View
        phrases.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View v) {
                Intent phrasesIntent = new Intent(MainActivity.this, com.Language.ApplicationRelease.PhraseActivity.class);
                startActivity(phrasesIntent);
            }
        });

    }



}