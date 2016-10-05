package ru.linuxcomp.apps.hstester;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;

/**
 * Created by andr on 24.09.16.
 */

// This class I remained, because it captures pause and not let your player to distarb you while testing remote control buttons.

public class MediaButtonIntentReceiver extends BroadcastReceiver {

    public MediaButtonIntentReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (!Intent.ACTION_MEDIA_BUTTON.equals(intentAction)) {
            return;
        }
        KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
        if (event == null) {
            return;
        }
        int action = event.getAction();
        if (action == KeyEvent.ACTION_DOWN) {
            // do something
           // Log.d("blabla","pressed");
            // Toast.makeText(context, "toggl play-pause", Toast.LENGTH_SHORT).show();
        }
        abortBroadcast();
    }
}
