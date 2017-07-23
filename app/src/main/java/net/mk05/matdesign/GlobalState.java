package net.mk05.matdesign;

import android.app.Application;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Marcos on 18/07/2017.
 */

class Mascota
{
    protected String nombre;
    protected int cuantosMeGusta;
    protected int foto;

    public Mascota(String nombre, int cuantosGusta, int foto) {
        this.nombre = nombre;
        this.cuantosMeGusta = cuantosGusta;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuantosMeGusta() {
        return cuantosMeGusta;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

/**
 * Esta clase se instancia y se ejecuta cuando se lanza la aplicación,
 * inicializando la variable misMascotas y haciéndola accesible desde cualquier
 * parte de la aplicación, para no tener que usar Bundles entre actividades.
 */
public class GlobalState extends Application {
    // Genera un número aleatorio entre 0 y 100
    private int likes() { return (int) (20*Math.random()); }
    public ArrayList<Mascota> misMascotas;
    public ArrayList<Mascota> ultimasMascotasFavoritas;

    @Override
    public void onCreate() {
        super.onCreate();

        misMascotas = new ArrayList<Mascota>();
        misMascotas.add(new Mascota("Beagle", likes(), R.drawable.dog_beagle));
        misMascotas.add(new Mascota("Husky", likes(), R.drawable.dog_husky));
        misMascotas.add(new Mascota("DJ", likes(), R.drawable.dog_music));
        misMascotas.add(new Mascota("Bolt", likes(), R.drawable.dog_movie));
        misMascotas.add(new Mascota("Meme", likes(), R.drawable.dog_meme));
        misMascotas.add(new Mascota("Odie", likes(), R.drawable.dog_odie));
        misMascotas.add(new Mascota("Ayudante de Santa", likes(), R.drawable.dog_santa_s_little_helper));
        misMascotas.add(new Mascota("Caliente", likes(), R.drawable.dog_hotdog));

        ultimasMascotasFavoritas = new ArrayList<>();
    }
}