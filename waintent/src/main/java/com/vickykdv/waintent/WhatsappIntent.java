package com.vickykdv.waintent;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WhatsappIntent  {

    public WhatsappIntent(Context context, String phone, String pesan) {

        if (phone.matches("")) {
            Toast.makeText(context, "No Tujuan belum ditentukan !!", Toast.LENGTH_SHORT).show();
        } else {
            String regex = "\\d{11}|\\d{12}|\\d{13}|\\d{14}|\\d{15}";

            Pattern p = Pattern.compile(regex);

            Matcher m = p.matcher(phone);

            if (!m.matches()){
                Toast.makeText(context, "No telepon tidak valid !!", Toast.LENGTH_SHORT).show();
            }
            else {
                try {


                    String text = pesan;

                    String hello = phone;

                    String hellotemp = hello.substring(1, hello.length() - 1);

                    Log.d("WhatsappInten", "onCreate: " + hellotemp);


                    hello = hello.substring(0, 1);

                    if (hello.matches("0")) {
                        hello = hello.replace("0", "+62");
                        hellotemp = hello + hellotemp;
                        Log.d("WhatsappInten", "onCreate: " + hellotemp);

                        Log.d("WhatsappInten", "onCreate: " + hello);


                        Intent sendIntent = new Intent("android.intent.action.MAIN");
                        sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.setType("text/plain");
                        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
                        sendIntent.putExtra("jid", phone + "@s.whatsapp.net");
                        sendIntent.setPackage("com.whatsapp");
                        context.startActivity(sendIntent);


                    } else {
                        Toast.makeText(context, "No depan harus diawali 0 !!", Toast.LENGTH_SHORT).show();
                        Log.d("WhatsappInten", "onCreate: " + hellotemp);
                    }


                } catch (Exception e) {
                    Toast.makeText(context, "Whatsapp belum terinstall", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp"));
                    context.startActivity(intent);

                }
            }
        }
    }




}
