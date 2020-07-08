package com.example.geomob.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geomob.Activities.PaysActivity
import com.example.geomob.Adapters.TweetAdapter
import com.example.geomob.DataClasses.Tweet
import com.example.geomob.R
import com.example.geomob.Threads.AppExecutors
import kotlinx.android.synthetic.main.fragment_videos.*
import twitter4j.*
import twitter4j.conf.ConfigurationBuilder


class TweetsFragment : Fragment() {

    private var countryCode = ""
    private var countryName = ""
    var tweetList = arrayListOf<Tweet>()

    lateinit var tweetAdapter: TweetAdapter
    lateinit var layoutManager : LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryCode = (activity as PaysActivity).getCountryCode()
        countryName = (activity as PaysActivity).getCountryName()

        recyclerView.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager

        tweetAdapter = TweetAdapter(activity!! as PaysActivity, tweetList)
        recyclerView.adapter = tweetAdapter


        initTwitter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tweets, container, false)
    }
    
    fun initTwitter(){
        AppExecutors.instance!!.diskIO().execute {
            val consumerKey = "Na9iLBHIupFXEoGwQL0zyaSEs"
            val consumerKeySecret = "CuK8ZUmFSY9VU4Xw0s5YSwgMvhyM4FjN2dywbqLNwaC05wyHkv"
            val accessToken = "1223554396883124224-eQ73Yq9Iw2573F46R7I4nSQMNRXScV"
            val accessTokenSecret = "DLCjwJkm9vxJjqqoYM92oEgDDOrV5J2YEkhvIHA6NAGMb"


            val cb = ConfigurationBuilder()
            cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerKeySecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret)

            val tf = TwitterFactory(cb.build())
            val twitter = tf.instance

            searchQuery(twitter,countryName)
        }

    }
    
    fun searchQuery(twitter : Twitter, query : String){
        try {
            val query = Query(query)
            val result: QueryResult
            tweetList.clear()
            query.count = 30
            query.lang = "en"
            result = twitter.search(query)
            for (status in result.tweets) {
                var mediaUrl = ""
                if (status.mediaEntities.isNotEmpty()){
                    mediaUrl = status.mediaEntities[0].mediaURLHttps
                }
                val tweet = Tweet(status.id, status.user.originalProfileImageURLHttps, status.user.name, "@"+status.user.screenName,
                mediaUrl, status.text, countryCode)
                tweetList.add(tweet)
            }

            AppExecutors.instance!!.mainThread().execute {
                tweetAdapter.notifyDataSetChanged()
            }

        } catch (e: TwitterException) {
            e.printStackTrace()
        }
    }
}
