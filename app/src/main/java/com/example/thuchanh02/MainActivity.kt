
package com.example.thuchanh02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val so1 = findViewById<EditText>(R.id.edtSo1)
        val so2 = findViewById<EditText>(R.id.edtSo2)
        val ketQua = findViewById<TextView>(R.id.txtKetQua)

        val cong = findViewById<Button>(R.id.btnCong)
        val tru = findViewById<Button>(R.id.btnTru)
        val nhan = findViewById<Button>(R.id.btnNhan)
        val chia = findViewById<Button>(R.id.btnChia)

        fun tinh(phepTinh: String) {
            val a = so1.text.toString().toDoubleOrNull()
            val b = so2.text.toString().toDoubleOrNull()

            if (a == null || b == null) {
                ketQua.text = "Vui lòng nhập đủ hai số!"
                return
            }

            val kq = when (phepTinh) {
                "+" -> a + b
                "-" -> a - b
                "*" -> a * b
                "/" -> {
                    if (b == 0.0) {
                        ketQua.text = "Không thể chia cho 0!"
                        return
                    }
                    a / b
                }
                else -> return
            }

            ketQua.text = "Kết quả: $kq"
        }

        cong.setOnClickListener { tinh("+") }
        tru.setOnClickListener { tinh("-") }
        nhan.setOnClickListener { tinh("*") }
        chia.setOnClickListener { tinh("/") }
    }
}
