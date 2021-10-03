package com.trung.hw5_question1

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListener()
    }

    private fun setListener() {
        btnSubmit.setOnClickListener {
            val isQuestionOneCorrect = !rbOne.isChecked && rbTwo.isChecked && !rbThree.isChecked
            val isQuestionTwoCorrect = cbOne.isChecked && cbTwo.isChecked && cbThree.isChecked && !cbFour.isChecked

            if (isQuestionOneCorrect && isQuestionTwoCorrect) {
                showAlertDialog("RESULT", "Your grade is 100!!! Congratulations!!!")
            } else if (isQuestionOneCorrect || isQuestionTwoCorrect) {
                showAlertDialog("RESULT", "Your grade is 50!!!")
            }  else {
                showAlertDialog("RESULT", "You're failed!!!")
            }
        }

        btnReset.setOnClickListener {
            rbOne.isChecked = false
            rbTwo.isChecked = false
            rbThree.isChecked = false
            cbOne.isChecked = false
            cbTwo.isChecked = false
            cbThree.isChecked = false
            cbFour.isChecked = false
        }
    }

    private fun showAlertDialog(title:String, message: String, currentDate: Date = Calendar.getInstance().time) {
        val alertDialog: AlertDialog? = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setNeutralButton("Ok",
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.dismiss()
                    })
                setTitle(title)
                setMessage("You just submitted your quiz at $currentDate \n$message")

            }
            // Create the AlertDialog
            builder.create()
        }.apply {
            show()
        }
    }
}