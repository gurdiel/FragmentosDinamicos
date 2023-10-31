package com.mpd.pmdm.dynamicfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    //Atributos para acceder a las Views
    private val starSign: TextView?
        get() = view?.findViewById(R.id.star_sign)
    private val symbol: TextView?
        get() = view?.findViewById(R.id.symbol)
    private val dateRange: TextView?
        get() = view?.findViewById(R.id.date_range)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    /*
    Aquí recuperamos el valor de la clave STAR_SIGN_ID que se ha añadido como argumento
    al instanciar el fragmento (ver la función newInstance del companion object)
    y se pasa a setStarSignData.
    Se tiene que hacer en onViewCreated porque en setStarSignData se accede a las vistas
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val starSignId = arguments?.getInt(STAR_SIGN_ID, 0) ?: 0
        setStarSignData(starSignId)
    }

    /**
     * Cumplimenta la IU con los datos del signo
     */
    fun setStarSignData(starSignId: Int){
        when(starSignId){
            R.id.aquarius -> {
                starSign?.text = getString(R.string.aquarius)
                symbol?.text = getString(R.string.symbol,"Water Carrier")
                dateRange?.text = getString(R.string.date_range,
                    "January 20 - February 18")
            }
            R.id.pisces -> {
                starSign?.text = getString(R.string.pisces)
                symbol?.text = getString(R.string.symbol, "Fish")
                dateRange?.text = getString(R.string.date_range, "February 19 - March 20")
            }
            R.id.aries -> {
                starSign?.text = getString(R.string.aries)
                symbol?.text = getString(R.string.symbol, "Ram")
                dateRange?.text = getString(R.string.date_range, "March 21 - April 19")
            }
            R.id.taurus -> {
                starSign?.text = getString(R.string.taurus)
                symbol?.text = getString(R.string.symbol, "Bull")
                dateRange?.text = getString(R.string.date_range, "April 20 - May 20")
            }
            R.id.gemini -> {
                starSign?.text = getString(R.string.gemini)
                symbol?.text = getString(R.string.symbol, "Twins")
                dateRange?.text = getString(R.string.date_range, "May 21 - June 20")
            }
            R.id.cancer -> {
                starSign?.text = getString(R.string.cancer)
                symbol?.text = getString(R.string.symbol, "Crab")
                dateRange?.text = getString(R.string.date_range, "June 21 - July 22")
            }
            R.id.leo -> {
                starSign?.text = getString(R.string.leo)
                symbol?.text = getString(R.string.symbol, "Lion")
                dateRange?.text = getString(R.string.date_range, "July 23 - August 22")
            }
            R.id.virgo -> {
                starSign?.text = getString(R.string.virgo)
                symbol?.text = getString(R.string.symbol, "Virgin")
                dateRange?.text = getString(R.string.date_range, "August 23 - September 22")
            }
            R.id.libra -> {
                starSign?.text = getString(R.string.libra)
                symbol?.text = getString(R.string.symbol, "Scales")
                dateRange?.text = getString(R.string.date_range, "September 23 - October 22")
            }
            R.id.scorpio -> {
                starSign?.text = getString(R.string.scorpio)
                symbol?.text = getString(R.string.symbol, "Scorpion")
                dateRange?.text = getString(R.string.date_range, "October 23 - November 21")
            }
            R.id.sagittarius -> {
                starSign?.text = getString(R.string.sagittarius)
                symbol?.text = getString(R.string.symbol, "Archer")
                dateRange?.text = getString(R.string.date_range, "November 22 - December 21")
            }
            R.id.capricorn -> {
                starSign?.text = getString(R.string.capricorn)
                symbol?.text = getString(R.string.symbol, "Mountain Goat")
                dateRange?.text = getString(R.string.date_range, "December 22 - January 19")
            }
            else -> {
                Toast.makeText(context, getString(R.string.unknown_star_sign), Toast.LENGTH_LONG).show()
            }
        }
    }
    companion object {
        private const val STAR_SIGN_ID = "STAR_SIGN_ID"

        /*
        Función pública y estática, que
        toma como entrada una starSignId, crea una nueva instancia del
        DetailFragment, y añade el starSignId en un nuevo Bundle
        Se hace igual que con intent.extras, con pares clave/valor

        Es un static factory method: un método estático de la clase que nos genera
        instancias de la misma, como alternativa al uso de constructores. Es un constrcutor
        más flexible, que hace lo que nos dé la gana. En este caso, recoger directamente el argumento
         */
        @JvmStatic
        fun newInstance(starSignId: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    //Guardamos el id del signo del zodiaco
                    putInt(STAR_SIGN_ID, starSignId)
                }
            }
    }
}