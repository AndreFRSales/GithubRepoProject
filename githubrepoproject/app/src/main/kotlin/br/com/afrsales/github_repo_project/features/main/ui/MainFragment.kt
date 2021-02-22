package br.com.afrsales.github_repo_project.features.main.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.afrsales.github_repo_project.R
import br.com.afrsales.github_repo_project.databinding.FragmentMainBinding
import br.com.afrsales.github_repo_project.extensions.gone
import br.com.afrsales.github_repo_project.extensions.viewBinding
import br.com.afrsales.github_repo_project.extensions.visible
import br.com.afrsales.github_repo_project.features.main.models.Repository
import org.koin.androidx.viewmodel.ext.android.stateViewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainViewModel by stateViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupSearchView()
        setupRetry()
    }

    private fun setupRetry() {
        binding.mainErrorState.errorButton.setOnClickListener {
            val text = binding.mainSearchView.query.toString()
            viewModel.retry(text)
        }
    }

    private fun setupSearchView() {
        binding.mainSearchView.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let {
                        viewModel.fetchRepos(it)
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                }

            })

            queryHint = getString(R.string.main_query_string)
        }

    }

    private fun setupObservers() {
        viewModel.viewModelState.observe(viewLifecycleOwner, {
            with(binding) {
                when (it) {
                    is MainViewModelState.Loading -> {
                        mainErrorState.root.gone()
                        mainLoading.visible()
                    }
                    is MainViewModelState.Data -> {
                        updateList(it.repositories)
                        mainRecyclerView.visible()
                        binding.mainErrorState.root.gone()
                        binding.mainLoading.gone()
                    }
                    is MainViewModelState.Error -> {
                        mainErrorState.root.visible()
                        mainLoading.gone()
                        mainRecyclerView.gone()
                    }
                }
            }

        })
    }

    private fun updateList(repositories: List<Repository>) {
        with(binding.mainRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            if(adapter == null) {
                val mainAdapter =  MainAdapter {
                    findNavController().navigate(MainFragmentDirections.homeToDetail(it))
                }
                mainAdapter.setRepos(repositories)
                adapter = mainAdapter
            } else {
                (adapter as MainAdapter).setRepos(repositories)
            }
        }


    }
}