package com.androidtutorialshub.bottomsheets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    private fun initListeners() {
        show_bottom_sheet_dialog_button.setOnClickListener { it ->
            CustomBottomSheetDialogFragment().show(supportFragmentManager, "Dialog")
        }
    }
}