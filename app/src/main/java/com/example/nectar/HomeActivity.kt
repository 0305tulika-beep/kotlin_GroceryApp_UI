package com.example.nectar

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.nectar.R

class HomeActivity : AppCompatActivity() {

    private lateinit var navShop: LinearLayout
    private lateinit var navExplore: LinearLayout
    private lateinit var navCart: LinearLayout
    private lateinit var navFavourite: LinearLayout
    private lateinit var navAccount: LinearLayout

    private lateinit var imgShop: ImageView
    private lateinit var imgExplore: ImageView
    private lateinit var imgCart: ImageView
    private lateinit var imgFavourite: ImageView
    private lateinit var imgAccount: ImageView

    private lateinit var btnShop: Button
    private lateinit var btnExplore: Button
    private lateinit var btnCart: Button
    private lateinit var btnFavourite: Button
    private lateinit var btnAccount: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        navShop = findViewById(R.id.navShop)
        navExplore = findViewById(R.id.navExplore)
        navCart = findViewById(R.id.navCart)
        navFavourite = findViewById(R.id.navFavourite)
        navAccount = findViewById(R.id.navAccount)


        imgShop = findViewById(R.id.imgShop)
        imgExplore = findViewById(R.id.imgExplore)
        imgCart = findViewById(R.id.imgCart)
        imgFavourite = findViewById(R.id.imgFavourite)
        imgAccount = findViewById(R.id.imgAccount)


        btnShop = findViewById(R.id.btnShop)
        btnExplore = findViewById(R.id.btnExplore)
        btnCart = findViewById(R.id.btnCart)
        btnFavourite = findViewById(R.id.btnFavourite)
        btnAccount = findViewById(R.id.btnAccount)


        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
            updateNavigationTint(imgShop)
        }


        navShop.setOnClickListener {
            loadFragment(HomeFragment())
            updateNavigationTint(imgShop)
        }

        navExplore.setOnClickListener {
            loadFragment(ExploreFragment())
            updateNavigationTint(imgExplore)
        }

        navCart.setOnClickListener {
            loadFragment(CartFragment())
            updateNavigationTint(imgCart)
        }

        navFavourite.setOnClickListener {
            loadFragment(FavouriteFragment())
            updateNavigationTint(imgFavourite)
        }

        navAccount.setOnClickListener {
            loadFragment(AccountFragment())
            updateNavigationTint(imgAccount)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun updateNavigationTint(selectedImage: ImageView) {
        val inactiveColor = ContextCompat.getColor(this, android.R.color.black)
        val activeColor = ContextCompat.getColor(this, R.color.green_active)


        imgShop.setColorFilter(inactiveColor)
        imgExplore.setColorFilter(inactiveColor)
        imgCart.setColorFilter(inactiveColor)
        imgFavourite.setColorFilter(inactiveColor)
        imgAccount.setColorFilter(inactiveColor)


        btnShop.setTextColor(inactiveColor)
        btnExplore.setTextColor(inactiveColor)
        btnCart.setTextColor(inactiveColor)
        btnFavourite.setTextColor(inactiveColor)
        btnAccount.setTextColor(inactiveColor)

        selectedImage.setColorFilter(activeColor)

        when (selectedImage.id) {
            R.id.imgShop -> btnShop.setTextColor(activeColor)
            R.id.imgExplore -> btnExplore.setTextColor(activeColor)
            R.id.imgCart -> btnCart.setTextColor(activeColor)
            R.id.imgFavourite -> btnFavourite.setTextColor(activeColor)
            R.id.imgAccount -> btnAccount.setTextColor(activeColor)
        }
    }
}