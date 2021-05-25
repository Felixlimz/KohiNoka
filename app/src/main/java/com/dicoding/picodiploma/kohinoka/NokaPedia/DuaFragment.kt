package com.dicoding.picodiploma.kohinoka.NokaPedia

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.kohinoka.databinding.FragmentPediaBinding

class DuaFragment : Fragment(){
    private lateinit var connectBinding : FragmentPediaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        connectBinding = FragmentPediaBinding.inflate(inflater,container,false)
        return connectBinding.root
    }

    private fun pageLoad(state : Boolean){
        if (state){
            connectBinding.MyProgressBar.visibility = View.VISIBLE
        }
        else{
            connectBinding.MyProgressBar.visibility = View.GONE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            pageLoad(true)
            val modelShow = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[PediaViewModel::class.java]
            val pedia = modelShow.getPedia()
            val matchAdapter = PediaAdapter()
            matchAdapter.setData(pedia)
            pageLoad(false)

            with(connectBinding.recycleFragmentMovie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = matchAdapter
            }

            matchAdapter.setOnItemClickCallback(object : PediaAdapter.OnItemClickCallback{
                override fun onItemClicked(user: DataPedia) {
                    val goIntent = Intent(activity, DetailPediaActivity::class.java)
                    goIntent.putExtra(DetailPediaActivity.EXTRA_DATA, user )
                    startActivity(goIntent)
                }

            })
        }
    }
}