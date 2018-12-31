package com.example.dell.androidramp_up;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.androidramp_up.ComponentsTask.ServiceActivity;
import com.example.dell.androidramp_up.Database.DatabaseActivity;
import com.example.dell.androidramp_up.FragmentsTask.MyFragmentActivity;
import com.example.dell.androidramp_up.Networking.PostRetrofitActivity;
import com.example.dell.androidramp_up.Networking.RetrofitActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public String TAG = this.getClass().getSimpleName();
    TextView getMsg;

    /**
     * <h>oncreate</h>
     * <p>Documentation Method Comment</p>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("MyToolbar");
        toolbar.setFocusableInTouchMode(true);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btn = findViewById(R.id.btn);
        Button broadcastBtn = findViewById(R.id.btn_broadcast);
        Button serviceBtn = findViewById(R.id.btn_service);
        Button videoBtn = findViewById(R.id.btn_video);
        Button dateBtn = findViewById(R.id.btn_date);
        Button myFragmentBtn = findViewById(R.id.btn_fragmentNew);
        Button emptyBtn = findViewById(R.id.btn_empty);
        Button endlessListBtn = findViewById(R.id.btn_endlessList);
        Button deviceIdBtn = findViewById(R.id.btn_deviceId);
        Button asyncBtn = findViewById(R.id.btn_asynTask);
        Button getMsgBtn = findViewById(R.id.btn_getMessage);
        getMsg = findViewById(R.id.tv_getMessage);
        Button coordinatorBtn = findViewById(R.id.btn_Coordinator);
        Button employeeBtn = findViewById(R.id.btn_details);
        ImageButton imageButton = findViewById(R.id.img_btn);
        Button notification = findViewById(R.id.btn_notification);
        ImageView imageView = findViewById(R.id.imageView);
        Button sendBtn = findViewById(R.id.btn_send);
        Button databaseTaskBtn = findViewById(R.id.btn_database);
        Button sendObjectBtn = findViewById(R.id.btn_sendObject);
        Button getRetrofitBtn = findViewById(R.id.btn_getRetrofit);
        Button postRetrofitBtn = findViewById(R.id.btn_post_retrofit);
        final EditText et_number = findViewById(R.id.et_number);
        final EditText et_name = findViewById(R.id.et_name);
        Button fragBtn = findViewById(R.id.btn_fragment);
        Button btn_camera = findViewById(R.id.btn_camera);

        getMsgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GetMessageActivity.class);
                startActivityForResult(intent, 2);
            }
        });

        serviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });

        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });

        broadcastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("MyAction");
                sendBroadcast(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        myFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent for Fragment Creation class
                Intent intent = new Intent(MainActivity.this, MyFragmentActivity.class);
                startActivity(intent);
            }
        });

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Calendar calendar = Calendar.getInstance();
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy:hh:mm:ss");
//                String date = simpleDateFormat.format(calendar.getTime());

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String date = sdf.format(new Date());

//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                String date = sdf.format(System.currentTimeMillis());

                Toast.makeText(MainActivity.this, "Today's Date and time: " + date, Toast.LENGTH_SHORT).show();
            }
        });

        deviceIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeviceId();
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification.Builder builder = new Notification.Builder(MainActivity.this)
                        .setAutoCancel(true)
                        .setContentText("Notification from Android RampUp App")
                        .setContentTitle("Android RampUp")
                        .setSmallIcon(R.drawable.star);

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(contentIntent);
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0, builder.build());
            }
        });

        emptyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setPackage("com.whatsapp");  // Package used in Whatsapp
                startActivity(intent);
            }
        });

        endlessListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EndlessListActivity.class);
                startActivity(intent);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Image Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataTransferActivity.class);
                Bundle bundle = new Bundle();
                String name = et_name.getText().toString();
                int number = Integer.parseInt(et_number.getText().toString());
                bundle.putString("Name", name);
                bundle.putInt("Number", number);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        fragBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });

        asyncBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AsyncTaskActivity.class);
                startActivity(intent);
            }
        });

        getRetrofitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RetrofitActivity.class);
                startActivity(intent);
            }
        });

        postRetrofitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostRetrofitActivity.class);
                startActivity(intent);
            }
        });

        coordinatorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, CoordinatorLayoutActivity.class);
                Intent intent = new Intent(MainActivity.this, CoordinatorActivity.class);
                startActivity(intent);
            }
        });

        employeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmployeeDetails.class);
                startActivity(intent);
            }
        });

        databaseTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatabaseActivity.class);
                startActivity(intent);
            }
        });

        sendObjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Uncomment the codes", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this,DataTransferActivity.class);
//                Student student = new Student("Anurag",456);
//                intent.putExtra("parcel_data",student);
//                startActivity(intent);
            }
        });

        Picasso.get()
                .load("https://upload.wikimedia.org/wikipedia/commons/e/ee/Android_green_figure,_next_to_its_original_packaging.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .resize(700, 700)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getApplicationContext(), "Success Loading Image", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getApplicationContext(), "An errror occured while loading", Toast.LENGTH_SHORT).show();
                    }
                });

//        Glide.with(MainActivity.this)
//                .asGif()
//                .load("http://i.kinja-img.com/gawker-media/image/upload/s--B7tUiM5l--/gf2r69yorbdesguga10i.gif")
//                .into(imageView);


        Log.d(TAG, "Inside OnCreate() Method of MainActivity");
    }

    private void openCamera() {
        Boolean Status = permission();
        if (Status.equals(true)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        }
    }

    private void showDeviceId() {
        TelephonyManager mTelephonyMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
//        String myId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
//        Toast.makeText(MainActivity.this, "Device id: " + myId, Toast.LENGTH_SHORT).show();
        String imei = mTelephonyMgr.getDeviceId();
        Toast.makeText(MainActivity.this, "Device id: " + imei, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 2) {
                String message = data.getStringExtra("Message");
                getMsg.setText(message);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Request Cancelled and No Data Passed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        int number = 25;
        outState.putInt("Number", number);
        Toast.makeText(MainActivity.this, "Number saved: " + number, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int myNumber = savedInstanceState.getInt("Number");
        Toast.makeText(MainActivity.this, "Number retrieved : " + myNumber, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "You clicked Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_logout:
                Toast.makeText(getApplicationContext(), "You clicked Logout", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_image:
                Toast.makeText(getApplicationContext(), "You clicked Image", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    boolean permission() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 100);
            return false;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Inside OnStart() Method of MainActivity");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Inside OnResume() Method of MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Inside OnPause() Method of MainActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Inside OnStop() Method of MainActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Inside OnRestart() Method of MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy() Method of MainActivity");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera();
                } else {
                    Toast.makeText(MainActivity.this, "Permission for Camera Denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
