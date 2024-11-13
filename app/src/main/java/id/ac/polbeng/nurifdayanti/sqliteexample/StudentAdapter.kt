package id.ac.polbeng.nurifdayanti.sqliteexample
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.polbeng.nurifdayanti.sqliteexample.databinding.ItemListBinding
class StudentAdapter (private val studentList:
                      ArrayList<StudentModel>):
    RecyclerView.Adapter<StudentAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback:
                               OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: StudentModel)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ListViewHolder {
        val binding =
            ItemListBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
        return ListViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position:
    Int) {
        val (nim, name, _) = studentList[position]
        holder.binding.tvNIM.text = "NIM : $nim"
        holder.binding.tvNama.text = "Nama : $name"
        holder.itemView.setOnClickListener {

            onItemClickCallback.onItemClicked(studentList[holder.adapterPosition])
        }
    }
    override fun getItemCount(): Int = studentList.size
    inner class ListViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root)
}
