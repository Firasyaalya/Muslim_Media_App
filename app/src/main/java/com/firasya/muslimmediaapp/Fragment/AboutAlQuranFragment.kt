package com.firasya.muslimmediaapp.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.firasya.muslimmediaapp.NewsViewModel
import com.firasya.muslimmediaapp.adapter.NewsAdapter
import com.firasya.muslimmediaapp.databinding.FragmentAboutAlQuranBinding

class AboutAlQuranFragment : Fragment() {
    private var _binding: FragmentAboutAlQuranBinding? = null
    private val binding get() = _binding as FragmentAboutAlQuranBinding

    private var _quranNewsViewModel: NewsViewModel? = null
    private val quranNewsViewModel get() = _quranNewsViewModel as NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutAlQuranBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingView.root.visibility = View.VISIBLE
        _quranNewsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        quranNewsViewModel.aboutAlQuranNews()
        quranNewsViewModel.aboutAlQuranNews.observe(viewLifecycleOwner){
            val mAdapter = NewsAdapter()
            mAdapter.setData(it.articles)
            Log.i(
                "AboutAlquranFragment",
                "onViewCreated: ${it.articles}"
            )
            binding.rvAlquran.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(view.context)
            }
            binding.loadingView.root.visibility = View.GONE
        }
    }
//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }
}