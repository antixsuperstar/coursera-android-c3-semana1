package net.mk05.matdesign;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by marc05 on 19/07/17.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.activity_cv_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, final int position) {
        final Mascota estaMascota = mascotas.get(position);
        holder.txtTotalMeGusta.setText(String.valueOf(estaMascota.getCuantosMeGusta()));
        holder.txtNombreMascota.setText(estaMascota.getNombre());
        holder.imgMascota.setImageResource(estaMascota.getFoto());

        holder.btnMeGusta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Mascota> favoritas = ((GlobalState)activity.getApplication()).ultimasMascotasFavoritas;

                if( favoritas.size() >= 5 ) {
                    do {
                        favoritas.remove(0);
                    } while (favoritas.size() >= 5);
                } else {
                    favoritas.add(estaMascota);
                }
                Toast.makeText(view.getContext(), "Ahora te gusta '" + estaMascota.getNombre() + "'", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMascota;
        private ImageView imgMeGusta;
        private TextView txtNombreMascota;
        private TextView txtTotalMeGusta;
        private ImageButton btnMeGusta;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgMascota          = (ImageView)itemView.findViewById(R.id.cvMascotaImg);
            imgMeGusta          = (ImageView)itemView.findViewById(R.id.cvMascotaMeGusta);
            txtNombreMascota    = (TextView)itemView.findViewById(R.id.cvMascotaNombre);
            txtTotalMeGusta     = (TextView)itemView.findViewById(R.id.cvMascotaCuantosGustos);
            btnMeGusta          = (ImageButton)itemView.findViewById(R.id.cvMascotaMeGusta);
        }
    }
}
