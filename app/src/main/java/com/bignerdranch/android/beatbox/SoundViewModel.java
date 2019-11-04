package com.bignerdranch.android.beatbox;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private BeatBox mBeatBox;

    public SoundViewModel(BeatBox beatBox){
        mBeatBox = beatBox;
    }

    //注解可绑定的属性;
    @Bindable
    public Sound getmSound() {
        return mSound;
    }

    public String getTitle(){
        return mSound.getmName();
    }

    public void setmSound(Sound mSound) {
        this.mSound = mSound;
        notifyChange();             //绑定类会再次运行绑定表达式更新视图;
    }
}
