package com.mpd.pmdm.dynamicfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView

const val STAR_SIGN_ID = "STAR_SIGN_ID"
interface StarSignListener {
    /**
     * Se lanzará cuando se seleccione un signo desde el ListFragment
     */
    fun onSelected(id: Int)
}

class MainActivity : AppCompatActivity(), StarSignListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Si savedInstanceState no es null, significa que es una reconfiguración (ej: girar la pantalla),
        //por lo que ya no es necesario volver a añadir el fragmento inicial
        if (savedInstanceState == null) {
            //Referenciamos el FragmentContainerView del activity_main
            val fragmentContainer = findViewById<FragmentContainerView>(R.id.fragment_container)
            //Construímos un nuevo ListFragment
            val listFragment = ListFragment()
            //Le indicamos al controlador de fragmentos supportFragmentManager
            // que queremos añadir un nuevo fragmento ListFragment al contenedor
            supportFragmentManager
                .beginTransaction() //empezar una transacción
                .add(fragmentContainer.id, listFragment)//qué transacción? añadir un fragmento al contenedor
                .commit()//confirmar transacción
        }
    }

    override fun onSelected(starSignId: Int) {
        val fragmentContainer = findViewById<FragmentContainerView>(R.id.fragment_container)
        //Instanciamos el detailFragment, pasándole el id al factory method
        val detailFragment = DetailFragment.newInstance(starSignId)
        supportFragmentManager
            .beginTransaction()
            .replace(fragmentContainer.id,detailFragment)//reemplazamos el fragmento actual del contenedor por un DetailFragment
            .addToBackStack(null)//Con esto le decimos que el botón atrás no salga de la aplicación, sino que vuelva al fragmento anterior
            .commit()
    }
}