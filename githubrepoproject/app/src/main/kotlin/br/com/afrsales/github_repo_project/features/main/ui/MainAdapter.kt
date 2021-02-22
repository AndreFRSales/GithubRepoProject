package br.com.afrsales.github_repo_project.features.main.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.afrsales.github_repo_project.databinding.ItemRepositoriesBinding
import br.com.afrsales.github_repo_project.features.main.models.Repository

class MainAdapter(
    private val onClick: (Repository) -> Unit
) :
    RecyclerView.Adapter<MainViewHolder>() {

    private var repositories: MutableList<Repository> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding =
            ItemRepositoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val repository = repositories[position]
        holder.bind(repository)
    }

    override fun getItemCount() = repositories.size

    fun setRepos(repositories: List<Repository>) {
        this.repositories.clear()
        this.repositories.addAll(repositories)
        notifyDataSetChanged()
    }
}


class MainViewHolder(
    private val binding: ItemRepositoriesBinding,
    private val onClick: (Repository) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(repository: Repository) {
        with(binding) {
            title.text = repository.name
            subtitle.text = repository.owner.name
            itemView.setOnClickListener { onClick(repository) }
        }
    }

}