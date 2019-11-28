package tads.eaj.ufrn.exemplobroadcast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.PackageManager
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import android.widget.Toast
import android.content.Intent
import android.view.View
import android.content.BroadcastReceiver
import android.Manifest.permission.RECEIVE_SMS
import android.Manifest.permission.READ_PHONE_STATE
import android.Manifest.permission.READ_SMS
import android.content.IntentFilter
import tads.eaj.ufrn.exemplobroadcast.PermissionUtils.Companion.alertAndFinish


class MainActivity : AppCompatActivity() {

    var meu_receiver: BroadcastReceiver = ReceiverDinamico()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LocalBroadcastManager.getInstance(this).registerReceiver(meu_receiver, IntentFilter("BANG"))

        // Solicita as permissões
        PermissionUtils.validate(this, 0, READ_SMS, READ_PHONE_STATE,RECEIVE_SMS)
    }

    fun onClickDinamico(v: View) {

        val i = Intent("BANG")
        LocalBroadcastManager.getInstance(this).sendBroadcast(i)
        Toast.makeText(this, "Intent enviada  por API!", Toast.LENGTH_SHORT).show()
    }

    fun fechar(v: View) {
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(meu_receiver)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        for (result in grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) {
                // Alguma permissão foi negada, agora é com você :-)
                alertAndFinish(this, R.string.app_name)
                return
            }
        }
        // Se chegou aqui está OK :-)
    }

}
