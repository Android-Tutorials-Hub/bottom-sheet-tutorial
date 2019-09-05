package com.androidtutorialshub.bottomsheets

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // BottomSheetBehavior variable
    private var bottomSheetBehavior: BottomSheetBehavior<*>? = null
    // TextView variable
    private var bottomSheetHeading: TextView? = null
    // Button variables
    private var expandBottomSheetButton: Button? = null
    private var collapseBottomSheetButton: Button? = null
    private var hideBottomSheetButton: Button? = null
    private var showBottomSheetDialogButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListeners()


    }

    /**
     * method to initialize the views
     */
    private fun initViews() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        bottomSheetBehavior = BottomSheetBehavior.from(findViewById<View>(R.id.bottomSheetLayout))
        bottomSheetHeading = findViewById<View>(R.id.bottomSheetHeading) as TextView

        expandBottomSheetButton = findViewById<View>(R.id.expand_bottom_sheet_button) as Button
        collapseBottomSheetButton = findViewById<View>(R.id.collapse_bottom_sheet_button) as Button
        hideBottomSheetButton = findViewById<View>(R.id.hide_bottom_sheet_button) as Button
        showBottomSheetDialogButton = findViewById<View>(R.id.show_bottom_sheet_dialog_button) as Button


    }


    /**
     * method to initialize the listeners
     */
    private fun initListeners() {
        // register the listener for button click
        expandBottomSheetButton!!.setOnClickListener(this)
        collapseBottomSheetButton!!.setOnClickListener(this)
        hideBottomSheetButton!!.setOnClickListener(this)
        showBottomSheetDialogButton!!.setOnClickListener(this)

        // Capturing the callbacks for bottom sheet
        bottomSheetBehavior!!.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetHeading!!.text = getString(R.string.text_collapse_me)
                } else {
                    bottomSheetHeading!!.text = getString(R.string.text_expand_me)
                }

                // Check Logs to see how bottom sheets behaves
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> Log.e("Bottom Sheet Behaviour", "STATE_COLLAPSED")
                    BottomSheetBehavior.STATE_DRAGGING -> Log.e("Bottom Sheet Behaviour", "STATE_DRAGGING")
                    BottomSheetBehavior.STATE_EXPANDED -> Log.e("Bottom Sheet Behaviour", "STATE_EXPANDED")
                    BottomSheetBehavior.STATE_HIDDEN -> Log.e("Bottom Sheet Behaviour", "STATE_HIDDEN")
                    BottomSheetBehavior.STATE_SETTLING -> Log.e("Bottom Sheet Behaviour", "STATE_SETTLING")
                }
            }


            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })


    }

    /**
     * onClick Listener to capture button click
     *
     * @param v
     */
    override fun onClick(v: View) {
        when (v.id) {
            R.id.collapse_bottom_sheet_button ->
                // Collapsing the bottom sheet
                bottomSheetBehavior!!.setState(BottomSheetBehavior.STATE_COLLAPSED)
            R.id.expand_bottom_sheet_button ->
                // Expanding the bottom sheet
                bottomSheetBehavior!!.setState(BottomSheetBehavior.STATE_EXPANDED)
            R.id.hide_bottom_sheet_button ->
                // Hiding the bottom sheet
                bottomSheetBehavior!!.setState(BottomSheetBehavior.STATE_HIDDEN)
            R.id.show_bottom_sheet_dialog_button ->
                // Opening the Dialog Bottom Sheet
                CustomBottomSheetDialogFragment().show(supportFragmentManager, "Dialog")
        }
    }
}
