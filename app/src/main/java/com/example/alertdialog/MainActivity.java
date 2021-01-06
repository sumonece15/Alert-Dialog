package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button exitButton;
    private AlertDialog.Builder alterDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitButton = (Button) findViewById(R.id.buttonId);
        exitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        alterDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        //for setting title
        alterDialogBuilder.setTitle(R.string.title_text);

        //for setting message
        alterDialogBuilder.setMessage(R.string.message_text);

        //for setting icon
        alterDialogBuilder.setIcon(R.mipmap.ic_launcher);

        alterDialogBuilder.setCancelable(false);
        alterDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //exit
                finish();
            }
        });

        alterDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });

        alterDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                Toast.makeText(MainActivity.this,"You have clicked neutral button",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alterDialogBuilder.create();
        alertDialog.show();
    }
}