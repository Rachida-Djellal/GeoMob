package com.example.geomob.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.geomob.Activities.PaysActivity
import com.example.geomob.Adapters.VideoAdapter
import com.example.geomob.DataClasses.*
import com.example.geomob.Other.RequestHandler

import com.example.geomob.R
import kotlinx.android.synthetic.main.fragment_videos.*

class VideosFragment : Fragment() {

    private var countryCode = ""
    private var countryName = ""
    var videoList = arrayListOf<PaysVideo>()

    lateinit var videoAdapter: VideoAdapter
    lateinit var layoutManager : LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryCode = (activity as PaysActivity).getCountryCode()
        countryName = (activity as PaysActivity).getCountryName()

        recyclerView.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager

        videoAdapter = VideoAdapter(activity!! as PaysActivity, videoList)
        recyclerView.adapter = videoAdapter


        val videoUrl = "https://www.googleapis.com/youtube/v3/search?key=AIzaSyBAZcxVrHs8w3EHcxlaE2H1ahtGxnzR-_E&q=$countryName&maxResults=20&type=video&safeSearch=strict&part=snippet"
        val jsonRequestVideos = JsonObjectRequest(
            Request.Method.GET, videoUrl, null,
            Response.Listener { response ->
                videoList.clear()
                val items = response.getJSONArray("items")
                for (i in 0 until items.length()){
                    val video = items.getJSONObject(i)
                    val id = video.getJSONObject("id").getString("videoId")
                    val title = video.getJSONObject("snippet").getString("title")
                    videoList.add(PaysVideo(id, title, countryCode))
                }
                videoAdapter.notifyDataSetChanged()
            },
            Response.ErrorListener {

            })

        RequestHandler.getInstance(activity!!).addToRequestQueue(jsonRequestVideos)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_videos, container, false)
    }
}
