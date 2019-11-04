# WhatsappDirect


# Validasi no belum diisi
![alt text](https://raw.githubusercontent.com/vickyKDV/WhatsappDirect/master/wa1.jpeg)

# Validasi no tidak valid
![alt text](https://raw.githubusercontent.com/vickyKDV/WhatsappDirect/master/wa2.jpeg)

# Direct ke playstore jika whatsapp belum terinstall
![alt text](https://raw.githubusercontent.com/vickyKDV/WhatsappDirect/master/wa3.jpeg)





Cara implementasi
   
   
   Set pada build.gradle application
   
     allprojects {
          repositories {
             ...
             ...
             maven { url "https://jitpack.io" }

          }
      }
    
   Set pada build.gradle module
    
    dependencies {
        ...
        ...
        implementation  'com.github.vickykdv:WhatsappDirect:1.0'
    }

Cara menggunakan
    
    findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            //Panggil fungsi disini ( Context, no Hp , dan Pesan )
            new WhatsappIntent(MainActivity.this,edthp.getText().toString(),edtpesan.getText().toString());


            }

        });
