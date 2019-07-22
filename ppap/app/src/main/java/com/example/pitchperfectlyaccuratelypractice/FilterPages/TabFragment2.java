package com.example.pitchperfectlyaccuratelypractice.FilterPages;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.ToggleButton;

import com.example.pitchperfectlyaccuratelypractice.R;
import com.example.pitchperfectlyaccuratelypractice.bitmap.IntervalsBitmap;
import com.example.pitchperfectlyaccuratelypractice.bitmap.NotesBitmap;
import com.example.pitchperfectlyaccuratelypractice.music.Interval;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment2 extends Fragment{

    private static final String TAG="TabFragment2";
    private FilterActivity filter;
    public View view;

    Interval[] generated_interval;

    private IntervalsBitmap tmpData;

    TableLayout notesTableView1;
    TableLayout notesTableView2;

    LayoutInflater layoutInflater;

    public TabFragment2(FilterActivity filter) {
        this.filter = filter;
        tmpData = IntervalsBitmap.getAllTrueIntervalsBitmap();
        generated_interval = tmpData.toInterval();
        // Required empty public constructor
    }

    public TabFragment2(FilterActivity filter, IntervalsBitmap intervalsBitmap) {
        this.filter = filter;
        this.tmpData = intervalsBitmap;
        tmpData = IntervalsBitmap.getAllTrueIntervalsBitmap();
        generated_interval = tmpData.toInterval();
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_tab_fragment2, container, false);
        view = layout;
        notesTableView1 = view.findViewById(R.id.tableLayout1);
        notesTableView2 = view.findViewById(R.id.tableLayout2);
        Log.d(TAG, "onCreateView: ");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        view.findViewById(R.id.backButton).setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                filter.returnToMainActivity(tmpData);
//            }
//        });
        setButtonListener();
        layoutInflater = LayoutInflater.from(getContext());
        create_interval_table();
//        restoreButtonState(tmpData);
    }

//    private void restoreButtonState(IntervalsBitmap tmpData){
//        int index = 11;
//        for(int row = 0; row < notesTableView1.getChildCount(); row++) {
//            TableRow tableRow = (TableRow)notesTableView1.getChildAt(row);
//            for(int col = 0; col < tableRow.getChildCount(); col++){
//                ToggleButton toggleButton = (ToggleButton) tableRow.getChildAt(col);
//                if()
//            }
//        }
//    }

    private void setButtonListener(){
        Button selectButton = view.findViewById(R.id.select_all);
        Button cancelButton = view.findViewById(R.id.cancel_all);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int row = 0; row < notesTableView1.getChildCount(); row++) {
                    TableRow tableRow = (TableRow)notesTableView1.getChildAt(row);
                    for(int col = 0; col < tableRow.getChildCount(); col++){
                        ToggleButton toggleButton = (ToggleButton) tableRow.getChildAt(col);
                        if(!toggleButton.isChecked()){
                            toggleButton.setChecked(true);
                        }
                    }
                }
                for(int row = 0; row < notesTableView2.getChildCount(); row++) {
                    TableRow tableRow = (TableRow)notesTableView2.getChildAt(row);
                    for(int col = 0; col < tableRow.getChildCount(); col++){
                        ToggleButton toggleButton = (ToggleButton) tableRow.getChildAt(col);
                        if(!toggleButton.isChecked()){
                            toggleButton.setChecked(true);
                        }
                    }
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int row = 0; row < notesTableView1.getChildCount(); row++) {
                    TableRow tableRow = (TableRow)notesTableView1.getChildAt(row);
                    for(int col = 0; col < tableRow.getChildCount(); col++){
                        ToggleButton toggleButton = (ToggleButton) tableRow.getChildAt(col);
                        if(toggleButton.isChecked()){
                            toggleButton.setChecked(false);
                        }
                    }
                }

                for(int row = 0; row < notesTableView2.getChildCount(); row++) {
                    TableRow tableRow = (TableRow)notesTableView2.getChildAt(row);
                    for(int col = 0; col < tableRow.getChildCount(); col++){
                        ToggleButton toggleButton = (ToggleButton) tableRow.getChildAt(col);
                        if(toggleButton.isChecked()){
                            toggleButton.setChecked(false);
                        }
                    }
                }
            }
        });
    }

    public void create_interval_table(){

        // generate buttons
        int negative_index = 11;
        int positive_index = 13;

        for (int i = 0; i < 7; i++) {
            int buttonNum = 2;
            if (i == 2 || i == 6){
                buttonNum = 1;
            }
            TableRow row1 = (TableRow) layoutInflater.inflate(R.layout.note_table_row, null, false);
            TableRow row2 = (TableRow) layoutInflater.inflate(R.layout.note_table_row, null, false);
            for (int j = 0; j < buttonNum; j++) {
                ToggleButton note_button1 = (ToggleButton) layoutInflater.inflate(R.layout.note_button, null, false);
                ToggleButton note_button2 = (ToggleButton) layoutInflater.inflate(R.layout.note_button, null, false);
                Interval left_interval = generated_interval[negative_index];
                Log.d(TAG, "create_interval_table: " + left_interval.getTextWithoutSign());
                Interval right_interval = generated_interval[positive_index];
                note_button1 = updateButton(note_button1, left_interval);
                note_button2 = updateButton(note_button2, right_interval);
                row1.addView(note_button1);
                row2.addView(note_button2);
                negative_index--;
                positive_index++;
            }
            if(i == 6){
                ToggleButton note_button = (ToggleButton) layoutInflater.inflate(R.layout.note_button, null, false);
                Interval interval = generated_interval[12];
                note_button = updateButton(note_button, interval);
                row1.addView(note_button);
            }
            notesTableView1.addView(row1);
            notesTableView2.addView(row2);
        }

    }


    /**
     * update note button so that it has the note text as button text
     * and listener when toggle is toggled
     * @param button
     * @param interval
     * @return
     */
    ToggleButton updateButton(ToggleButton button, final Interval interval) {
        String interval_text = interval.getTextWithoutSign();
        button.setText(interval_text);
        button.setTextOff(interval_text);
        button.setTextOn(interval_text);
        button.setChecked(false);
        Log.v(TAG, "updateButton: " + interval_text);
        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                tmpData.toggleNote(interval);

                generated_interval = tmpData.toInterval();
                filter.filterPageOption.setIntervalsBitmap(Interval.IntervalsToInts(generated_interval));
            }
        });
        return button;
    }
}
