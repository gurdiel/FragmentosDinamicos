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

        if (savedInstanceState == null) {
            //Referenciamos el FragmentContainerView del activity_main
            val fragmentContainer = findViewById<FragmentContainerView>(R.id.fragment_container)
            //Construímos un nuevo ListFragment
            val listFragment = ListFragment()
            //Le indicamos al controlar de fragmento supportFragmentManager que queremos añadir un nuevo fragmento al FragmentContainer referenciado
            supportFragmentManager.beginTransaction().add(fragmentContainer.id, listFragment)
        }
    }

    override fun onSelected(id: Int) {
        //TODO
    }
}