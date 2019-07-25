package com.example.pitchperfectlyaccuratelypractice.modeSettingsTabFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pitchperfectlyaccuratelypractice.R;
import com.example.pitchperfectlyaccuratelypractice.activities.PerModeSettingActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongModeMiscSettingTab extends GeneralMiscSettingTab {


    public SongModeMiscSettingTab(PerModeSettingActivity perModeSettingActivity) {
        super(perModeSettingActivity);
        resource = R.layout.tabfragment_song_practice_mode_misc_settings;
    }



}
