package com.arash.altafi.swipebutton.sample5

import android.widget.TextView
import android.os.Handler
import co.mobiwise.library.ProgressLayout
import androidx.recyclerview.widget.RecyclerView
import co.mobiwise.library.ProgressLayout.ProgressLayoutListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.arash.altafi.swipebutton.R
import java.lang.StringBuilder

class RecylerListAdapter : RecyclerView.Adapter<RecylerListAdapter.ViewHolder>() {
    /**
     * Track list
     */
    private var trackList: List<Track>? = null

    /**
     * need to keep current playing.
     */
    private var currentTrack: Track? = null

    /**
     * Current duration
     */
    private var currentDuration = 0

    /**
     * is currently playing
     */
    private var isPlaying = false

    /**
     * needed handler for recyclerview
     */
    private val mHandler: Handler = Handler()

    /**
     * count up second
     */
    private val mRunnable: Runnable = object : Runnable {
        override fun run() {
            currentDuration += 1
            mHandler.postDelayed(this, SECOND_MS.toLong())
        }
    }

    fun setTrackList(trackList: List<Track>?) {
        this.trackList = trackList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val track: Track = trackList!![i]
        viewHolder.textViewDuration.text = calculateSongDuration(track.durationInSec)
        viewHolder.textViewSong.setText(track.songName)
        viewHolder.textViewSinger.setText(track.singerName)
        viewHolder.imageViewAction.setBackgroundResource(R.drawable.play)
        viewHolder.progressLayout.setMaxProgress(track.durationInSec)
        if (currentTrack != null && currentTrack === track) {
            viewHolder.imageViewAction.setBackgroundResource(
                if (isPlaying) R.drawable.pause else R.drawable.play
            )
            viewHolder.progressLayout.setCurrentProgress(currentDuration)
            if (isPlaying) viewHolder.progressLayout.start()
        } else {
            viewHolder.progressLayout.cancel()
        }
        viewHolder.imageViewAction.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (track !== currentTrack) {
                    currentTrack = track
                    mHandler.removeCallbacks(mRunnable)
                    currentDuration = 0
                }
                if (!viewHolder.progressLayout!!.isPlaying) {
                    isPlaying = true
                    viewHolder.progressLayout!!.start()
                    mHandler.postDelayed(mRunnable, 0)
                    viewHolder.imageViewAction.setBackgroundResource(R.drawable.pause)
                    notifyDataSetChanged()
                } else {
                    isPlaying = false
                    viewHolder.progressLayout!!.stop()
                    mHandler.removeCallbacks(mRunnable)
                    viewHolder.imageViewAction.setBackgroundResource(R.drawable.play)
                    notifyDataSetChanged()
                }
            }
        })
        viewHolder.progressLayout.setProgressLayoutListener(object : ProgressLayoutListener {
            override fun onProgressCompleted() {
                viewHolder.imageViewAction.setBackgroundResource(R.drawable.play)
            }

            override fun onProgressChanged(seconds: Int) {
                viewHolder.textViewDuration.text = calculateSongDuration(seconds)
            }
        })
    }

    /**
     * List count
     */
    override fun getItemCount(): Int {
        return trackList!!.size
    }

    /**
     * Calculate in string (hh:mm)
     */
    private fun calculateSongDuration(seconds: Int): String {
        return StringBuilder((seconds / 60).toString())
            .append(":")
            .append((seconds % 60).toString())
            .toString()
    }

    /**
     * ViewHolder
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageViewAction: ImageView = itemView.findViewById(R.id.imageviewAction)
        var progressLayout: ProgressLayout = itemView.findViewById(R.id.progressLayout)
        var textViewSong: TextView = itemView.findViewById(R.id.textviewSong)
        var textViewSinger: TextView = itemView.findViewById(R.id.textviewSinger)
        var textViewDuration: TextView = itemView.findViewById(R.id.textviewDuration)
    }

    companion object {
        private const val SECOND_MS = 1000
    }
}