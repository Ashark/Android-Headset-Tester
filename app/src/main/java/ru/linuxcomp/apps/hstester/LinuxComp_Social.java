package ru.linuxcomp.apps.hstester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import ru.linuxcomp.apps.hstester.hstester.R;

public class LinuxComp_Social extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linuxcomp_social);
        TextView tv1 = (TextView) findViewById(R.id.tvLink_lc_site);
        TextView tv2 = (TextView) findViewById(R.id.tvLink_fb);
        TextView tv3 = (TextView) findViewById(R.id.tvLink_gp);
        TextView tv4 = (TextView) findViewById(R.id.tvLink_tw);
        TextView tv5 = (TextView) findViewById(R.id.tvLink_vk);

        TextView tv6 = (TextView) findViewById(R.id.tvLink_hss);
        TextView tv7 = (TextView) findViewById(R.id.tvLink_trb);
        TextView tv8 = (TextView) findViewById(R.id.tvLink_vak);
        TextView tv9 = (TextView) findViewById(R.id.tvLink_rhb);
        TextView tv10 = (TextView) findViewById(R.id.tvLink_kta);

        tv1.setMovementMethod(LinkMovementMethod.getInstance());
        tv2.setMovementMethod(LinkMovementMethod.getInstance());
        tv3.setMovementMethod(LinkMovementMethod.getInstance());
        tv4.setMovementMethod(LinkMovementMethod.getInstance());
        tv5.setMovementMethod(LinkMovementMethod.getInstance());
        tv6.setMovementMethod(LinkMovementMethod.getInstance());
        tv7.setMovementMethod(LinkMovementMethod.getInstance());
        tv8.setMovementMethod(LinkMovementMethod.getInstance());
        tv9.setMovementMethod(LinkMovementMethod.getInstance());
        tv10.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
