# WhatsappDirect



Cara menggunakan
    
    findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            //Panggil fungsi disini ( Context, no Hp , dan Pesan )
            new WhatsappIntent(MainActivity.this,edthp.getText().toString(),edtpesan.getText().toString());


            }

        });
