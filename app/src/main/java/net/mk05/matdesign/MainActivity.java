package net.mk05.matdesign;

import android.graphics.Point;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ajustar el ancho del ScrollView a la pantalla del dispositivo, al no poder hacerse desde el XML
        ScrollView myView = (ScrollView)findViewById(R.id.listaPrincipal);
        ConstraintLayout.LayoutParams p = (ConstraintLayout.LayoutParams)myView.getLayoutParams();
        Point tamanio = new Point();

        getWindowManager().getDefaultDisplay().getSize(tamanio);
        p.width = tamanio.x;
        myView.setLayoutParams(p);
    }
}
