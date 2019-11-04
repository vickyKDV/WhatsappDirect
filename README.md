# WhatsappDirect

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
        implementation 'com.github.vickykdv:CircleRectImageView:1.0'
    }

Cara menggunakan
    
    findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            //Panggil fungsi disini ( Context, no Hp , dan Pesan )
            new WhatsappIntent(MainActivity.this,edthp.getText().toString(),edtpesan.getText().toString());


            }

        });
