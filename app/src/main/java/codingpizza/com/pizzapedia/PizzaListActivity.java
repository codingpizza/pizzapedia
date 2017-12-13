package codingpizza.com.pizzapedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_list);

//      #Declaramos nuestro RecyclerView, Creamos nuestras pizzas y declaramos el adaptador
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        List<Pizza> pizzaList = new ArrayList<>();

        Pizza pizza_margherita = new Pizza("Margherita",R.drawable.pizza3,"Tomate,Mozzarella,Albahaca,sal,aceite");
        pizzaList.add(pizza_margherita);
        Pizza pizza_marinara = new Pizza("Marinara",R.drawable.pizza2,"Tomate,Aceite,Ajo y oregano");
        pizzaList.add(pizza_marinara);
        Pizza pizza_salciccia = new Pizza ("Pizza alle salciccia",R.drawable.pizza2,"Tomate,Mozzarella,Albahaca,aceite,salchichas");
        pizzaList.add(pizza_salciccia);

        //Creamos nuestro adaptador con nuestro OnClickListener personalizado que hemos creado
        CustomAdapter customAdapter = new CustomAdapter(pizzaList, new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(Pizza pizza_selected) {
                Toast.makeText(PizzaListActivity.this, pizza_selected.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(customAdapter);

    }
}
