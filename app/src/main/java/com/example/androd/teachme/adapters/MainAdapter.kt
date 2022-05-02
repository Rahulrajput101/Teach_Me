package com.example.androd.teachme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androd.teachme.databinding.ItemViewBinding


//class MainAdapter(val mainList: List<Courses>) :
//    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
//
//    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainViewHolder {
//        // inflates the card_view_design view
//        // that is used to hold list item
//        val view = LayoutInflater.from(p0.context)
//            .inflate(R.layout.item_view, p0, false)
//        return MainViewHolder(view)
//
//    }
//
//    override fun onBindViewHolder(p0: MainViewHolder, p1: Int) {
//        //p0.textTitle.text=mainList[p1]
//        //p0.image.setImageResource(mainList[p1])
//        //val Courses=mainList[p1]
//
//        p0.image.setImageResource(mainList[p1].adapterImage)
//        p0.textHeadline.text = mainList[p1].title
//        p0.textSubHeadline.text = mainList[p1].subTitle
//    }
//
//    override fun getItemCount(): Int {
//
//        return mainList.size
//
//    }
//
//    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var textHeadline = itemView.findViewById<TextView>(R.id.headline)
//        var image: ImageView = itemView.findViewById(R.id.item_image)
//        var textSubHeadline: TextView = itemView.findViewById(R.id.sub_headline)
//
//
//
//
//    }
//}


class MainAdapter(val mainList: List<Courses>) :RecyclerView.Adapter<MainAdapter.MainViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        return (MainViewHolder.From(parent))


    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        holder.bind(mainList[position],position)
    }

    override fun getItemCount(): Int {
        return mainList.size
    }


    class MainViewHolder(private val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {

            fun From(parent: ViewGroup): MainViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemViewBinding.inflate(inflater, parent, false)

                return MainViewHolder(binding)

            }

        }

        fun bind(courses: Courses,position: Int) {
            binding.headline.text = courses.title
            binding.subHeadline.text = courses.subTitle
            binding.itemImage.setImageDrawable(
                ContextCompat.getDrawable(binding.root.context, courses.adapterImage)
            )

            when(position % 6){

                0-> binding.offerItemCardView.setCardBackgroundColor(ContextCompat.getColor(binding.root.context,R.color.redbackground))
                1-> binding.offerItemCardView.setCardBackgroundColor(ContextCompat.getColor(binding.root.context,R.color.pinkbackground))
                2-> binding.offerItemCardView.setCardBackgroundColor(ContextCompat.getColor(binding.root.context,R.color.purplebackground))
                3-> binding.offerItemCardView.setCardBackgroundColor(ContextCompat.getColor(binding.root.context,R.color.bluebackground))
                4-> binding.offerItemCardView .setCardBackgroundColor(ContextCompat.getColor(binding.root.context,R.color.greenbackground))
                5-> binding.offerItemCardView.setCardBackgroundColor(ContextCompat.getColor(binding.root.context,R.color.yellowbackground))



            }
            when(position %6){
                0-> binding.sideCardView.setCardBackgroundColor(ContextCompat.getColor(binding.root.context,R.color.redbackground))
                1-> binding.sideCardView.setCardBackgroundColor(ContextCompat.getColor(binding.root.context,R.color.pinkbackground))
                2-> binding.sideCardView.setCardBackgroundColor(ContextCompat.getColor(binding.root.context,R.color.purplebackground))
                3-> binding.sideCardView.setCardBackgroundColor(ContextCompat.getColor(binding.root.context,R.color.bluebackground))
                4-> binding.sideCardView.setCardBackgroundColor(ContextCompat.getColor(binding.root.context,R.color.greenbackground))
                5-> binding.sideCardView.setCardBackgroundColor(ContextCompat.getColor(binding.root.context,R.color.yellowbackground))
            }


        }


    }
}
