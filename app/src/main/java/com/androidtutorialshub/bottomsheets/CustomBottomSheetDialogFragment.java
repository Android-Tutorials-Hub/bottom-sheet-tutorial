package com.androidtutorialshub.bottomsheets;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomBottomSheetDialogFragment extends BottomSheetDialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_dialog_bottom_sheet, container, false);
        return v;
    }


}
