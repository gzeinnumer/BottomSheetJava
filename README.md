# BottomSheetJava

https://tutorial.androidrion.com/tutorial-cara-membuat-bottom-sheet-android-studio/

- activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:text="Open Bottom Sheet" />

    <FrameLayout
        android:id="@+id/bottom_sheet"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_behavior="com.google.android.material.bottomsheet.BottomSheetBehavior" />
</androidx.coordinatorlayout.widget.CoordinatorLayout>
```

- sheet.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_gravity="bottom"
    android:background="@color/purple_500"
    android:orientation="vertical"
    android:padding="15dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_marginTop="10dp"
        android:layout_marginBottom="10dp"
        android:text="Android Rion"
        android:textAppearance="@style/TextAppearance.AppCompat.Title"
        android:textColor="@color/white" />

    <TextView
        android:id="@+id/detail"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_marginTop="5dp"
        android:text="Jangan lupa untuk like, komen, share dan subscribe Channel YouTube Android Rion"
        android:textAppearance="@style/TextAppearance.AppCompat.Subhead"
        android:textColor="@color/white" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="15dp"
        android:gravity="right"
        android:orientation="horizontal">

        <Button
            android:id="@+id/bt_close"
            style="@style/TextAppearance.AppCompat.Widget.Button.Colored"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:backgroundTint="@color/white"
            android:text="CLOSE"
            android:textColor="@color/black" />

        <Button
            android:id="@+id/bt_subscribe"
            style="@style/TextAppearance.AppCompat.Widget.Button.Colored"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:backgroundTint="@color/white"
            android:text="SUBSCRIBE"
            android:textColor="@color/black" />
    </LinearLayout>
</LinearLayout>
```

- MainActivity.java
```java
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
```

---

```
Copyright 2021 M. Fadli Zein
```