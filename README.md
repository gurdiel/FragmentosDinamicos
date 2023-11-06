# Fragmentos Dinamicos
Ejemplo de navegación en android usando carga de fragmentos dinámica (cambiando en tiempo de ejecución).

En este caso sólo hay un layout, para un único tamaño de pantalla. Es el mismo ejemplo adaptado de [Dual Panel Layout](https://github.com/mcventur/DualPaneLayouts)



 - En el activity_main.xml ya no usamos elementos \<fragment>, 
que están orientados al uso de fragmentos estáticos, 
sino que usamos un \<FragmentContainerView>, que está 
orientado al uso de fragmentos dinámicos.

 _Nota: realmente podríamos haber usado también este FragmentContainerView 
para hacer de contenedor de los fragmentos estáticos, simplemente indicando el 
atributo android_name: para indicar el nombre cualificado de la clase correspondiente
al fragmento._

- Para cambiar, añadir o quitar un fragmento en un FragmentContainerView, usaremos FragmentTransactions. Os recomiendo leer este manual previamente y compararlo con el código de este proyecto: https://developer.android.com/guide/fragments/create?hl=es-419#add-programmatic
  - En esta aplicación hay dos transacciones:
    - Añadir el fragmento inicial ListFragment en el  onCreate de MainActivity añade el fragmento inicial:
    ```     
        if (savedInstanceState == null) {
              val fragmentContainer = findViewById<FragmentContainerView>(R.id.fragment_container)
              val listFragment = ListFragment()
              supportFragmentManager
                  .beginTransaction() //empezar una transacción
                  .add(fragmentContainer.id, listFragment)
                  .commit()
        }
    ```
    Nótese que todo el código está encerrado en un if que controla que la llamada al onCreate no se produzca por una reconfiguración.
    - Reemplazar el fragmento actual (ListFragment) por otro (DetailFragment), en la función onSelected de MainActivity, que hace de Listener para cualquier pulsación sobre un signo realizada en ListFragment.
    En este caso, vemos además como se usa la función _newInstance()_, un [static factory method](https://stackoverflow.com/questions/27101185/fragment-and-factory-method#:~:text=by%20static%20factory%20method%2C%20you,to%20know%20what%20keys%20are.) que nos genera Android para instanciar fragmentos
  
      Los detalles sobre el uso de interfaces y listeners como elemento de comunicación entre fragmentos y actividades están explicados en [Dual Panel Layout](https://github.com/mcventur/DualPaneLayouts)     

Más info sobre transacciones:https://developer.android.com/guide/fragments/transactions?hl=es-419#add-remove


