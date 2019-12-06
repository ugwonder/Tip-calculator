package com.mgbachi_ugo.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        seekBarTipPercent.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewTipPercent.text = progress.toString() + "%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        } )
        seekBarHowManyPeople.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewHowManyPeople.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        if (editTextBiilAmount != null) {
            btnCalculate.setOnClickListener {

                //Get the bill Amount
                var billAmount = editTextBiilAmount.text.toString().toInt()


                //Get the tip percent
                var tipPercent = seekBarTipPercent.progress

                //get the amount of people
                var people = seekBarHowManyPeople.progress



                //Calculate the tip amount
                var tipAmount = (billAmount * tipPercent) / 100

                //calculate the total payment
                var totalAmount = billAmount + tipAmount

                //how much each person that ate will pay
                var moneyDivided = totalAmount / people

                var totalAmountN = totalAmount.toString()

                var moneyDivededN = moneyDivided.toString()

                textViewTotalpriceDisplay.text = "Total $totalAmountN (Tip is $tipAmount) and each person bill is $moneyDivededN"
            }
        }
            else {
            Toast.makeText(this, "Add Bill Amount", Toast.LENGTH_SHORT).show()
        }
    }
}

