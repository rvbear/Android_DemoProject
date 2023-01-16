package com.example.lovetest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R
import kotlinx.android.synthetic.main.fragment_login.*
import splitties.toast.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

data class User (val id : String, val pw : String){}
var users = arrayListOf<User>()

class LoginFragment : Fragment() {

    lateinit var navController: NavController

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    fun init(){
        users.add(User("Kim","asd123"))
        users.add(User("jeon","qwe123"))
    }

    fun select_id(id: String):Boolean{
        var Id = id;
        for(i:Int in 0..users.size){
            if(users[i].id.equals(Id))
                return true;
        }
        return false;
    }

    fun select_pw(pw: String):Boolean{
        var Pw = pw;
        for(i:Int in 0..users.size){
            if(users[i].pw.equals(Pw))
                return true;
        }
        return false;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        init();
        navController = Navigation.findNavController(view);

        btn_login.setOnClickListener {
            var id = login_id.text.toString();
            var pw = login_pw.text.toString();

            if(select_id(id) && select_pw(pw))
                navController.navigate(R.id.action_loginFragment3_to_mainFragment);
            else
                toast("아이디 혹은 비밀번호 입력 오류");
        }

        btn_register.setOnClickListener {
            navController.navigate(R.id.action_loginFragment3_to_registerFragment);
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}