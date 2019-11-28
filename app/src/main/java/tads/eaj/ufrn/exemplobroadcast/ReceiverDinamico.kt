package tads.eaj.ufrn.exemplobroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class ReceiverDinamico : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i("Script", "Mensagem recebida, com API!!");
    }
}
