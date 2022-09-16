package dev.maryann.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.maryann.workoutlog.R
import dev.maryann.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var sharedPrefs: SharedPreferences
    //    lateinit var fcvHome:FragmentContainerView
//    lateinit var bnvHome:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
        setupBottomNav()

    binding.tvLogout.setOnClickListener {
        val editor=sharedPrefs.edit()
        editor.putString("ACCESS_TOKEN","")
        editor.putString("USER_ID","")
        editor.putString("PROFILE_ID","")
        editor.apply()
        startActivity(Intent(this,LoginActivity::class.java ))
        logOutRequest()
    }


    }

    fun castViews(){
        binding.fcvHome
        binding.bnvHome
    }
    fun setupBottomNav(){
        binding.bnvHome.setOnItemSelectedListener{item->
            when(item.itemId){
                R.id.plan ->{ supportFragmentManager.beginTransaction().replace(
                    R.id.fcvHome,
                    PlanFragment()
                )
                    .commit()
                    true
                }

                R.id.track ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, Trackfragment())
                        .commit()
                    true
                }

                R.id.profile ->{
                            supportFragmentManager.beginTransaction().replace(
                                R.id.fcvHome,
                                ProfileFragment()
                            ).commit()
                            true
                        }
                else->false
                }

            }

        }
    fun logOutRequest(){
        sharedPrefs.edit().clear().commit()
    }
    }
