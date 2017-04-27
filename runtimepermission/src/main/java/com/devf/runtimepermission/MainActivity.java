package com.devf.runtimepermission;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_example)
    TextView tvExample;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * Methon for request camera permission
     */
    private void requestCameraPermission() {
        String[] permissions = new String[]{Manifest.permission.CAMERA};

        if (!ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CAMERA)) {

        } else {
            ActivityCompat.requestPermissions(MainActivity.this, permissions, Constants.REQUEST_PERMISSION_CAMERA);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //Preguntamos si es el request code con el que mandamos a solicitar el o los permisos
        if (requestCode == Constants.REQUEST_PERMISSION_CAMERA) {
            if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Yeah!!
                btnClick();
                return;
            }

            if (!ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CAMERA)) {
                //TODO Decirle al usuario que tiene que ir a las configuraciones y habilitar el permiso manualmente
            } else {
                ActivityCompat.requestPermissions(MainActivity.this, permissions, Constants.REQUEST_PERMISSION_CAMERA);
            }

        }
    }

    @OnClick(R.id.button)
    public void btnClick() {

        //Primero verifico si el permiso de la camara esta permitido
        //si todavia no lo tiene lo pediremos
        int permissionStatus =
                ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, Constants.REQUEST_CODE_TAKE_PICTURE);
            }

        } else {
            requestCameraPermission();
        }

    }


}
