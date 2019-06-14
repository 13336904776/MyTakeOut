package com.zfy.mytakeout.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.zfy.mytakeout.R
import java.util.*

/**
 *
 */
class HomeAdapter(val mContext: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val TYPE_TOP = 0
        val TYPE_ITEM = 1
    }

    var list = ArrayList<String>()

    fun setData(list: ArrayList<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        when (position) {
            0 -> return TYPE_TOP
            else -> return TYPE_ITEM
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, type: Int): RecyclerView.ViewHolder {
        val view: View
        when (type) {
            TYPE_TOP -> {
                view = View.inflate(mContext, R.layout.item_title, null)
                return HomeTopViewholder(view)
            }
            else -> {
                view = View.inflate(mContext, R.layout.item_seller, null)
                return HomeTopViewholder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (list.size == 0) 0 else list.size + 1
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, position: Int) {
        val itemViewType = getItemViewType(position)
        when (itemViewType) {
            TYPE_TOP -> {
                val homeTopViewholder = p0 as HomeTopViewholder

//网络加载例子
                val networkImages: List<String> = arrayListOf("http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg"
                        , "http://tvfiles.alphacoders.com/100/hdclearart-10.png"
                        , "http://cdn3.nflximg.net/images/3093/2043093.jpg"
                        , "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg")

//                homeTopViewholder.cvBanner.setPages(object : CBViewHolderCreator<NetworkImageHolderView>() {
//                    @Override
//                    public NetworkImageHolderView createHolder()
//                    {
//                        return new NetworkImageHolderView ();
//                    }
//                }, networkImages);
//                homeTopViewholder.cvBanner.setPages(CBViewHolderCreator<NetworkI>())
            }
            else -> {
            }
        }
    }

    inner class HomeItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val textView:TextView
//        init {
//            textView = itemView.findViewById<TextView>(R.id.tv)
//        }
    }

    inner class HomeTopViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cvBanner: ConvenientBanner<String>

        init {
            cvBanner = itemView.findViewById<ConvenientBanner<String>>(R.id.convenientBanner)
        }
    }
}