package br.com.afrsales.github_repo_project.features.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.afrsales.github_repo_project.R
import br.com.afrsales.github_repo_project.databinding.FragmentDetailBinding
import br.com.afrsales.github_repo_project.extensions.viewBinding
import coil.load

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args by lazy {
        arguments?.let {
            DetailFragmentArgs.fromBundle(it)
        }
    }

    private val binding by viewBinding(FragmentDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupScreen()
    }

    private fun setupScreen() {
        setupToolbar()
        loadAvatar()
        setupTexts()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun loadAvatar() {
        args?.repository?.run {
            binding.avatar.load(owner.avatarUrl) {
                crossfade(true)
            }
        }
    }

    private fun setupTexts() {
        with(binding) {
            args?.repository?.run {
                repoName.text = name
                repoOwner.text = owner.name
                repoDescription.text = description
            }
        }
    }
}