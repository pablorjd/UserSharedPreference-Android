package space.pablorjd.usersharedpreference

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import space.pablorjd.usersharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener{

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: LayoutManager
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(getUser(), this)

        linearLayoutManager = LinearLayoutManager(this)

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val isFirstTime = preferences.getBoolean(getString(R.string.sp_first_time), true)
        Log.i("SP", "${getString(R.string.sp_first_time)} == ${isFirstTime}")
        Log.i("SP", "${getString(R.string.username)} === ${preferences.getString(getString(R.string.username), "N/A")}")

        if(isFirstTime) {
            val dialogView = layoutInflater.inflate(R.layout.dialog_register, null)

           /* MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_title)
                .setView(dialogView)
                .setCancelable(false)
                .setPositiveButton(R.string.dialog_confirm, DialogInterface.OnClickListener { dialogInterface, i ->
                    val userName = dialogView.findViewById<TextInputEditText>(R.id.etUserName).text.toString()
                    with(preferences.edit()) {
                        putBoolean(getString(R.string.sp_first_time),false)
                        putString(getString(R.string.username),userName)
                            .apply()
                    }
                    Toast.makeText(this, getString(R.string.register_user), Toast.LENGTH_SHORT).show()
                    //preferences.edit().putBoolean(getString(R.string.sp_first_time),false).commit()
                })
                //.setNegativeButton("Cancelar", null)
                .show() */
            val dialog = MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_title)
                .setView(dialogView)
                .setCancelable(false)
                .setPositiveButton(R.string.dialog_confirm, DialogInterface.OnClickListener { dialogInterface, i ->})
                .create()

            dialog.show()
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener {
                val userName = dialogView.findViewById<TextInputEditText>(R.id.etUserName).text.toString()
                if ( userName.isBlank() ) {
                    Toast.makeText(this, getString(R.string.register_invalid), Toast.LENGTH_SHORT).show()
                }else {
                    with(preferences.edit()) {
                        putBoolean(getString(R.string.sp_first_time),false)
                        putString(getString(R.string.username),userName)
                            .apply()
                    }
                    Toast.makeText(this, getString(R.string.register_user), Toast.LENGTH_SHORT).show()

                    dialog.dismiss()
                }
            }


        } else {
            val userName = preferences.getString(getString(R.string.username), getString(R.string.nombre_de_usuario))
            Toast.makeText(this, "Bienvenido ${userName}", Toast.LENGTH_SHORT).show()
        }


        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }

        val swipeHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                userAdapter.remove(viewHolder.adapterPosition)
            }
        })

        swipeHelper.attachToRecyclerView(binding.recyclerView)
    }

    override fun onCLick(user: User, position: Int) {
        Toast.makeText(this, "${position} , ${user.getFullName()}", Toast.LENGTH_LONG).show()
    }


    private fun getUser(): MutableList<User> {
        val user = mutableListOf<User>()

        val pablo = User(1,"Pablo","Jimenez", "https://upload.wikimedia.org/wikipedia/commons/f/ff/Chris_Hemsworth_Thor_2_cropped.png")
        val user1 = User(1,"Florencia","Jimenez", "https://elcomercio.pe/resizer/kzA7GjtSnLhUz6nZEM9pr2b2H_E=/1200x1200/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/2IRVLDWH2VBA5F2DAMVVR5DHJU.jpg")
        val user2 = User(1,"Maximiliano","Jimenez", "https://www.mundodeportivo.com/alfabeta/hero/2022/08/Definitivamente-Hulk-enojado-es-mucho-mas-poderoso-que-su-prima.jpg")
        val user3 = User(1,"Litzi","Caceres", "https://i0.wp.com/imgs.hipertextual.com/wp-content/uploads/2020/01/hipertextual-mira-espectacular-nuevo-trailer-viuda-negra-2020457263.jpg")

        user.add(pablo)
        user.add(user1)
        user.add(user2)
        user.add(user3)
        user.add(pablo)
        user.add(user1)
        user.add(user2)
        user.add(user3)
        user.add(pablo)
        user.add(user1)
        user.add(user2)
        user.add(user3)
        user.add(pablo)
        user.add(user1)
        user.add(user2)
        user.add(user3)
        user.add(pablo)
        user.add(user1)
        user.add(user2)
        user.add(user3)
        user.add(pablo)
        user.add(user1)
        user.add(user2)
        user.add(user3)
        return user
    }
}