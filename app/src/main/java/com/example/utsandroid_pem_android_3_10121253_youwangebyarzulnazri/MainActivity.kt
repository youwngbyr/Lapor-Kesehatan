package com.example.utsandroid_pem_android_3_10121253_youwangebyarzulnazri

//03 Juni 2024, 10121253, Youwan Gebyar Zulnazri, Pemrograman Android 3

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroupTestType: RadioGroup
    private lateinit var editTextConfirmationDate: EditText
    private lateinit var editTextNIK: EditText
    private lateinit var editTextName: EditText
    private lateinit var editTextBirthDate: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var radioGroupRelationship: RadioGroup
    private lateinit var checkBoxDisclaimer: CheckBox
    private lateinit var buttonSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroupTestType = findViewById(R.id.radioGroupTestType)
        editTextConfirmationDate = findViewById(R.id.editTextConfirmationDate)
        editTextNIK = findViewById(R.id.editTextNIK)
        editTextName = findViewById(R.id.editTextName)
        editTextBirthDate = findViewById(R.id.editTextBirthDate)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        radioGroupRelationship = findViewById(R.id.radioGroupRelationship)
        checkBoxDisclaimer = findViewById(R.id.checkBoxDisclaimer)
        buttonSubmit = findViewById(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            if (validateInputs()) {
                val intent = Intent(this, ReviewActivity::class.java).apply {
                    putExtra("testType", getSelectedRadioButtonText(radioGroupTestType))
                    putExtra("confirmationDate", editTextConfirmationDate.text.toString())
                    putExtra("nik", editTextNIK.text.toString())
                    putExtra("name", editTextName.text.toString())
                    putExtra("birthDate", editTextBirthDate.text.toString())
                    putExtra("gender", getSelectedRadioButtonText(radioGroupGender))
                    putExtra("relationship", getSelectedRadioButtonText(radioGroupRelationship))
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInputs(): Boolean {
        return radioGroupTestType.checkedRadioButtonId != -1 &&
                editTextConfirmationDate.text.isNotEmpty() &&
                editTextNIK.text.isNotEmpty() &&
                editTextName.text.isNotEmpty() &&
                editTextBirthDate.text.isNotEmpty() &&
                radioGroupGender.checkedRadioButtonId != -1 &&
                radioGroupRelationship.checkedRadioButtonId != -1 &&
                checkBoxDisclaimer.isChecked
    }

    private fun getSelectedRadioButtonText(radioGroup: RadioGroup): String {
        val selectedId = radioGroup.checkedRadioButtonId
        val radioButton = findViewById<RadioButton>(selectedId)
        return radioButton.text.toString()
    }
}
