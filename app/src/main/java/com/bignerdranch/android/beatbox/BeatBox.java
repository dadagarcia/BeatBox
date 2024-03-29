package com.bignerdranch.android.beatbox;


import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final String TAG = "BeatBox";

    private static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context){
        mAssets = context.getAssets();
        loadSounds();
    }

    private void loadSounds(){
        String[] soundName;

        try{
            soundName = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG,"Found " + soundName.length + " sounds");
        }catch (IOException ioe){
            Log.e(TAG,"Could not list assets",ioe);
            return;
        }

        for(String filename : soundName){
            String assetPath = SOUNDS_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

    public List<Sound> getmSounds(){
        return mSounds;
    }
}
