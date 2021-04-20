package tads.eaj.ufrn.exemplobroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class ReceiverBateria :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent!!.action) {
            Intent.ACTION_BATTERY_CHANGED -> {
                val level = intent.getIntExtra("level", 0)
                Log.i("Script", "battery level is ${level}")
            }
        }
    }
}