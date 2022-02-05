package com.arash.altafi.swipebutton.sample5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.swipebutton.R
import kotlinx.android.synthetic.main.activity_sample5.*
import androidx.recyclerview.widget.LinearLayoutManager

class Sample5 : AppCompatActivity() {

    private var recylerListAdapter: RecylerListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample5)

        init()
    }

    private fun init() {

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recylerListAdapter = RecylerListAdapter()
        recyclerView.adapter = recylerListAdapter
        loadMockData()

    }

    private fun loadMockData() {
        val tracks: MutableList<Track> = ArrayList()
        tracks.add(Track(1, "Voodoo Mon Amor", "Diablo Swing Orchestra", 81))
        tracks.add(Track(2, "Guerilla Laments", "Diablo Swing Orchestra", 295))
        tracks.add(Track(3, "Kewlar Sweethearts", "Diablo Swing Orchestra", 264))
        tracks.add(Track(4, "How To Organize a Lynch Mob", "Diablo Swing Orchestra", 23))
        tracks.add(Track(5, "Black Box Messiah", "Diablo Swing Orchestra", 297))
        tracks.add(Track(6, "Exit Strategy of a Wrecking Ball", "Diablo Swing Orchestra", 361))
        tracks.add(Track(7, "Aurora", "Diablo Swing Orchestra", 305))
        tracks.add(Track(8, "Mass Rapture", "Diablo Swing Orchestra", 303))
        tracks.add(Track(9, "Black Box Messiah", "Diablo Swing Orchestra", 297))
        tracks.add(Track(10, "Exit Strategy of a Wrecking Ball", "Diablo Swing Orchestra", 361))
        tracks.add(Track(11, "Aurora", "Diablo Swing Orchestra", 305))
        tracks.add(Track(12, "Mass Rapture", "Diablo Swing Orchestra", 303))
        recylerListAdapter!!.setTrackList(tracks)
    }

}