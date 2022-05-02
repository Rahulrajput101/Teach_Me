package com.example.androd.teachme

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment

import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androd.teachme.dataClass.words

import com.example.androd.teachme.databinding.FragmentMainBinding
import com.example.androd.teachme.viewModel.MainViewModel
import com.example.androd.teachme.viewModel.MainViewModelFactory

class MainFragment : Fragment() {




     private lateinit var mainViewModel : MainViewModel
     private lateinit var viewModelFactory: MainViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

       val binding: FragmentMainBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)

        viewModelFactory= MainViewModelFactory(requireContext())
        mainViewModel=ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)


       // setWords(mainViewModel.getWord())








        val courses : MutableList<Courses> = mutableListOf<Courses>()
//        val courses=ArrayList<Courses>()
        courses.add( Courses("Day 1","A, An and The",R.drawable.angrybird1))
        courses.add( Courses("Day 2","A, An and The",R.drawable.angrybird3))
        courses.add( Courses("Day 3","A, An and The",R.drawable.angrybird4))
        courses.add( Courses("Day 4","A, An and The",R.drawable.angrybird5))
        courses.add( Courses("Day 5","A, An and The",R.drawable.angrybird6))
        courses.add( Courses("Day 2","A, An and The",R.drawable.angrybird8))
       //val main= intArrayOf(R.drawable.angrybird1 ,R.drawable.angrybird1,R.drawable.angrybird1,R.drawable.angrybird1,R.drawable.angrybird1,R.drawable.angrybird1)
       // val main: List<String> = listOf("hello","hey","hui","heeee","hi","hello","hey","hui","heeee","hi")
        binding.recyclerView.adapter=MainAdapter(courses)
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
//        recyclerView.adapter=MainAdapter(main)
//        recyclerView.layoutManager=LinearLayoutManager(context)



        setHasOptionsMenu(true)
        return binding.root

    }

//     fun setWords(word: words) {
//         binding.wordText.text=word.text
//         binding.cateogryText.text=word.cateogry
//         binding.meaningText.text=word.meaning
//
//    }
//    fun onNext(view : View){
//        setWords(mainViewModel.nextWord())
//    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
        requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }











}