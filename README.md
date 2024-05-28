# Proyecto Alke Wallet

## Descripción
Alke Wallet es una billetera virtual desarrollada para una importante empresa financiera. La aplicación permite a los usuarios realizar un seguimiento de sus tarjetas y gastos, así como realizar pagos virtuales. Este proyecto se encuentra actualmente en desarrollo, pero ya cuenta con un esqueleto funcional y una lógica de comunicación establecida entre la capa de Vista (View) y el Modelo de Vista (ViewModel).

## Funcionalidades Implementadas

1. **Vista de Inicio**
   - Saludo personalizado al usuario.
   - Visualización del balance total del usuario.
   - Botones para enviar e ingresar dinero.
   - Listado de las últimas transacciones realizadas.

2. **Lista de Transacciones**
   - Cada transacción muestra:
     - Imagen del usuario.
     - Nombre del usuario.
     - Fecha de la transacción.
     - Cantidad transferida.

## Arquitectura del Proyecto

El proyecto sigue el patrón de arquitectura MVVM (Model-View-ViewModel) para asegurar una separación clara de responsabilidades y facilitar el mantenimiento del código.

### Vista (View)

La capa de vista está compuesta por fragmentos y actividades que se encargan de mostrar la interfaz de usuario. Utilizamos `FragmentA5HomeBinding` para vincular la vista con el layout correspondiente.

```kotlin
class A5Home : Fragment() {
    private lateinit var transferenciaViewModel: TransferenciaViewModel
    private var _binding: FragmentA5HomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentA5HomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Configuración de ViewModel y RecyclerView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
```
### ViewModel
El TransferenciaViewModel gestiona la lógica de negocio y proporciona los datos necesarios a la vista. Utiliza LiveData para observar los cambios en los datos y actualizar la interfaz de usuario automáticamente.
```kotlin
class TransferenciaViewModel(private val transferenciaRepository: TransferenciaRepository) : ViewModel() {

    private val _transferencias = MutableLiveData<List<Transferencia>>()
    val transferencias: LiveData<List<Transferencia>> get() = _transferencias

    init {
        loadTransferencias()
    }

    private fun loadTransferencias() {
        _transferencias.value = transferenciaRepository.getListaTransferencias()
    }
}
```
### Repositorio
El TransferenciaRepository se encarga de obtener los datos necesarios para el ViewModel. En este caso, utilizamos un dataset simulado para las transferencias.
```
class TransferenciaRepository {
    fun getListaTransferencias(): List<Transferencia> {
        // Retornar lista de transferencias simulada
    }
}
```
### Adapter del RecyclerView
El TransferenciaAdapter gestiona la visualización de cada ítem en la lista de transferencias.
```
class TransferenciaAdapter(private val transferencias: List<Transferencia>) : RecyclerView.Adapter<TransferenciaAdapter.TransferenciaViewHolder>() {

    class TransferenciaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val nombreTextView: TextView = itemView.findViewById(R.id.text_view_nombre)
        val fechaTextView: TextView = itemView.findViewById(R.id.text_view_fecha)
        val cantidadTextView: TextView = itemView.findViewById(R.id.text_view_cantidad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferenciaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_transferencia, parent, false)
        return TransferenciaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TransferenciaViewHolder, position: Int) {
        val currentItem = transferencias[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.nombreTextView.text = currentItem.nombre
        holder.fechaTextView.text = currentItem.fecha
        holder.cantidadTextView.text = currentItem.cantidad.toString()
    }

    override fun getItemCount() = transferencias.size
}
```
### Próximos Pasos
- Implementar la lógica para realizar transferencias y actualizar el balance.
- Añadir registro de usuario.
- Mejorar la interfaz de usuario según los diseños proporcionados en Figma.
- Realizar pruebas unitarias y de integración para asegurar el correcto funcionamiento de la aplicación.
- Documentar todas las funcionalidades y componentes desarrollados.

