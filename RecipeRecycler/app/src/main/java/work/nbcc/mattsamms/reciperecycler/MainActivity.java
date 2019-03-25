package work.nbcc.mattsamms.reciperecycler;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.LinkedList;

import work.nbcc.mattsamms.model.DataProvider;
import work.nbcc.mattsamms.model.Recipe;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mRecipeNames = new LinkedList<>();
    private final LinkedList<String> mRecipeDesc = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataProvider x = new DataProvider();
        LinkedList<Recipe> mRecipeList = x.getRecipes();
        RecyclerView mRecyclerView = findViewById(R.id.recyclerview);
        RecipeAdapter mAdapter = new RecipeAdapter(this, mRecipeList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
