package dev.maryann.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.maryann.workoutlog.databinding.ActivityHomeBinding
import dev.maryann.workoutlog.databinding.ActivityLoginBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
//    lateinit var fcvHome:FragmentContainerView
//    lateinit var bnvHome:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
        setupBottomNav()
    }

    fun castViews(){
        binding.fcvHome
        binding.bnvHome
    }
    fun setupBottomNav(){
        binding.bnvHome.setOnItemSelectedListener{item->
            when(item.itemId){
                R.id.plan->{ supportFragmentManager.beginTransaction().replace(R.id.fcvHome,PlanFragment())
                    .commit()
                    true
                }

                R.id.track->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome,Trackfragment())
                        .commit()
                    true
                }

                R.id.profile->{
                            supportFragmentManager.beginTransaction().replace(R.id.fcvHome,ProfileFragment()).commit()
                            true
                        }
                else->false
                }

            }

        }
    }
