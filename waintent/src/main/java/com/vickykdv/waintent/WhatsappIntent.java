package com.vickykdv.waintent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WhatsappIntent  {

    private String regex = "\\d{11}|\\d{12}|\\d{13}|\\d{14}|\\d{15}";

    public WhatsappIntent(Activity activity, String phone, String pesan) {

        if (phone.matches("")) {
            Toast.makeText(activity, "No Tujuan belum ditentukan !!", Toast.LENGTH_SHORT).show();
        } else {

            Pattern p = Pattern.compile(regex);

            Matcher m = p.matcher(phone);

            if (!m.matches()){
                Toast.makeText(activity, "No telepon tidak valid !!", Toast.LENGTH_SHORT).show();
            }
            else {

                try {


                    String phoneshub = phone;

                    String phonetemp = phoneshub.substring(1, phone.length());

                    Log.d("WhatsappInten", "phonetemp: " + phonetemp);


                    phoneshub = phoneshub.substring(0, 1);

                    if (phoneshub.matches("0")) {
                        phoneshub = phoneshub.replace("0", "62");
                        phonetemp = phoneshub + phonetemp;
                        Log.d("WhatsappInten", "phonetemp: " + phonetemp);

                        Log.d("WhatsappInten", "phoneshub: " + phoneshub);


                        Intent wa = new Intent("android.intent.action.SEND");
                        wa.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                        wa.putExtra(Intent.EXTRA_TEXT, pesan);
                        wa.setAction(Intent.ACTION_SEND);
                        wa.setType("text/plain");
                        wa.setPackage("com.whatsapp");
                        wa.putExtra("jid", phonetemp + "@s.whatsapp.net");


//                        if (wa.resolveActivity(activity.getPackageManager()) == null) {
//
//                            Intent w4b = new Intent("android.intent.action.MAIN");
//                            w4b.putExtra(Intent.EXTRA_TEXT, pesan);
//                            w4b.setAction(Intent.ACTION_SEND);
//                            w4b.setPackage("com.whatsapp.w4b");
//                            w4b.putExtra("jid", phonetemp + "@s.whatsapp.w4b.net");
//                            w4b.setType("text/plain");
//                            w4b.setComponent(new ComponentName("com.whatsapp.w4b", "com.whatsapp.w4b.Conversation"));
//                            activity.startActivity(w4b);
//                            if (w4b.resolveActivity(activity.getPackageManager()) == null) {
//                                Toast.makeText(activity, "Whatsapp belum terinstall", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(Intent.ACTION_VIEW);
//                                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp"));
//                                activity.startActivity(intent);
//                                return;
//                            }
//                            return;
//                        }else {

                        activity.startActivity(wa);
//                        }

                    } else {
                        Toast.makeText(activity, "No depan harus diawali 0 !!", Toast.LENGTH_SHORT).show();
                        Log.d("WhatsappInten", "onCreate: " + phonetemp);
                    }
                }catch (Exception e){
                       Toast.makeText(activity, "Whatsapp belum terinstall", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(Intent.ACTION_VIEW);
                       intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp"));
                       activity.startActivity(intent);
                }
            }
        }
    }




}
