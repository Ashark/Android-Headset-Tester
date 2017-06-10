package ru.linuxcomp.apps.hstester;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import ru.linuxcomp.apps.hstester.hstester.R;

import static android.view.KeyEvent.KEYCODE_BACK;
import static android.view.KeyEvent.KEYCODE_HEADSETHOOK;
import static android.view.KeyEvent.KEYCODE_VOICE_ASSIST;


public class MainActivity extends AppCompatActivity {

    private AudioManager audio;

    // A - Vol+
    // B - Vol-
    // C - Hook
    // D - Voice
    private int mCountAD = 0;
    private int mCountAR = 0;
    private int mCountBD = 0;
    private int mCountBR = 0;
    private int mCountCD = 0;
    private int mCountCR = 0;
    private int mCountDD = 0;
    private int mCountDR = 0;

    private static final String KEY_AD = "AD";
    private static final String KEY_AR = "AR";
    private static final String KEY_BD = "BD";
    private static final String KEY_BR = "BR";
    private static final String KEY_CD = "CD";
    private static final String KEY_CR = "CR";
    private static final String KEY_DD = "DD";
    private static final String KEY_DR = "DR";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        IntentFilter filter = new IntentFilter(Intent.ACTION_MEDIA_BUTTON);
        MediaButtonIntentReceiver r = new MediaButtonIntentReceiver();
        //filter.setPriority(10000);
        registerReceiver(r, filter);

        ((AudioManager)getSystemService(AUDIO_SERVICE)).registerMediaButtonEventReceiver(
                new ComponentName(
                        getPackageName(),
                        MediaButtonIntentReceiver.class.getName()));

        IntentFilter mediaButtonFilter = new IntentFilter(
                Intent.ACTION_MEDIA_BUTTON);
        mediaButtonFilter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);

        audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Restore values of counters after rotation
        if (savedInstanceState != null) {
            mCountAD = savedInstanceState.getInt(KEY_AD, 0);
            mCountAR = savedInstanceState.getInt(KEY_AR, 0);
            mCountBD = savedInstanceState.getInt(KEY_BD, 0);
            mCountBR = savedInstanceState.getInt(KEY_BR, 0);
            mCountCD = savedInstanceState.getInt(KEY_CD, 0);
            mCountCR = savedInstanceState.getInt(KEY_CR, 0);
            mCountDD = savedInstanceState.getInt(KEY_DD, 0);
            mCountDR = savedInstanceState.getInt(KEY_DR, 0);

            TextView tvAD = (TextView) findViewById(R.id.tvAD);
            TextView tvAR = (TextView) findViewById(R.id.tvAR);
            TextView tvBD = (TextView) findViewById(R.id.tvBD);
            TextView tvBR = (TextView) findViewById(R.id.tvBR);
            TextView tvCD = (TextView) findViewById(R.id.tvCD);
            TextView tvCR = (TextView) findViewById(R.id.tvCR);
            TextView tvDD = (TextView) findViewById(R.id.tvDD);
            TextView tvDR = (TextView) findViewById(R.id.tvDR);

            tvAD.setText("" + mCountAD);
            tvAR.setText("" + mCountAR);
            tvBD.setText("" + mCountBD);
            tvBR.setText("" + mCountBR);
            tvCD.setText("" + mCountCD);
            tvCR.setText("" + mCountCR);
            tvDD.setText("" + mCountDD);
            tvDR.setText("" + mCountDR);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle ourState) {
        super.onSaveInstanceState(ourState);
        // save our counters before rotation
        ourState.putInt(KEY_AD, mCountAD);
        ourState.putInt(KEY_AR, mCountAR);
        ourState.putInt(KEY_BD, mCountBD);
        ourState.putInt(KEY_BR, mCountBR);
        ourState.putInt(KEY_CD, mCountCD);
        ourState.putInt(KEY_CR, mCountCR);
        ourState.putInt(KEY_DD, mCountDD);
        ourState.putInt(KEY_DR, mCountDR);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Toast.makeText(getApplicationContext(), "Нажата кейкод="+keyCode, Toast.LENGTH_SHORT).show();
        ImageView remctrl = (ImageView) findViewById(R.id.pultIV);


        TextView tvkeycode = (TextView) findViewById(R.id.keycodetv);


        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                //audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                  //      AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
               // Toast.makeText(getApplicationContext(), "кнопка громче!", Toast.LENGTH_SHORT).show(); //Log.d("Test", "vol up нажато");
                remctrl.setImageResource(R.drawable.headset_remote_hor_plus);

                TextView tw3 = (TextView) findViewById(R.id.tvAD);
                tw3.setText("" + ++mCountAD);
                tvkeycode.setText("DeviceID: "+event.getDeviceId());
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
               // audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                 //       AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
                remctrl.setImageResource(R.drawable.headset_remote_hor_minus);
                TextView tw4 = (TextView) findViewById(R.id.tvBD);
                tw4.setText("" + ++mCountBD);
                tvkeycode.setText("DeviceID: "+event.getDeviceId());
                return true;
            case KEYCODE_HEADSETHOOK:
                remctrl.setImageResource(R.drawable.headset_remote_hor_hook);
                TextView tw5 = (TextView) findViewById(R.id.tvCD);
                tw5.setText("" + ++mCountCD);
                tvkeycode.setText("DeviceID: "+event.getDeviceId());
                return true;
            case KEYCODE_VOICE_ASSIST:
                remctrl.setImageResource(R.drawable.headset_remote_hor);
                TextView tw7 = (TextView) findViewById(R.id.tvDD);
                tw7.setText("" + ++mCountDD);
                tvkeycode.setText("DeviceID: "+event.getDeviceId());
                return true;
            case KEYCODE_BACK:
                finish();
                return true;
            default:
                return false;
        }

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        ImageView remctrl = (ImageView) findViewById(R.id.pultIV);

        TextView tvkeycode = (TextView) findViewById(R.id.keycodetv);
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                remctrl.setImageResource(R.drawable.headset_remote_hor);
                TextView tw3 = (TextView) findViewById(R.id.tvAR);
                tw3.setText("" + ++mCountAR);
                tvkeycode.setText("DeviceID: "+event.getDeviceId());
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                remctrl.setImageResource(R.drawable.headset_remote_hor);
                TextView tw4 = (TextView) findViewById(R.id.tvBR);
                tw4.setText("" + ++mCountBR);
                tvkeycode.setText("DeviceID: "+event.getDeviceId());
                return true;
            case KEYCODE_HEADSETHOOK:
                remctrl.setImageResource(R.drawable.headset_remote_hor);
                TextView tw5 = (TextView) findViewById(R.id.tvCR);
                tw5.setText("" + ++mCountCR);
                tvkeycode.setText("DeviceID: "+event.getDeviceId());
                return true;
            case KEYCODE_VOICE_ASSIST:
                remctrl.setImageResource(R.drawable.headset_remote_hor);
                TextView tw7 = (TextView) findViewById(R.id.tvDR);
                tw7.setText("" + ++mCountDR);
                tvkeycode.setText("DeviceID: "+event.getDeviceId());
                return true;
            default:
                return false;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;
        switch (id) {
            case R.id.action_linuxcomp:
                intent = new Intent(MainActivity.this, LinuxComp_Social.class);
                startActivity(intent);
                return true;
            case R.id.action_about:
                intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ImageView iconHeadType = (ImageView) findViewById(R.id.TypeIconIV);

            final String action = intent.getAction();
            String nm = intent.getStringExtra("name");
            Log.d("tag", "index=" + nm); // do not remove "index=" +, otherwise app crashes on android 6+.
            if (Intent.ACTION_HEADSET_PLUG.equals(action)) {
                int state = intent.getIntExtra("state", -1);
                int microphone = intent.getIntExtra("microphone", -1);

                TextView stateTextViewobj = (TextView)findViewById(R.id.tvCableState);
                TextView micTextViewobj = (TextView)findViewById(R.id.tvMicState);
                switch(state){
                    case 0:
                        stateTextViewobj.setText(R.string.no);
                        micTextViewobj.setText(R.string.insert_cable);
                        iconHeadType.setImageResource(R.drawable.no_cable);
                        break;
                    case 1:
                        stateTextViewobj.setText(R.string.yes);
                        switch (microphone){
                            case 0:
                                iconHeadType.setImageResource(R.drawable.headphones_module);
                                micTextViewobj.setText(R.string.no);
                                break;
                            case 1:
                                iconHeadType.setImageResource(R.drawable.headset_module);
                                micTextViewobj.setText(R.string.yes);
                                break;
                            default:
                                iconHeadType.setImageResource(R.drawable.error);
                                micTextViewobj.setText(R.string.cannot_determine);
                        }

                        break;
                    default:
                        iconHeadType.setImageResource(R.drawable.error);
                        stateTextViewobj.setText(R.string.cannot_determine);
                        micTextViewobj.setText(R.string.cannot_determine);
                }

            }
        }
    };



    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        getApplicationContext().registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        getApplicationContext().unregisterReceiver(mReceiver);
    }
}

