package com.gzeinnumer.bottomsheetjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    BottomSheetBehavior sheetBehavior;
    BottomSheetDialog sheetDialog;
    View bottom_sheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom_sheet = findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(bottom_sheet);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();

            }
        });
    }

    private void showBottomSheetDialog() {
        View view = getLayoutInflater().inflate(R.layout.sheet, null);

        if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        (view.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sheetDialog.dismiss();
            }
        });

        (view.findViewById(R.id.bt_subscribe)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Makasih ya sudah subscribe", Toast.LENGTH_SHORT).show();
            }
        });

        sheetDialog = new BottomSheetDialog(this);
        sheetDialog.setContentView(view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            sheetDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        sheetDialog.show();
        sheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                sheetDialog = null;
            }
        });
    }
}