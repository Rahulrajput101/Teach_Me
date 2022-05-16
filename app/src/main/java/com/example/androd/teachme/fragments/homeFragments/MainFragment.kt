package com.example.androd.teachme

import android.os.Bundle
import android.view.*

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androd.teachme.dataClass.words
import com.example.androd.teachme.databinding.FragmentMainBinding
import com.example.androd.teachme.viewModel.MainViewModel

class MainFragment : Fragment() {


    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        listName()
        bindWord(mainViewModel.getWord())
        changeWordClickListener()

        setHasOptionsMenu(true)
        return binding.root

    }

    private fun changeWordClickListener() {
        binding.floatingbutton.setOnClickListener {
            bindWord(mainViewModel.randomWord())
        }
    }

    private fun bindWord(words: words) {
        binding.wordText.text=words.text
        binding.cateogryText.text=words.cateogry
        binding.meaningText.text=words.meaning
    }

    private fun listName() {
        val courses: MutableList<Courses> = mutableListOf<Courses>()

        courses.add(Courses("Day 1", "A, An and The", R.drawable.angrybird1))
        courses.add(Courses("Day 2", "A, An and The", R.drawable.angrybird3))
        courses.add(Courses("Day 3", "A, An and The", R.drawable.angrybird4))
        courses.add(Courses("Day 4", "A, An and The", R.drawable.angrybird5))
        courses.add(Courses("Day 5", "A, An and The", R.drawable.angrybird6))
        courses.add(Courses("Day 6", "A, An and The", R.drawable.angrybird8))

        binding.recyclerView.adapter = MainAdapter(courses)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}