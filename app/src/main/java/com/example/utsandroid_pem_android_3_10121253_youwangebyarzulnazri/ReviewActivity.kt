package com.example.utsandroid_pem_android_3_10121253_youwangebyarzulnazri

//03 Juni 2024, 10121253, Youwan Gebyar Zulnazri, Pemrograman Android 3


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {

    private lateinit var textTestTypeReview: TextView
    private lateinit var textConfirmationDateReview: TextView
    private lateinit var textNIKReview: TextView
    private lateinit var textNameReview: TextView
    private lateinit var textBirthDateReview: TextView
    private lateinit var textGenderReview: TextView
    private lateinit var textRelationshipReview: TextView
    private lateinit var buttonEdit: Button
    private lateinit var buttonSubmitReview: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        textTestTypeReview = findViewById(R.id.text_test_type_review)
        textConfirmationDateReview = findViewById(R.id.text_confirmation_date_review)
        textNIKReview = findViewById(R.id.text_nik_review)
        textNameReview = findViewById(R.id.text_name_review)
        textBirthDateReview = findViewById(R.id.text_birth_date_review)
        textGenderReview = findViewById(R.id.text_gender_review)
        textRelationshipReview = findViewById(R.id.text_relationship_review)
        buttonEdit = findViewById(R.id.buttonEdit)
        buttonSubmitReview = findViewById(R.id.buttonSubmitReview)

        // Retrieve data from intent
        val testType = intent.getStringExtra("testType")
        val confirmationDate = intent.getStringExtra("confirmationDate")
        val nik = intent.getStringExtra("nik")
        val name = intent.getStringExtra("name")
        val birthDate = intent.getStringExtra("birthDate")
        val gender = intent.getStringExtra("gender")
        val relationship = intent.getStringExtra("relationship")

        // Display data
        textTestTypeReview.text = testType
        textConfirmationDateReview.text = confirmationDate
        textNIKReview.text = nik
        textNameReview.text = name
        textBirthDateReview.text = birthDate
        textGenderReview.text = gender
        textRelationshipReview.text = relationship

        buttonEdit.setOnClickListener {
            // Finish the current activity and return to MainActivity to edit the data
            finish()
        }

        buttonSubmitReview.setOnClickListener {
            // Show success dialog
            AlertDialog.Builder(this)
                .setTitle("Berhasil Mendapatkan Akses")
                .setMessage("Silahkan tap tombol di bawah untuk memulai mengisi form Lapor Kesehatan Harian.")
                .setPositiveButton("OK") { _, _ ->
                    // Close the application or return to MainActivity with cleared data
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                }
                .show()
        }
    }
}
