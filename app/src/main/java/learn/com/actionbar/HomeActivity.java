package learn.com.actionbar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends Activity {
    private EditText edTxt_username, edTxt_password;
    private Button btn_login;
    private ConnectivityManager connectivityManager;

    public HomeActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        edTxt_username = (EditText) findViewById(R.id.edTxt_username);
        edTxt_password = (EditText) findViewById(R.id.edTxt_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SaveDataActivity.class);
                intent.putExtra("PASSWORD", edTxt_password.getText().toString());

                startActivity(intent);
                Toast.makeText(getBaseContext(), "Login :" + edTxt_username.getText().toString(), Toast.LENGTH_LONG).show();
                finish();
            }
        });
        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifi.isWifiEnabled()) {
            Toast.makeText(this, "WIFI on", Toast.LENGTH_SHORT).show();
        } else {
            checkNetConnection();

            Toast.makeText(this, "WIFI off", Toast.LENGTH_SHORT).show();
        }


    }

    public void wifiNav(View view) {
        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
    }

    public void locationNav(View view) {
        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
    }

    public void moblieDataNav(View view) {
        startActivity(new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS));
    }

    public void checkNetConnection() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Turn on you wifi");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }

                });

        alertDialog.show();
    }

}
