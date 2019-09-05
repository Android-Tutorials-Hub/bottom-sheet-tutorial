package com.androidtutorialshub.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.content_dialog_bottom_sheet.*
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.content.DialogInterface



class CustomBottomSheetDialogFragment : BottomSheetDialogFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Here is our bottomsheet dialog customization
        initDialogListeners()

        val view = inflater.inflate(R.layout.content_dialog_bottom_sheet, container, false)
        return view
    }

    private fun initDialogListeners() {
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        dialog.setOnShowListener { dialog ->
            //BottomSheetDialog wrapInBottomSheet() method
            val bottomSheet = (dialog as BottomSheetDialog).findViewById(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
            BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    override fun onStart() {
        super.onStart()
        initviews()

    }
    private fun initviews() {
        bottomSheetSubmitButton.setOnClickListener {
            val text = bottomSheetInput.text.toString()
            Toast.makeText(context, "submit :: " + text, Toast.LENGTH_SHORT).show()
        }


    }



}
