package com.example.olaintent

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btTeste.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:984699201"))
            startActivity(intent)

        }
        val ok = PermissionUtils.request(this,arrayOf(Manifest.permission.CALL_PHONE))
        if(!ok){
            btTeste.visibility = View.INVISIBLE

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val ok = PermissionUtils.validate(this, permissions)
        if(ok){
            btTeste.visibility = View.VISIBLE
        }
    }
}