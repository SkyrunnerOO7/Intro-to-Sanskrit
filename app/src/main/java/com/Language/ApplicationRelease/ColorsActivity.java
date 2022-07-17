package com.Language.ApplicationRelease;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<com.Language.ApplicationRelease.Word> words = new ArrayList<com.Language.ApplicationRelease.Word>();
        words.add(new com.Language.ApplicationRelease.Word("Red", "रक्त (rakta)", R.drawable.color_red, R.raw.colour_red));
        words.add(new com.Language.ApplicationRelease.Word("Green", "हरित (harita)", R.drawable.color_green, R.raw.colour_green));
        words.add(new com.Language.ApplicationRelease.Word("Brown", "कपिशः (Kapiśaḥ)", R.drawable.color_brown, R.raw.colour_brown));
        words.add(new com.Language.ApplicationRelease.Word("Gray", "धूसर (dhUsara)", R.drawable.color_gray, R.raw.colour_gray));
        words.add(new com.Language.ApplicationRelease.Word("Black", "कृष्ण (kRSNa)", R.drawable.color_black, R.raw.colour_black));
        words.add(new com.Language.ApplicationRelease.Word("White", "श्वेत (śveta)", R.drawable.color_white, R.raw.colour_white));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        com.Language.ApplicationRelease.WordAdapter adapter = new com.Language.ApplicationRelease.WordAdapter(this, words,R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);


        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(NumbersActivity.this, "Your click is registered", Toast.LENGTH_SHORT).show();

                //get the {@link word} object at the given position the user clicked on
                com.Language.ApplicationRelease.Word word = words.get(position);

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceId() );

                // Start the audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}